package com.example.newleaf2o

import androidx.appcompat.widget.AppCompatEditText

/*
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
*/
fun AppCompatEditText.nameValidate():Boolean{
    when{
        this.text.toString().trim().isBlank()||this.text.toString().trim().isEmpty()->
            throw ValidateName("Please Enter Your Name")
        isNotAlfa(this.text.toString().trim())->
            throw ValidateName("Name Shuld Conten Only Alfabets")
        this.text.toString().trim().length>30->
            throw ValidateName("Name Shuld Be Less Than 30")
        else -> return true
    }
}
fun AppCompatEditText.mobileValidate():Boolean{
    when{
        this.text.toString().trim().isBlank()||this.text.toString().trim().isEmpty()->
            throw ValidateMobile("Please Enter Your Mobile No")
        this.text.toString().trim().length<10->
            throw ValidateMobile("Mobile No Shuld Be Grater Than or Equal To 10")
        else -> return true
    }
}
fun AppCompatEditText.emailValidate():Boolean{
    when{
        this.text.toString().trim().isBlank()||this.text.toString().trim().isEmpty()->
            throw ValidateEmail("Please Enter Your Email Address")
        isvalidEmail(this.text.toString().trim())->
            throw ValidateEmail("Please Enter Valid Email Address")
        else -> return true
    }
}

fun AppCompatEditText.passwordValidate():Boolean{
    when{
        this.text.toString().trim().isBlank()||this.text.toString().trim().isEmpty()->
            throw ValidatePassword("Please Enter Password")
        this.text.toString().trim().length<5->
            throw ValidatePassword("Password Shuld Grater Than 5")
        this.text.toString().trim().length>15->
            throw ValidatePassword("Password Shuld Be Less Than 15")
        else -> return true
    }
}
fun AppCompatEditText.confPasswordValidate(pass: AppCompatEditText):Boolean
{
    when{
        this.text.toString().trim()!=pass.text.toString().trim()->
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