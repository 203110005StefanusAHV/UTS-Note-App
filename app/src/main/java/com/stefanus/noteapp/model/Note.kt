package com.stefanus.noteapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

//tabel yang bernama notes yang beisi id, noteTitle dan noteBody
@Entity(tableName = "notes")
//pembagian kelas
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val noteTitle: String,
    val noteBody: String
) : Parcelable
