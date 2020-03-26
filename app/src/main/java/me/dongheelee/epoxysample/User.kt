package me.dongheelee.epoxysample

data class User(
    val id: Long,
    val name: String,
    val thumbnail: String,
    val followerCount: Int = 0
)