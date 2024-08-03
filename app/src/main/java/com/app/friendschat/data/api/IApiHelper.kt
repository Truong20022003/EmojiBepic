package com.app.friendschat.data.api

import com.app.friendschat.data.model.GitResponse
import io.reactivex.Observable

interface IApiHelper {
    fun getRepoGit(): Observable<GitResponse>
}