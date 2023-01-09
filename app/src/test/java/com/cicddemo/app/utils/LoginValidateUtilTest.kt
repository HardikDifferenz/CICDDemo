package com.cicddemo.app.utils

import com.google.common.truth.Truth
import org.junit.Test

class LoginValidateUtilTest {

    @Test
   fun validateEmptyEditText() {
        val emptyString = ValidationUtil.validateEmptyEditText(" ")
        Truth.assertThat(emptyString).isTrue()

        val emailWithSpace = ValidationUtil.validateEmptyEditText("Demo Space")
        Truth.assertThat(emailWithSpace).isFalse()

    }

    @Test
    fun validateEmail() {
        val emailWithSpace = ValidationUtil.validateEmail(" ")
        Truth.assertThat(emailWithSpace).isTrue()

        val emailWithInvalid = ValidationUtil.validateEmail("asc.com")
        Truth.assertThat(emailWithInvalid).isTrue()

        val emailWithCenterSpace = ValidationUtil.validateEmail("asfd@ frk.com")
        Truth.assertThat(emailWithCenterSpace).isTrue()

        val emailWithValid = ValidationUtil.validateEmail("asc@demo.com")
        Truth.assertThat(emailWithValid).isFalse()
    }

    @Test
    fun validateConfirmPassword() {
        val passwordConfirmWithSpace = ValidationUtil.validateEmptyEditText("")
        Truth.assertThat(passwordConfirmWithSpace).isTrue()

        val passwordWithWrong = ValidationUtil.validateConfirmPassword("123456","122245")
        Truth.assertThat(passwordWithWrong).isTrue()

        val passwordWithBlankWithPassword = ValidationUtil.validateConfirmPassword(" ","123456")
        Truth.assertThat(passwordWithBlankWithPassword).isTrue()

        val passwordWithPasswordWithBlank = ValidationUtil.validateConfirmPassword("123456"," ")
        Truth.assertThat(passwordWithPasswordWithBlank).isTrue()

        val emailTest = ValidationUtil.validateConfirmPassword("123456","123456")
        Truth.assertThat(emailTest).isFalse()

    }

    @Test
     fun validateMobileNo() {
        val emptyPhoneNumber = ValidationUtil.validateMobileNo(" ")
        Truth.assertThat(emptyPhoneNumber).isTrue()

        val phoneNumberWithSpace = ValidationUtil.validateMobileNo("91-963-852-7895")
        Truth.assertThat(phoneNumberWithSpace).isTrue()

        val phoneNumberWithValid = ValidationUtil.validateMobileNo("1234567890")
        Truth.assertThat(phoneNumberWithValid).isFalse()

    }
}