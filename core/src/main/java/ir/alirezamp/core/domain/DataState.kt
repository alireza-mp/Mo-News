package ir.alirezamp.core.domain

sealed class DataState<T>(val data: T? = null, val message: String? = null) {

    class Success<T>(data: T?) : DataState<T>(data)

    class Error<T>(data: T? = null, message: String) : DataState<T>(data, message)

}
