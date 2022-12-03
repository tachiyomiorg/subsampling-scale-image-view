package com.davemorrissey.labs.subscaleview.test

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.davemorrissey.labs.subscaleview.test.R.id

abstract class AbstractPagesActivity protected constructor(
    private val title: Int,
    private val layout: Int,
    private val notes: List<Page>
) : FragmentActivity() {
    protected var page = 0
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        val actionBar = actionBar
        if (actionBar != null) {
            actionBar.title = getString(title)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        findViewById<View>(id.next).setOnClickListener { next() }
        findViewById<View>(id.previous).setOnClickListener { previous() }
        if (savedInstanceState != null && savedInstanceState.containsKey(BUNDLE_PAGE)) {
            page = savedInstanceState.getInt(BUNDLE_PAGE)
        }
    }

    override fun onResume() {
        super.onResume()
        updateNotes()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(BUNDLE_PAGE, page)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }

    private operator fun next() {
        page++
        updateNotes()
    }

    private fun previous() {
        page--
        updateNotes()
    }

    private fun updateNotes() {
        if (page > notes.size - 1) {
            return
        }
        val actionBar = actionBar
        actionBar?.setSubtitle(notes[page].subtitle)
        (findViewById<View>(id.note) as TextView).setText(notes[page].text)
        findViewById<View>(id.next).visibility =
            if (page >= notes.size - 1) View.INVISIBLE else View.VISIBLE
        findViewById<View>(id.previous).visibility =
            if (page <= 0) View.INVISIBLE else View.VISIBLE
        onPageChanged(page)
    }

    protected open fun onPageChanged(page: Int) {}

    companion object {
        private const val BUNDLE_PAGE = "page"
    }
}