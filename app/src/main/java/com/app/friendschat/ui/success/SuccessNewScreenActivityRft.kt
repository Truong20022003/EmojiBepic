package com.app.friendschat.ui.success

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import com.app.friendschat.R
import com.app.friendschat.data.model.Action
import com.app.friendschat.databinding.ActivitySuccessfullySaveBepicRftBinding
import com.app.friendschat.rate.RatingBepicDialog
import com.app.friendschat.rate.SharePrefUtils
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.main.MainBepicActivityRft
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.widget.tapAndCheckInternet
import com.google.android.gms.tasks.Task
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManager
import com.google.android.play.core.review.ReviewManagerFactory
import kotlin.reflect.KClass

class SuccessNewScreenActivityRft : BaseActivity<SuccessViewModel, ActivitySuccessfullySaveBepicRftBinding>() {

    companion object {
        private var numberOfClickMoreButtonBepic = 0
    }

    private var actionBepicRft: Action? = null

    override fun initView() {
        EventTracking.logEvent(this, EventTracking.EVENT_NAME_SUCCESS_VIEW)

        actionBepicRft = intent.getSerializableExtra(Constants.BUNDLE_SAVE_ACTION) as Action

        binding.tvExploreMore.text = intent.getStringExtra(Constants.BUNDLE_BUTTON_TEXT_CONTENT_SUCCESS_ACTIVITY)
        binding.rlExploreMore.tapAndCheckInternet {

            numberOfClickMoreButtonBepic++

            if (!SharePrefUtils.isRated(this) && numberOfClickMoreButtonBepic % 4 == 0) {
                showRatingDialogBepicRft()
            } else {
                navigateToNextScreenBepicRft()
            }
            EventTracking.logEvent(this, EventTracking.EVENT_NAME_SUCCESS_MORE_CLICK)
        }
    }

    override fun createViewModel(): Class<SuccessViewModel> = SuccessViewModel::class.java

    override fun getContentView(): Int = R.layout.activity_successfully_save_bepic_rft

    override fun onFragmentResumed(fragment: BaseFragment<*, *>) {

    }

    override fun switchFragment(fragment: KClass<*>, bundle: Bundle?, addToBackStack: Boolean) {

    }

    override fun bindViewModel() {

    }
    fun dialogAfterRateRft() {
        val builder = AlertDialog.Builder(this@SuccessNewScreenActivityRft, R.style.TransparentDialog)
        val inflater = LayoutInflater.from(this@SuccessNewScreenActivityRft)
        val dialogView = inflater.inflate(R.layout.dialog_after_rate_rft, null)
        builder.setView(dialogView)
        val dialog = builder.create()
        val rlOkay = dialogView.findViewById<RelativeLayout>(R.id.rl_okay)
        rlOkay.setOnClickListener(View.OnClickListener { navigateToNextScreenBepicRft() })
        dialog.show()
    }

    private fun showRatingDialogBepicRft() {
        val ratingDialog =
            RatingBepicDialog(this)
        ratingDialog.setOnPressBepic(object : RatingBepicDialog.OnPress {

            override fun cancel() {
                navigateToNextScreenBepicRft()
            }

            override fun later() {
                ratingDialog.dismiss()
                navigateToNextScreenBepicRft()
            }

            override fun rating() {
                val manager: ReviewManager = ReviewManagerFactory.create(this@SuccessNewScreenActivityRft)
                val request: Task<ReviewInfo> = manager.requestReviewFlow()
                request.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val reviewInfo: ReviewInfo = task.result
                        val flow: Task<Void> =
                            manager.launchReviewFlow(this@SuccessNewScreenActivityRft, reviewInfo)
                        flow.addOnSuccessListener {
                            SharePrefUtils.forceRated(this@SuccessNewScreenActivityRft)
                            ratingDialog.dismiss()
                            dialogAfterRateRft()
                        }
                    } else {
                        ratingDialog.dismiss()
                        navigateToNextScreenBepicRft()
                    }
                }
            }

            override fun send(rate: Float) {
                Toast.makeText(
                    this@SuccessNewScreenActivityRft,
                    this@SuccessNewScreenActivityRft.getString(R.string.thank_you_for_rating_us),
                    Toast.LENGTH_SHORT
                ).show()
                SharePrefUtils.forceRated(this@SuccessNewScreenActivityRft)
                ratingDialog.dismiss()
                dialogAfterRateRft()
            }
        })
        ratingDialog.show()

        val bundle = Bundle()
        bundle.putString("position", "Success Screen")
        EventTracking.logEvent(this@SuccessNewScreenActivityRft, EventTracking.EVENT_NAME_RATE_SHOW)
    }
    private fun navigateToNextScreenBepicRft() {
        val bundle = Bundle()
        bundle.putSerializable(Constants.BUNDLE_SUCCESS_ACTION, actionBepicRft)
        showActivity(MainBepicActivityRft::class.java, bundle)
        finishAffinity()
    }
    override fun onBackPressed() {

    }







}