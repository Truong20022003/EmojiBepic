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


class DrawTestNewScreenActivity : AppCompatActivity() {

    private val REQUEST_CODE_IMPORT_IMAGE_BEPIC = 10

    private var mDrawingViewBepic: DrawingView? = null
    private var mSizeSeekBarBepic: SeekBar? = null
    private var mUndoButtonBepic: Button? = null
    private var mRedoButtonBepic: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_bepic)

        mDrawingViewBepic = findViewById<DrawingView>(R.id.drawing_view)
        mDrawingViewBepic?.setUndoAndRedoEnable(true)

        var bitmap = drawableToBitmapBepic(resources.getDrawable(R.drawable.image))
        Log.d("logBitmapphoto", "1.bitmap: $bitmap")

        val brushView = findViewById<BrushView>(R.id.brush_view)
        brushView.setDrawingView(mDrawingViewBepic)

        mSizeSeekBarBepic = findViewById<SeekBar>(R.id.size_seek_bar)
        mSizeSeekBarBepic?.setMax(100)
        mSizeSeekBarBepic?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                val brushSettings = mDrawingViewBepic?.getBrushSettings()
                brushSettings!!.selectedBrushSize = i / 100f
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })



        findViewById<View>(R.id.clear).tapAndCheckInternet{
                if (mDrawingViewBepic!!.clear()) {
                    mUndoButtonBepic!!.isEnabled = true
                    mRedoButtonBepic!!.isEnabled = false
                }

        }

        findViewById<View>(R.id.reset_zoom).tapAndCheckInternet {
                mDrawingViewBepic!!.resetZoom()
        }

        val zoomModeButton = findViewById<Button>(R.id.zoom_mode_button)
        zoomModeButton.tapAndCheckInternet {
                if (mDrawingViewBepic!!.isInZoomMode()) {
                    mDrawingViewBepic!!.exitZoomMode()
                    zoomModeButton.setText(R.string.enterzoommode)
                    return@tapAndCheckInternet
                }
                mDrawingViewBepic!!.enterZoomMode()
                zoomModeButton.setText(R.string.exitzoommode)

        }

        findViewById<View>(R.id.set_background).tapAndCheckInternet {
                val intent = Intent(Intent.ACTION_GET_CONTENT)
                intent.addCategory(Intent.CATEGORY_OPENABLE)
                intent.type = "image/*"
                startActivityForResult(intent, REQUEST_CODE_IMPORT_IMAGE_BEPIC)
        }

        findViewById<View>(R.id.export).tapAndCheckInternet{
                if (ActivityCompat.checkSelfPermission(
                        this@DrawTestNewScreenActivity,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this@DrawTestNewScreenActivity,
                        arrayOf<String>(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        0
                    ) //ignoring the request code
                    return@tapAndCheckInternet
                }
                val bitmap = mDrawingViewBepic!!.exportDrawing()
                exportImageBepic(bitmap)
        }

        findViewById<View>(R.id.export_without_bg).tapAndCheckInternet{
                if (ActivityCompat.checkSelfPermission(
                        this@DrawTestNewScreenActivity,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this@DrawTestNewScreenActivity,
                        arrayOf<String>(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        0
                    ) //ignoring the request code
                    return@tapAndCheckInternet
                }
                val bitmap = mDrawingViewBepic!!.exportDrawingWithoutBackground()
                exportImageBepic(bitmap)
        }

        setupUndoAndRedoBepic()
        setupBrushesBepic()
        setupColorViewsBepic()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_IMPORT_IMAGE_BEPIC) {
            if (RESULT_OK != resultCode) return
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, data!!.data)
                mDrawingViewBepic!!.setBackgroundImage(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun exportImageBepic(bitmap: Bitmap) {
        val folder: File =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        folder.mkdirs()
        val imageFile = File(folder, UUID.randomUUID().toString() + ".png")
        try {
            storeBitmapBepic(imageFile, bitmap)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        MediaScannerConnection.scanFile(
            this, arrayOf(), arrayOf("image/png"),
            null
        )
        sendBroadcast(Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(imageFile)))
    }

    private fun setBrushSelectedBepic(brushID: Int) {
        val settings = mDrawingViewBepic!!.brushSettings
        settings.selectedBrush = brushID
        val sizeInPercentage = (settings.selectedBrushSize * 100).toInt()
        mSizeSeekBarBepic!!.progress = sizeInPercentage
    }

    @Throws(Exception::class)
    private fun storeBitmapBepic(file: File, bitmap: Bitmap) {
        try {
            if (!file.exists() && !file.createNewFile()) throw Exception("Not able to create " + file.getPath())
            val stream: FileOutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            stream.flush()
            stream.close()
        } catch (e: Exception) {

        }
    }

    fun drawableToBitmapBepic(drawable: Drawable): Bitmap? {
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

    private fun setupUndoAndRedoBepic() {
        mUndoButtonBepic = findViewById<Button>(R.id.undo)
        mUndoButtonBepic!!.tapAndCheckInternet( {
            mDrawingViewBepic!!.undo()
            mUndoButtonBepic!!.setEnabled(!mDrawingViewBepic!!.isUndoStackEmpty)
            mRedoButtonBepic!!.isEnabled = !mDrawingViewBepic!!.isRedoStackEmpty
        })
        mRedoButtonBepic = findViewById<Button>(R.id.redo)
        mRedoButtonBepic!!.tapAndCheckInternet( {
            mDrawingViewBepic!!.redo()
            mUndoButtonBepic!!.setEnabled(!mDrawingViewBepic!!.isUndoStackEmpty)
            mRedoButtonBepic!!.setEnabled(!mDrawingViewBepic!!.isRedoStackEmpty)
        })
        mDrawingViewBepic!!.setOnDrawListener {
            mUndoButtonBepic!!.setEnabled(true)
            mRedoButtonBepic!!.setEnabled(false)
        }
    }

    private fun setupColorViewsBepic() {
        val colorsContainer = findViewById<ViewGroup>(R.id.brush_colors_container)
        for (colorView in colorsContainer.touchables) colorView.setOnClickListener { view ->
            val color = (view.background as ColorDrawable).color
            val brushSettings = mDrawingViewBepic!!.brushSettings
            brushSettings.color = color
        }
        val bgColorsContainer = findViewById<ViewGroup>(R.id.bg_colors_container)
        for (colorView in bgColorsContainer.touchables) colorView.tapAndCheckInternet { view ->
            val color = (view?.background as ColorDrawable).color
            mDrawingViewBepic!!.drawingBackground = color
        }
    }

    private fun setupBrushesBepic() {
        val pen = findViewById<RadioButton>(R.id.pen)
        pen.setOnCheckedChangeListener { compoundButton, b -> if (b) setBrushSelectedBepic(Brushes.PEN) }
        val pencil = findViewById<RadioButton>(R.id.pencil)
        pencil.setOnCheckedChangeListener { compoundButton, b -> if (b) setBrushSelectedBepic(Brushes.PENCIL) }
        val eraser = findViewById<RadioButton>(R.id.eraser)
        eraser.setOnCheckedChangeListener { compoundButton, b -> if (b) setBrushSelectedBepic(Brushes.ERASER) }
        val calligraphy = findViewById<RadioButton>(R.id.calligraphy)
        calligraphy.setOnCheckedChangeListener { compoundButton, b ->
            if (b) setBrushSelectedBepic(
                Brushes.CALLIGRAPHY
            )
        }
        val airBrush = findViewById<RadioButton>(R.id.air_brush)
        airBrush.setOnCheckedChangeListener { compoundButton, b -> if (b) setBrushSelectedBepic(Brushes.AIR_BRUSH) }
    }
}