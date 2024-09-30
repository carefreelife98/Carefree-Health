package com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.mapper

import com.carefreelife.carefreehealth.core.property.Description
import com.carefreelife.carefreehealth.core.property.Title
import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.entity.PhysicalTrainEntity
import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.entity.PhysicalTrainTagEntity
import com.carefreelife.carefreehealth.domains.physical.application.dto.common.PhysicalTrainCommonDto
import com.carefreelife.carefreehealth.domains.physical.application.dto.request.PhysicalTrainRequestDto
import com.carefreelife.carefreehealth.domains.physical.application.dto.response.PhysicalTrainResponseDto

class PhysicalTrainEntityMapper {
    companion object {

        fun toEntity(physicalExercise: PhysicalTrainRequestDto): PhysicalTrainEntity {
            return PhysicalTrainEntity(
                null,
                Title(physicalExercise.title),
                Description(physicalExercise.description),
                physicalExercise.motion,
                physicalExercise.effect,
                physicalExercise.caution
            )
        }

        fun toDTO(physicalTrainEntity: PhysicalTrainEntity?): PhysicalTrainResponseDto {
            if (physicalTrainEntity != null) {
                return PhysicalTrainResponseDto(
                    // 이미 생성된 entity 를 DTO 로 변환하는 경우 AutoIncrement 에 의해 필수적으로 ID 가 생성된 상태임. (!!)
                    exerciseId = physicalTrainEntity.exerciseId!!,
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

        private fun toTagDto(tagEntity: PhysicalTrainTagEntity): PhysicalTrainCommonDto.PhysicalTrainTagDto {
            return PhysicalTrainCommonDto.PhysicalTrainTagDto(
                tagCode = tagEntity.tagCode,
                tagDescription = tagEntity.tagDescription
            )
        }

        private fun toTagDtoList(tagEntityList: List<PhysicalTrainTagEntity>): List<PhysicalTrainCommonDto.PhysicalTrainTagDto> {
            return tagEntityList.stream().map{ toTagDto(it) }.toList()
        }
    }

}