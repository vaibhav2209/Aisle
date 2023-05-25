package com.example.aisle.notes.domain.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Profile(
    @SerialName("approved_time")
    val approvedTime: Double,
    @SerialName("disapproved_time")
    val disapprovedTime: Double,
    @SerialName("general_information")
    val generalInformation: GeneralInformation,
    @SerialName("has_active_subscription")
    val hasActiveSubscription: Boolean,
    val icebreakers: String?,
    @SerialName("instagram_images")
    val instagramImages: String?,
    @SerialName("is_facebook_data_fetched")
    val isFacebookDataFetched: Boolean,
    @SerialName("last_seen")
    val last_seen: String?,
    @SerialName("last_seen_window")
    val lastSeenWindow: String,
    val lat: Double,
    val lng: Double,
    val meetup: String?,
    @SerialName("online_code")
    val onlineCode: Int,
    val photos: List<Photo>,
    val preferences: List<Preference>,
    @SerialName("profile_data_list")
    val profileDataList: List<ProfileData>,
    @SerialName("show_concierge_badge")
    val showConciergeBadge: Boolean,
    val story: String?,
    @SerialName("user_interests")
    val userInterests: List<String?>,
    @SerialName("verification_status")
    val verificationStatus: String,
    val work: Work
)