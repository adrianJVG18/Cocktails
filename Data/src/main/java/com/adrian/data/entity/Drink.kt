package com.adrian.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Drinks")
data class Drink(

    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,

    @ColumnInfo(name = NAME)
    val name: String? = null,

    @ColumnInfo(name = ALTERNATE)
    val alternate: String? = null,

    @ColumnInfo(name = TAGS)
    val tags: String? = null,

    @ColumnInfo(name = VIDEO)
    val video: String? = null,

    @ColumnInfo(name = CATEGORY)
    val category: String? = null,

    @ColumnInfo(name = IBA)
    val iba: String? = null,

    @ColumnInfo(name = ALCOHOLIC)
    val alcoholic: Boolean? = null,

    @ColumnInfo(name = GLASS)
    val glass: String? = null,

    @ColumnInfo(name = INSTRUCTIONS)
    val instructions: String? = null,

    @ColumnInfo(name = INSTRUCTIONS_ES)
    val instructionsES: String? = null,

    @ColumnInfo(name = INSTRUCTIONS_DE)
    val instructionsDE: String? = null,

    @ColumnInfo(name = INSTRUCTIONS_FR)
    val instructionsFR: String? = null,

    @ColumnInfo(name = INSTRUCTIONS_IT)
    val instructionsIT: String? = null,

    @ColumnInfo(name = INSTRUCTIONS_ZH_HANS)
    val instructionsZHHANS: String? = null,

    @ColumnInfo(name = INSTRUCTIONS_ZH_HANT)
    val instructionsZHHANT: String? = null,

    @ColumnInfo(name = THUMB)
    val thumb: String? = null,

    @ColumnInfo(name = IMAGE_SOURCE)
    val imageSource: String? = null,

    @ColumnInfo(name = IMAGE_ATTRIBUTION)
    val imageAttribution: String? = null,

    @ColumnInfo(name = CREATIVE_COMMONS_CONFIRMED)
    val creativeCommonsConfirmed: String? = null,

    @ColumnInfo(name = DATE_MODIFIED)
    val dateModified: String? = null

) {
    companion object {
        const val NAME = "Name"
        const val ALTERNATE = "Alternate"
        const val TAGS = "Tags"
        const val VIDEO = "Video"
        const val CATEGORY = "Category"
        const val IBA = "IBA"
        const val ALCOHOLIC = "Alcoholic"
        const val GLASS = "Glass"
        const val INSTRUCTIONS = "Instructions"
        const val INSTRUCTIONS_ES = "InstructionsES"
        const val INSTRUCTIONS_DE = "InstructionsDE"
        const val INSTRUCTIONS_FR = "InstructionsFR"
        const val INSTRUCTIONS_IT = "InstructionsIT"
        const val INSTRUCTIONS_ZH_HANS = "InstructionsZHHANS"
        const val INSTRUCTIONS_ZH_HANT = "InstructionsZHHANT"
        const val THUMB = "Thumb"
        const val IMAGE_SOURCE = "ImageSource"
        const val IMAGE_ATTRIBUTION = "ImageAttribution"
        const val CREATIVE_COMMONS_CONFIRMED = "CreativeCommonsConfirmed"
        const val DATE_MODIFIED = "DateModified"
    }
}