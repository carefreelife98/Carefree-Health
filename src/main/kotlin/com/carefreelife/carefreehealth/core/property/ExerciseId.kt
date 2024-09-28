package com.carefreelife.carefreehealth.core.property

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import lombok.Getter

@Getter
data class ExerciseId(
    @field:Positive(message = "운동의 ID는 양수만 설정 가능합니다.")
    @field:NotNull(message = "운동의 ID는 필수 요소입니다.")
    var id: Long
)