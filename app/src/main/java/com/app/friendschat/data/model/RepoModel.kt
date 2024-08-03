package com.app.friendschat.data.model

import java.io.Serializable

data class RepoModel(
    val id: Int,
    val node_id: String,
    val name: String,
    val full_name: String,
    val owner: Owner,
    var position: Int
) : Serializable
