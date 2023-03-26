package com.RNGLLIB

import com.facebook.react.bridge.ReactContext
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNGLLIBManagerDelegate
import com.facebook.react.viewmanagers.RNGLLIBManagerInterface

@ReactModule(name = RNGLLIBViewManager.NAME)
public class RNGLLIBViewManager(var reactContext: ReactContext) : ViewGroupManager<RNGLLIBView>(), RNGLLIBManagerInterface<RNGLLIBView> {
    private val mDelegate: ViewManagerDelegate<RNGLLIBView>

    companion object {
        const val NAME: String = "RNGLLIB"
    }

    init {
        mDelegate = RNGLLIBManagerDelegate(this)
    }

    override fun getDelegate(): ViewManagerDelegate<RNGLLIBView>? {
        return mDelegate;
    }

    override fun getName(): String {
        return NAME
    }

    override fun createViewInstance(ctx: ThemedReactContext): RNGLLIBView {
        return RNGLLIBView(ctx)
    }

    @ReactProp(name = "fragmentShader")
    override fun setFragmentShader(view: RNGLLIBView?, value: String?) {
    }

    @ReactProp(name = "vertexShader")
    override fun setVertexShader(view: RNGLLIBView?, value: String?) {
    }

    @ReactProp(name = "points")
    override fun setPoints(view: RNGLLIBView?, value: ReadableArray?) {
    }

    @ReactProp(name = "glLineWidth")
    override fun setGlLineWidth(view: RNGLLIBView?, value: Float) {
    }

    @ReactProp(name = "glPointSize")
    override fun setGlPointSize(view: RNGLLIBView?, value: Float) {
    }
}