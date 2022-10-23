package org.wit.charitymark.helpers

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import org.wit.charitymark.R

fun showImagePicker(intentLauncher : ActivityResultLauncher<Intent>) {
    var chooseFile = Intent(Intent.ACTION_OPEN_DOCUMENT)
    chooseFile.type = "image/*"
    chooseFile = Intent.createChooser(chooseFile, R.string.select_charitymark_image.toString())
    intentLauncher.launch(chooseFile)
}