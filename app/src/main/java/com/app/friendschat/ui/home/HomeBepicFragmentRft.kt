package com.app.friendschat.ui.home

import android.text.TextWatcher
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.friendschat.R
import com.app.friendschat.bottom_sheet.SelectTypeBepicBts
import com.app.friendschat.data.model.StickerModel
import com.app.friendschat.data.model.StickerPackInfo
import com.app.friendschat.databinding.FragmentHomeBepicRftBinding
import com.app.friendschat.server_call_data.ApiService
import com.app.friendschat.server_call_data.PackageStickerModel
import com.app.friendschat.ui.emoji.EmojiBepicActivityNew
import com.app.friendschat.utils.AssetUtils
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.widget.tapAndCheckInternet
import com.app.friendschat.whatsapp.AddToWhatsappBepicFragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeBepicFragmentRft : AddToWhatsappBepicFragment<HomeViewModel, FragmentHomeBepicRftBinding>() {

    private var suggestionStickerAdapterBepic: SuggestionStickerAdapter? = null
    private lateinit var selectTypeBottomSheetBepic: SelectTypeBepicBts

    override fun initView() {
        EventTracking.logEvent(requireActivity(), EventTracking.EVENT_NAME_HOME_VIEW)

        binding.linearNotFound.visibility = android.view.View.GONE
        binding.ivClear.visibility = android.view.View.GONE

        if (AssetUtils.stickerPacksInfo.isEmpty()) {
            ApiService.apiService.callApi().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<List<PackageStickerModel>> {
                    override fun onSubscribe(disposable: Disposable) {

                    }

                    override fun onError(e: Throwable) {

                    }

                    override fun onComplete() {
                        for (i in 0 until AssetUtils.stickerPacksInfo.size){
                            Log.d("listStickerCallData", "$i: ${AssetUtils.stickerPacksInfo[i].title} ${AssetUtils.stickerPacksInfo[i].stickers.size}")
                        }
                        setStickerAdapterBepicRft()
                    }

                    override fun onNext(list: List<PackageStickerModel>) {
                        val groupedByTitle: Map<String, List<PackageStickerModel>> = list.groupBy { it.title }

                        AssetUtils.stickerPacksInfo = groupedByTitle.map { (_, models) ->
                            StickerPackInfo(
                                title = models.first().title,
                                iconUrl = models.first().icon_url,
                                stickers = models.map { StickerModel(it.sticker_url) }
                            )
                        }.toMutableList()
                    }
                })
        } else {
            setStickerAdapterBepicRft()
        }

        selectTypeBottomSheetBepic = SelectTypeBepicBts(
            onClickEmoji = {
                showActivity(EmojiBepicActivityNew::class.java)
            },
            onClickSticker = {

            }
        )

        binding.edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: android.text.Editable?) {
                val text = p0.toString().trim()
                if (suggestionStickerAdapterBepic != null) {
                    val size = suggestionStickerAdapterBepic?.filter(text)

                    if (text.isEmpty()) {
                        binding.rlCreate.visibility = android.view.View.VISIBLE
                        binding.tvSuggest.visibility = android.view.View.VISIBLE
                    } else {
                        binding.rlCreate.visibility = android.view.View.GONE
                        binding.tvSuggest.visibility = android.view.View.GONE
                    }

                    if (size == 0) {
                        binding.linearNotFound.visibility = android.view.View.VISIBLE
                    } else {
                        binding.linearNotFound.visibility = android.view.View.GONE
                    }

                    if (text.isNotEmpty()) {
                        binding.ivClear.visibility = android.view.View.VISIBLE
                    } else {
                        binding.ivClear.visibility = android.view.View.GONE
                    }
                }

                EventTracking.logEvent(requireActivity(), EventTracking.EVENT_NAME_HOME_SEARCH_RESULT_VIEW)
            }
        })

        binding.ivClear.tapAndCheckInternet {
            binding.edtSearch.setText("")
        }
    }
    private fun setStickerAdapterBepicRft(){
        suggestionStickerAdapterBepic = SuggestionStickerAdapter(this@HomeBepicFragmentRft)
        binding.rvSuggest.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvSuggest.adapter = suggestionStickerAdapterBepic
    }
    override fun getResourceLayout(): Int = R.layout.fragment_home_bepic_rft

    override fun createViewModel(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun bindViewModel() {
        binding.rlCreate.tapAndCheckInternet {
            showActivity(EmojiBepicActivityNew::class.java)
            EventTracking.logEvent(requireActivity(), EventTracking.EVENT_NAME_HOME_CREATE_CLICK)
        }
    }


}