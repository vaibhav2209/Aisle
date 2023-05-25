package com.example.aisle.auth.domain.use_cases

import com.example.aisle.auth.domain.model.PhoneLoginDto
import com.example.aisle.auth.domain.model.PhoneLoginRequest
import com.example.aisle.auth.domain.repository.IAuthRepository
import com.example.aisle.utils.network.Resource
import javax.inject.Inject


class GetLoginViaPhoneUseCase @Inject constructor(
    private val repository: IAuthRepository
) {

    suspend operator fun invoke(request: PhoneLoginRequest): Resource<PhoneLoginDto> {
        return try {

            val response = repository.getLoginViaPhone(request)

            if (response.status) {
                Resource.Success(response)
            } else {
                Resource.Failure(
                    Exception("Login failed. check phone number")
                )
            }

        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }
    }
}