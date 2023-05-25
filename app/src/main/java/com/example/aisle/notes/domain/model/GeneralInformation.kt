package com.example.aisle.notes.domain.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class GeneralInformation(
    val age: Int,
    val cast: String?,
    @SerialName("date_of_birth")
    val dob: String,
    @SerialName("date_of_birth_v1")
    val dobV1: String,
    val diet: String?,
    @SerialName("drinking_v1")
    val drinkingV1: DrinkingV1,
    val faith: Faith,
    @SerialName("first_name")
    val firstName: String,
    val gender: String,
    val height: Int,
    val kid: String?,
    val location: Location,
    @SerialName("marital_status_v1")
    val maritalStatusV1: MaritalStatusV1,
    val mbti: String?,
    @SerialName("mother_tongue")
    val motherTongue: MotherTongue,
    val pet: String?,
    val politics: String?,
    @SerialName("ref_id")
    val refId: String,
    val settle: String?,
    @SerialName("smoking_v1")
    val smokingV1: SmokingV1,
    @SerialName("sun_sign_v1")
    val sunSignV1: SunSignV1
)