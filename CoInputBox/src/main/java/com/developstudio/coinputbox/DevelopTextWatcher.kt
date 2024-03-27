package com.developstudio.coinputbox

import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputEditText


class DevelopTextWatcher(private val editText: TextInputEditText, private val maxLength: Int, private val separatorIndices: List<Int>,private val separatorSign : Char) :
    TextWatcher {
    private var isDeleting = false

    init {
        editText.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        isDeleting = count > after
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (!isDeleting) {
            if (s == null) return

            val currentLength = s.length
            if (currentLength < maxLength) {
                separatorIndices.forEach { index ->
                    if (currentLength == index) {
                        editText.text?.insert(index, separatorSign.toString())
                    }
                }
            }
        } else {
            if (s.isNullOrEmpty()) return

            val lastChar = s[s.length - 1]
            val lastDashIndex = s.lastIndexOf(separatorSign)

            if (lastChar != separatorSign && lastDashIndex != -1 && lastDashIndex !in separatorIndices) {
                editText.text?.insert(lastDashIndex + 1, separatorSign.toString())
            }
        }

        val upperCaseText = s.toString().toUpperCase()
        if (s.toString() != upperCaseText) {
            editText.setText(upperCaseText)
            editText.setSelection(editText.length())
        }

    }

    override fun afterTextChanged(s: Editable?) {}

}