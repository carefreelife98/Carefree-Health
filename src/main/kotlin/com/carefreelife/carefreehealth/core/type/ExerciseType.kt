package com.carefreelife.carefreehealth.core.type

import lombok.Getter

@Getter
enum class ExerciseType (val value: String) {
    SINGLE(value = "SINGLE"),
    SHARED(value = "SHARED"),
}