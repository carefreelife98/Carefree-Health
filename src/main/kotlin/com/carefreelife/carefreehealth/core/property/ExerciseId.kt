package com.carefreelife.carefreehealth.core.property

import jakarta.annotation.Nullable
import lombok.Getter

@Getter
data class ExerciseId(
    @Nullable
    var id: Long
)