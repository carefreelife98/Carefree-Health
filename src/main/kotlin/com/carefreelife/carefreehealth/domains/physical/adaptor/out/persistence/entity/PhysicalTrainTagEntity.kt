package com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "physical_train_tag")
class PhysicalTrainTagEntity(
    tagCode: String,
    tagDescription: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val tagId: Long = 0

    @Column(nullable = false)
    val tagCode: String = tagCode.trim()

    @Column(nullable = false)
    val tagDescription: String = tagDescription.trim()

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    val physicalTrainEntity: PhysicalTrainEntity? = null
}