package com.app.friendschat.databinding;
import com.app.friendschat.R;
import com.app.friendschat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityIntroBepicNewBindingImpl extends ActivityIntroBepicNewBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linear_dots, 1);
        sViewsWithIds.put(R.id.dot_1, 2);
        sViewsWithIds.put(R.id.dot_2, 3);
        sViewsWithIds.put(R.id.dot_3, 4);
        sViewsWithIds.put(R.id.viewpager, 5);
        sViewsWithIds.put(R.id.rl_next_ads, 6);
        sViewsWithIds.put(R.id.tv_next, 7);
        sViewsWithIds.put(R.id.iv_row_continue, 8);
        sViewsWithIds.put(R.id.native_ad_view_container, 9);
        sViewsWithIds.put(R.id.native_ad_view, 10);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityIntroBepicNewBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private ActivityIntroBepicNewBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.view.View) bindings[2]
            , (android.view.View) bindings[3]
            , (android.view.View) bindings[4]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.FrameLayout) bindings[10]
            , (android.widget.FrameLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[0]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.TextView) bindings[7]
            , (androidx.viewpager2.widget.ViewPager2) bindings[5]
            );
        this.parent.setTag(null);
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
            setViewModel((com.app.friendschat.ui.intro.IntroViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.app.friendschat.ui.intro.IntroViewModel ViewModel) {
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