package com.cicddemo.app

import android.os.Bundle
import android.view.animation.Animation
import com.cicddemo.app.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var blinkanim: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.idBtnLogin.setOnClickListener {

        }
    }
}