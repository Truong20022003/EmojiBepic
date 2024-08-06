package com.app.friendschat.databinding;
import com.app.friendschat.R;
import com.app.friendschat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityEditEmojiNewRftBindingImpl extends ActivityEditEmojiNewRftBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rl_header, 1);
        sViewsWithIds.put(R.id.iv_back, 2);
        sViewsWithIds.put(R.id.tv_done, 3);
        sViewsWithIds.put(R.id.rl_emoji, 4);
        sViewsWithIds.put(R.id.stickerView, 5);
        sViewsWithIds.put(R.id.rl_lock, 6);
        sViewsWithIds.put(R.id.iv_lock_emoji, 7);
        sViewsWithIds.put(R.id.rl_delete, 8);
        sViewsWithIds.put(R.id.iv_delete_emoji, 9);
        sViewsWithIds.put(R.id.ll_options, 10);
        sViewsWithIds.put(R.id.rl_option_header, 11);
        sViewsWithIds.put(R.id.iv_refresh, 12);
        sViewsWithIds.put(R.id.iv_more, 13);
        sViewsWithIds.put(R.id.iv_flip_horizontal, 14);
        sViewsWithIds.put(R.id.iv_flip_vertical, 15);
        sViewsWithIds.put(R.id.view1, 16);
        sViewsWithIds.put(R.id.rv_icon, 17);
        sViewsWithIds.put(R.id.vp_icon, 18);
        sViewsWithIds.put(R.id.view2, 19);
        sViewsWithIds.put(R.id.rl_options, 20);
        sViewsWithIds.put(R.id.rl_recent, 21);
        sViewsWithIds.put(R.id.iv_option, 22);
        sViewsWithIds.put(R.id.tv_option, 23);
        sViewsWithIds.put(R.id.rv_options, 24);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityEditEmojiNewRftBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }
    private ActivityEditEmojiNewRftBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[22]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.RelativeLayout) bindings[10]
            , (android.widget.RelativeLayout) bindings[8]
            , (android.widget.RelativeLayout) bindings[4]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.RelativeLayout) bindings[6]
            , (android.widget.RelativeLayout) bindings[11]
            , (android.widget.RelativeLayout) bindings[20]
            , (android.widget.RelativeLayout) bindings[21]
            , (androidx.recyclerview.widget.RecyclerView) bindings[17]
            , (androidx.recyclerview.widget.RecyclerView) bindings[24]
            , (com.app.friendschat.utils.custom_sticker.StickerView) bindings[5]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[23]
            , (android.view.View) bindings[16]
            , (android.view.View) bindings[19]
            , (androidx.viewpager2.widget.ViewPager2) bindings[18]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((com.app.friendschat.ui.emoji_edit.EditEmojiViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.app.friendschat.ui.emoji_edit.EditEmojiViewModel ViewModel) {
        this.mViewModel = ViewModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}