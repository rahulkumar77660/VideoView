package com.example.videoview

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    lateinit var  videoView: VideoView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val VideoUrl = "https://resource.flexclip.com/templates/video/720p/breaking-news-channel-youtube-intro-outro.mp4"
        videoView =findViewById(R.id.video)
        val mediacontroller = MediaController(this)
        mediacontroller.setAnchorView(videoView)
        videoView.setVideoURI(Uri.parse(VideoUrl))
        videoView.setMediaController(mediacontroller)
        videoView.requestFocus()
        videoView.start()
        videoView.pause()


        videoView.setOnCompletionListener {
            Toast.makeText(applicationContext,"video is completed",Toast.LENGTH_SHORT).show()
        }
        videoView.setOnErrorListener { mp, what, extra ->

            Toast.makeText(applicationContext,"no network",Toast.LENGTH_SHORT).show()
            true

        }


    }
}