package com.carefreelife.carefreehealth.domains.physical.application.dto.request

import com.carefreelife.carefreehealth.domains.physical.application.dto.common.PhysicalTrainCommonDto
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class PhysicalTrainRequestDto(
    @NotBlank
    @Size(max = 30)
    val title: String,

    @NotBlank
    @Size(max = 255)
    val description: String,

    val motion: String,

    @NotBlank
    @Size(max = 255)
    val effect: String,

    @NotBlank
    @Size(max = 255)
    val caution: String,

    val tags: List<PhysicalTrainCommonDto.PhysicalTrainTagDto>?,
)