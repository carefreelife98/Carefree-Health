package com.carefreelife.carefreehealth.domains.physical.domain.`object`.common

enum class PhysicalTrainTag (val code: String, val description: String) {
    // 대분류 (근력, 유산소, 유연성, 지구력)
    STRENGTH("STRENGTH", "근력 운동"),
    CARDIO("CARDIO", "유산소 운동"),
    FLEX("FLEX", "유연성 운동"),
    ENDURE("ENDURE", "지구력 운동"),

    // 중분류 - 근력 (상체, 코어, 하체)
    STR_TOP("STR_TOP", "근력 - 상체 운동"),
    STR_CORE("STR_CORE", "근력 - 코어 운동"),
    STR_BOTTOM("STR_BOTTOM", "근력 - 하체 운동"),

    // 소분류 - 근력 - 상체 (어깨, 가슴, 등, 이두, 삼두)
    STR_TOP_SHOULDER("STR_TOP_SHOULDER", "근력 - 상체 - 어깨 운동"),
    STR_TOP_CHEST("STR_TOP_CHEST", "근력 - 상체 - 가슴 운동"),
    STR_TOP_BACK("STR_TOP_BACK", "근력 - 상체 - 등 운동"),
    STR_TOP_BICEPS("STR_TOP_BICEPS", "근력 - 상체 - 이두 운동"),
    STR_TOP_TRICEPS("STR_TOP_TRICEPS", "근력 - 상체 - 삼두 운동"),
}