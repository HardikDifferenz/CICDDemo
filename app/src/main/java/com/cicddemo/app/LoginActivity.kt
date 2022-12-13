package com.cicddemo.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.cicddemo.app.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding

    lateinit var idEdtUserName :EditText
    lateinit var idEdtPassword :EditText
    lateinit var idBtnLogin :  Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding.idBtnLogin.setOnClickListener {

        }

    }
}