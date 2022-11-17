package fr.leboncoin.projectx.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Track")
data class Track(
    @PrimaryKey(autoGenerate = true)
    var id: Long=0L,
    var albumId: Long = 1L,
    var title: String? = "title",
    var url: String? = "url",
    var thumbnailUrl: String? = "thumbnailURL"
) : Parcelable {
    override fun toString() = "$albumId,$id,$title,$url,$thumbnailUrl"
}