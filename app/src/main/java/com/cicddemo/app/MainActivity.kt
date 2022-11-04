package com.cicddemo.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //https://medium.com/firebase-developers/quickly-distribute-app-with-firebase-app-distribution-using-github-actions-fastlane-c7d8eca18ee0
    }
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