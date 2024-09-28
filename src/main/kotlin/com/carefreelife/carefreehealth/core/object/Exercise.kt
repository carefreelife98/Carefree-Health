package com.carefreelife.carefreehealth.core.`object`

import com.carefreelife.carefreehealth.core.property.Description
import com.carefreelife.carefreehealth.core.property.ExerciseId
import com.carefreelife.carefreehealth.core.property.ExerciseTags
import com.carefreelife.carefreehealth.core.property.Title
import lombok.Getter
import lombok.experimental.SuperBuilder
import java.time.ZonedDateTime

@Getter
@SuperBuilder
open class Exercise<T> (
    val exerciseId: ExerciseId,
    var title: Title,
    var description: Description,
    var tags: List<T> = ExerciseTags<T>().emptyTags(),
    var created: ZonedDateTime = ZonedDateTime.now(),
    var updated: ZonedDateTime = ZonedDateTime.now()
)