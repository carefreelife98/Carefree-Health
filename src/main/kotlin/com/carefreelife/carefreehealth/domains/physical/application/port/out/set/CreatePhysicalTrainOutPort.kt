package com.carefreelife.carefreehealth.domains.physical.application.port.out.set

import com.carefreelife.carefreehealth.domains.physical.application.dto.request.PhysicalTrainRequestDto
import com.carefreelife.carefreehealth.domains.physical.application.dto.response.PhysicalTrainResponseDto


interface CreatePhysicalTrainOutPort {
    fun createPhysicalTrainDetail(physicalTrainRequestDto: PhysicalTrainRequestDto): Long
}