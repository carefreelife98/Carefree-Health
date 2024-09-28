package com.carefreelife.carefreehealth.domains.physical.application.usecases

import com.carefreelife.carefreehealth.core.property.ExerciseId
import com.carefreelife.carefreehealth.domains.physical.application.dto.response.PhysicalTrainResponse

interface GetPhysicalTrainUseCase {
    fun getPhysicalTrainDetailById(exerciseId: ExerciseId): PhysicalTrainResponse.PhysicalTrainResponseDto
}