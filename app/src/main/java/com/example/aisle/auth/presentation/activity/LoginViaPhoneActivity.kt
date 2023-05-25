package com.example.aisle.auth.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.aisle.R
import com.example.aisle.application.AppNavigationRoute
import com.example.aisle.auth.domain.model.PhoneLoginRequest
import com.example.aisle.auth.presentation.viewmodel.AuthViewModel
import com.example.aisle.databinding.ActivityLoginViaPhoneBinding
import com.example.aisle.utils.UiUtils.showLogE
import com.example.aisle.utils.UiUtils.showToast
import com.example.aisle.utils.network.NetworkUtils
import com.example.aisle.utils.network.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginViaPhoneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginViaPhoneBinding

    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginViaPhoneBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        onViewClick()
        observeLoginViaPhone()
    }

    private fun onViewClick() {
        binding.btnContinue.setOnClickListener {
            if (isValidPhoneNumber()) {
                getLoginViaPhone(getCountryCode() + getPhoneNumber())
            } else {
                showToast(getString(R.string.enter_valid_phone_number))
            }
        }
    }

    private fun getPhoneNumber() =
        binding.etPhoneNumber.text.toString().trim()

    private fun isValidPhoneNumber() =
        getPhoneNumber().length >= 10

    private fun getCountryCode() =
        binding.etCountryCode.text.toString().trim()


    private fun getLoginViaPhone(phone: String) {
        if (NetworkUtils.hasInternetConnection(this)) {
            authViewModel.getLoginViaPhone(
                request = PhoneLoginRequest(
                    number = phone
                )
            )
        } else {
            showToast(getString(R.string.txt_check_your_connection))
        }
    }

    private fun observeLoginViaPhone() {
        authViewModel.doObserverLoginViaPhone().observe(this) {
            it?.let { res ->
                when (res) {
                    is Resource.Loading -> {
                        showProgress(true)
                    }
                    is Resource.Success -> {
                        showProgress(show = false)
                        showToast("Otp sent")
                        AppNavigationRoute.openOtpVerificationActivity(
                            context = this,
                            phone = getCountryCode() + getPhoneNumber()
                        )
                    }
                    is Resource.Failure -> {
                        showProgress(show = false)
                        showLogE(res.exception.message)
                        showToast(res.exception.message ?: "Error")
                    }
                    is Resource.NoResult -> {
                        showProgress(show = false)
                        showLogE(getString(R.string.no_result))
                    }
                }
            }
        }
    }

    private fun showProgress(show: Boolean) {
        if (show)
            binding.progress.visibility = View.VISIBLE
        else
            binding.progress.visibility = View.GONE
    }
}