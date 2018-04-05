package com.tecc0.hoge1

/**
 * Created by makoto_nishimoto on 2018/04/05.
 */

interface MainPresenter {

    fun onResume()

    fun onItemClicked(position: Int)

    fun onDestroy()
}