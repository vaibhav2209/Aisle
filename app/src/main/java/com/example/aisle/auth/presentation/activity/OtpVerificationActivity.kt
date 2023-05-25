package com.example.aisle.auth.presentation.activity

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.aisle.R
import com.example.aisle.application.AppNavigationRoute
import com.example.aisle.application.SessionManager
import com.example.aisle.auth.domain.model.OtpVerifyRequest
import com.example.aisle.auth.presentation.viewmodel.AuthViewModel
import com.example.aisle.databinding.ActivityOtpVerificationBinding
import com.example.aisle.utils.Constants
import com.example.aisle.utils.UiUtils
import com.example.aisle.utils.UiUtils.showLogE
import com.example.aisle.utils.UiUtils.showToast
import com.example.aisle.utils.network.NetworkUtils
import com.example.aisle.utils.network.Resource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OtpVerificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOtpVerificationBinding

    private val authViewModel: AuthViewModel by viewModels()

    private var phoneNumber = ""

    private var countdownTimer: CountDownTimer? = null

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpVerificationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        phoneNumber = intent.getStringExtra(Constants.PHONE_NUMBER).orEmpty()

        setupView()
        onViewClick()
        observeOtpVerification()

        initCountDownTimer()
    }

    private fun setupView() {
        binding.tvPhoneNumber.text = phoneNumber
    }

    private fun onViewClick() {
        binding.btnContinue.setOnClickListener {
            if (isValidOtp()) {
                getOtpVerification(
                    request = OtpVerifyRequest(
                        number = phoneNumber,
                        otp = getOtp()
                    )
                )
            } else {
                showToast(getString(R.string.otp_atleast_digits))
            }
        }

        binding.ivEditPhone.setOnClickListener {
            stopTimer()
            finish()
        }
    }

    private fun getOtp() =
        binding.etOtp.text.toString().trim()

    private fun isValidOtp() =
        getOtp().length >= 4

    private fun getOtpVerification(request: OtpVerifyRequest) {
        if (NetworkUtils.hasInternetConnection(this)) {
            authViewModel.getOtpVerification(
                request = request
            )
        } else {
            showToast(getString(R.string.txt_check_your_connection))
        }
    }

    private fun observeOtpVerification() {
        authViewModel.doObserverOtpVerification().observe(this) {
            it?.let { res ->
                when (res) {
                    is Resource.Loading -> {
                        showProgress(true)
                    }
                    is Resource.Success -> {
                        showProgress(show = false)
                        showToast("Login successfully")

                        /*storing token to shared Pref*/
                        sessionManager.putString(SessionManager.ACCESS_TOKEN, res.result.token ?: "")

                        AppNavigationRoute.openNotesActivityAndKillOthers(this)
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

    private fun initCountDownTimer() {
        countdownTimer = object: CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val remainingTime = UiUtils.timeFormat(millisUntilFinished)
                binding.tvTimer.text = remainingTime
            }

            override fun onFinish() {
                binding.tvTimer.visibility = View.GONE
            }
        }

        startTimer()
    }

    private fun stopTimer() =
        countdownTimer?.cancel()

    private fun startTimer() =
        countdownTimer?.start()


    override fun onDestroy() {
        super.onDestroy()
        stopTimer()
        countdownTimer = null
    }

}