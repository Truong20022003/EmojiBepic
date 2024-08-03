package com.app.friendschat;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.app.friendschat.databinding.ActivityEditEmojiNewRftBindingImpl;
import com.app.friendschat.databinding.ActivityEmojiBepicNewRftBindingImpl;
import com.app.friendschat.databinding.ActivityIntroBepicNewRftBindingImpl;
import com.app.friendschat.databinding.ActivityLanguageBepicRftBindingImpl;
import com.app.friendschat.databinding.ActivityLanguageStartBepicRftBindingImpl;
import com.app.friendschat.databinding.ActivityMainBepicRftBindingImpl;
import com.app.friendschat.databinding.ActivityNoInternetBepicRftBindingImpl;
import com.app.friendschat.databinding.ActivityPermissionBepicRftBindingImpl;
import com.app.friendschat.databinding.ActivityPolicyBepicRftBindingImpl;
import com.app.friendschat.databinding.ActivitySplashBepicRftBindingImpl;
import com.app.friendschat.databinding.ActivityStickerPackDetailBepicRftBindingImpl;
import com.app.friendschat.databinding.ActivitySuccessfullySaveBepicRftBindingImpl;
import com.app.friendschat.databinding.FragmentCreatedDraftBepicRftBindingImpl;
import com.app.friendschat.databinding.FragmentCreatedPackageBepicRftBindingImpl;
import com.app.friendschat.databinding.FragmentHomeBepicRftBindingImpl;
import com.app.friendschat.databinding.FragmentMyCreationBepicRftBindingImpl;
import com.app.friendschat.databinding.FragmentSettingsBepicRftBindingImpl;
import com.app.friendschat.databinding.ItemIconBindingImpl;
import com.app.friendschat.databinding.ItemLanguageStartBindingImpl;
import com.app.friendschat.databinding.ItemLayerBindingImpl;
import com.app.friendschat.databinding.ItemOptionsBindingImpl;
import com.app.friendschat.databinding.ItemPagerIconBindingImpl;
import com.app.friendschat.databinding.LayoutItemCreatedDraftRftBindingImpl;
import com.app.friendschat.databinding.LayoutItemTestRftBindingImpl;
import com.app.friendschat.databinding.LayoutNewPackageItemCreatedPackageRftBindingImpl;
import com.app.friendschat.databinding.LayoutNormalItemCreatedPackageRftBindingImpl;
import com.app.friendschat.databinding.LayoutPackageItemRftBindingImpl;
import com.app.friendschat.databinding.LayoutStickerItemRftBindingImpl;
import com.app.friendschat.databinding.LayoutSuggestionItemRftBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYEDITEMOJINEWRFT = 1;

  private static final int LAYOUT_ACTIVITYEMOJIBEPICNEWRFT = 2;

  private static final int LAYOUT_ACTIVITYINTROBEPICNEWRFT = 3;

  private static final int LAYOUT_ACTIVITYLANGUAGEBEPICRFT = 4;

  private static final int LAYOUT_ACTIVITYLANGUAGESTARTBEPICRFT = 5;

  private static final int LAYOUT_ACTIVITYMAINBEPICRFT = 6;

  private static final int LAYOUT_ACTIVITYNOINTERNETBEPICRFT = 7;

  private static final int LAYOUT_ACTIVITYPERMISSIONBEPICRFT = 8;

  private static final int LAYOUT_ACTIVITYPOLICYBEPICRFT = 9;

  private static final int LAYOUT_ACTIVITYSPLASHBEPICRFT = 10;

  private static final int LAYOUT_ACTIVITYSTICKERPACKDETAILBEPICRFT = 11;

  private static final int LAYOUT_ACTIVITYSUCCESSFULLYSAVEBEPICRFT = 12;

  private static final int LAYOUT_FRAGMENTCREATEDDRAFTBEPICRFT = 13;

  private static final int LAYOUT_FRAGMENTCREATEDPACKAGEBEPICRFT = 14;

  private static final int LAYOUT_FRAGMENTHOMEBEPICRFT = 15;

  private static final int LAYOUT_FRAGMENTMYCREATIONBEPICRFT = 16;

  private static final int LAYOUT_FRAGMENTSETTINGSBEPICRFT = 17;

  private static final int LAYOUT_ITEMICON = 18;

  private static final int LAYOUT_ITEMLANGUAGESTART = 19;

  private static final int LAYOUT_ITEMLAYER = 20;

  private static final int LAYOUT_ITEMOPTIONS = 21;

  private static final int LAYOUT_ITEMPAGERICON = 22;

  private static final int LAYOUT_LAYOUTITEMCREATEDDRAFTRFT = 23;

  private static final int LAYOUT_LAYOUTITEMTESTRFT = 24;

  private static final int LAYOUT_LAYOUTNEWPACKAGEITEMCREATEDPACKAGERFT = 25;

  private static final int LAYOUT_LAYOUTNORMALITEMCREATEDPACKAGERFT = 26;

  private static final int LAYOUT_LAYOUTPACKAGEITEMRFT = 27;

  private static final int LAYOUT_LAYOUTSTICKERITEMRFT = 28;

  private static final int LAYOUT_LAYOUTSUGGESTIONITEMRFT = 29;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(29);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_edit_emoji_new_rft, LAYOUT_ACTIVITYEDITEMOJINEWRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_emoji_bepic_new_rft, LAYOUT_ACTIVITYEMOJIBEPICNEWRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_intro_bepic_new_rft, LAYOUT_ACTIVITYINTROBEPICNEWRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_language_bepic_rft, LAYOUT_ACTIVITYLANGUAGEBEPICRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_language_start_bepic_rft, LAYOUT_ACTIVITYLANGUAGESTARTBEPICRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_main_bepic_rft, LAYOUT_ACTIVITYMAINBEPICRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_no_internet_bepic_rft, LAYOUT_ACTIVITYNOINTERNETBEPICRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_permission_bepic_rft, LAYOUT_ACTIVITYPERMISSIONBEPICRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_policy_bepic_rft, LAYOUT_ACTIVITYPOLICYBEPICRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_splash_bepic_rft, LAYOUT_ACTIVITYSPLASHBEPICRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_sticker_pack_detail_bepic_rft, LAYOUT_ACTIVITYSTICKERPACKDETAILBEPICRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_successfully_save_bepic_rft, LAYOUT_ACTIVITYSUCCESSFULLYSAVEBEPICRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.fragment_created_draft_bepic_rft, LAYOUT_FRAGMENTCREATEDDRAFTBEPICRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.fragment_created_package_bepic_rft, LAYOUT_FRAGMENTCREATEDPACKAGEBEPICRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.fragment_home_bepic_rft, LAYOUT_FRAGMENTHOMEBEPICRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.fragment_my_creation_bepic_rft, LAYOUT_FRAGMENTMYCREATIONBEPICRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.fragment_settings_bepic_rft, LAYOUT_FRAGMENTSETTINGSBEPICRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.item_icon, LAYOUT_ITEMICON);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.item_language_start, LAYOUT_ITEMLANGUAGESTART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.item_layer, LAYOUT_ITEMLAYER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.item_options, LAYOUT_ITEMOPTIONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.item_pager_icon, LAYOUT_ITEMPAGERICON);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.layout_item_created_draft_rft, LAYOUT_LAYOUTITEMCREATEDDRAFTRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.layout_item_test_rft, LAYOUT_LAYOUTITEMTESTRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.layout_new_package_item_created_package_rft, LAYOUT_LAYOUTNEWPACKAGEITEMCREATEDPACKAGERFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.layout_normal_item_created_package_rft, LAYOUT_LAYOUTNORMALITEMCREATEDPACKAGERFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.layout_package_item_rft, LAYOUT_LAYOUTPACKAGEITEMRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.layout_sticker_item_rft, LAYOUT_LAYOUTSTICKERITEMRFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.layout_suggestion_item_rft, LAYOUT_LAYOUTSUGGESTIONITEMRFT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYEDITEMOJINEWRFT: {
          if ("layout/activity_edit_emoji_new_rft_0".equals(tag)) {
            return new ActivityEditEmojiNewRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_edit_emoji_new_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYEMOJIBEPICNEWRFT: {
          if ("layout/activity_emoji_bepic_new_rft_0".equals(tag)) {
            return new ActivityEmojiBepicNewRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_emoji_bepic_new_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYINTROBEPICNEWRFT: {
          if ("layout/activity_intro_bepic_new_rft_0".equals(tag)) {
            return new ActivityIntroBepicNewRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_intro_bepic_new_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLANGUAGEBEPICRFT: {
          if ("layout/activity_language_bepic_rft_0".equals(tag)) {
            return new ActivityLanguageBepicRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_language_bepic_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLANGUAGESTARTBEPICRFT: {
          if ("layout/activity_language_start_bepic_rft_0".equals(tag)) {
            return new ActivityLanguageStartBepicRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_language_start_bepic_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAINBEPICRFT: {
          if ("layout/activity_main_bepic_rft_0".equals(tag)) {
            return new ActivityMainBepicRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main_bepic_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYNOINTERNETBEPICRFT: {
          if ("layout/activity_no_internet_bepic_rft_0".equals(tag)) {
            return new ActivityNoInternetBepicRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_no_internet_bepic_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPERMISSIONBEPICRFT: {
          if ("layout/activity_permission_bepic_rft_0".equals(tag)) {
            return new ActivityPermissionBepicRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_permission_bepic_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPOLICYBEPICRFT: {
          if ("layout/activity_policy_bepic_rft_0".equals(tag)) {
            return new ActivityPolicyBepicRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_policy_bepic_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSPLASHBEPICRFT: {
          if ("layout/activity_splash_bepic_rft_0".equals(tag)) {
            return new ActivitySplashBepicRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_splash_bepic_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSTICKERPACKDETAILBEPICRFT: {
          if ("layout/activity_sticker_pack_detail_bepic_rft_0".equals(tag)) {
            return new ActivityStickerPackDetailBepicRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_sticker_pack_detail_bepic_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSUCCESSFULLYSAVEBEPICRFT: {
          if ("layout/activity_successfully_save_bepic_rft_0".equals(tag)) {
            return new ActivitySuccessfullySaveBepicRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_successfully_save_bepic_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCREATEDDRAFTBEPICRFT: {
          if ("layout/fragment_created_draft_bepic_rft_0".equals(tag)) {
            return new FragmentCreatedDraftBepicRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_created_draft_bepic_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCREATEDPACKAGEBEPICRFT: {
          if ("layout/fragment_created_package_bepic_rft_0".equals(tag)) {
            return new FragmentCreatedPackageBepicRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_created_package_bepic_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOMEBEPICRFT: {
          if ("layout/fragment_home_bepic_rft_0".equals(tag)) {
            return new FragmentHomeBepicRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home_bepic_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMYCREATIONBEPICRFT: {
          if ("layout/fragment_my_creation_bepic_rft_0".equals(tag)) {
            return new FragmentMyCreationBepicRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_my_creation_bepic_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSETTINGSBEPICRFT: {
          if ("layout/fragment_settings_bepic_rft_0".equals(tag)) {
            return new FragmentSettingsBepicRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_settings_bepic_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMICON: {
          if ("layout/item_icon_0".equals(tag)) {
            return new ItemIconBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_icon is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMLANGUAGESTART: {
          if ("layout/item_language_start_0".equals(tag)) {
            return new ItemLanguageStartBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_language_start is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMLAYER: {
          if ("layout/item_layer_0".equals(tag)) {
            return new ItemLayerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_layer is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMOPTIONS: {
          if ("layout/item_options_0".equals(tag)) {
            return new ItemOptionsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_options is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMPAGERICON: {
          if ("layout/item_pager_icon_0".equals(tag)) {
            return new ItemPagerIconBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_pager_icon is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTITEMCREATEDDRAFTRFT: {
          if ("layout/layout_item_created_draft_rft_0".equals(tag)) {
            return new LayoutItemCreatedDraftRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_item_created_draft_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTITEMTESTRFT: {
          if ("layout/layout_item_test_rft_0".equals(tag)) {
            return new LayoutItemTestRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_item_test_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTNEWPACKAGEITEMCREATEDPACKAGERFT: {
          if ("layout/layout_new_package_item_created_package_rft_0".equals(tag)) {
            return new LayoutNewPackageItemCreatedPackageRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_new_package_item_created_package_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTNORMALITEMCREATEDPACKAGERFT: {
          if ("layout/layout_normal_item_created_package_rft_0".equals(tag)) {
            return new LayoutNormalItemCreatedPackageRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_normal_item_created_package_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTPACKAGEITEMRFT: {
          if ("layout/layout_package_item_rft_0".equals(tag)) {
            return new LayoutPackageItemRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_package_item_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTSTICKERITEMRFT: {
          if ("layout/layout_sticker_item_rft_0".equals(tag)) {
            return new LayoutStickerItemRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_sticker_item_rft is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTSUGGESTIONITEMRFT: {
          if ("layout/layout_suggestion_item_rft_0".equals(tag)) {
            return new LayoutSuggestionItemRftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_suggestion_item_rft is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "model");
      sKeys.put(2, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(29);

    static {
      sKeys.put("layout/activity_edit_emoji_new_rft_0", com.app.friendschat.R.layout.activity_edit_emoji_new_rft);
      sKeys.put("layout/activity_emoji_bepic_new_rft_0", com.app.friendschat.R.layout.activity_emoji_bepic_new_rft);
      sKeys.put("layout/activity_intro_bepic_new_rft_0", com.app.friendschat.R.layout.activity_intro_bepic_new_rft);
      sKeys.put("layout/activity_language_bepic_rft_0", com.app.friendschat.R.layout.activity_language_bepic_rft);
      sKeys.put("layout/activity_language_start_bepic_rft_0", com.app.friendschat.R.layout.activity_language_start_bepic_rft);
      sKeys.put("layout/activity_main_bepic_rft_0", com.app.friendschat.R.layout.activity_main_bepic_rft);
      sKeys.put("layout/activity_no_internet_bepic_rft_0", com.app.friendschat.R.layout.activity_no_internet_bepic_rft);
      sKeys.put("layout/activity_permission_bepic_rft_0", com.app.friendschat.R.layout.activity_permission_bepic_rft);
      sKeys.put("layout/activity_policy_bepic_rft_0", com.app.friendschat.R.layout.activity_policy_bepic_rft);
      sKeys.put("layout/activity_splash_bepic_rft_0", com.app.friendschat.R.layout.activity_splash_bepic_rft);
      sKeys.put("layout/activity_sticker_pack_detail_bepic_rft_0", com.app.friendschat.R.layout.activity_sticker_pack_detail_bepic_rft);
      sKeys.put("layout/activity_successfully_save_bepic_rft_0", com.app.friendschat.R.layout.activity_successfully_save_bepic_rft);
      sKeys.put("layout/fragment_created_draft_bepic_rft_0", com.app.friendschat.R.layout.fragment_created_draft_bepic_rft);
      sKeys.put("layout/fragment_created_package_bepic_rft_0", com.app.friendschat.R.layout.fragment_created_package_bepic_rft);
      sKeys.put("layout/fragment_home_bepic_rft_0", com.app.friendschat.R.layout.fragment_home_bepic_rft);
      sKeys.put("layout/fragment_my_creation_bepic_rft_0", com.app.friendschat.R.layout.fragment_my_creation_bepic_rft);
      sKeys.put("layout/fragment_settings_bepic_rft_0", com.app.friendschat.R.layout.fragment_settings_bepic_rft);
      sKeys.put("layout/item_icon_0", com.app.friendschat.R.layout.item_icon);
      sKeys.put("layout/item_language_start_0", com.app.friendschat.R.layout.item_language_start);
      sKeys.put("layout/item_layer_0", com.app.friendschat.R.layout.item_layer);
      sKeys.put("layout/item_options_0", com.app.friendschat.R.layout.item_options);
      sKeys.put("layout/item_pager_icon_0", com.app.friendschat.R.layout.item_pager_icon);
      sKeys.put("layout/layout_item_created_draft_rft_0", com.app.friendschat.R.layout.layout_item_created_draft_rft);
      sKeys.put("layout/layout_item_test_rft_0", com.app.friendschat.R.layout.layout_item_test_rft);
      sKeys.put("layout/layout_new_package_item_created_package_rft_0", com.app.friendschat.R.layout.layout_new_package_item_created_package_rft);
      sKeys.put("layout/layout_normal_item_created_package_rft_0", com.app.friendschat.R.layout.layout_normal_item_created_package_rft);
      sKeys.put("layout/layout_package_item_rft_0", com.app.friendschat.R.layout.layout_package_item_rft);
      sKeys.put("layout/layout_sticker_item_rft_0", com.app.friendschat.R.layout.layout_sticker_item_rft);
      sKeys.put("layout/layout_suggestion_item_rft_0", com.app.friendschat.R.layout.layout_suggestion_item_rft);
    }
  }
}
