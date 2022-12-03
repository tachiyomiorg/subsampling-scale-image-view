package com.davemorrissey.labs.subscaleview.test.imagedisplay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.davemorrissey.labs.subscaleview.ImageSource.Companion.asset
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.davemorrissey.labs.subscaleview.test.R
import com.davemorrissey.labs.subscaleview.test.R.layout

class ImageDisplayRotateFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(layout.imagedisplay_rotate_fragment, container, false)
        val imageView = rootView.findViewById<SubsamplingScaleImageView>(R.id.imageView)
        imageView.setImage(asset(context!!, "swissroad.jpg"))
        val activity = activity as ImageDisplayActivity?
        if (activity != null) {
            rootView.findViewById<View>(R.id.previous).setOnClickListener { activity.previous() }
            rootView.findViewById<View>(R.id.next).setOnClickListener { activity.next() }
        }
        return rootView
    }
}