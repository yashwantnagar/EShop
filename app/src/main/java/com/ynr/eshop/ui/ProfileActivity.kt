package com.ynr.eshop.ui

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.ynr.eshop.R

class ProfileActivity : AppCompatActivity(), OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val backBtn : AppCompatImageButton = findViewById(R.id.backBtn)
        val wishlist : TextView = findViewById(R.id.wishlist)
        val btnLogOut : MaterialButton = findViewById(R.id.btnLogOut)

        backBtn.setOnClickListener(this)
        wishlist.setOnClickListener(this)
        btnLogOut.setOnClickListener(this)


    }

    override fun onClick(v : View?) {

        when(v?.id){

            R.id.backBtn -> onBackPressedDispatcher.onBackPressed()

            R.id.wishlist -> {
                val intent = Intent(this,WishlistActivity::class.java)
                startActivity(intent)
            }

            R.id.btnLogOut -> logOutDialog()

        }

    }

    private fun logOutDialog() {

//        MaterialAlertDialogBuilder(this,R.style.RoundShapeTheme)
//            .setView(R.layout.activity_profile)
//            .show()

        MaterialAlertDialogBuilder(this,R.style.RoundShapeTheme)
            .setTitle("LogOut")
            .setMessage("Are you sure you want to LogOut?")
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->

                Toast.makeText(this,"Yes",Toast.LENGTH_SHORT).show()

            })
            .setNeutralButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->

                dialogInterface.dismiss()

            })
            .show()

    }

}