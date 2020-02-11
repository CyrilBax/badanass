package com.example.badanass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.badanass.detail.CardDetailFragment
import com.example.badanass.list.CardListFragment
import android.widget.Toast

class MainActivity : AppCompatActivity(), MainActivityContract {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().run {
            replace(R.id.activity_main, CardListFragment.newInstance())
        }.commit()

    }

    override fun onItemSelected(name: String) {
        supportFragmentManager.beginTransaction().run {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            addToBackStack(null)
            replace(R.id.activity_main, CardDetailFragment.newInstance(name))
        }.commit()
    }

    override fun onBackPressed() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        super.onBackPressed()
        return true
    }
}