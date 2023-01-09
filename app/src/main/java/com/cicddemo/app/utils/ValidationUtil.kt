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
        et_password: String,
        et_confirm_password: String
    ): Boolean {
        if (et_password.isEmpty() || et_confirm_password.isEmpty()){
            return true
        }else  if (et_password.trim { it <= ' ' } != et_confirm_password.trim { it <= ' ' }){
            return true
        }else  if (et_password.trim { it <= ' ' } == et_confirm_password.trim { it <= ' ' }){
            return false
        }
        return true
    }

    fun validateMobileNo(et_mobile_no: String): Boolean {
        val mobileNo = et_mobile_no.trim { it <= ' ' }

        return mobileNo.isEmpty() || !isValidMobileNo(mobileNo)
    }

    private fun isValidMobileNo(mobile_no: String): Boolean {
        return (mobile_no.length in 10..12)
    }
}