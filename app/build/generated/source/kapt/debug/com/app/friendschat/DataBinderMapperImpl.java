package com.app.friendschat;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.app.friendschat.databinding.ActivityEditEmojiNewBindingImpl;
import com.app.friendschat.databinding.ActivityEmojiBepicNewBindingImpl;
import com.app.friendschat.databinding.ActivityIntroBepicNewBindingImpl;
import com.app.friendschat.databinding.ActivityLanguageBepicBindingImpl;
import com.app.friendschat.databinding.ActivityLanguageStartBepicBindingImpl;
import com.app.friendschat.databinding.ActivityMainBepicBindingImpl;
import com.app.friendschat.databinding.ActivityNoInternetBepicBindingImpl;
import com.app.friendschat.databinding.ActivityPermissionBepicBindingImpl;
import com.app.friendschat.databinding.ActivityPolicyBepicBindingImpl;
import com.app.friendschat.databinding.ActivitySplashBepicBindingImpl;
import com.app.friendschat.databinding.ActivityStickerPackDetailBepicBindingImpl;
import com.app.friendschat.databinding.ActivitySuccessfullySaveBepicBindingImpl;
import com.app.friendschat.databinding.FragmentCreatedDraftBepicBindingImpl;
import com.app.friendschat.databinding.FragmentCreatedPackageBepicBindingImpl;
import com.app.friendschat.databinding.FragmentHomeBepicBindingImpl;
import com.app.friendschat.databinding.FragmentMyCreationBepicBindingImpl;
import com.app.friendschat.databinding.FragmentSettingsBepicBindingImpl;
import com.app.friendschat.databinding.ItemIconBindingImpl;
import com.app.friendschat.databinding.ItemLanguageStartBindingImpl;
import com.app.friendschat.databinding.ItemLayerBindingImpl;
import com.app.friendschat.databinding.ItemOptionsBindingImpl;
import com.app.friendschat.databinding.ItemPagerIconBindingImpl;
import com.app.friendschat.databinding.LayoutItemCreatedDraftBindingImpl;
import com.app.friendschat.databinding.LayoutItemTestBindingImpl;
import com.app.friendschat.databinding.LayoutNewPackageItemCreatedPackageBindingImpl;
import com.app.friendschat.databinding.LayoutNormalItemCreatedPackageBindingImpl;
import com.app.friendschat.databinding.LayoutPackageItemBindingImpl;
import com.app.friendschat.databinding.LayoutStickerItemBindingImpl;
import com.app.friendschat.databinding.LayoutSuggestionItemBindingImpl;
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
  private static final int LAYOUT_ACTIVITYEDITEMOJINEW = 1;

  private static final int LAYOUT_ACTIVITYEMOJIBEPICNEW = 2;

  private static final int LAYOUT_ACTIVITYINTROBEPICNEW = 3;

  private static final int LAYOUT_ACTIVITYLANGUAGEBEPIC = 4;

  private static final int LAYOUT_ACTIVITYLANGUAGESTARTBEPIC = 5;

  private static final int LAYOUT_ACTIVITYMAINBEPIC = 6;

  private static final int LAYOUT_ACTIVITYNOINTERNETBEPIC = 7;

  private static final int LAYOUT_ACTIVITYPERMISSIONBEPIC = 8;

  private static final int LAYOUT_ACTIVITYPOLICYBEPIC = 9;

  private static final int LAYOUT_ACTIVITYSPLASHBEPIC = 10;

  private static final int LAYOUT_ACTIVITYSTICKERPACKDETAILBEPIC = 11;

  private static final int LAYOUT_ACTIVITYSUCCESSFULLYSAVEBEPIC = 12;

  private static final int LAYOUT_FRAGMENTCREATEDDRAFTBEPIC = 13;

  private static final int LAYOUT_FRAGMENTCREATEDPACKAGEBEPIC = 14;

  private static final int LAYOUT_FRAGMENTHOMEBEPIC = 15;

  private static final int LAYOUT_FRAGMENTMYCREATIONBEPIC = 16;

  private static final int LAYOUT_FRAGMENTSETTINGSBEPIC = 17;

  private static final int LAYOUT_ITEMICON = 18;

  private static final int LAYOUT_ITEMLANGUAGESTART = 19;

  private static final int LAYOUT_ITEMLAYER = 20;

  private static final int LAYOUT_ITEMOPTIONS = 21;

  private static final int LAYOUT_ITEMPAGERICON = 22;

  private static final int LAYOUT_LAYOUTITEMCREATEDDRAFT = 23;

  private static final int LAYOUT_LAYOUTITEMTEST = 24;

  private static final int LAYOUT_LAYOUTNEWPACKAGEITEMCREATEDPACKAGE = 25;

  private static final int LAYOUT_LAYOUTNORMALITEMCREATEDPACKAGE = 26;

  private static final int LAYOUT_LAYOUTPACKAGEITEM = 27;

  private static final int LAYOUT_LAYOUTSTICKERITEM = 28;

  private static final int LAYOUT_LAYOUTSUGGESTIONITEM = 29;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(29);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_edit_emoji_new, LAYOUT_ACTIVITYEDITEMOJINEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_emoji_bepic_new, LAYOUT_ACTIVITYEMOJIBEPICNEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_intro_bepic_new, LAYOUT_ACTIVITYINTROBEPICNEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_language_bepic, LAYOUT_ACTIVITYLANGUAGEBEPIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_language_start_bepic, LAYOUT_ACTIVITYLANGUAGESTARTBEPIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_main_bepic, LAYOUT_ACTIVITYMAINBEPIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_no_internet_bepic, LAYOUT_ACTIVITYNOINTERNETBEPIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_permission_bepic, LAYOUT_ACTIVITYPERMISSIONBEPIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_policy_bepic, LAYOUT_ACTIVITYPOLICYBEPIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_splash_bepic, LAYOUT_ACTIVITYSPLASHBEPIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_sticker_pack_detail_bepic, LAYOUT_ACTIVITYSTICKERPACKDETAILBEPIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.activity_successfully_save_bepic, LAYOUT_ACTIVITYSUCCESSFULLYSAVEBEPIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.fragment_created_draft_bepic, LAYOUT_FRAGMENTCREATEDDRAFTBEPIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.fragment_created_package_bepic, LAYOUT_FRAGMENTCREATEDPACKAGEBEPIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.fragment_home_bepic, LAYOUT_FRAGMENTHOMEBEPIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.fragment_my_creation_bepic, LAYOUT_FRAGMENTMYCREATIONBEPIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.fragment_settings_bepic, LAYOUT_FRAGMENTSETTINGSBEPIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.item_icon, LAYOUT_ITEMICON);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.item_language_start, LAYOUT_ITEMLANGUAGESTART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.item_layer, LAYOUT_ITEMLAYER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.item_options, LAYOUT_ITEMOPTIONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.item_pager_icon, LAYOUT_ITEMPAGERICON);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.layout_item_created_draft, LAYOUT_LAYOUTITEMCREATEDDRAFT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.layout_item_test, LAYOUT_LAYOUTITEMTEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.layout_new_package_item_created_package, LAYOUT_LAYOUTNEWPACKAGEITEMCREATEDPACKAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.layout_normal_item_created_package, LAYOUT_LAYOUTNORMALITEMCREATEDPACKAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.layout_package_item, LAYOUT_LAYOUTPACKAGEITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.layout_sticker_item, LAYOUT_LAYOUTSTICKERITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.friendschat.R.layout.layout_suggestion_item, LAYOUT_LAYOUTSUGGESTIONITEM);
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
        case  LAYOUT_ACTIVITYEDITEMOJINEW: {
          if ("layout/activity_edit_emoji_new_0".equals(tag)) {
            return new ActivityEditEmojiNewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_edit_emoji_new is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYEMOJIBEPICNEW: {
          if ("layout/activity_emoji_bepic_new_0".equals(tag)) {
            return new ActivityEmojiBepicNewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_emoji_bepic_new is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYINTROBEPICNEW: {
          if ("layout/activity_intro_bepic_new_0".equals(tag)) {
            return new ActivityIntroBepicNewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_intro_bepic_new is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLANGUAGEBEPIC: {
          if ("layout/activity_language_bepic_0".equals(tag)) {
            return new ActivityLanguageBepicBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_language_bepic is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLANGUAGESTARTBEPIC: {
          if ("layout/activity_language_start_bepic_0".equals(tag)) {
            return new ActivityLanguageStartBepicBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_language_start_bepic is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAINBEPIC: {
          if ("layout/activity_main_bepic_0".equals(tag)) {
            return new ActivityMainBepicBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main_bepic is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYNOINTERNETBEPIC: {
          if ("layout/activity_no_internet_bepic_0".equals(tag)) {
            return new ActivityNoInternetBepicBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_no_internet_bepic is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPERMISSIONBEPIC: {
          if ("layout/activity_permission_bepic_0".equals(tag)) {
            return new ActivityPermissionBepicBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_permission_bepic is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPOLICYBEPIC: {
          if ("layout/activity_policy_bepic_0".equals(tag)) {
            return new ActivityPolicyBepicBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_policy_bepic is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSPLASHBEPIC: {
          if ("layout/activity_splash_bepic_0".equals(tag)) {
            return new ActivitySplashBepicBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_splash_bepic is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSTICKERPACKDETAILBEPIC: {
          if ("layout/activity_sticker_pack_detail_bepic_0".equals(tag)) {
            return new ActivityStickerPackDetailBepicBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_sticker_pack_detail_bepic is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSUCCESSFULLYSAVEBEPIC: {
          if ("layout/activity_successfully_save_bepic_0".equals(tag)) {
            return new ActivitySuccessfullySaveBepicBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_successfully_save_bepic is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCREATEDDRAFTBEPIC: {
          if ("layout/fragment_created_draft_bepic_0".equals(tag)) {
            return new FragmentCreatedDraftBepicBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_created_draft_bepic is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCREATEDPACKAGEBEPIC: {
          if ("layout/fragment_created_package_bepic_0".equals(tag)) {
            return new FragmentCreatedPackageBepicBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_created_package_bepic is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOMEBEPIC: {
          if ("layout/fragment_home_bepic_0".equals(tag)) {
            return new FragmentHomeBepicBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home_bepic is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMYCREATIONBEPIC: {
          if ("layout/fragment_my_creation_bepic_0".equals(tag)) {
            return new FragmentMyCreationBepicBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_my_creation_bepic is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSETTINGSBEPIC: {
          if ("layout/fragment_settings_bepic_0".equals(tag)) {
            return new FragmentSettingsBepicBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_settings_bepic is invalid. Received: " + tag);
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
        case  LAYOUT_LAYOUTITEMCREATEDDRAFT: {
          if ("layout/layout_item_created_draft_0".equals(tag)) {
            return new LayoutItemCreatedDraftBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_item_created_draft is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTITEMTEST: {
          if ("layout/layout_item_test_0".equals(tag)) {
            return new LayoutItemTestBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_item_test is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTNEWPACKAGEITEMCREATEDPACKAGE: {
          if ("layout/layout_new_package_item_created_package_0".equals(tag)) {
            return new LayoutNewPackageItemCreatedPackageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_new_package_item_created_package is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTNORMALITEMCREATEDPACKAGE: {
          if ("layout/layout_normal_item_created_package_0".equals(tag)) {
            return new LayoutNormalItemCreatedPackageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_normal_item_created_package is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTPACKAGEITEM: {
          if ("layout/layout_package_item_0".equals(tag)) {
            return new LayoutPackageItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_package_item is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTSTICKERITEM: {
          if ("layout/layout_sticker_item_0".equals(tag)) {
            return new LayoutStickerItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_sticker_item is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTSUGGESTIONITEM: {
          if ("layout/layout_suggestion_item_0".equals(tag)) {
            return new LayoutSuggestionItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_suggestion_item is invalid. Received: " + tag);
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
      sKeys.put("layout/activity_edit_emoji_new_0", com.app.friendschat.R.layout.activity_edit_emoji_new);
      sKeys.put("layout/activity_emoji_bepic_new_0", com.app.friendschat.R.layout.activity_emoji_bepic_new);
      sKeys.put("layout/activity_intro_bepic_new_0", com.app.friendschat.R.layout.activity_intro_bepic_new);
      sKeys.put("layout/activity_language_bepic_0", com.app.friendschat.R.layout.activity_language_bepic);
      sKeys.put("layout/activity_language_start_bepic_0", com.app.friendschat.R.layout.activity_language_start_bepic);
      sKeys.put("layout/activity_main_bepic_0", com.app.friendschat.R.layout.activity_main_bepic);
      sKeys.put("layout/activity_no_internet_bepic_0", com.app.friendschat.R.layout.activity_no_internet_bepic);
      sKeys.put("layout/activity_permission_bepic_0", com.app.friendschat.R.layout.activity_permission_bepic);
      sKeys.put("layout/activity_policy_bepic_0", com.app.friendschat.R.layout.activity_policy_bepic);
      sKeys.put("layout/activity_splash_bepic_0", com.app.friendschat.R.layout.activity_splash_bepic);
      sKeys.put("layout/activity_sticker_pack_detail_bepic_0", com.app.friendschat.R.layout.activity_sticker_pack_detail_bepic);
      sKeys.put("layout/activity_successfully_save_bepic_0", com.app.friendschat.R.layout.activity_successfully_save_bepic);
      sKeys.put("layout/fragment_created_draft_bepic_0", com.app.friendschat.R.layout.fragment_created_draft_bepic);
      sKeys.put("layout/fragment_created_package_bepic_0", com.app.friendschat.R.layout.fragment_created_package_bepic);
      sKeys.put("layout/fragment_home_bepic_0", com.app.friendschat.R.layout.fragment_home_bepic);
      sKeys.put("layout/fragment_my_creation_bepic_0", com.app.friendschat.R.layout.fragment_my_creation_bepic);
      sKeys.put("layout/fragment_settings_bepic_0", com.app.friendschat.R.layout.fragment_settings_bepic);
      sKeys.put("layout/item_icon_0", com.app.friendschat.R.layout.item_icon);
      sKeys.put("layout/item_language_start_0", com.app.friendschat.R.layout.item_language_start);
      sKeys.put("layout/item_layer_0", com.app.friendschat.R.layout.item_layer);
      sKeys.put("layout/item_options_0", com.app.friendschat.R.layout.item_options);
      sKeys.put("layout/item_pager_icon_0", com.app.friendschat.R.layout.item_pager_icon);
      sKeys.put("layout/layout_item_created_draft_0", com.app.friendschat.R.layout.layout_item_created_draft);
      sKeys.put("layout/layout_item_test_0", com.app.friendschat.R.layout.layout_item_test);
      sKeys.put("layout/layout_new_package_item_created_package_0", com.app.friendschat.R.layout.layout_new_package_item_created_package);
      sKeys.put("layout/layout_normal_item_created_package_0", com.app.friendschat.R.layout.layout_normal_item_created_package);
      sKeys.put("layout/layout_package_item_0", com.app.friendschat.R.layout.layout_package_item);
      sKeys.put("layout/layout_sticker_item_0", com.app.friendschat.R.layout.layout_sticker_item);
      sKeys.put("layout/layout_suggestion_item_0", com.app.friendschat.R.layout.layout_suggestion_item);
    }
  }
}
