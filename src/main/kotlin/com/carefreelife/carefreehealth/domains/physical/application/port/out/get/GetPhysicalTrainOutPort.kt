package com.carefreelife.carefreehealth.domains.physical.application.port.out.get

import com.carefreelife.carefreehealth.core.property.ExerciseId
import com.carefreelife.carefreehealth.domains.physical.application.dto.response.PhysicalTrainResponse

interface GetPhysicalTrainOutPort {
    fun getPhysicalTrainDetailById(exerciseId: ExerciseId): PhysicalTrainResponse.PhysicalTrainResponseDto
}