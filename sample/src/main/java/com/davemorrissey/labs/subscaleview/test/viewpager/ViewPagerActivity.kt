package com.davemorrissey.labs.subscaleview.test.viewpager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.davemorrissey.labs.subscaleview.test.AbstractPagesActivity
import com.davemorrissey.labs.subscaleview.test.Page
import com.davemorrissey.labs.subscaleview.test.R.id
import com.davemorrissey.labs.subscaleview.test.R.layout
import com.davemorrissey.labs.subscaleview.test.R.string

class ViewPagerActivity : AbstractPagesActivity(
    string.pager_title, layout.view_pager, listOf(
        Page(string.pager_p1_subtitle, string.pager_p1_text),
        Page(string.pager_p2_subtitle, string.pager_p2_text)
    )
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val horizontalPager = findViewById<ViewPager>(id.horizontal_pager)
        horizontalPager.adapter = ScreenSlidePagerAdapter(supportFragmentManager)
        val verticalPager = findViewById<ViewPager>(id.vertical_pager)
        verticalPager.adapter = ScreenSlidePagerAdapter(supportFragmentManager)
    }

    override fun onBackPressed() {
        val viewPager =
            findViewById<ViewPager>(if (page == 0) id.horizontal_pager else id.vertical_pager)
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    override fun onPageChanged(page: Int) {
        if (page == 0) {
            findViewById<View>(id.horizontal_pager).visibility = View.VISIBLE
            findViewById<View>(id.vertical_pager).visibility = View.GONE
        } else {
            findViewById<View>(id.horizontal_pager).visibility = View.GONE
            findViewById<View>(id.vertical_pager).visibility = View.VISIBLE
        }
    }

    private inner class ScreenSlidePagerAdapter constructor(fm: FragmentManager) :
        FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            val fragment = ViewPagerFragment()
            fragment.setAsset(IMAGES[position])
            return fragment
        }

        override fun getCount(): Int {
            return IMAGES.size
        }
    }

    companion object {
        private val IMAGES = arrayOf("sanmartino.jpg", "swissroad.jpg")
    }
}