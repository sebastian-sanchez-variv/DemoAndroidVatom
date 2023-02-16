package com.example.vatomwandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vatomwallet.VatomWallet

class MainActivity : AppCompatActivity() {
    var vatomWallet: VatomWallet? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        this.vatomWallet = VatomWallet(this, "", creds.vatom.accessToken, creds.vatom.refreshToken)
        setContentView(this.vatomWallet)
        //vatomWallet.load()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        this.vatomWallet!!.onPermissionsChanged(requestCode,permissions,grantResults)
    }
}

