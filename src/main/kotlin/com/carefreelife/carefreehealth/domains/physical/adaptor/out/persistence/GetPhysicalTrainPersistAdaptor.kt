package com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence

import com.carefreelife.carefreehealth.core.property.ExerciseId
import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.mapper.PhysicalTrainEntityMapper
import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.repository.PhysicalTrainRepository
import com.carefreelife.carefreehealth.domains.physical.application.dto.response.PhysicalTrainResponseDto
import com.carefreelife.carefreehealth.domains.physical.application.port.out.get.GetPhysicalTrainOutPort
import org.springframework.stereotype.Service

@Service
class GetPhysicalTrainPersistAdaptor(
    private val physicalTrainRepository: PhysicalTrainRepository
): GetPhysicalTrainOutPort {

    override fun getPhysicalTrainDetailById(exerciseId: ExerciseId): PhysicalTrainResponseDto {
        val physicalTrainEntity = physicalTrainRepository.findById(exerciseId.id).orElseThrow()
        val result = PhysicalTrainEntityMapper.toDTO(physicalTrainEntity)
        return result
    }
}