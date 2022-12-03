package com.davemorrissey.labs.subscaleview.test.basicfeatures

import android.os.Bundle
import com.davemorrissey.labs.subscaleview.ImageSource.Companion.asset
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.davemorrissey.labs.subscaleview.test.AbstractPagesActivity
import com.davemorrissey.labs.subscaleview.test.Page
import com.davemorrissey.labs.subscaleview.test.R.id
import com.davemorrissey.labs.subscaleview.test.R.layout
import com.davemorrissey.labs.subscaleview.test.R.string

class BasicFeaturesActivity : AbstractPagesActivity(
    string.basic_title, layout.pages_activity, listOf(
        Page(string.basic_p1_subtitle, string.basic_p1_text),
        Page(string.basic_p2_subtitle, string.basic_p2_text),
        Page(string.basic_p3_subtitle, string.basic_p3_text),
        Page(string.basic_p4_subtitle, string.basic_p4_text),
        Page(string.basic_p5_subtitle, string.basic_p5_text)
    )
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = findViewById<SubsamplingScaleImageView>(id.imageView)
        view.setImage(asset(this, "sanmartino.jpg"))
    }
}