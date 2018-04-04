package com.tecc0.hoge1

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*


class MainActivity : Activity(), MainView, AdapterView.OnItemClickListener {

    private var listView: ListView? = null
    private var progressBar: ProgressBar? = null
    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById<View>(R.id.list) as ListView
        listView?.onItemClickListener = this
        progressBar = findViewById<View>(R.id.progress) as ProgressBar?
        presenter = MainPresenterImpl(this, FindItemsInteractorImpl())
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        presenter?.onDestroy()
        super.onDestroy()
    }

    override fun showProgress() {
        progressBar?.visibility = View.VISIBLE
        listView?.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progressBar?.visibility = View.INVISIBLE
        listView?.visibility = View.VISIBLE
    }

    override fun setItems(items: List<String>) {
        listView?.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        presenter?.onItemClicked(position)
    }
}