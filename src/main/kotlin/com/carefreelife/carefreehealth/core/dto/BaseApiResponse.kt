package com.carefreelife.carefreehealth.core.dto

data class BaseCFHealthApiResponse<T>(
    val code: ResponseCode,
    val data: T? = null,
    val message: String = code.message
)
