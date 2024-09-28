package com.carefreelife.carefreehealth.domains.physical.application.dto.response

import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.entity.PhysicalTrainTagEntity
import java.time.ZonedDateTime

interface PhysicalTrainResponse {
    data class PhysicalTrainResponseDto(
        val exerciseId: Long,
        val title: String,
        val description: String,
        val motion: String,
        val effect: String,
        val caution: String,
        val tags: List<PhysicalTrainTagDto>,
        val created: ZonedDateTime,
        val updated: ZonedDateTime
    )

    data class PhysicalTrainTagDto(
        val tagCode: String,
        val tagDescription: String
    )
}