package com.davemorrissey.labs.subscaleview.test.viewpager

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.viewpager.widget.ViewPager

/**
 * From http://stackoverflow.com/a/22797619/2719186
 */
class VerticalViewPager : ViewPager {
    constructor(context: Context?) : super(context!!) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
        init()
    }

    private fun init() {
        setPageTransformer(true, VerticalPageTransformer())
        overScrollMode = OVER_SCROLL_NEVER
    }

    private fun swapXY(ev: MotionEvent): MotionEvent {
        val width = width.toFloat()
        val height = height.toFloat()
        val newX = ev.y / height * width
        val newY = ev.x / width * height
        ev.setLocation(newX, newY)
        return ev
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        val intercepted = super.onInterceptTouchEvent(swapXY(ev))
        swapXY(ev)
        return intercepted
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return super.onTouchEvent(swapXY(ev))
    }

    private inner class VerticalPageTransformer : PageTransformer {
        override fun transformPage(view: View, position: Float) {
            if (position < -1) {
                view.alpha = 0f
            } else if (position <= 1) {
                view.alpha = 1f
                view.translationX = view.width * -position
                val yPosition = position * view.height
                view.translationY = yPosition
            } else {
                view.alpha = 0f
            }
        }
    }
}