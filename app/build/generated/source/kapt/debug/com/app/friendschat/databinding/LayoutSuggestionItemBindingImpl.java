package com.app.friendschat.databinding;
import com.app.friendschat.R;
import com.app.friendschat.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LayoutSuggestionItemBindingImpl extends LayoutSuggestionItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rl_icon, 1);
        sViewsWithIds.put(R.id.iv_icon, 2);
        sViewsWithIds.put(R.id.pb_icon, 3);
        sViewsWithIds.put(R.id.tv_title, 4);
        sViewsWithIds.put(R.id.iv_number_of_sticker, 5);
        sViewsWithIds.put(R.id.tv_number_of_sticker, 6);
        sViewsWithIds.put(R.id.iv_dots, 7);
        sViewsWithIds.put(R.id.sf_1, 8);
        sViewsWithIds.put(R.id.iv_image_1, 9);
        sViewsWithIds.put(R.id.pb_1, 10);
        sViewsWithIds.put(R.id.sf_2, 11);
        sViewsWithIds.put(R.id.iv_image_2, 12);
        sViewsWithIds.put(R.id.pb_2, 13);
        sViewsWithIds.put(R.id.sf_3, 14);
        sViewsWithIds.put(R.id.iv_image_3, 15);
        sViewsWithIds.put(R.id.pb_3, 16);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public LayoutSuggestionItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private LayoutSuggestionItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ProgressBar) bindings[10]
            , (android.widget.ProgressBar) bindings[13]
            , (android.widget.ProgressBar) bindings[16]
            , (android.widget.ProgressBar) bindings[3]
            , (android.widget.RelativeLayout) bindings[1]
            , (com.app.friendschat.utils.custom_view.SquareFrame) bindings[8]
            , (com.app.friendschat.utils.custom_view.SquareFrame) bindings[11]
            , (com.app.friendschat.utils.custom_view.SquareFrame) bindings[14]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[4]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
            return variableSet;
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
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}