package com.example.project_s_h_o_p

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(val context: Context, val factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "app", factory, 1) { //1 bo to pierwsza wersja bazy danych
    override fun onCreate(p0: SQLiteDatabase?) {
        val query =
            "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, login TEXT, password TEXT, email TEXT)"
        p0?.execSQL(query) //? bo w przypadku gdyby p0 bylo nullem to nie wywali bledu, mozna uzyc !! ale wtedy wywali bledy(mniej praktyczne i zakazane!!!)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS users")
        onCreate(p0) //tworzymy od nowa baze danych
    }

    fun adduser(user: User) {
        val values = ContentValues()
        values.put("login", user.login)
        values.put("password", user.password)
        values.put("email", user.email)
        //id tworzy sie i +1 automatycznie

        val db = this.writableDatabase
        db.insert(
            "users",
            null,
            values
        ) //dodajemy users do bazy danych, null bo nie chcemy dodawac pustych wartosci i values bo chcemy dodac wartosci z values
        db.close()

    }
}