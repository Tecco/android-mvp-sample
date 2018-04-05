package com.tecc0.hoge1

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : Activity(), MainView, AdapterView.OnItemClickListener {

    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listview?.onItemClickListener = this
        presenter = MainPresenterImpl(this, FindItemsInteractorImpl())
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    override fun onDestroy() {
        presenter?.onDestroy()
        super.onDestroy()
    }

    override fun showProgress() {
        progressbar?.visibility = View.VISIBLE
        listview?.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progressbar?.visibility = View.INVISIBLE
        listview?.visibility = View.VISIBLE
    }

    override fun setItems(items: List<String>) {
        listview?.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        presenter?.onItemClicked(position)
    }
}