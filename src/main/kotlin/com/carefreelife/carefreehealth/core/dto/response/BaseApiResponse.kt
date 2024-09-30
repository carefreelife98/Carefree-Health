package com.carefreelife.carefreehealth.core.dto.response

import com.carefreelife.carefreehealth.core.common.ResponseCode

data class BaseCarefreeApiResponse<T>(
    val status: ResponseCode,
    val data: T? = null
) {
    val code: String = status.code
    val message: String = status.message
}
