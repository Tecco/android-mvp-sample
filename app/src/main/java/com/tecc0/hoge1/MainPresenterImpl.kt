package com.tecc0.hoge1

/**
 * Created by makoto_nishimoto on 2018/04/04.
 */

class MainPresenterImpl(mainView: MainView, private val findItemsInteractor: FindItemsInteractor)
    : MainPresenter, FindItemsInteractor.OnFinishedListener {

    var mainView: MainView?

    init {
        this.mainView = mainView
    }

    override fun onResume() {
        mainView?.showProgress()
        findItemsInteractor.setItems(this)
    }

    override fun onItemClicked(position: Int) {
        if (BuildConfig.DEBUG) {
            mainView?.showMessage(String.format("Position %d", position + 1))
        } else {
            mainView?.showErrorMessage("Error")
        }
    }

    override fun onDestroy() {
        mainView = null
    }

    override fun onFinished(items: List<String>) {
        mainView?.setItems(items)
        mainView?.hideProgress()
    }
}