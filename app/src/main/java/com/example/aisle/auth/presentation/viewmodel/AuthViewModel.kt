package com.example.aisle.auth.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aisle.auth.domain.model.OtpVerifyDto
import com.example.aisle.auth.domain.model.OtpVerifyRequest
import com.example.aisle.auth.domain.model.PhoneLoginDto
import com.example.aisle.auth.domain.model.PhoneLoginRequest
import com.example.aisle.auth.domain.use_cases.AuthUseCases
import com.example.aisle.utils.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
) : ViewModel(),
    IAuthViewModelContract {

    /* Login Via Phone */
    private val phoneLogin = MutableLiveData<Resource<PhoneLoginDto>>()

    override fun getLoginViaPhone(request: PhoneLoginRequest) {
        viewModelScope.launch {
            phoneLogin.postValue(Resource.Loading)

            val result = authUseCases.ucGetLoginViaPhoneUseCase(request)

            phoneLogin.postValue(result)
        }
    }

    override fun doObserverLoginViaPhone(): LiveData<Resource<PhoneLoginDto>> =
        phoneLogin


    /* Otp Verification */
    private val otpVerification = MutableLiveData<Resource<OtpVerifyDto>>()

    override fun getOtpVerification(request: OtpVerifyRequest) {
        viewModelScope.launch {
            otpVerification.postValue(Resource.Loading)

            val result = authUseCases.ucGetOtpVerifyUseCase(request)

            otpVerification.postValue(result)
        }
    }

    override fun doObserverOtpVerification(): LiveData<Resource<OtpVerifyDto>> =
        otpVerification
}