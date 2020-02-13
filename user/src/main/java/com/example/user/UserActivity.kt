package com.example.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import com.example.user.ui.user.UserFragment
import kotlinx.android.synthetic.main.toolbar.*

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.user_activity)

//        setSupportActionBar(toolbar_user)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.user_activity, UserFragment.newInstance())
                .commitNow()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        return true
    }

}
