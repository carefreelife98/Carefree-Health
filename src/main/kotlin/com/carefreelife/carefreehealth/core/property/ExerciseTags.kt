package com.carefreelife.carefreehealth.core.property

import java.util.*

data class ExerciseTags<T>(
    var tags: List<T> = Collections.emptyList(),
){
    fun emptyTags():List<T> = Collections.emptyList<T>()
}
