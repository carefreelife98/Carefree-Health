package com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.entity

import com.carefreelife.carefreehealth.core.entity.CarefreeBaseEntity
import com.carefreelife.carefreehealth.core.property.Description
import com.carefreelife.carefreehealth.core.property.ExerciseId
import com.carefreelife.carefreehealth.core.property.Title
import jakarta.persistence.*

@Entity
@Table(name = "physical_train")
class PhysicalTrainEntity(
    exerciseId: ExerciseId?,
    title: Title,
    description: Description,

    @Column val motion: String = "",
    @Column val effect: String = "",
    @Column val caution: String = "",
): CarefreeBaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val exerciseId: Long? = exerciseId?.id

    @Column
    val title: String = title.title

    @Column
    val description: String = description.description

    @Column
    @OneToMany(mappedBy = "physicalTrainEntity", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    val tags: List<PhysicalTrainTagEntity> = mutableListOf()
}