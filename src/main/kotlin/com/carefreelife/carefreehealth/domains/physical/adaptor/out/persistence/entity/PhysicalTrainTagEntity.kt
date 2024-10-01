package com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.entity

import jakarta.persistence.*
import org.hibernate.annotations.Columns
import org.hibernate.annotations.Comment

@Entity
@Table(name = "physical_train_tag")
class PhysicalTrainTagEntity(
    tagCode: String,
    tagDescription: String,
    targetEntity: PhysicalTrainEntity
) {

    @Id
    @Comment(value = "태그 (카테고리) ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val tagId: Long = 0

    @Column(nullable = false)
    @Comment(value = "태그 코드")
    val tagCode: String = tagCode.trim()

    @Column(nullable = false)
    @Comment(value = "태그 설명")
    val tagDescription: String = tagDescription.trim()

    @ManyToOne
    @Comment(value = "매핑된 운동 ID")
    @JoinColumn(name = "exercise_id", nullable = false)
    val physicalTrainEntity: PhysicalTrainEntity = targetEntity
}