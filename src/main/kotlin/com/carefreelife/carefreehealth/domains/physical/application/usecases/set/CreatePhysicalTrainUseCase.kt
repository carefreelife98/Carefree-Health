package com.carefreelife.carefreehealth.domains.physical.application.usecases.set

import com.carefreelife.carefreehealth.domains.physical.application.dto.request.PhysicalTrainRequestDto
import com.carefreelife.carefreehealth.domains.physical.domain.common.PhysicalTrainTags

interface CreatePhysicalTrainUseCase {
    fun createPhysicalTrainDetail(physicalTrainRequestDto: PhysicalTrainRequestDto): Long
//    fun createPhysicalTrainTag(physicalTrainTags: PhysicalTrainTags)
}