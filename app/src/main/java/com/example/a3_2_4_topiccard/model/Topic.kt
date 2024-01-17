package com.example.a3_2_4_topiccard.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic (@StringRes
                    val stringResourceId: Int,
                  val cantidadCursos: Int,
                  @DrawableRes
                  val imageResourceId: Int
)
