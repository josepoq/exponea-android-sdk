package com.exponea.sdk.manager

import android.app.Activity
import android.app.Application
import android.os.Bundle
import java.sql.Timestamp

abstract class SessionManager : Application.ActivityLifecycleCallbacks {

    abstract fun onSessionStart()

    abstract fun onSessionEnd()

    abstract fun startSessionListener()

    abstract fun stopSessionListener()

    abstract fun trackSessionEnd(timestamp: Long)

    abstract fun trackSessionStart(timestamp: Long)

    override fun onActivityPaused(activity: Activity?) {
        onSessionEnd()
    }

    override fun onActivityResumed(activity: Activity?) {
        onSessionStart()
    }

    override fun onActivityStarted(activity: Activity?) {}
    override fun onActivityDestroyed(activity: Activity?) {}
    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {}
    override fun onActivityStopped(activity: Activity?) {}
    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {}
}