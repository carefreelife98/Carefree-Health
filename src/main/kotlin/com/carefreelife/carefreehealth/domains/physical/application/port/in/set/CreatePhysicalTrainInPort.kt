package com.carefreelife.carefreehealth.domains.physical.application.port.`in`.set

import com.carefreelife.carefreehealth.domains.physical.application.dto.request.PhysicalTrainRequestDto
import com.carefreelife.carefreehealth.domains.physical.application.port.out.set.CreatePhysicalTrainOutPort
import com.carefreelife.carefreehealth.domains.physical.application.usecases.set.CreatePhysicalTrainUseCase
import com.carefreelife.carefreehealth.domains.physical.domain.`object`.PhysicalTrainExercise
import com.carefreelife.carefreehealth.domains.physical.domain.`object`.mapper.PhysicalExerciseMapper
import org.springframework.stereotype.Service

@Service
class CreatePhysicalTrainInPort(
    private val createPhysicalTrainOutPort: CreatePhysicalTrainOutPort
): CreatePhysicalTrainUseCase {

    override fun createPhysicalTrainDetail(physicalTrainRequestDto: PhysicalTrainRequestDto): Long {
        val exercise: PhysicalTrainExercise = PhysicalExerciseMapper().requestDtoToExercise(physicalTrainRequestDto)
        return createPhysicalTrainOutPort.createPhysicalTrainDetail(exercise)
    }
}