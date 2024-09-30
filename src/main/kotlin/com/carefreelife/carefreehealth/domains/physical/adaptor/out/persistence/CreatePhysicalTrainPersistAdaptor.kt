package com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence

import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.mapper.PhysicalTrainEntityMapper
import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.repository.PhysicalTrainRepository
import com.carefreelife.carefreehealth.domains.physical.application.dto.request.PhysicalTrainRequestDto
import com.carefreelife.carefreehealth.domains.physical.application.dto.response.PhysicalTrainResponseDto
import com.carefreelife.carefreehealth.domains.physical.application.port.out.set.CreatePhysicalTrainOutPort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreatePhysicalTrainPersistAdaptor(
    private var physicalTrainRepository: PhysicalTrainRepository
): CreatePhysicalTrainOutPort {

    @Transactional
    override fun createPhysicalTrainDetail(physicalTrainRequestDto: PhysicalTrainRequestDto): Long {

        val entity = PhysicalTrainEntityMapper.toEntity(physicalTrainRequestDto)
        val response = physicalTrainRepository.save(entity).exerciseId ?: throw Exception("Database Error Occurred !!")

        return response
    }
}