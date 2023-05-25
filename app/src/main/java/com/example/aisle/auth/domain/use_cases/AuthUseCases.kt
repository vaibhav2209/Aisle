package com.example.aisle.auth.domain.use_cases

data class AuthUseCases(
    val ucGetLoginViaPhoneUseCase: GetLoginViaPhoneUseCase,
    val ucGetOtpVerifyUseCase: GetOtpVerifyUseCase
)
