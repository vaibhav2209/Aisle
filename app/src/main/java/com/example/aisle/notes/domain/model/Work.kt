package com.example.aisle.notes.domain.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Work(
    @SerialName("experience_v1")
    val experienceV1: ExperienceV1,
    @SerialName("field_of_study_v1")
    val fieldOfStudyV1: FieldOfStudyV1,
    @SerialName("highest_qualification_v1")
    val highestQualificationV1: HighestQualificationV1,
    @SerialName("industry_v1")
    val industryV1: IndustryV1,
    @SerialName("monthly_income_v1")
    val monthlyIncomeV1: String?
)