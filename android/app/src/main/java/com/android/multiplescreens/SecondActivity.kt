package com.android.multiplescreens

import android.app.Presentation
import android.content.Context
import android.os.Bundle
import android.view.Display
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactRootView
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler


/**
 * This is the second activity
 */
class SecondActivity(private var outerContext: Context?, display: Display?) : Presentation(
    outerContext,
    display
), DefaultHardwareBackBtnHandler  {


    private lateinit var mReactRootView: ReactRootView
    private var mReactInstanceManager: ReactInstanceManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mReactRootView = ReactRootView(outerContext)

        mReactInstanceManager = MyApplication.getInstance().reactInstanceManager
        mReactRootView.startReactApplication(mReactInstanceManager, "SecondDisplay", null)

        setContentView(mReactRootView)
    }

    override fun invokeDefaultOnBackPressed() {
        super.onBackPressed()
    }



    override fun onBackPressed() {
        if (mReactInstanceManager != null) {
            mReactInstanceManager!!.onBackPressed()
        } else {
            super.onBackPressed()
        }
    }


    companion object {
        private const val TAG = "DualScreenStatus"
    }
}
