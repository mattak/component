package me.mattak.example.lifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val component by lazy { AppComponents() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.component.onCreate(this, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        this.component.onStart(this)
    }

    override fun onResume() {
        super.onResume()
        this.component.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        this.component.onPause(this)
    }

    override fun onStop() {
        super.onStop()
        this.component.onStop(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        this.component.onDestroy(this)
    }
}