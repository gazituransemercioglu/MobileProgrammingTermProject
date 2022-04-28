package com.example.mobileprogrammingtermproject

class User{
    var id: Int = 0
    var username:String = ""
    var name: String = ""
    var email: String = ""
    var password: String = ""

    constructor(username:String,name:String,email:String,password:String){
        this.username=username
        this.name=name
        this.email=email
        this.password=password
    }
    constructor(){

    }
}