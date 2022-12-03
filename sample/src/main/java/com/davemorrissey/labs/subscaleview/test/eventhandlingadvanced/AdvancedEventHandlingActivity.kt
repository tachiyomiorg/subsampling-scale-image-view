package com.davemorrissey.labs.subscaleview.test.eventhandlingadvanced

import android.os.Bundle
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.widget.Toast
import com.davemorrissey.labs.subscaleview.ImageSource.Companion.asset
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.davemorrissey.labs.subscaleview.test.AbstractPagesActivity
import com.davemorrissey.labs.subscaleview.test.Page
import com.davemorrissey.labs.subscaleview.test.R.id
import com.davemorrissey.labs.subscaleview.test.R.layout
import com.davemorrissey.labs.subscaleview.test.R.string

class AdvancedEventHandlingActivity : AbstractPagesActivity(
    string.advancedevent_title, layout.pages_activity, listOf(
        Page(string.advancedevent_p1_subtitle, string.advancedevent_p1_text),
        Page(string.advancedevent_p2_subtitle, string.advancedevent_p2_text),
        Page(string.advancedevent_p3_subtitle, string.advancedevent_p3_text),
        Page(string.advancedevent_p4_subtitle, string.advancedevent_p4_text),
        Page(string.advancedevent_p5_subtitle, string.advancedevent_p5_text)
    )
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageView = findViewById<SubsamplingScaleImageView>(id.imageView)
        val gestureDetector = GestureDetector(this, object : SimpleOnGestureListener() {
            override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
                if (imageView.isReady) {
                    val sCoord = imageView.viewToSourceCoord(e.x, e.y)
                    Toast.makeText(
                        applicationContext,
                        "Single tap: " + sCoord!!.x.toInt() + ", " + sCoord.y.toInt(),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Single tap: Image not ready",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                return true
            }

            override fun onLongPress(e: MotionEvent) {
                if (imageView.isReady) {
                    val sCoord = imageView.viewToSourceCoord(e.x, e.y)
                    Toast.makeText(
                        applicationContext,
                        "Long press: " + sCoord!!.x.toInt() + ", " + sCoord.y.toInt(),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Long press: Image not ready",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onDoubleTap(e: MotionEvent): Boolean {
                if (imageView.isReady) {
                    val sCoord = imageView.viewToSourceCoord(e.x, e.y)
                    Toast.makeText(
                        applicationContext,
                        "Double tap: " + sCoord!!.x.toInt() + ", " + sCoord.y.toInt(),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Double tap: Image not ready",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                return true
            }
        })
        imageView.setImage(asset(this, "sanmartino.jpg"))
        imageView.setOnTouchListener { _, motionEvent -> gestureDetector.onTouchEvent(motionEvent) }
    }
}