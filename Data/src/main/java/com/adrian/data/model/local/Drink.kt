package com.adrian.data.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Drink(

    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "DrinkName")
    val name: String? = null,

    @ColumnInfo(name = "DrinkAlternate")
    val alternate: String? = null,

    @ColumnInfo(name = "Tags")
    val tags: String? = null,

    @ColumnInfo(name = "Video")
    val video: String? = null,

    @ColumnInfo(name = "Category")
    val category: String? = null,

    @ColumnInfo(name = "IBA")
    val iba: String? = null,

    @ColumnInfo(name = "Alcoholic")
    val alcoholic: Boolean? = null,

    @ColumnInfo(name = "Glass")
    val glass: String? = null,

    @ColumnInfo(name = "instructions")
    val instructions: String? = null,

    @ColumnInfo(name = "instructionsES")
    val instructionsES: String? = null,

    @ColumnInfo(name = "instructionsDE")
    val instructionsDE: String? = null,

    @ColumnInfo(name = "instructionsFR")
    val instructionsFR: String? = null,

    @ColumnInfo(name = "instructionsIT")
    val instructionsIT: String? = null,

    @ColumnInfo(name = "instructionsZHHANS")
    val instructionsZHHANS: String? = null,

    @ColumnInfo(name = "instructionsZHHANT")
    val instructionsZHHANT: String? = null,

    @ColumnInfo(name = "DrinkThumb")
    val thumb: String? = null,

    // TODO add ingredients table

    @ColumnInfo(name = "ImageSource")
    val imageSource: String? = null,

    @ColumnInfo(name = "ImageAttribution")
    val imageAttribution: String? = null,

    @ColumnInfo(name = "CreativeCommonsConfirmed")
    val creativeCommonsConfirmed: String? = null,

    @ColumnInfo(name = "eModified")
    val dateModified: String? = null

)