package com.app.friendschat.di;

import com.app.friendschat.ui.main.MainBepicActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityBuilder_BindMainActivity$Emoji_Maker_v1_0_0_08_03_2024_debug
          .MainBepicActivitySubcomponent.class
)
public abstract class ActivityBuilder_BindMainActivity$Emoji_Maker_v1_0_0_08_03_2024_debug {
  private ActivityBuilder_BindMainActivity$Emoji_Maker_v1_0_0_08_03_2024_debug() {}

  @Binds
  @IntoMap
  @ClassKey(MainBepicActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MainBepicActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface MainBepicActivitySubcomponent extends AndroidInjector<MainBepicActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainBepicActivity> {}
  }
}
