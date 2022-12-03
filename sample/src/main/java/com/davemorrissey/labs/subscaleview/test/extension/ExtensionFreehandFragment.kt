package com.davemorrissey.labs.subscaleview.test.extension

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.davemorrissey.labs.subscaleview.ImageSource.Companion.asset
import com.davemorrissey.labs.subscaleview.test.R
import com.davemorrissey.labs.subscaleview.test.R.layout
import com.davemorrissey.labs.subscaleview.test.extension.views.FreehandView

class ExtensionFreehandFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(layout.extension_freehand_fragment, container, false)
        val activity = activity as ExtensionActivity?
        if (activity != null) {
            rootView.findViewById<View>(R.id.previous).setOnClickListener { activity.previous() }
        }
        val imageView = rootView.findViewById<FreehandView>(R.id.imageView)
        imageView.setImage(asset(context!!, "sanmartino.jpg"))
        rootView.findViewById<View>(R.id.reset).setOnClickListener { imageView.reset() }
        return rootView
    }
}