package com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.mapper

import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.entity.PhysicalTrainEntity
import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.entity.PhysicalTrainTagEntity
import com.carefreelife.carefreehealth.domains.physical.application.dto.response.PhysicalTrainResponseDto
import com.carefreelife.carefreehealth.domains.physical.domain.`object`.PhysicalTrainExercise
import com.carefreelife.carefreehealth.domains.physical.domain.`object`.common.PhysicalTrainTag

class PhysicalTrainEntityMapper {
    companion object {

        fun toEntity(physicalExercise: PhysicalTrainExercise): PhysicalTrainEntity {
            return PhysicalTrainEntity(
                null,
                physicalExercise.title,
                physicalExercise.description,
                physicalExercise.motion,
                physicalExercise.effect,
                physicalExercise.caution
            )
        }

        fun toDTO(physicalTrainEntity: PhysicalTrainEntity): PhysicalTrainResponseDto {
            return PhysicalTrainResponseDto(
                // 이미 생성된 entity 를 DTO 로 변환하는 경우 AutoIncrement 에 의해 필수적으로 ID 가 생성된 상태임. (!!)
                exerciseId = physicalTrainEntity.exerciseId!!,
                title = physicalTrainEntity.title,
                description = physicalTrainEntity.description,
                motion = physicalTrainEntity.motion,
                effect = physicalTrainEntity.effect,
                caution = physicalTrainEntity.caution,
                tags = toTagList(physicalTrainEntity.tags),
                created = physicalTrainEntity.created,
                updated = physicalTrainEntity.updated
            )
        }

        private fun toTag(tagEntity: PhysicalTrainTagEntity): PhysicalTrainTag {
            return PhysicalTrainTag.valueOf(tagEntity.tagCode)
        }

        private fun toTagList(tagEntityList: List<PhysicalTrainTagEntity>): List<PhysicalTrainTag> {
            return tagEntityList.stream().map{ toTag(it) }.toList()
        }

        private fun toTagEntity(tag: PhysicalTrainTag, targetEntity: PhysicalTrainEntity): PhysicalTrainTagEntity {
            return PhysicalTrainTagEntity(
                tagCode = tag.code,
                tagDescription = tag.description,
                targetEntity = targetEntity
            )
        }

        fun toTagEntityList(tagList: List<PhysicalTrainTag>, targetEntity: PhysicalTrainEntity): List<PhysicalTrainTagEntity> {
            return tagList.stream().map { toTagEntity(it, targetEntity) }.toList()
        }
    }

}