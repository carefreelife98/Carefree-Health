package com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.mapper

import com.carefreelife.carefreehealth.core.property.Description
import com.carefreelife.carefreehealth.core.property.ExerciseId
import com.carefreelife.carefreehealth.core.property.Title
import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.entity.PhysicalTrainEntity
import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.entity.PhysicalTrainTagEntity
import com.carefreelife.carefreehealth.domains.physical.application.dto.response.PhysicalTrainResponse
import com.carefreelife.carefreehealth.domains.physical.domain.`object`.PhysicalExercise
import java.util.stream.Collectors

class PhysicalTrainEntityMapper {
    companion object {

        fun toEntity(physicalExercise: PhysicalExercise): PhysicalTrainEntity {
            return PhysicalTrainEntity(
                physicalExercise.exerciseId,
                physicalExercise.title,
                physicalExercise.description,
                physicalExercise.motion,
                physicalExercise.effect,
                physicalExercise.caution
            )
        }

        fun toDTO(physicalTrainEntity: PhysicalTrainEntity?): PhysicalTrainResponse.PhysicalTrainResponseDto {
            if (physicalTrainEntity != null) {
                return PhysicalTrainResponse.PhysicalTrainResponseDto(
                    exerciseId = physicalTrainEntity.exerciseId,
                    title = physicalTrainEntity.title,
                    description = physicalTrainEntity.description,
                    motion = physicalTrainEntity.motion,
                    effect = physicalTrainEntity.effect,
                    caution = physicalTrainEntity.caution,
                    tags = toTagDtoList(physicalTrainEntity.tags),
                    created = physicalTrainEntity.created,
                    updated = physicalTrainEntity.updated
                )
            }
            // TODO: Custom Exception 추가
            throw NoSuchElementException("Exercise not found")
        }

        private fun toTagDto(tagEntity: PhysicalTrainTagEntity): PhysicalTrainResponse.PhysicalTrainTagDto {
            return PhysicalTrainResponse.PhysicalTrainTagDto(
                tagCode = tagEntity.tagCode,
                tagDescription = tagEntity.tagDescription
            )
        }

        fun toTagDtoList(tagEntityList: List<PhysicalTrainTagEntity>): List<PhysicalTrainResponse.PhysicalTrainTagDto> {
            return tagEntityList.stream().map{ toTagDto(it) }.toList()
        }
    }

}