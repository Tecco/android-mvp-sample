package com.tecc0.hoge1

import android.os.Handler
import java.util.*


/**
 * Created by makoto_nishimoto on 2018/04/04.
 */

class FindItemsInteractorImpl : FindItemsInteractor {

    private val items = Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

    override fun setItems(listener: FindItemsInteractor.OnFinishedListener) {
        // ローディングを擬似的に2000ミリ秒出す
        Handler().postDelayed({ listener.onFinished(items) }, 2000)
    }
}