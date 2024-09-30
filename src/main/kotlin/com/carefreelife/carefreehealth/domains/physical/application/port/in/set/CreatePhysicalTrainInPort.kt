package com.carefreelife.carefreehealth.domains.physical.application.port.`in`.set

import com.carefreelife.carefreehealth.domains.physical.application.dto.request.PhysicalTrainRequestDto
import com.carefreelife.carefreehealth.domains.physical.application.dto.response.PhysicalTrainResponseDto
import com.carefreelife.carefreehealth.domains.physical.application.port.out.set.CreatePhysicalTrainOutPort
import com.carefreelife.carefreehealth.domains.physical.application.usecases.set.CreatePhysicalTrainUseCase
import com.carefreelife.carefreehealth.domains.physical.domain.common.PhysicalTrainTags
import org.springframework.stereotype.Service

@Service
class CreatePhysicalTrainInPort(
    private val createPhysicalTrainOutPort: CreatePhysicalTrainOutPort
): CreatePhysicalTrainUseCase {

    override fun createPhysicalTrainDetail(physicalTrainRequestDto: PhysicalTrainRequestDto): Long {
        return createPhysicalTrainOutPort.createPhysicalTrainDetail(physicalTrainRequestDto)
    }
}