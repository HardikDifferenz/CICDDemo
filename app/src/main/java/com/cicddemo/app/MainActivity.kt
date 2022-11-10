package com.cicddemo.app

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.tasks.Task


class MainActivity : AppCompatActivity() {
    private var mGoogleSignInClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gso: GoogleSignInOptions =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        val account = GoogleSignIn.getLastSignedInAccount(this)
        findViewById<TextView>(R.id.btnLogin).setOnClickListener {
            signIn()
        }
//  dlskdflksdl dsfsdfsdf dsdfsd gdfdfgdfgdfgsdsdfsdfdsfsdf
        //https://medium.com/firebase-developers/quickly-distribute-app-with-firebase-app-distribution-using-github-actions-fastlane-c7d8eca18ee0
    }

    private fun signIn() {
        //Google Login Reference link fgfgf fdgf
        //https://developers.google.com/identity/sign-in/android/start-integrating
        val signInIntent = mGoogleSignInClient!!.signInIntent
        resultLauncher.launch(signInIntent)
    }

    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val task: Task<GoogleSignInAccount> =
                    GoogleSignIn.getSignedInAccountFromIntent(result.data)
                Log.d("Email ", task.result.email ?: "")
            }else if (result.resultCode == Activity.RESULT_CANCELED){
                Log.d("Error ", "result")
            }
        }
    // You can do the assignment inside onAttach or onCreate, i.e, before the activity is displayed
}


//Shreyas changes
/*
* Fastlanecommand
* brew install fastlane

* Fastlane
sudo gem install fastlane
fastlane init

*
*
fastlane add_plugin firebase_app_distribution
fastlane run firebase_app_distribution_login
export FIREBASE_APP_ID=1:269966259407:android:2f3838a98e2c0b2609f3ba//AppID
* */