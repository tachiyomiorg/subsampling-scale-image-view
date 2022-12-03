package com.davemorrissey.labs.subscaleview.test.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.davemorrissey.labs.subscaleview.ImageSource.Companion.asset
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.davemorrissey.labs.subscaleview.test.R
import com.davemorrissey.labs.subscaleview.test.R.layout

class ViewPagerFragment : Fragment() {
    private var asset: String? = null
    fun setAsset(asset: String?) {
        this.asset = asset
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(layout.view_pager_page, container, false)
        if (savedInstanceState != null) {
            if (asset == null && savedInstanceState.containsKey(BUNDLE_ASSET)) {
                asset = savedInstanceState.getString(BUNDLE_ASSET)
            }
        }
        if (asset != null) {
            val imageView = rootView.findViewById<SubsamplingScaleImageView>(R.id.imageView)
            imageView.setImage(asset(context!!, asset!!))
        }
        return rootView
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val rootView = view
        if (rootView != null) {
            outState.putString(BUNDLE_ASSET, asset)
        }
    }

    companion object {
        private const val BUNDLE_ASSET = "asset"
    }
}