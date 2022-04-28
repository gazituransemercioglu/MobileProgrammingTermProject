package com.example.mobileprogrammingtermproject

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.mobileprogrammingtermproject.databinding.ActivityLoginBinding
import kotlin.coroutines.coroutineContext

val database_name = "myDatabase"
val table_name = "Users"
val col_username = "username"
val col_name = "name"
val col_email = "email"
val col_password = "password"
val col_id = "id"

class DatabaseHelper(context : Context):SQLiteOpenHelper(context, database_name,null,1){
    val context = context
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = " CREATE TABLE $table_name ($col_username VARCHAR(10), $col_name VARCHAR(30) , " +
                " $col_email VARCHAR(30)," +
                " $col_password VARCHAR(30)," +
                " $col_id INTEGER PRIMARY KEY AUTOINCREMENT )"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    fun insertData(user:User){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(col_username,user.username)
        cv.put(col_name,user.name)
        cv.put(col_email,user.email)
        cv.put(col_password,user.password)

        var result = db.insert(table_name,null,cv)
        if (result==(-1).toLong()){
            Toast.makeText(context,"Register Not Successful!",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context,"Register Successful!",Toast.LENGTH_LONG).show()
        }
    }

    fun readData():MutableList<User>{
        val userList :MutableList<User> = ArrayList()
        val db = this.readableDatabase
        val query = "SELECT * FROM $table_name"
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                val user = User()
                user.id = result.getString(result.getColumnIndexOrThrow(col_id)).toInt()
                user.username = result.getString(result.getColumnIndexOrThrow(col_username))
                user.name = result.getString(result.getColumnIndexOrThrow(col_name))
                user.email = result.getString(result.getColumnIndexOrThrow(col_email))
                user.password = result.getString(result.getColumnIndexOrThrow(col_password))
                userList.add(user)
            }while (result.moveToNext())
        }
        result.close()
        db.close()
        return userList
    }

}