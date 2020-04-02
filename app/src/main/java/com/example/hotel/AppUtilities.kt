package com.example.hotel

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.ContextCompat.getSystemService

object AppUtilities {

    fun hideSoftKeyBoard(input: EditText, context: Context) {

        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(input.windowToken,0)
    }
}