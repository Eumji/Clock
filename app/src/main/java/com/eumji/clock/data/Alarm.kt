package com.eumji.clock.data

data class Alarm (
    val title: String,
    val holiday: Boolean,
    val convertTime: Boolean,
    val time: String,
    val date: String,
    val day: BooleanArray,
    val everyDay : Boolean,
    val switch: Boolean
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Alarm

        if (!day.contentEquals(other.day)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + day.contentHashCode()
        return result
    }
}