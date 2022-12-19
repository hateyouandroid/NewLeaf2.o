package com.example.newleaf2o

import androidx.appcompat.widget.AppCompatEditText

fun AppCompatEditText.nameVaild(name: AppCompatEditText, msg:String): Boolean {
    when{
        name.text.toString().trim().isEmpty()||name.text.toString().trim().isBlank() ->
        {
            throw VaildateName(msg)

        }

        isNotAlphbate(name.text.toString())
        ->{
            throw VaildateName("Name should be chararter")
        }
        else -> return true
    }

}
fun AppCompatEditText.mailVaild(mail: AppCompatEditText, msg:String): Boolean{
    when{
        mail.text.toString().trim().isEmpty()||mail.text.toString().trim().isBlank() ->
        {
            throw VaildateMail(msg)

        }

        isNotAlphbate(mail.text.toString())
        ->{
            throw VaildateMail("Name should be chararter")
        }
        else -> return true
    }

}

fun isNotAlphbate(name:String): Boolean {
    val regex = Regex("[a-zA-Z]+?")
    return regex.matches(name).not()

}
