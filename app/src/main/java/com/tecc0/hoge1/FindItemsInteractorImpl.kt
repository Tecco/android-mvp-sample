package com.tecc0.hoge1

import android.os.Handler
import java.util.*


/**
 * Created by makoto_nishimoto on 2018/04/04.
 */

class FindItemsInteractorImpl : FindItemsInteractor {
    override fun findItems(listener: FindItemsInteractor.OnFinishedListener) {
        Handler().postDelayed({ listener.onFinished(createArrayList()) }, 2000)
    }

    private fun createArrayList(): List<String> {
        return Arrays.asList(
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5",
                "Item 6",
                "Item 7",
                "Item 8",
                "Item 9",
                "Item 10"
        )
    }
}