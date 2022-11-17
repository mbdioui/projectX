package fr.leboncoin.projectx.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Album")
data class Album(@PrimaryKey var id: Long=0L, var title: String?) : Parcelable