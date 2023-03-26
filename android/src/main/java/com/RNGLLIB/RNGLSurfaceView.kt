package com.RNGLLIB

import android.opengl.GLSurfaceView
import com.facebook.react.bridge.ReactContext

class RNGLSurfaceView(ctx: ReactContext) : GLSurfaceView(ctx) {

    override fun onPause() {
        super.onPause()

    }

    override fun onResume() {
        super.onResume()
    }

    override fun setRenderer(renderer: Renderer?) {
        super.setRenderer(renderer)
    }

}