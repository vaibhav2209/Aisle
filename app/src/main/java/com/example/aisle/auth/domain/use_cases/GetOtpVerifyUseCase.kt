package com.example.aisle.auth.domain.use_cases

import com.example.aisle.auth.domain.model.OtpVerifyDto
import com.example.aisle.auth.domain.model.OtpVerifyRequest
import com.example.aisle.auth.domain.repository.IAuthRepository
import com.example.aisle.utils.network.Resource
import javax.inject.Inject


class GetOtpVerifyUseCase @Inject constructor(
    private val repository: IAuthRepository
) {

    suspend operator fun invoke(request: OtpVerifyRequest): Resource<OtpVerifyDto> {
        return try {

            val response = repository.getOtpVerification(request)

            if (response.token.isNullOrBlank()) {
                Resource.Failure(
                    Exception("Invalid Otp or Token is null")
                )
            } else {
                Resource.Success(response)
            }

        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }
    }
}