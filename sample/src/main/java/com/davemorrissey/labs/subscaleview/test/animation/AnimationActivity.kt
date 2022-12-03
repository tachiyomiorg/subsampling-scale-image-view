package com.davemorrissey.labs.subscaleview.test.animation

import android.graphics.PointF
import android.os.Bundle
import android.view.View
import com.davemorrissey.labs.subscaleview.ImageSource.Companion.asset
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.davemorrissey.labs.subscaleview.test.AbstractPagesActivity
import com.davemorrissey.labs.subscaleview.test.Page
import com.davemorrissey.labs.subscaleview.test.R.id
import com.davemorrissey.labs.subscaleview.test.R.layout
import com.davemorrissey.labs.subscaleview.test.R.string
import com.davemorrissey.labs.subscaleview.test.extension.views.PinView
import java.util.Random

class AnimationActivity : AbstractPagesActivity(
    string.animation_title, layout.animation_activity, listOf(
        Page(string.animation_p1_subtitle, string.animation_p1_text),
        Page(string.animation_p2_subtitle, string.animation_p2_text),
        Page(string.animation_p3_subtitle, string.animation_p3_text),
        Page(string.animation_p4_subtitle, string.animation_p4_text)
    )
) {
    private var view: PinView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<View>(id.play).setOnClickListener { play() }
        view = findViewById(id.imageView)
        view!!.setImage(asset(this, "sanmartino.jpg"))
    }

    override fun onPageChanged(page: Int) {
        if (page == 2) {
            view!!.setPanLimit(SubsamplingScaleImageView.PAN_LIMIT_CENTER)
        } else {
            view!!.setPanLimit(SubsamplingScaleImageView.PAN_LIMIT_INSIDE)
        }
    }

    private fun play() {
        val random = Random()
        if (view!!.isReady) {
            val maxScale = view!!.maxScale
            val minScale: Float = view!!.getMinScale()
            val scale = random.nextFloat() * (maxScale - minScale) + minScale
            val center = PointF(
                random.nextInt(view!!.sWidth).toFloat(), random.nextInt(
                    view!!.sHeight
                ).toFloat()
            )
            view!!.setPin(center)
            val animationBuilder = view!!.animateScaleAndCenter(scale, center)
            if (page == 3) {
                animationBuilder!!.withDuration(2000)
                    .withEasing(SubsamplingScaleImageView.EASE_OUT_QUAD).withInterruptible(false)
                    .start()
            } else {
                animationBuilder!!.withDuration(750).start()
            }
        }
    }
}