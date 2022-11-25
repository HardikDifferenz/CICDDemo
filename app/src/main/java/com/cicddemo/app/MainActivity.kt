package com.cicddemo.app

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.tasks.Task
import org.json.JSONArray
import org.json.JSONObject

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

        var json1 = JSONArray(
            "[\n" +
                    "  {\n" +
                    "    \"Id\": \"a043t000012dbnUAAQ\",\n" +
                    "    \"dqp__Selected_GL_Code__c\": \"a033t00000fuC3rAAE\",\n" +
                    "    \"dqp__GL_Code__c\": \"200-8000-815-050\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Id\": \"a043t000012dbnXAAQ\",\n" +
                    "     \"dqp__GL_Code__c\": \"100\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Id\": \"a043t000012dbnEAAQ\",\n" +
                    "     \"dqp__GL_Code__c\": \"100\"\n" +
                    "  }\n" +
                    "]"
        )
        var json2 = JSONArray(
            "[\n" +
                    "  {\n" +
                    "    \"dqp__Credit_Amount__c\": \"100\",\n" +
                    "    \"Id\": \"a043t000012dbnUAAQ\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"dqp__Debit_Amount__c\": \"200\",\n" +
                    "    \"dqp__Credit_Amount__c\": \"200\",\n" +
                    "    \"Id\": \"a043t000012dbnXAAQ\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"dqp__Debit_Amount__c\": \"200\",\n" +
                    "    \"dqp__Credit_Amount__c\": \"200\",\n" +
                    "    \"Id\": \"a043t000012dbnGAAQ\"\n" +
                    "  }\n" +
                    "]"
        )

        for (i in 0 until json1.length()) {
            var isAvailable = false
            for (j in 0 until json2.length()) {

                if ((json1[i] as JSONObject).getString("Id")
                        .equals((json2[j] as JSONObject).getString("Id"), true)
                ) {
                    isAvailable = true
                    (json2[j] as JSONObject).apply {
                        for (key in (json1[i] as JSONObject).keys()) {
                            val value: Any = (json1[i] as JSONObject).get(key)
                            (json2[j] as JSONObject).put(key, value)
                        }
                    }
                }
            }
            if (!isAvailable) {
                json2.put(json1[i])
            }
        }


        Log.d("TAG", "onCreate: $json2")

        //References
        //https://medium.com/firebase-developers/quickly-distribute-app-with-firebase-app-distribution-using-github-actions-fastlane-c7d8eca18ee0
        //https://www.kodeco.com/19407406-continuous-delivery-for-android-using-github-actions#toc-anchor-020
    }

    private fun signIn() {
        //Google Login Reference link fgfgf fdgf
        //https://developers.google.com/identity/sign-in/android/start-integratingfdf sdfsd
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
            } else if (result.resultCode == Activity.RESULT_CANCELED) {
                Log.d("Error ", "result")
            }
        }
    // You can do the assignment inside onAttach or onCreate, i.e, before the activity is displayed
}

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