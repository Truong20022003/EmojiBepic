package com.app.friendschat.ui.my_creation.created_package_fragment

import android.content.Intent
import com.app.friendschat.R
import com.app.friendschat.databinding.FragmentCreatedPackageBepicBinding
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.whatsapp.AddToWhatsappBepicFragment

class CreatedPackageBepicFragment: AddToWhatsappBepicFragment<CreatedPackageViewModel, FragmentCreatedPackageBepicBinding>() {

    override fun initView() {
        EventTracking.logEvent(requireActivity(), EventTracking.EVENT_NAME_CREATION_PACKAGE_VIEW)
    }

    override fun bindViewModel() {
        viewModel.loadPackagesFromDatabase(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Constants.REQUEST_CODE_DELETE_STICKER) {
            viewModel.refreshAdapterWithNewList()
        }
    }

    override fun createViewModel(): Class<CreatedPackageViewModel> = CreatedPackageViewModel::class.java

    override fun getResourceLayout(): Int = R.layout.fragment_created_package_bepic
}