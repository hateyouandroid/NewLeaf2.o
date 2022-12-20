package com.example.newleaf2o.util

import androidx.appcompat.widget.AppCompatEditText
import com.example.newleaf2o.Exceptions.*

fun AppCompatEditText.nameValidate():Boolean{
    when{
        text.toString().trim().isBlank()|| text.toString().trim().isEmpty()->
            throw ValidateName("Please Enter Your Name")
        isNotAlfa(this.text.toString().trim())->
            throw ValidateName("Name Shuld Conten Only Alfabets")
        text.toString().trim().length>30->
            throw ValidateName("Name Shuld Be Less Than 30")
        else -> return true
    }
}
fun AppCompatEditText.mobileValidate():Boolean{
    when{
        text.toString().trim().isBlank()|| text.toString().trim().isEmpty()->
            throw ValidateMobile("Please Enter Your Mobile No")
         text.toString().trim().length<10->
            throw ValidateMobile("Mobile No Shuld Be Grater Than or Equal To 10")
        else -> return true
    }
}
fun AppCompatEditText.emailValidate():Boolean{
    when{
           text.toString().trim().isBlank()||text.toString().trim().isEmpty()->
            throw ValidateEmail("Please Enter Your Email Address")
        isvalidEmail(text.toString().trim())->
            throw ValidateEmail("Please Enter Valid Email Address")
        else -> return true
    }
}

fun AppCompatEditText.passwordValidate():Boolean{
    when{
           text.toString().trim().isBlank()||text.toString().trim().isEmpty()->
            throw ValidatePassword("Please Enter Password")
        text.toString().trim().length<5->
            throw ValidatePassword("Password Shuld Grater Than 5")
        text.toString().trim().length>15->
            throw ValidatePassword("Password Shuld Be Less Than 15")
        else -> return true
    }
}
fun AppCompatEditText.confPasswordValidate(pass: AppCompatEditText):Boolean
{
    when{
           text.toString().trim()!=pass.text.toString().trim()->
            throw ValidateConformPassword("Password Shuld be same")
        else-> return true
    }
}

fun isNotAlfa(name: String): Boolean {
    val regex = Regex("[a-zA-Z]+?")
    return regex.matches(name).not()
}
fun isvalidEmail(email: String): Boolean {
    if (email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()).not())
        return true
    else
       return false
}
//for Showing Error Massage on Validation Error

fun AppCompatEditText.validationError(massage:String):Boolean
{
    requestFocus()
    error=massage
    return false
}
