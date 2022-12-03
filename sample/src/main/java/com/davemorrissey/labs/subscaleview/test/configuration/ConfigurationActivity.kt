package com.davemorrissey.labs.subscaleview.test.configuration

import android.graphics.PointF
import android.os.Bundle
import com.davemorrissey.labs.subscaleview.ImageSource.Companion.asset
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.davemorrissey.labs.subscaleview.test.AbstractPagesActivity
import com.davemorrissey.labs.subscaleview.test.Page
import com.davemorrissey.labs.subscaleview.test.R.id
import com.davemorrissey.labs.subscaleview.test.R.layout
import com.davemorrissey.labs.subscaleview.test.R.string

class ConfigurationActivity : AbstractPagesActivity(
    string.configuration_title, layout.pages_activity, listOf(
        Page(string.configuration_p1_subtitle, string.configuration_p1_text),
        Page(string.configuration_p2_subtitle, string.configuration_p2_text),
        Page(string.configuration_p3_subtitle, string.configuration_p3_text),
        Page(string.configuration_p4_subtitle, string.configuration_p4_text),
        Page(string.configuration_p5_subtitle, string.configuration_p5_text),
        Page(string.configuration_p6_subtitle, string.configuration_p6_text),
        Page(string.configuration_p7_subtitle, string.configuration_p7_text),
        Page(string.configuration_p8_subtitle, string.configuration_p8_text),
        Page(string.configuration_p9_subtitle, string.configuration_p9_text),
        Page(string.configuration_p10_subtitle, string.configuration_p10_text)
    )
) {
    private var view: SubsamplingScaleImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = findViewById(id.imageView)
        view!!.setImage(asset(this, "card.png"))
    }

    override fun onPageChanged(page: Int) {
        if (page == 0) {
            view!!.setMinimumDpi(50)
        } else {
            view!!.maxScale = 2f
        }
        if (page == 1) {
            view!!.setMinimumTileDpi(50)
        } else {
            view!!.setMinimumTileDpi(320)
        }
        if (page == 4) {
            view!!.setDoubleTapZoomStyle(SubsamplingScaleImageView.ZOOM_FOCUS_CENTER)
        } else if (page == 5) {
            view!!.setDoubleTapZoomStyle(SubsamplingScaleImageView.ZOOM_FOCUS_CENTER_IMMEDIATE)
        } else {
            view!!.setDoubleTapZoomStyle(SubsamplingScaleImageView.ZOOM_FOCUS_FIXED)
        }
        if (page == 6) {
            view!!.setDoubleTapZoomDpi(240)
        } else {
            view!!.setDoubleTapZoomScale(1f)
        }
        if (page == 7) {
            view!!.setPanLimit(SubsamplingScaleImageView.PAN_LIMIT_CENTER)
        } else if (page == 8) {
            view!!.setPanLimit(SubsamplingScaleImageView.PAN_LIMIT_OUTSIDE)
        } else {
            view!!.setPanLimit(SubsamplingScaleImageView.PAN_LIMIT_INSIDE)
        }
        if (page == 9) {
            view!!.setDebug(true)
        } else {
            view!!.setDebug(false)
        }
        if (page == 2) {
            view!!.setScaleAndCenter(0f, PointF(3900f, 3120f))
            view!!.setPanEnabled(false)
        } else {
            view!!.setPanEnabled(true)
        }
        if (page == 3) {
            view!!.setScaleAndCenter(1f, PointF(3900f, 3120f))
            view!!.isZoomEnabled = false
        } else {
            view!!.isZoomEnabled = true
        }
    }
}