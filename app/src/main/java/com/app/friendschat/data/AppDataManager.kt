package com.app.friendschat.data

import com.app.friendschat.data.api.IApiHelper
import com.app.friendschat.data.local.IPreferenceHelper
import com.app.friendschat.data.model.GitResponse
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject constructor(
    private val mPreferencesHelper: IPreferenceHelper,
    private val mApiHelper: IApiHelper
) : DataManager {
    override var token: String
        get() = mPreferencesHelper.token
        set(value) {
            mPreferencesHelper.token = value
        }
    override var jsonUndoList: String?
        get() = mPreferencesHelper.jsonUndoList
        set(value) {
            mPreferencesHelper.jsonUndoList = value
        }

    override fun getRepoGit(): Observable<GitResponse> {
        return mApiHelper.getRepoGit()
    }
}