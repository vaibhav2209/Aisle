package com.example.aisle.notes.domain.model

import org.json.JSONArray
import org.json.JSONObject

interface INotesApiFilter {

    companion object {


        fun getNotes(response: String) {
            try {

                val jsonObject = JSONObject(response)
                val responseObj = jsonObject.optJSONObject("invites") ?: JSONObject()

                /*getting Likes*/
                getLikes(jsonObject)




            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }

        fun getLikes(response: JSONObject): Likes {

            return try {

                val likesObj = response.optJSONObject("likes") ?: JSONObject()

                /*getting profiles of liked users*/
                val profileArr = likesObj.optJSONArray("profiles") ?: JSONArray()

                val likesUser = mutableListOf<LikesUser>()

                for (i in 0 until profileArr.length()) {

                    val profileObj = profileArr.optJSONObject(i) ?: JSONObject()

                    val firstName = profileObj.optString("first_name").orEmpty()
                    val avatar = profileObj.optString("avatar").orEmpty()

                    likesUser.add(
                        LikesUser(
                            avatar = avatar,
                            firstName = firstName
                        )
                    )
                }

                val canSeeProfile = likesObj.optBoolean("can_see_profile")
                val receivedCount = likesObj.optInt("likes_received_count")

                Likes(
                    likesUsers = likesUser,
                    canSeeProfile = canSeeProfile,
                    likesReceivedCount = receivedCount
                )

            } catch (e: Exception) {
                e.printStackTrace()
                Likes()
            }
        }

        fun getInvites(response: JSONObject) {

        }
    }
}