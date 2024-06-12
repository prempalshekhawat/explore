package com.prempal.explore.ui.adpaters

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.google.android.flexbox.FlexboxLayout
import com.google.android.material.chip.Chip
import com.prempal.explore.R

@SuppressLint("UseCompatLoadingForDrawables")
@BindingAdapter("purpose")
fun setPurposes(view: FlexboxLayout, purpose: String?) {
    view.removeAllViews()
    val purposesList = purpose?.split(",")

    if (purposesList != null) {
        for (purposeText in purposesList) {
            val chip = LayoutInflater.from(view.context).inflate(R.layout.explore_personal_purposes_chip, view, false) as Chip
            chip.text = "$purposeText  |"

            when(purposeText){
                "Coffee" -> {
                    chip.chipIcon = view.context.getDrawable(R.drawable.icon_coffee)
                    chip.setTextColor(ContextCompat.getColorStateList(view.context, R.color.brown))
                }

                "Business" -> {
                    chip.chipIcon = view.context.getDrawable(R.drawable.icon_business)
                    chip.setTextColor(ContextCompat.getColorStateList(view.context, R.color.orange))
                }

                "Hobbies" -> {
                    chip.chipIcon = view.context.getDrawable(R.drawable.icon_hobbies)
                    chip.setTextColor(ContextCompat.getColorStateList(view.context, R.color.blue))
                }

                "Friendship" -> {
                    chip.chipIcon = view.context.getDrawable(R.drawable.icon_friendship)
                    chip.setTextColor(ContextCompat.getColorStateList(view.context, R.color.light_brown))
                }

                "Movies" -> {
                    chip.chipIcon = view.context.getDrawable(R.drawable.icon_coffee)
                    chip.setTextColor(ContextCompat.getColorStateList(view.context, R.color.brown))
                }

                "Dining" -> {
                    chip.chipIcon = view.context.getDrawable(R.drawable.icon_business)
                    chip.setTextColor(ContextCompat.getColorStateList(view.context, R.color.orange))
                }

                "Dating" -> {
                    chip.chipIcon = view.context.getDrawable(R.drawable.icon_dating)
                    chip.setTextColor(ContextCompat.getColorStateList(view.context, R.color.yellow))
                }

                "Matrimony" -> {
                    chip.chipIcon = view.context.getDrawable(R.drawable.icon_friendship)
                    chip.setTextColor(ContextCompat.getColorStateList(view.context, R.color.light_brown))
                }
            }

            view.addView(chip)
        }
    }
}