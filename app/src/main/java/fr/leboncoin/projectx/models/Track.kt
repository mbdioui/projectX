package fr.leboncoin.projectx.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Track")
data class Track(
    @PrimaryKey(autoGenerate = true)
    val id: Long=0L,
    val albumId: Long = 1L,
    val title: String? = "title",
    val url: String? = "url",
    val thumbnailUrl: String? = "thumbnailURL"
) : Parcelable {
    override fun toString() = "$albumId,$id,$title,$url,$thumbnailUrl"
}