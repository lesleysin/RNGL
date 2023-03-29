package com.RNGLLIB

import android.app.ActivityManager
import android.content.Context
import android.content.pm.ConfigurationInfo
import android.graphics.PixelFormat
import android.opengl.GLSurfaceView
import android.opengl.GLSurfaceView.RENDERMODE_WHEN_DIRTY
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.view.ViewGroupCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.facebook.react.bridge.LifecycleEventListener
import com.facebook.react.bridge.ReactContext
import com.facebook.react.bridge.ReadableArray
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10


class RNGLLIBView(ctx: ReactContext) : FrameLayout(ctx), LifecycleOwner {
    private val lifecycleRegistry: LifecycleRegistry = LifecycleRegistry(this)
    private val appCtx: ReactContext;
    private var renderer: CustomGlRenderer = CustomGlRenderer();
    private var glSurface: GLSurfaceView = GLSurfaceView(ctx);

    init {
        appCtx = ctx;
       if (supportES2()) {
           Toast.makeText(ctx, "OpenGl ES 2.0 is supported", Toast.LENGTH_SHORT).show();
           glSurface.setEGLContextClientVersion(2)
           glSurface.setZOrderOnTop(true)
           glSurface.setEGLConfigChooser(8, 8, 8, 8, 16, 0)
           glSurface.holder.setFormat(PixelFormat.RGBA_8888)
           glSurface.setRenderer(renderer)

           ctx.addLifecycleEventListener(object : LifecycleEventListener {
               override fun onHostResume() {
                   Log.i("RNGL", "onResume")
                   glSurface.onResume()
               }
               override fun onHostPause() {
                   Log.i("RNGL", "onPause")
                   glSurface.onPause()
               }
               override fun onHostDestroy() {
                   Log.i("RNGL", "onDestroy")
                   //dispose logic there
               }
           })

           addView(glSurface)

       } else {
           Toast.makeText(ctx, "OpenGl ES 2.0 is not supported", Toast.LENGTH_LONG).show();
       }
    }

    private fun supportES2(): Boolean {
        val activityManager = appCtx.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager?
        val configurationInfo: ConfigurationInfo = activityManager!!.deviceConfigurationInfo
        return configurationInfo.reqGlEsVersion >= 0x20000
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    fun setGlLineWidth(value: Float) {
    }

    fun setGlPointSize(value: Float) {

    }

    fun setShaderPair(value: ReadableArray?) {

    }

    fun setActive(value: Boolean) {
        renderer.isActive = value;
    }

    fun setPoints(value: ReadableArray?) {

    }

}