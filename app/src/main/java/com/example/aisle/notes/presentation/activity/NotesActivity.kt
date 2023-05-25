package com.example.aisle.notes.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.aisle.R
import com.example.aisle.application.SessionManager
import com.example.aisle.databinding.ActivityNotesBinding
import com.example.aisle.notes.domain.model.Notes
import com.example.aisle.notes.presentation.viewmodel.NotesViewModel
import com.example.aisle.utils.UiUtils.showLogD
import com.example.aisle.utils.UiUtils.showLogE
import com.example.aisle.utils.UiUtils.showToast
import com.example.aisle.utils.network.NetworkUtils
import com.example.aisle.utils.network.Resource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotesBinding

    private val notesViewModel: NotesViewModel by viewModels()

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        observeNotes()
        getNotes()
    }

    private fun getNotes() {
        if (NetworkUtils.hasInternetConnection(this)) {
            notesViewModel.getNotes(
                token = sessionManager.getString(SessionManager.ACCESS_TOKEN)
            )
        } else {
            showToast(getString(R.string.txt_check_your_connection))
        }
    }

    private fun observeNotes() {
        notesViewModel.doObserverNotes().observe(this) {
            it?.let { res ->
                when (res) {
                    is Resource.Loading -> {
                        showProgress(true)
                    }
                    is Resource.Success -> {
                        showLogD(res.result.toString())
                        bindData(res.result)
                        showProgress(show = false)
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

    private fun bindData(notes: Notes) {

        val profile = notes.invites.profiles.first()
        val likeProfiles = notes.likes.profiles

        /*user name*/
        binding.tvUserName.text = profile.generalInformation.firstName

        /*Display user selected photo*/
        val selectedPhoto = profile.photos.find { it.selected }?.photo ?: ""
        binding.ivUser.load(selectedPhoto) {
            crossfade(true)
            placeholder(R.drawable.demo1)
        }

        /*Liked user 1*/
        binding.tvLikedUserName1.text = likeProfiles.first().firstName

        val likeAvatar1 = likeProfiles.first().avatar
        binding.ivLike1.load(likeAvatar1) {
            crossfade(true)
            placeholder(R.drawable.demo1)
        }

        /*Liked user 2*/
        if (likeProfiles.size > 1) {
            binding.tvLikedUserName2.text = likeProfiles[1].firstName

            val likeAvatar2 = likeProfiles[1].avatar
            binding.ivLike2.load(likeAvatar2) {
                crossfade(true)
                placeholder(R.drawable.demo2)
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