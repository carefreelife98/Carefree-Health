package com.carefreelife.carefreehealth.core.dto

enum class ResponseCode(val code: String, val message: String) {
    // Http status 200
    SUCCESS("SU", "Operation successful"),

    // Http status 400
    BAD_REQUEST("BR", "Bad request"),

    // Http status 401
    UNAUTHORIZED("UA", "Unauthorized access"),

    // Http status 403
    FORBIDDEN("FB", "Access forbidden"),

    // Http status 404
    NOT_FOUND("NF", "Resource not found"),

    // Http status 500
    INTERNAL_ERROR("ER", "Internal server error");
}