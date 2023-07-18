package com.eimtest.sds.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.eimtest.sds.R
import com.eimtest.sds.getInitials
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val viewModel by viewModels<MainViewModel>()

    private val progressBar by lazy {
        findViewById<ProgressBar>(R.id.progressbar)
    }

    private val imageView by lazy {
        findViewById<ImageView>(R.id.imageView)
    }

    private val textView by lazy {
        findViewById<TextView>(R.id.textView)
    }

    private val buttonPrev by lazy {
        findViewById<Button>(R.id.buttonPrev)
    }

    private val buttonNext by lazy {
        findViewById<Button>(R.id.buttonNext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonPrev.setOnClickListener(this)
        buttonNext.setOnClickListener(this)

        viewModel.playlists.observe(this) { playlists ->
            if (playlists.isNotEmpty()) {
                viewModel.playTrack(0)
            }
        }

        viewModel.isLoading.observe(this) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.error.observe(this) { error ->
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }

        viewModel.currentTrack.observe(this) { track ->
            Glide.with(this)
                .load(track.getImageUrl())
                .into(imageView)

            textView.text = track.name.getInitials()
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.buttonPrev -> viewModel.playPreviousTrack()
            R.id.buttonNext -> viewModel.playNextTrack()
        }
    }

}