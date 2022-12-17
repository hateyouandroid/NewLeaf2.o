package com.example.newleaf2o.util

import androidx.appcompat.widget.AppCompatEditText
import com.example.newleaf2o.Exceptions.*

fun AppCompatEditText.nameValidate(name:AppCompatEditText):Boolean{
    when{
        name.text.toString().trim().isBlank()||name.text.toString().trim().isEmpty()->
            throw ValidateName("Please Enter Your Name")
        isNotAlfa(name.text.toString().trim())->
            throw ValidateName("Name Shuld Conten Only Alfabets")
        name.text.toString().trim().length>30->
            throw ValidateName("Name Shuld Be Less Than 30")
        else -> return true
    }
}
fun AppCompatEditText.mobileValidate(mob:AppCompatEditText):Boolean{
    when{
        mob.text.toString().trim().isBlank()||mob.text.toString().trim().isEmpty()->
            throw ValidateMobile("Please Enter Your Mobile No")
        mob.text.toString().trim().length<10->
            throw ValidateMobile("Mobile No Shuld Be Grater Than or Equal To 10")
        else -> return true
    }
}
fun AppCompatEditText.emailValidate(email:AppCompatEditText):Boolean{
    when{
        email.text.toString().trim().isBlank()||email.text.toString().trim().isEmpty()->
            throw ValidateEmail("Please Enter Your Email Address")
        isvalidEmail(email.text.toString().trim())->
            throw ValidateEmail("Please Enter Valid Email Address")
        else -> return true
    }
}

fun AppCompatEditText.passwordValidate(pass:AppCompatEditText):Boolean{
    when{
        pass.text.toString().trim().isBlank()||pass.text.toString().trim().isEmpty()->
            throw ValidatePassword("Please Enter Password")
        pass.text.toString().trim().length<5->
            throw ValidateName("Password Shuld Grater Than 5")
        pass.text.toString().trim().length>15->
            throw ValidateName("Password Shuld Be Less Than 15")
        else -> return true
    }
}
fun AppCompatEditText.confPasswordValidate(pass: AppCompatEditText,pass2:AppCompatEditText):Boolean
{
    when{
        pass.text.toString().trim()!=pass2.text.toString().trim()->
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
