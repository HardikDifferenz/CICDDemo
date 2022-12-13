package com.cicddemo.app.utils

import com.google.common.truth.Truth
import org.junit.Test

class LoginValidateUtilTest {

    @Test
   fun validateEmptyEditText() {
        val emailTest = ValidationUtil.validateEmptyEditText("dasd")
        Truth.assertThat(emailTest).isFalse()
    }

    @Test
    fun validateEmail() {
        val emailTest = ValidationUtil.validateEmail("asc@gmail.com")
        Truth.assertThat(emailTest).isFalse()
    }

    @Test
    fun validateConfirmPassword() {
        val emailTest = ValidationUtil.validateConfirmPassword("123456","123456")
        Truth.assertThat(emailTest).isFalse()
    }

    @Test
     fun validateMobileNo() {
        val emailTest = ValidationUtil.validateMobileNo("9638527410")
        Truth.assertThat(emailTest).isFalse()
    }

    @Test
    fun isValidMobileNo() {
    }
}