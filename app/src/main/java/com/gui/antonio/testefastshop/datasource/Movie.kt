package com.gui.antonio.testefastshop.datasource

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity
class Movie(
    @PrimaryKey(autoGenerate = true) val uid: Int,

    @SerializedName("poster_path") @ColumnInfo(name = "poster_path")
    @Expose
    var posterPath: String? = null,

    @SerializedName("adult") @ColumnInfo(name = "adult")
    @Expose
    var adult: Boolean? = null,

    @SerializedName("overview")  @ColumnInfo(name = "overview")
    @Expose
    var overview: String? = null,

    @SerializedName("release_date")  @ColumnInfo(name = "release_date")
    @Expose
    var releaseDate: String? = null,

    @SerializedName("id")   @ColumnInfo(name = "id")
    @Expose
    var id: Int? = null,

    @SerializedName("original_title") @ColumnInfo(name = "original_title")
    @Expose
    var originalTitle: String? = null,

    @SerializedName("original_language")  @ColumnInfo(name = "original_language")
    @Expose
    var originalLanguage: String? = null,

    @SerializedName("title") @ColumnInfo(name = "title")
    @Expose
    var title: String? = null,

    @SerializedName("backdrop_path")  @ColumnInfo(name = "backdrop_path")
    @Expose
    var backdropPath: String? = null,

    @SerializedName("popularity")  @ColumnInfo(name = "popularity")
    @Expose
    var popularity: Double? = null,

    @SerializedName("vote_count") @ColumnInfo(name = "vote_count")
    @Expose
    var voteCount: Int? = null,

    @SerializedName("video") @ColumnInfo(name = "video")
    @Expose
    var video: Boolean? = null,

    @SerializedName("vote_average") @ColumnInfo(name = "vote_average")
    @Expose
    var voteAverage: Double? = null
)