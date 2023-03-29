package com.RNGLLIB

import android.opengl.GLES20.glClearColor
import android.opengl.GLES20.glViewport
import android.opengl.GLSurfaceView.Renderer
import android.util.Log
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class CustomGlRenderer : Renderer {
    private lateinit var mTriangle: Triangle
    var isActive: Boolean = false

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        Log.i("Renderer", "onSurfaceCreated")
        glClearColor(0f, 0f, 0f, 1f);
        mTriangle = Triangle()
    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        Log.i("Renderer", "onSurfaceChanged")
        glViewport(0, 0, width, height)
    }

    override fun onDrawFrame(gl: GL10?) {
        if (isActive) {
            Log.i("Renderer", "onDrawFrame")
            mTriangle.draw()
        }
    }
}