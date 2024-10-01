package com.carefreelife.carefreehealth.domains.physical.application.dto.request

import com.carefreelife.carefreehealth.domains.physical.domain.`object`.common.PhysicalTrainTag
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class PhysicalTrainRequestDto(
    @NotBlank(message = "트레이닝 종목의 이름은 필수 값 입니다.")
    @Size(max = 30)
    val title: String,

    @NotBlank(message = "트레이닝 종목의 설명은 필수 값 입니다.")
    @Size(max = 255)
    val description: String,

    val motion: String,

    @NotBlank(message = "트레이닝 종목의 효과는 필수 값 입니다.")
    @Size(max = 255)
    val effect: String,

    @NotBlank(message = "트레이닝 종목의 주의 사항은 필수 값 입니다.")
    @Size(max = 255)
    val caution: String,

    @NotNull(message = "트레이닝 종목의 태그 (카테고리) 설정은 필수입니다.")
    val tags: List<PhysicalTrainTag>,
)