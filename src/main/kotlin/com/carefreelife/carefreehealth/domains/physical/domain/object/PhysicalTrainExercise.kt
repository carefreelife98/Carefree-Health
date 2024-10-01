package com.carefreelife.carefreehealth.domains.physical.domain.`object`

import com.carefreelife.carefreehealth.core.property.Description
import com.carefreelife.carefreehealth.core.property.ExerciseId
import com.carefreelife.carefreehealth.core.property.Title
import com.carefreelife.carefreehealth.core.`object`.Exercise
import com.carefreelife.carefreehealth.domains.physical.domain.`object`.common.PhysicalTrainTag
import java.time.ZonedDateTime

class PhysicalTrainExercise (
    exerciseId: ExerciseId?,
    title: Title,
    description: Description,
    tags: List<PhysicalTrainTag> = emptyList(),
    created: ZonedDateTime? = ZonedDateTime.now(),
    updated: ZonedDateTime? = ZonedDateTime.now(),

    var motion: String = "",
    var effect: String = "",
    var caution: String = "",
): Exercise<PhysicalTrainTag>(title, description, tags, created, updated)