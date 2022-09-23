package com.northsoltech.domain.models

sealed class ApiResource<out T> {
    class Loading<T>(val data: T? = null) : ApiResource<T>()
    class Valid<T>(val data: T) : ApiResource<T>()
    class Invalid<T>(val data: T? = null, val message: String) : ApiResource<T>()
}

fun <T, R> ApiResource<T>.transform(
    transform: ((value: T) -> R),
): ApiResource<R> = when (this) {
    is ApiResource.Loading -> ApiResource.Loading(
        data = data?.let { transform.invoke(it) })
    is ApiResource.Valid -> ApiResource.Valid(
        data = transform.invoke(data))
    is ApiResource.Invalid -> ApiResource.Invalid(
        data = data?.let { transform.invoke(it) },
        message = message
    )
}

fun <T> ApiResource<T>.getDataOrNull() = when (this) {
    is ApiResource.Valid -> data
    is ApiResource.Invalid -> data
    is ApiResource.Loading -> data
}
