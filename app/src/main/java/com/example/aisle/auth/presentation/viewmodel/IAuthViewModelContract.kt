package com.example.aisle.auth.presentation.viewmodel

import androidx.lifecycle.LiveData
import com.example.aisle.auth.domain.model.OtpVerifyDto
import com.example.aisle.auth.domain.model.OtpVerifyRequest
import com.example.aisle.auth.domain.model.PhoneLoginDto
import com.example.aisle.auth.domain.model.PhoneLoginRequest
import com.example.aisle.utils.network.Resource

interface IAuthViewModelContract {

    fun getLoginViaPhone(request: PhoneLoginRequest)
    fun doObserverLoginViaPhone(): LiveData<Resource<PhoneLoginDto>>

    fun getOtpVerification(request: OtpVerifyRequest)
    fun doObserverOtpVerification(): LiveData<Resource<OtpVerifyDto>>
}