package com.app.friendschat.ui.my_creation

import android.graphics.Color
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.app.friendschat.R
import com.app.friendschat.data.model.Action
import com.app.friendschat.databinding.FragmentMyCreationBepicBinding
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.main.MainBepicActivity
import com.app.friendschat.utils.printLog
import com.app.friendschat.utils.widget.tapAndCheckInternet

class MyCreationBepicFragment : BaseFragment<MyCreationViewModel, FragmentMyCreationBepicBinding>(), NavController.OnDestinationChangedListener {

    private lateinit var navControllerBepic: NavController

    override fun initView() {
        try {
            val navHostFragment = childFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
            navControllerBepic = navHostFragment.navController

            if ((requireActivity() as MainBepicActivity).actionEditDraftBepic != null) {
                if ((requireActivity() as MainBepicActivity).actionEditDraftBepic == Action.EDIT_DRAFT) {
                    binding.rlPackageTab.background = ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.border_share_or_download_button,
                        null
                    )

                    binding.rlDraftTab.background =
                        ResourcesCompat.getDrawable(resources, R.drawable.border_select_language, null)

                    if (navControllerBepic.currentDestination?.id != R.id.createdDraftFragment) {
                        navControllerBepic.navigate(R.id.createdDraftFragment)
                    }

                    binding.tvPackage.setTextColor(Color.parseColor("#0C111D"))
                    binding.tvDraft.setTextColor(Color.parseColor("#FFFFFF"))
                }
            }
        } catch (e: Exception) {

        }
    }

    override fun createViewModel(): Class<MyCreationViewModel> = MyCreationViewModel::class.java

    override fun bindViewModel() {
        setupFragmentNavigationBepic()
    }

    override fun getResourceLayout(): Int = R.layout.fragment_my_creation_bepic

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        printLog("$controller - $destination")
    }

    private fun setupFragmentNavigationBepic() {
        binding.rlPackageTab.tapAndCheckInternet {
            binding.rlPackageTab.background = ResourcesCompat.getDrawable(resources, R.drawable.border_select_language, null)
            binding.rlDraftTab.background = ResourcesCompat.getDrawable(resources, R.drawable.border_share_or_download_button, null)
            binding.tvPackage.setTextColor(Color.parseColor("#FFFFFF"))
            binding.tvDraft.setTextColor(Color.parseColor("#0C111D"))

            if (navControllerBepic.currentDestination?.id != R.id.createdPackageFragment) {
                navControllerBepic.navigate(R.id.createdPackageFragment)
            }
        }
        binding.rlDraftTab.tapAndCheckInternet {
            binding.rlPackageTab.background = ResourcesCompat.getDrawable(resources, R.drawable.border_share_or_download_button, null)
            binding.rlDraftTab.background = ResourcesCompat.getDrawable(resources, R.drawable.border_select_language, null)
            binding.tvPackage.setTextColor(Color.parseColor("#0C111D"))
            binding.tvDraft.setTextColor(Color.parseColor("#FFFFFF"))
            if (navControllerBepic.currentDestination?.id != R.id.createdDraftFragment) {
                navControllerBepic.navigate(R.id.createdDraftFragment)
            }
        }
    }
}