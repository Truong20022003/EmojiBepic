package com.app.friendschat.databinding;
import com.app.friendschat.R;
import com.app.friendschat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityEmojiBepicNewBindingImpl extends ActivityEmojiBepicNewBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rl_header, 1);
        sViewsWithIds.put(R.id.iv_back, 2);
        sViewsWithIds.put(R.id.tv_create, 3);
        sViewsWithIds.put(R.id.g1, 4);
        sViewsWithIds.put(R.id.rl_emoji, 5);
        sViewsWithIds.put(R.id.stickerView, 6);
        sViewsWithIds.put(R.id.rl_lock, 7);
        sViewsWithIds.put(R.id.iv_lock_emoji, 8);
        sViewsWithIds.put(R.id.rl_delete, 9);
        sViewsWithIds.put(R.id.iv_delete_emoji, 10);
        sViewsWithIds.put(R.id.ll_options, 11);
        sViewsWithIds.put(R.id.rl_option_header, 12);
        sViewsWithIds.put(R.id.iv_refresh, 13);
        sViewsWithIds.put(R.id.iv_more, 14);
        sViewsWithIds.put(R.id.iv_flip_horizontal, 15);
        sViewsWithIds.put(R.id.iv_flip_vertical, 16);
        sViewsWithIds.put(R.id.view1, 17);
        sViewsWithIds.put(R.id.rv_icon, 18);
        sViewsWithIds.put(R.id.vp_icon, 19);
        sViewsWithIds.put(R.id.view2, 20);
        sViewsWithIds.put(R.id.rl_options, 21);
        sViewsWithIds.put(R.id.rl_recent, 22);
        sViewsWithIds.put(R.id.iv_option, 23);
        sViewsWithIds.put(R.id.tv_option, 24);
        sViewsWithIds.put(R.id.rv_options, 25);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityEmojiBepicNewBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 26, sIncludes, sViewsWithIds));
    }
    private ActivityEmojiBepicNewBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.Guideline) bindings[4]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[23]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.RelativeLayout) bindings[11]
            , (android.widget.RelativeLayout) bindings[9]
            , (android.widget.RelativeLayout) bindings[5]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.RelativeLayout) bindings[7]
            , (android.widget.RelativeLayout) bindings[12]
            , (android.widget.RelativeLayout) bindings[21]
            , (android.widget.RelativeLayout) bindings[22]
            , (androidx.recyclerview.widget.RecyclerView) bindings[18]
            , (androidx.recyclerview.widget.RecyclerView) bindings[25]
            , (com.app.friendschat.utils.custom_sticker.StickerView) bindings[6]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[24]
            , (android.view.View) bindings[17]
            , (android.view.View) bindings[20]
            , (androidx.viewpager2.widget.ViewPager2) bindings[19]
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
            setViewModel((com.app.friendschat.ui.emoji.EmojiViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.app.friendschat.ui.emoji.EmojiViewModel ViewModel) {
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