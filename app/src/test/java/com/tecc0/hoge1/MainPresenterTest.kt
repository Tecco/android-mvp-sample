package com.tecc0.hoge1

import junit.framework.Assert.assertNull
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor.forClass
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.util.*


/**
 * Created by makoto_nishimoto on 2018/04/05.
 */

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

    @Mock
    private var view: MainView? = null
    @Mock
    private var interactor: FindItemsInteractor? = null

    private var presenter: MainPresenterImpl? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        presenter = MainPresenterImpl(view!!, interactor!!)
    }

    @Test
    fun checkIfShowsProgressOnResume() {
        presenter!!.onResume()
        verify(view, times(1))!!.showProgress()
    }

    @Test
    fun checkIfShowsMessageOnItemClick() {
        presenter!!.onItemClicked(1)
        verify(view, times(1))!!.showMessage(anyString())
    }

    @Test
    fun checkIfRightMessageIsDisplayed() {
        val captor = forClass(String::class.java)
        presenter!!.onItemClicked(1)
        verify(view, times(1))!!.showMessage(captor.capture())
        assertThat(captor.getValue(), `is`("Position 2 clicked"))
    }

    @Test
    fun checkIfViewIsReleasedOnDestroy() {
        presenter!!.onDestroy()
        assertNull(presenter!!.mainView)
    }

    @Test
    fun checkIfItemsArePassedToView() {
        val items = Arrays.asList("Model", "View", "Controller")
        presenter!!.onFinished(items)
        verify(view, times(1))!!.setItems(items)
        verify(view, times(1))!!.hideProgress()
    }
}