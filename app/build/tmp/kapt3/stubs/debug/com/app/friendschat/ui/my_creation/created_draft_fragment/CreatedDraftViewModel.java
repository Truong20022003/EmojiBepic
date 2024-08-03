package com.app.friendschat.ui.my_creation.created_draft_fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/app/friendschat/ui/my_creation/created_draft_fragment/CreatedDraftViewModel;", "Lcom/app/friendschat/ui/base/BaseViewModel;", "()V", "adapter", "Lcom/app/friendschat/ui/my_creation/created_draft_fragment/CreatedDraftAdapter;", "packageDao", "Lcom/app/friendschat/database/PackageDao;", "stickers", "", "Lcom/app/friendschat/data/model/StickerModel;", "deleteStickerFromDraft", "", "sticker", "loadPackagesFromDatabase", "fragment", "Lcom/app/friendschat/ui/my_creation/created_draft_fragment/CreatedDraftBepicFragment;", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public final class CreatedDraftViewModel extends com.app.friendschat.ui.base.BaseViewModel {
    private com.app.friendschat.database.PackageDao packageDao;
    private java.util.List<com.app.friendschat.data.model.StickerModel> stickers;
    private com.app.friendschat.ui.my_creation.created_draft_fragment.CreatedDraftAdapter adapter;
    
    public CreatedDraftViewModel() {
        super();
    }
    
    public final void loadPackagesFromDatabase(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.my_creation.created_draft_fragment.CreatedDraftBepicFragment fragment) {
    }
    
    public final void deleteStickerFromDraft(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.StickerModel sticker) {
    }
}