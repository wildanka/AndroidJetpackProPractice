package com.wildanka.moviecatalogue.util

import android.os.Handler
import android.os.Looper
import androidx.annotation.NonNull
import androidx.annotation.VisibleForTesting
import java.util.concurrent.Executor
import java.util.concurrent.Executors


open class AppExecutors @VisibleForTesting
constructor(private val diskIO: Executor) {

    constructor() : this(
        DiskIOThreadExecutor(),
    )

    fun diskIO(): Executor {
        return diskIO
    }

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(@NonNull command: Runnable) {
            mainThreadHandler.post(command)
        }
    }

    companion object {

        private val THREAD_COUNT = 1
    }

}