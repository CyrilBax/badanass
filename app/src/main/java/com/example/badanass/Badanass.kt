package com.example.badanass

import android.app.Application
import android.content.Context

class BadanassApps : Application() {


    override fun onCreate() {
        super.onCreate()

        context=this
    }

    companion object{

        lateinit var context: Context
    }

}