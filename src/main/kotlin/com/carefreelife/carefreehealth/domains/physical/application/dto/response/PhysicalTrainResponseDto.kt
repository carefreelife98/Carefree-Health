package com.carefreelife.carefreehealth.domains.physical.application.dto.response

import com.carefreelife.carefreehealth.domains.physical.domain.`object`.common.PhysicalTrainTag
import java.time.ZonedDateTime

data class PhysicalTrainResponseDto(
    val exerciseId: Long,
    val title: String,
    val description: String,
    val motion: String,
    val effect: String,
    val caution: String,
    val tags: List<PhysicalTrainTag>,
    val created: ZonedDateTime,
    val updated: ZonedDateTime
)