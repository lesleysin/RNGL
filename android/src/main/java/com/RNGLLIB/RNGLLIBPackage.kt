package com.RNGLLIB

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager

class RNGLLIBPackage : ReactPackage{

    override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
        return listOf<ViewManager<*, *>>(RNGLLIBViewManager(reactContext))
    }

    override fun createNativeModules(p0: ReactApplicationContext): List<NativeModule> {
        return emptyList()
    }
}