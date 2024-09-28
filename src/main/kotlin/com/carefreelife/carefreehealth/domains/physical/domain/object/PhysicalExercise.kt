package com.carefreelife.carefreehealth.domains.physical.domain.`object`

import com.carefreelife.carefreehealth.core.property.Description
import com.carefreelife.carefreehealth.core.property.ExerciseId
import com.carefreelife.carefreehealth.core.property.Title
import com.carefreelife.carefreehealth.core.`object`.Exercise
import com.carefreelife.carefreehealth.domains.physical.domain.common.PhysicalTrainTags
import java.time.ZonedDateTime

class PhysicalExercise (
    exerciseId: ExerciseId,
    title: Title,
    description: Description,
    tags: List<PhysicalTrainTags> = emptyList(),
    created: ZonedDateTime = ZonedDateTime.now(),
    updated: ZonedDateTime = ZonedDateTime.now(),

    var motion: String = "",
    var effect: String = "",
    var caution: String = "",
): Exercise<PhysicalTrainTags>(exerciseId, title, description, tags, created, updated)