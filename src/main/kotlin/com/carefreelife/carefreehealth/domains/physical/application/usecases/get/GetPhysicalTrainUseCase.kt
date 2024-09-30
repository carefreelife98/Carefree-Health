package com.carefreelife.carefreehealth.domains.physical.application.usecases.get

import com.carefreelife.carefreehealth.core.property.ExerciseId
import com.carefreelife.carefreehealth.domains.physical.application.dto.response.PhysicalTrainResponseDto

interface GetPhysicalTrainUseCase {
    fun getPhysicalTrainDetailById(exerciseId: ExerciseId): PhysicalTrainResponseDto
}