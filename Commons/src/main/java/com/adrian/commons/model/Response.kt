package com.adrian.commons.model

sealed class Response<T> {
    data class Loading<T>(val isLoading: Boolean) : Response<T>()
    data class Success<T>(val data: T) : Response<T>()
    data class Failure<T>(val error: Exception, val message: String) : Response<T>()
}