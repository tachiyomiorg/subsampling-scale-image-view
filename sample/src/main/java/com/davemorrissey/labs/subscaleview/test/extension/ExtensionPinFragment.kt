package com.davemorrissey.labs.subscaleview.test.extension

import android.graphics.PointF
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.davemorrissey.labs.subscaleview.ImageSource.Companion.asset
import com.davemorrissey.labs.subscaleview.test.R
import com.davemorrissey.labs.subscaleview.test.R.layout
import com.davemorrissey.labs.subscaleview.test.extension.views.PinView

class ExtensionPinFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(layout.extension_pin_fragment, container, false)
        val activity = activity as ExtensionActivity?
        if (activity != null) {
            rootView.findViewById<View>(R.id.next).setOnClickListener { activity.next() }
        }
        val imageView = rootView.findViewById<PinView>(R.id.imageView)
        imageView.setImage(asset(context!!, "sanmartino.jpg"))
        imageView.setPin(PointF(1602f, 405f))
        return rootView
    }
}