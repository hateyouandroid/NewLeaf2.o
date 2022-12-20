package com.example.newleaf2o

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class SQLiteHelper(private val context: Context?):
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE =
            "create table $TABLE_NAME($ENAME text, $EMAIL text, $MOBILE text,$PASSWORD text)"
        Toast.makeText(context, "onCreate is called", Toast.LENGTH_LONG).show()
        try {

            db?.execSQL(CREATE_TABLE)
            Toast.makeText(context, "Table is inserted", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(context, "Exception $e", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Toast.makeText(context, "onUpgrade is called", Toast.LENGTH_SHORT).show()
        db?.execSQL("drop table if exists $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(
        name:String?,
        email: String?,
        mobile: String?,
        password:String?
    ): Boolean {
        val db = writableDatabase
        val cv = ContentValues()
        cv.put(ENAME, name)
        cv.put(EMAIL, email)
        cv.put(MOBILE,  mobile)
        cv.put(PASSWORD,password)
        val result = db.insert(TABLE_NAME, null, cv)
        return result != -1L
    }
    /*  fun deleteData(

          firstName: String?,
          lastName: String?,
          userName: String?,
          password: String?

      ): Boolean {
          val db = writableDatabase
          db.delete(TABLE_NAME, SQLiteHelper.FIRST_NAME + "='" + firstName + "'", null)

          return false
      }
  */
    fun showAll(): Cursor {
        val select = "select *from $TABLE_NAME"

        val db = readableDatabase
        return db.rawQuery(select, null)
    }


    companion object {
        private const val DATABASE_NAME = "emp_db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "customer_registration"
        private const val ENAME = "name"
        private const val EMAIL = "email"
        private const val MOBILE = "mobile"
        private const val PASSWORD = "password"

    }
    init {
        Toast.makeText(context,"constructor is called", Toast.LENGTH_SHORT).show()
    }
}
