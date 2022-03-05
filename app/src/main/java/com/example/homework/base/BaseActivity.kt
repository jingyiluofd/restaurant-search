package com.example.homework.base

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.homework.R

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(backVisible())
        supportActionBar?.title = setTitle()
        setContentView(getLayoutResource())
    }

    abstract fun getLayoutResource(): Int

    /**
     * show back
     * @return true:visible false:hidden
     */
    open fun backVisible(): Boolean {
        return true
    }

    open fun setTitle(): String {
        return resources.getString(R.string.app_name)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}