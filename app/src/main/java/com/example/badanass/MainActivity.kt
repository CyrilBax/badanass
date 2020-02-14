package com.example.badanass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.badanass.detail.CardDetailFragment
import com.example.badanass.list.CardListFragment
import com.example.user.UserActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityContract {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar_main)

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_button -> navigateModule()
            else -> super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun navigateModule() {
        val intent = Intent(this, UserActivity::class.java)
        startActivity(intent)
    }
}