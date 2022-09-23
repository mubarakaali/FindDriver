package com.northsoltech.network.utils

internal interface TransformableRequest<DATA_MODEL, DOMAIN_MODEL> {
    fun fromDomain(domainObj: DOMAIN_MODEL): DATA_MODEL
}