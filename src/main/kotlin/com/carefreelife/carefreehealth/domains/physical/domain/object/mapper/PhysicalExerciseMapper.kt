package com.carefreelife.carefreehealth.domains.physical.domain.`object`.mapper

import com.carefreelife.carefreehealth.core.property.Description
import com.carefreelife.carefreehealth.core.property.Title
import com.carefreelife.carefreehealth.domains.physical.application.dto.request.PhysicalTrainRequestDto
import com.carefreelife.carefreehealth.domains.physical.domain.`object`.PhysicalTrainExercise

class PhysicalExerciseMapper {
    fun requestDtoToExercise(physicalTrainRequestDto: PhysicalTrainRequestDto): PhysicalTrainExercise {
        return PhysicalTrainExercise(
            null,
            Title(physicalTrainRequestDto.title),
            Description(physicalTrainRequestDto.description),
            physicalTrainRequestDto.tags,
            null,
            null,
            physicalTrainRequestDto.motion,
            physicalTrainRequestDto.effect,
            physicalTrainRequestDto.caution
        )
    }
}