package com.tecc0.hoge1

/**
 * Created by makoto_nishimoto on 2018/04/05.
 */

interface MainView {

    fun showProgress()

    fun hideProgress()

    fun setItems(items: List<String>)

    fun showMessage(message: String)

    fun showErrorMessage(message: String)
}