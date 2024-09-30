package com.carefreelife.carefreehealth.domains.physical.application.usecases.set

import com.carefreelife.carefreehealth.domains.physical.application.dto.request.PhysicalTrainRequestDto

interface CreatePhysicalTrainUseCase {
    fun createPhysicalTrainDetail(physicalTrainRequestDto: PhysicalTrainRequestDto): Long
}