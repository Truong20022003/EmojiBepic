package com.app.friendschat.ui.settings

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManager
import com.google.android.play.core.review.ReviewManagerFactory
import com.app.friendschat.BuildConfig
import com.app.friendschat.R
import com.app.friendschat.databinding.FragmentSettingsBepicBinding
import com.app.friendschat.rate.RatingBepicDialog
import com.app.friendschat.rate.SharePrefUtils
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.language_setting.LanguageBepicActivity
import com.app.friendschat.ui.policy.PolicyBepicActivity
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.widget.tapAndCheckInternet

class SettingsBepicFragment : BaseFragment<SettingsViewModel, FragmentSettingsBepicBinding>() {

    override fun initView() {

        EventTracking.logEvent(requireActivity(), EventTracking.EVENT_NAME_SETTING_VIEW)

        binding.tvVersion.text = getString(R.string.version) + " " + BuildConfig.VERSION_NAME

        binding.llLanguage.tapAndCheckInternet {
            showActivity(LanguageBepicActivity::class.java)
            EventTracking.logEvent(requireActivity(), EventTracking.EVENT_NAME_SETTING_LANGUAGE_CLICK)
        }

        binding.llRating.tapAndCheckInternet {
            showRatingDialogBepic()

        }

        binding.llShare.tapAndCheckInternet {

            binding.llShare.isEnabled = false

            shareAppBepic()
            EventTracking.logEvent(requireActivity(), EventTracking.EVENT_NAME_SETTING_SHARE_CLICK)

            Handler().postDelayed({
                binding.llShare.isEnabled = true
            }, 1000)
        }

        binding.llPrivacyPolicy.tapAndCheckInternet {
            showActivity(PolicyBepicActivity::class.java)
            EventTracking.logEvent(requireActivity(), EventTracking.EVENT_NAME_SETTING_PRIVACY_POLICY_CLICK)
        }

        if (SharePrefUtils.isRated(requireActivity())) {
            binding.llRating.visibility = View.GONE
        }
    }

    override fun getResourceLayout(): Int = R.layout.fragment_settings_bepic

    override fun createViewModel(): Class<SettingsViewModel> = SettingsViewModel::class.java

    override fun bindViewModel() {

    }

    private fun shareAppBepic() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name))
        intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + requireActivity().packageName)
        startActivity(Intent.createChooser(intent, getString(R.string.share_app)))
    }

    private fun showRatingDialogBepic() {
        val ratingDialog =
            RatingBepicDialog(requireActivity())
        ratingDialog.setOnPressBepic(object : RatingBepicDialog.OnPress {

            override fun cancel() {

            }

            override fun later() {
                ratingDialog.dismiss()
            }

            override fun rating() {
                val manager: ReviewManager = ReviewManagerFactory.create(requireActivity())
                val request: Task<ReviewInfo> = manager.requestReviewFlow()
                request.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val reviewInfo: ReviewInfo = task.result
                        val flow: Task<Void> =
                            manager.launchReviewFlow(requireActivity(), reviewInfo)
                        flow.addOnSuccessListener {
                            SharePrefUtils.forceRated(requireActivity())
                            ratingDialog.dismiss()
                            dialogAfterRate()
                            binding.llRating.visibility = View.GONE
                        }
                    } else {
                        ratingDialog.dismiss()
                    }
                }
            }

            override fun send(rate: Float) {
                Toast.makeText(
                    requireActivity(),
                    requireActivity().getString(R.string.thank_you_for_rating_us),
                    Toast.LENGTH_SHORT
                ).show()
                SharePrefUtils.forceRated(requireActivity())
                binding.llRating.visibility = View.GONE
                ratingDialog.dismiss()
                dialogAfterRate()
            }
        })
        ratingDialog.show()

        val bundle = Bundle()
        bundle.putString("position", "Setting")
        EventTracking.logEvent(requireActivity(), EventTracking.EVENT_NAME_RATE_SHOW)
    }

    fun dialogAfterRate() {
        val builder = AlertDialog.Builder(requireActivity(), R.style.TransparentDialog)
        val inflater = LayoutInflater.from(requireActivity())
        val dialogView = inflater.inflate(R.layout.dialog_after_rate, null)
        builder.setView(dialogView)
        val dialog = builder.create()
        val rlOkay = dialogView.findViewById<RelativeLayout>(R.id.rl_okay)
        rlOkay.setOnClickListener(View.OnClickListener { dialog.dismiss() })
        dialog.show()
    }
}