package com.example.badanass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.badanass.detail.CardDetailFragment
import com.example.badanass.list.CardListFragment

class MainActivity : AppCompatActivity(), MainActivityContract {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().run {
            replace(R.id.activity_main, CardListFragment.newInstance())
        }.commit()
    }

    override fun onItemSelected(cardId: String) {
        supportFragmentManager.beginTransaction().run {
            addToBackStack("")
            add(R.id.activity_main, CardDetailFragment.newInstance(cardId))
        }.commit()
    }
}