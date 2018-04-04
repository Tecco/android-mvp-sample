package com.tecc0.hoge1

/**
 * Created by makoto_nishimoto on 2018/04/04.
 */

class MainPresenterImpl(mainView: MainView, private val findItemsInteractor: FindItemsInteractor) : MainPresenter, FindItemsInteractor.OnFinishedListener {

    var mainView: MainView? = null
        private set

    init {
        this.mainView = mainView
    }

    override fun onResume() {
        mainView?.showProgress()
        findItemsInteractor.findItems(this)
    }

    override fun onItemClicked(position: Int) {
        mainView?.showMessage(String.format("Position %d clicked", position + 1))
    }

    override fun onDestroy() {
        mainView = null
    }

    override fun onFinished(items: List<String>) {
        mainView?.setItems(items)
        mainView?.hideProgress()
    }
}