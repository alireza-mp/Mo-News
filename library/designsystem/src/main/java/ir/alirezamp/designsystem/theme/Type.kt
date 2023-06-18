package ir.alirezamp.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ir.alirezamp.designsystem.R

// Fonts
private val SHABNAM_BOLD = FontFamily(Font(R.font.shabnam_bold, FontWeight.Normal))
private val SHABNAM_MEDIUM = FontFamily(Font(R.font.shabnam_medium, FontWeight.Normal))
private val SHABNAM_LIGHT = FontFamily(Font(R.font.shabnam, FontWeight.Normal))

// Set of Material typography styles to start with
val Typography = Typography(
    /*   displayLarge =,
       displayMedium =,
       displaySmall =,*/
    headlineLarge = TextStyle(
        fontFamily = SHABNAM_BOLD,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = SHABNAM_BOLD,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    /* headlineSmall = ,*/
    titleLarge = TextStyle(
        fontFamily = SHABNAM_BOLD,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = SHABNAM_BOLD,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = SHABNAM_BOLD,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = SHABNAM_LIGHT,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = SHABNAM_MEDIUM,
        fontWeight = FontWeight.Normal,
        fontSize = 8.sp,
    ),
    /*bodySmall =,*/
    labelLarge = TextStyle(
        fontFamily = SHABNAM_BOLD,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = SHABNAM_BOLD,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = SHABNAM_MEDIUM,
        fontWeight = FontWeight.Normal,
        fontSize = 8.sp,
    ),
)


/*
val androidx.compose.material.Typography.publisherChips: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = SHABNAM_MEDIUM,
        fontWeight = FontWeight.Normal,
        fontSize = 8.sp,
    )*/