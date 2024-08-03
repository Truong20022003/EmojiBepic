package com.app.friendschat.ui.success

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import com.app.friendschat.R
import com.app.friendschat.data.model.Action
import com.app.friendschat.databinding.ActivitySuccessfullySaveBepicBinding
import com.app.friendschat.rate.RatingBepicDialog
import com.app.friendschat.rate.SharePrefUtils
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.main.MainBepicActivity
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.widget.tapAndCheckInternet
import com.google.android.gms.tasks.Task
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManager
import com.google.android.play.core.review.ReviewManagerFactory
import kotlin.reflect.KClass

class SuccessNewScreenActivity : BaseActivity<SuccessViewModel, ActivitySuccessfullySaveBepicBinding>() {

    companion object {
        private var numberOfClickMoreButtonBepic = 0
    }

    private var actionBepic: Action? = null

    override fun initView() {
        EventTracking.logEvent(this, EventTracking.EVENT_NAME_SUCCESS_VIEW)

        actionBepic = intent.getSerializableExtra(Constants.BUNDLE_SAVE_ACTION) as Action

        binding.tvExploreMore.text = intent.getStringExtra(Constants.BUNDLE_BUTTON_TEXT_CONTENT_SUCCESS_ACTIVITY)
        binding.rlExploreMore.tapAndCheckInternet {

            numberOfClickMoreButtonBepic++

            if (!SharePrefUtils.isRated(this) && numberOfClickMoreButtonBepic % 4 == 0) {
                showRatingDialogBepic()
            } else {
                navigateToNextScreenBepic()
            }
            EventTracking.logEvent(this, EventTracking.EVENT_NAME_SUCCESS_MORE_CLICK)
        }
    }

    override fun createViewModel(): Class<SuccessViewModel> = SuccessViewModel::class.java

    override fun getContentView(): Int = R.layout.activity_successfully_save_bepic

    override fun onFragmentResumed(fragment: BaseFragment<*, *>) {

    }

    override fun switchFragment(fragment: KClass<*>, bundle: Bundle?, addToBackStack: Boolean) {

    }

    override fun bindViewModel() {

    }

    override fun onBackPressed() {

    }

    private fun showRatingDialogBepic() {
        val ratingDialog =
            RatingBepicDialog(this)
        ratingDialog.setOnPressBepic(object : RatingBepicDialog.OnPress {

            override fun cancel() {
                navigateToNextScreenBepic()
            }

            override fun later() {
                ratingDialog.dismiss()
                navigateToNextScreenBepic()
            }

            override fun rating() {
                val manager: ReviewManager = ReviewManagerFactory.create(this@SuccessNewScreenActivity)
                val request: Task<ReviewInfo> = manager.requestReviewFlow()
                request.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val reviewInfo: ReviewInfo = task.result
                        val flow: Task<Void> =
                            manager.launchReviewFlow(this@SuccessNewScreenActivity, reviewInfo)
                        flow.addOnSuccessListener {
                            SharePrefUtils.forceRated(this@SuccessNewScreenActivity)
                            ratingDialog.dismiss()
                            dialogAfterRate()
                        }
                    } else {
                        ratingDialog.dismiss()
                        navigateToNextScreenBepic()
                    }
                }
            }

            override fun send(rate: Float) {
                Toast.makeText(
                    this@SuccessNewScreenActivity,
                    this@SuccessNewScreenActivity.getString(R.string.thank_you_for_rating_us),
                    Toast.LENGTH_SHORT
                ).show()
                SharePrefUtils.forceRated(this@SuccessNewScreenActivity)
                ratingDialog.dismiss()
                dialogAfterRate()
            }
        })
        ratingDialog.show()

        val bundle = Bundle()
        bundle.putString("position", "Success Screen")
        EventTracking.logEvent(this@SuccessNewScreenActivity, EventTracking.EVENT_NAME_RATE_SHOW)
    }

    private fun navigateToNextScreenBepic() {
        val bundle = Bundle()
        bundle.putSerializable(Constants.BUNDLE_SUCCESS_ACTION, actionBepic)
        showActivity(MainBepicActivity::class.java, bundle)
        finishAffinity()
    }

    fun dialogAfterRate() {
        val builder = AlertDialog.Builder(this@SuccessNewScreenActivity, R.style.TransparentDialog)
        val inflater = LayoutInflater.from(this@SuccessNewScreenActivity)
        val dialogView = inflater.inflate(R.layout.dialog_after_rate, null)
        builder.setView(dialogView)
        val dialog = builder.create()
        val rlOkay = dialogView.findViewById<RelativeLayout>(R.id.rl_okay)
        rlOkay.setOnClickListener(View.OnClickListener { navigateToNextScreenBepic() })
        dialog.show()
    }

}