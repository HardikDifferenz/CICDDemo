package com.cicddemo.app.utils

import androidx.core.util.PatternsCompat

object ValidationUtil {
    fun validateEmptyEditText(et_advertise: String?): Boolean {
        return et_advertise?.trim { it <= ' ' }?.isEmpty() ?: true
    }

    private fun isValidEmail(email: String?): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email!!).matches()
    }

    fun validateEmail(et_email: String?): Boolean {
        val email = (et_email?:"").trim { it <= ' ' }
        return (email.isEmpty() || !isValidEmail(email))
    }

    fun validateConfirmPassword(
        et_password: String?,
        et_confirm_password: String?
    ): Boolean {
        return et_password.toString().trim { it <= ' ' } != et_confirm_password.toString()
            .trim { it <= ' ' }
    }

    fun validateMobileNo(et_mobile_no: String): Boolean {
        val mobile_no = et_mobile_no.trim { it <= ' ' }
        return mobile_no.isEmpty() || !isValidMobileNo(mobile_no)
    }

    fun isValidMobileNo(mobile_no: String): Boolean {
        return (mobile_no.length in 10..12)
    }

}