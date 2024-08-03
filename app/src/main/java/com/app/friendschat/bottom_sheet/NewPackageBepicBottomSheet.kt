package com.app.friendschat.bottom_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.Toast
import com.app.friendschat.R
import com.app.friendschat.data.model.PackageModel
import com.app.friendschat.database.AppDatabase
import com.app.friendschat.database.PackageDao
import com.app.friendschat.utils.widget.tapAndCheckInternet
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewPackageBepicBottomSheet(
    private val onCreateSuccessfully : () -> Unit = {}
) : BottomSheetDialogFragment() {

    private lateinit var rlCancelBepic: RelativeLayout
    private lateinit var rlSaveBepic: RelativeLayout
    private lateinit var edtPackageNameBepic: EditText

    private var packageDaoBepic: PackageDao? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val contentView = inflater.inflate(R.layout.layout_new_package_bottom_sheet, container, false)
        initViewBepic(contentView)
        connectToDatabaseBepic()
        return contentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListenersBepic()
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }

    private fun setupListenersBepic() {
        rlCancelBepic.tapAndCheckInternet {
            dismiss()
        }

        rlSaveBepic.tapAndCheckInternet {
            CoroutineScope(Dispatchers.Main).launch {
                if (validatePackageName()) {
                    insertPackageName(edtPackageNameBepic.text.trim().toString())
                    onCreateSuccessfully.invoke()
                    dismiss()
                }
            }
        }
    }

    private fun connectToDatabaseBepic() {
        packageDaoBepic = AppDatabase.getInstance(requireActivity())?.packageNameDao()
    }

    private fun initViewBepic(view: View) {
        edtPackageNameBepic = view.findViewById(R.id.edt_package_name)
        rlCancelBepic = view.findViewById(R.id.rl_cancel)
        rlSaveBepic = view.findViewById(R.id.rl_save)
    }

    private suspend fun validatePackageName(): Boolean {
        val text = edtPackageNameBepic.text.trim().toString()

        if (text.isEmpty()) {
            Toast.makeText(requireContext(), getString(R.string.please_enter_package_name), Toast.LENGTH_SHORT).show()
            return false
        }

        if (checkPackageNameExisted(text)) {
            Toast.makeText(requireContext(), getString(R.string.package_name_already_exists), Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private suspend fun insertPackageName(packageName: String) = withContext(Dispatchers.IO) {
        packageDaoBepic?.insertPackage(PackageModel(packageName))
    }

    private suspend fun checkPackageNameExisted(packageName: String): Boolean = withContext(Dispatchers.IO) {
        return@withContext packageDaoBepic?.isPackageNameExisted(packageName) ?: false
    }
}
