package com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.entity

import com.carefreelife.carefreehealth.core.entity.CarefreeBaseEntity
import com.carefreelife.carefreehealth.core.property.Description
import com.carefreelife.carefreehealth.core.property.ExerciseId
import com.carefreelife.carefreehealth.core.property.Title
import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Entity
@Table(name = "physical_train")
@Comment(value = "헬스 트레이닝 종목 테이블")
class PhysicalTrainEntity(
    exerciseId: ExerciseId?,
    title: Title,
    description: Description,

    @Column
    @Comment(value = "운동 모션 URL")
    val motion: String = "",

    @Column
    @Comment(value = "운동 효과")
    val effect: String = "",

    @Column
    @Comment(value = "운동 주의사항")
    val caution: String = "",
): CarefreeBaseEntity() {
    @Id
    @Comment(value = "운동 ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val exerciseId: Long? = exerciseId?.id

    @Column
    @Comment(value = "운동 제목")
    val title: String = title.title

    @Column
    @Comment(value = "운동 설명")
    val description: String = description.description

    @Column
    @Comment(value = "운동 태그 (카테고리)")
    @OneToMany(mappedBy = "physicalTrainEntity", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    val tags: List<PhysicalTrainTagEntity> = mutableListOf()
}