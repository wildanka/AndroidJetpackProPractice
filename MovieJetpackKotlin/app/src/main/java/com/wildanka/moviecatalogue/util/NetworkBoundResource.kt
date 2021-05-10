package com.wildanka.moviecatalogue.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.wildanka.moviecatalogue.vo.Resource

abstract class NetworkBoundResource<ResultType, RequestType>(private val mExecutors: AppExecutors) {

    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.loading(null)

        @Suppress("LeakingThis")
        val dbSource = loadFromDB()

        result.addSource(dbSource) { data ->
            result.removeSource(dbSource)
            result.addSource(dbSource) { newData ->
                result.value = Resource.success(newData)
            }
        }
    }

    protected abstract fun loadFromDB(): LiveData<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean


    fun asLiveData(): LiveData<Resource<ResultType>> = result
}