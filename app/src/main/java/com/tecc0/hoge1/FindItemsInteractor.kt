package com.tecc0.hoge1

/**
 * Created by makoto_nishimoto on 2018/04/04.
 */

interface FindItemsInteractor {

    interface OnFinishedListener {
        fun onFinished(items: List<String>)
    }

    fun findItems(listener: OnFinishedListener)
}