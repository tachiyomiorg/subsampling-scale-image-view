package com.davemorrissey.labs.subscaleview.test

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.davemorrissey.labs.subscaleview.test.R.id
import com.davemorrissey.labs.subscaleview.test.R.layout
import com.davemorrissey.labs.subscaleview.test.R.string
import com.davemorrissey.labs.subscaleview.test.animation.AnimationActivity
import com.davemorrissey.labs.subscaleview.test.basicfeatures.BasicFeaturesActivity
import com.davemorrissey.labs.subscaleview.test.configuration.ConfigurationActivity
import com.davemorrissey.labs.subscaleview.test.eventhandling.EventHandlingActivity
import com.davemorrissey.labs.subscaleview.test.eventhandlingadvanced.AdvancedEventHandlingActivity
import com.davemorrissey.labs.subscaleview.test.extension.ExtensionActivity
import com.davemorrissey.labs.subscaleview.test.imagedisplay.ImageDisplayActivity
import com.davemorrissey.labs.subscaleview.test.viewpager.ViewPagerActivity

class MainActivity : Activity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionBar = actionBar
        actionBar?.setTitle(string.main_title)
        setContentView(layout.main)
        findViewById<View>(id.basicFeatures).setOnClickListener(this)
        findViewById<View>(id.imageDisplay).setOnClickListener(this)
        findViewById<View>(id.eventHandling).setOnClickListener(this)
        findViewById<View>(id.advancedEventHandling).setOnClickListener(this)
        findViewById<View>(id.viewPagerGalleries).setOnClickListener(this)
        findViewById<View>(id.animation).setOnClickListener(this)
        findViewById<View>(id.extension).setOnClickListener(this)
        findViewById<View>(id.configuration).setOnClickListener(this)
        findViewById<View>(id.github).setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            id.basicFeatures -> startActivity(BasicFeaturesActivity::class.java)
            id.imageDisplay -> startActivity(ImageDisplayActivity::class.java)
            id.eventHandling -> startActivity(EventHandlingActivity::class.java)
            id.advancedEventHandling -> startActivity(AdvancedEventHandlingActivity::class.java)
            id.viewPagerGalleries -> startActivity(ViewPagerActivity::class.java)
            id.animation -> startActivity(AnimationActivity::class.java)
            id.extension -> startActivity(ExtensionActivity::class.java)
            id.configuration -> startActivity(ConfigurationActivity::class.java)
            id.github -> openGitHub()
        }
    }

    private fun startActivity(activity: Class<out Activity>) {
        val intent = Intent(this, activity)
        startActivity(intent)
    }

    private fun openGitHub() {
        val i = Intent(Intent.ACTION_VIEW)
        i.data =
            Uri.parse("https://github.com/davemorrissey/subsampling-scale-image-view")
        startActivity(i)
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }
}