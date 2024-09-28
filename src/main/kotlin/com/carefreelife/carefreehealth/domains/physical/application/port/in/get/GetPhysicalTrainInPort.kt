package com.carefreelife.carefreehealth.domains.physical.application.port.`in`.get

import com.carefreelife.carefreehealth.core.property.ExerciseId
import com.carefreelife.carefreehealth.domains.physical.application.dto.response.PhysicalTrainResponse
import com.carefreelife.carefreehealth.domains.physical.application.port.out.get.GetPhysicalTrainOutPort
import com.carefreelife.carefreehealth.domains.physical.application.usecases.GetPhysicalTrainUseCase
import com.carefreelife.carefreehealth.domains.physical.domain.`object`.PhysicalExercise
import org.springframework.stereotype.Service

@Service
class GetPhysicalTrainInPort(
    private val getPhysicalTrainOutPort: GetPhysicalTrainOutPort
): GetPhysicalTrainUseCase {

    override fun getPhysicalTrainDetailById(exerciseId: ExerciseId): PhysicalTrainResponse.PhysicalTrainResponseDto {
        return getPhysicalTrainOutPort.getPhysicalTrainDetailById(exerciseId)
    }
}