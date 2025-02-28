// Generated by Dagger (https://dagger.dev).
package com.app.friendschat.data;

import com.app.friendschat.data.api.IApiHelper;
import com.app.friendschat.data.local.IPreferenceHelper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppDataManager_Factory implements Factory<AppDataManager> {
  private final Provider<IPreferenceHelper> mPreferencesHelperProvider;

  private final Provider<IApiHelper> mApiHelperProvider;

  public AppDataManager_Factory(Provider<IPreferenceHelper> mPreferencesHelperProvider,
      Provider<IApiHelper> mApiHelperProvider) {
    this.mPreferencesHelperProvider = mPreferencesHelperProvider;
    this.mApiHelperProvider = mApiHelperProvider;
  }

  @Override
  public AppDataManager get() {
    return newInstance(mPreferencesHelperProvider.get(), mApiHelperProvider.get());
  }

  public static AppDataManager_Factory create(
      Provider<IPreferenceHelper> mPreferencesHelperProvider,
      Provider<IApiHelper> mApiHelperProvider) {
    return new AppDataManager_Factory(mPreferencesHelperProvider, mApiHelperProvider);
  }

  public static AppDataManager newInstance(IPreferenceHelper mPreferencesHelper,
      IApiHelper mApiHelper) {
    return new AppDataManager(mPreferencesHelper, mApiHelper);
  }
}
