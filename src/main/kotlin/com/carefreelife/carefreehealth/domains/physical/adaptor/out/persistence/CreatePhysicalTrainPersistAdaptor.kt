package com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence

import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.entity.PhysicalTrainTagEntity
import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.mapper.PhysicalTrainEntityMapper
import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.repository.PhysicalTrainRepository
import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.repository.PhysicalTrainTagRepository
import com.carefreelife.carefreehealth.domains.physical.application.dto.common.PhysicalTrainCommonDto
import com.carefreelife.carefreehealth.domains.physical.application.dto.request.PhysicalTrainRequestDto
import com.carefreelife.carefreehealth.domains.physical.application.dto.response.PhysicalTrainResponseDto
import com.carefreelife.carefreehealth.domains.physical.application.port.out.set.CreatePhysicalTrainOutPort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreatePhysicalTrainPersistAdaptor(
    private var physicalTrainRepository: PhysicalTrainRepository,
    private var physicalTrainTagRepository: PhysicalTrainTagRepository
): CreatePhysicalTrainOutPort {

    @Transactional
    override fun createPhysicalTrainDetail(physicalTrainRequestDto: PhysicalTrainRequestDto): Long {

        val physicalTrainEntity = PhysicalTrainEntityMapper.toEntity(physicalTrainRequestDto)
        val result = physicalTrainRepository.save(physicalTrainEntity).exerciseId ?: throw Exception("Database Error Occurred !!")

        if (!physicalTrainRequestDto.tags.isNullOrEmpty()) {
            val tagEntityList: List<PhysicalTrainTagEntity> = PhysicalTrainEntityMapper.toTagEntityList(physicalTrainRequestDto.tags, physicalTrainEntity)
            physicalTrainTagRepository.saveAll(tagEntityList)
        }

        return result
    }
}