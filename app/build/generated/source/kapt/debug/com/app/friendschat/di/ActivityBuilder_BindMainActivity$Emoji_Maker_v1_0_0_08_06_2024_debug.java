package com.app.friendschat.di;

import com.app.friendschat.ui.main.MainBepicActivityRft;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityBuilder_BindMainActivity$Emoji_Maker_v1_0_0_08_06_2024_debug
          .MainBepicActivityRftSubcomponent.class
)
public abstract class ActivityBuilder_BindMainActivity$Emoji_Maker_v1_0_0_08_06_2024_debug {
  private ActivityBuilder_BindMainActivity$Emoji_Maker_v1_0_0_08_06_2024_debug() {}

  @Binds
  @IntoMap
  @ClassKey(MainBepicActivityRft.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MainBepicActivityRftSubcomponent.Factory builder);

  @Subcomponent
  public interface MainBepicActivityRftSubcomponent extends AndroidInjector<MainBepicActivityRft> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainBepicActivityRft> {}
  }
}
