package com.carefreelife.carefreehealth.core.property

import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length

data class Title (
    @NotBlank
    @Length(max = 30)
    var title: String
)