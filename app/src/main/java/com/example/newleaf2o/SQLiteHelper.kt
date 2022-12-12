package com.example.newleaf2o

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.net.wifi.p2p.WifiP2pManager.UpnpServiceResponseListener
import android.widget.Toast

class SQLiteHelper(private val context: Context?):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION)
{
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE ="create table $TABLE_NAME($USERNAME text, $MAIL_ID text, $CONTACT_NO text, $PASSWORD text)"
        Toast.makeText(context, "onCreate is called", Toast.LENGTH_LONG).show()
        try {
            db?.execSQL(CREATE_TABLE)
            Toast.makeText(context, "Table is created", Toast.LENGTH_LONG).show()
        }
        catch (e:Exception)
        {
            Toast.makeText(context,"Exception",Toast.LENGTH_LONG).show()
        }
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Toast.makeText(context,"OnUpgrade call",Toast.LENGTH_LONG).show()
        db?.execSQL("drop table if exists TABLE_NAME")
        onCreate(db)
    }
    fun insertData(
        username:String?,
        mailid:String?,
        contactno:String?,
        password:String?

    ):Boolean{
        val db=writableDatabase
        val cv=ContentValues()
        cv.put(USERNAME, username)
        cv.put(MAIL_ID,mailid)
        cv.put(CONTACT_NO,contactno)
        cv.put(PASSWORD,password)

        val result=db.insert(TABLE_NAME,null,cv)
        return result !=-1L
    }
    fun showAll(): Cursor
    {
        val select = "select * from TABLE_NAME"
        val db=readableDatabase
        return db.rawQuery(select,null)
    }
    companion object
    {
        private const val DATABASE_NAME="emp_db"
        private const val DATABASE_VERSION=3

        private const val TABLE_NAME="customer_registration"
        private const val USERNAME="username"
        private const val MAIL_ID="mailid"
        private const val CONTACT_NO="contactno"
        private const val PASSWORD="password"

    }
    init {
        Toast.makeText(context,"constructor is called",Toast.LENGTH_LONG).show()
    }
    }