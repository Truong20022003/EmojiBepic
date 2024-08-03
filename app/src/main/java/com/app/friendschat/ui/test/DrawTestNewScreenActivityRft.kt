package com.app.friendschat.ui.test

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.app.friendschat.R
import com.app.friendschat.utils.custom_view.BrushView
import com.app.friendschat.utils.custom_view.DrawingView
import com.app.friendschat.utils.custom_view.brushes.Brushes
import com.app.friendschat.utils.widget.tapAndCheckInternet
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.UUID


class DrawTestNewScreenActivityRft : AppCompatActivity() {

    private val REQUEST_CODE_IMPORT_IMAGE_BEPIC_RFT = 10

    private var mDrawingViewBepicRft: DrawingView? = null
    private var mSizeSeekBarBepicRft: SeekBar? = null
    private var mUndoButtonBepicRft: Button? = null
    private var mRedoButtonBepicRft: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_bepic_rft)

        mDrawingViewBepicRft = findViewById<DrawingView>(R.id.drawing_view)
        mDrawingViewBepicRft?.setUndoAndRedoEnable(true)

        var bitmap = drawableToBitmapBepicRft(resources.getDrawable(R.drawable.image))
        Log.d("logBitmapphoto", "1.bitmap: $bitmap")

        val brushView = findViewById<BrushView>(R.id.brush_view)
        brushView.setDrawingView(mDrawingViewBepicRft)

        mSizeSeekBarBepicRft = findViewById<SeekBar>(R.id.size_seek_bar)
        mSizeSeekBarBepicRft?.setMax(100)
        mSizeSeekBarBepicRft?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                val brushSettings = mDrawingViewBepicRft?.getBrushSettings()
                brushSettings!!.selectedBrushSize = i / 100f
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })



        findViewById<View>(R.id.clear).tapAndCheckInternet{
                if (mDrawingViewBepicRft!!.clear()) {
                    mUndoButtonBepicRft!!.isEnabled = true
                    mRedoButtonBepicRft!!.isEnabled = false
                }

        }

        findViewById<View>(R.id.reset_zoom).tapAndCheckInternet {
                mDrawingViewBepicRft!!.resetZoom()
        }

        val zoomModeButton = findViewById<Button>(R.id.zoom_mode_button)
        zoomModeButton.tapAndCheckInternet {
                if (mDrawingViewBepicRft!!.isInZoomMode()) {
                    mDrawingViewBepicRft!!.exitZoomMode()
                    zoomModeButton.setText(R.string.enterzoommode)
                    return@tapAndCheckInternet
                }
                mDrawingViewBepicRft!!.enterZoomMode()
                zoomModeButton.setText(R.string.exitzoommode)

        }

        findViewById<View>(R.id.set_background).tapAndCheckInternet {
                val intent = Intent(Intent.ACTION_GET_CONTENT)
                intent.addCategory(Intent.CATEGORY_OPENABLE)
                intent.type = "image/*"
                startActivityForResult(intent, REQUEST_CODE_IMPORT_IMAGE_BEPIC_RFT)
        }

        findViewById<View>(R.id.export).tapAndCheckInternet{
                if (ActivityCompat.checkSelfPermission(
                        this@DrawTestNewScreenActivityRft,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this@DrawTestNewScreenActivityRft,
                        arrayOf<String>(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        0
                    ) //ignoring the request code
                    return@tapAndCheckInternet
                }
                val bitmap = mDrawingViewBepicRft!!.exportDrawing()
                exportImageBepicRft(bitmap)
        }

        findViewById<View>(R.id.export_without_bg).tapAndCheckInternet{
                if (ActivityCompat.checkSelfPermission(
                        this@DrawTestNewScreenActivityRft,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this@DrawTestNewScreenActivityRft,
                        arrayOf<String>(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        0
                    ) //ignoring the request code
                    return@tapAndCheckInternet
                }
                val bitmap = mDrawingViewBepicRft!!.exportDrawingWithoutBackground()
                exportImageBepicRft(bitmap)
        }

        setupUndoAndRedoBepicRft()
        setupBrushesBepicRft()
        setupColorViewsBepicRft()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_IMPORT_IMAGE_BEPIC_RFT) {
            if (RESULT_OK != resultCode) return
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, data!!.data)
                mDrawingViewBepicRft!!.setBackgroundImage(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun exportImageBepicRft(bitmap: Bitmap) {
        val folder: File =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        folder.mkdirs()
        val imageFile = File(folder, UUID.randomUUID().toString() + ".png")
        try {
            storeBitmapBepicRft(imageFile, bitmap)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        MediaScannerConnection.scanFile(
            this, arrayOf(), arrayOf("image/png"),
            null
        )
        sendBroadcast(Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(imageFile)))
    }

    private fun setBrushSelectedBepicRft(brushID: Int) {
        val settings = mDrawingViewBepicRft!!.brushSettings
        settings.selectedBrush = brushID
        val sizeInPercentage = (settings.selectedBrushSize * 100).toInt()
        mSizeSeekBarBepicRft!!.progress = sizeInPercentage
    }








    fun drawableToBitmapBepicRft(drawable: Drawable): Bitmap? {
        try {
            var bitmap: Bitmap? = null
            if (drawable is BitmapDrawable) {
                val bitmapDrawable = drawable
                if (bitmapDrawable.bitmap != null) {
                    return bitmapDrawable.bitmap
                }
            }
            bitmap = if (drawable.intrinsicWidth <= 0 || drawable.intrinsicHeight <= 0) {
                Bitmap.createBitmap(
                    1,
                    1,
                    Bitmap.Config.ARGB_8888
                ) // Single color bitmap will be created of 1x1 pixel
            } else {
                Bitmap.createBitmap(
                    drawable.intrinsicWidth,
                    drawable.intrinsicHeight,
                    Bitmap.Config.ARGB_8888
                )
            }
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)
            return bitmap
        } catch (e: Exception) {

        }
        return null
    }



    @Throws(Exception::class)
    private fun storeBitmapBepicRft(file: File, bitmap: Bitmap) {
        try {
            if (!file.exists() && !file.createNewFile()) throw Exception("Not able to create " + file.getPath())
            val stream: FileOutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            stream.flush()
            stream.close()
        } catch (e: Exception) {

        }
    }
    private fun setupUndoAndRedoBepicRft() {
        mUndoButtonBepicRft = findViewById<Button>(R.id.undo)
        mUndoButtonBepicRft!!.tapAndCheckInternet( {
            mDrawingViewBepicRft!!.undo()
            mUndoButtonBepicRft!!.setEnabled(!mDrawingViewBepicRft!!.isUndoStackEmpty)
            mRedoButtonBepicRft!!.isEnabled = !mDrawingViewBepicRft!!.isRedoStackEmpty
        })
        mRedoButtonBepicRft = findViewById<Button>(R.id.redo)
        mRedoButtonBepicRft!!.tapAndCheckInternet( {
            mDrawingViewBepicRft!!.redo()
            mUndoButtonBepicRft!!.setEnabled(!mDrawingViewBepicRft!!.isUndoStackEmpty)
            mRedoButtonBepicRft!!.setEnabled(!mDrawingViewBepicRft!!.isRedoStackEmpty)
        })
        mDrawingViewBepicRft!!.setOnDrawListener {
            mUndoButtonBepicRft!!.setEnabled(true)
            mRedoButtonBepicRft!!.setEnabled(false)
        }
    }

    private fun setupColorViewsBepicRft() {
        val colorsContainer = findViewById<ViewGroup>(R.id.brush_colors_container)
        for (colorView in colorsContainer.touchables) colorView.setOnClickListener { view ->
            val color = (view.background as ColorDrawable).color
            val brushSettings = mDrawingViewBepicRft!!.brushSettings
            brushSettings.color = color
        }
        val bgColorsContainer = findViewById<ViewGroup>(R.id.bg_colors_container)
        for (colorView in bgColorsContainer.touchables) colorView.tapAndCheckInternet { view ->
            val color = (view?.background as ColorDrawable).color
            mDrawingViewBepicRft!!.drawingBackground = color
        }
    }
    private fun setupBrushesBepicRft() {
        val pen = findViewById<RadioButton>(R.id.pen)
        pen.setOnCheckedChangeListener { compoundButton, b -> if (b) setBrushSelectedBepicRft(Brushes.PEN) }
        val pencil = findViewById<RadioButton>(R.id.pencil)
        pencil.setOnCheckedChangeListener { compoundButton, b -> if (b) setBrushSelectedBepicRft(Brushes.PENCIL) }
        val eraser = findViewById<RadioButton>(R.id.eraser)
        eraser.setOnCheckedChangeListener { compoundButton, b -> if (b) setBrushSelectedBepicRft(Brushes.ERASER) }
        val calligraphy = findViewById<RadioButton>(R.id.calligraphy)
        calligraphy.setOnCheckedChangeListener { compoundButton, b ->
            if (b) setBrushSelectedBepicRft(
                Brushes.CALLIGRAPHY
            )
        }
        val airBrush = findViewById<RadioButton>(R.id.air_brush)
        airBrush.setOnCheckedChangeListener { compoundButton, b -> if (b) setBrushSelectedBepicRft(Brushes.AIR_BRUSH) }
    }
}