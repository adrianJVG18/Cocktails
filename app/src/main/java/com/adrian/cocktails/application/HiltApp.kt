package com.adrian.cocktails.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Requirement of Hilt's implementation
 */
@HiltAndroidApp
class HiltApp : Application() { }