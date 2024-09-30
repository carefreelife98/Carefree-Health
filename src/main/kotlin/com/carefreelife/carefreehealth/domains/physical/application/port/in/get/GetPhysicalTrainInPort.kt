package com.carefreelife.carefreehealth.domains.physical.application.port.`in`.get

import com.carefreelife.carefreehealth.core.property.ExerciseId
import com.carefreelife.carefreehealth.domains.physical.application.dto.response.PhysicalTrainResponseDto
import com.carefreelife.carefreehealth.domains.physical.application.port.out.get.GetPhysicalTrainOutPort
import com.carefreelife.carefreehealth.domains.physical.application.usecases.get.GetPhysicalTrainUseCase
import org.springframework.stereotype.Service

/**
 * 피지컬 트레이닝 상세 조회 비즈니스 로직
 */

@Service
class GetPhysicalTrainInPort(
    private val getPhysicalTrainOutPort: GetPhysicalTrainOutPort
): GetPhysicalTrainUseCase {

    override fun getPhysicalTrainDetailById(exerciseId: ExerciseId): PhysicalTrainResponseDto {
        return getPhysicalTrainOutPort.getPhysicalTrainDetailById(exerciseId)
    }

}