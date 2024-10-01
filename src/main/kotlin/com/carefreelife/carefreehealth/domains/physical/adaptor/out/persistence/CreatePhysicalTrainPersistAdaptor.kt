package com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence

import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.entity.PhysicalTrainTagEntity
import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.mapper.PhysicalTrainEntityMapper
import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.repository.PhysicalTrainRepository
import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.repository.PhysicalTrainTagRepository
import com.carefreelife.carefreehealth.domains.physical.application.port.out.set.CreatePhysicalTrainOutPort
import com.carefreelife.carefreehealth.domains.physical.domain.`object`.PhysicalTrainExercise
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreatePhysicalTrainPersistAdaptor(
    private var physicalTrainRepository: PhysicalTrainRepository,
    private var physicalTrainTagRepository: PhysicalTrainTagRepository
): CreatePhysicalTrainOutPort {

    @Transactional
    override fun createPhysicalTrainDetail(physicalTrainExercise: PhysicalTrainExercise): Long {
        if (Objects.isNull(physicalTrainExercise)) throw Exception("::: The physical train exercise is null :::")

        val physicalTrainEntity = PhysicalTrainEntityMapper.toEntity(physicalTrainExercise)
        val result = physicalTrainRepository.save(physicalTrainEntity).exerciseId ?: throw Exception("Database Error Occurred !!")

        val tags = physicalTrainExercise.tags
        if (tags.isNotEmpty()) {
            val tagEntityList: List<PhysicalTrainTagEntity> =
                PhysicalTrainEntityMapper.toTagEntityList(tags, physicalTrainEntity)
            physicalTrainTagRepository.saveAll(tagEntityList)
        }

        return result
    }
}