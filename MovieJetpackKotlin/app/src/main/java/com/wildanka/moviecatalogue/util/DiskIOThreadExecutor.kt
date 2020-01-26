package com.wildanka.moviecatalogue.util

import androidx.annotation.NonNull
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class DiskIOThreadExecutor : Executor {
    private var mDiskIO: Executor = Executors.newSingleThreadExecutor()

    override fun execute(@NonNull command: Runnable) {
        mDiskIO.execute(command)
    }
}
