package com.carefreelife.carefreehealth.domains.physical.application.dto.common

import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.entity.PhysicalTrainTagEntity

class PhysicalTrainCommonDto {
    data class PhysicalTrainTagDto(
        val tagCode: String,
        val tagDescription: String
    )
}