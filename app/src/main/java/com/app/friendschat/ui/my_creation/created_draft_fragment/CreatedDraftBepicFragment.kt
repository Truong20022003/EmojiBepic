package com.app.friendschat.ui.my_creation.created_draft_fragment

import com.app.friendschat.R
import com.app.friendschat.databinding.FragmentCreatedDraftBepicBinding
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.utils.EventTracking

class CreatedDraftBepicFragment: BaseFragment<CreatedDraftViewModel, FragmentCreatedDraftBepicBinding>() {

    override fun initView() {
        EventTracking.logEvent(this.requireActivity(), EventTracking.EVENT_NAME_CREATION_DRAFT_VIEW)
    }

    override fun createViewModel(): Class<CreatedDraftViewModel> = CreatedDraftViewModel::class.java

    override fun bindViewModel() {
        viewModel.loadPackagesFromDatabase(this)
    }

    override fun getResourceLayout(): Int = R.layout.fragment_created_draft_bepic
}