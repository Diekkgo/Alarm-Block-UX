package com.example.alarmblock.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alarmblock.ui.theme.Gold
import com.example.alarmblock.ui.theme.Gray
import com.example.alarmblock.ui.theme.Navy

/**
 * Top-of-screen "‹ Screen title" row used by every step of the new-alarm
 * flow, matching the mobile mockups (the back arrow and the screen's own
 * title share a single navy line, unlike the web app's separate breadcrumb).
 */
@Composable
fun ScreenHeader(
    title: String,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clickable(onClick = onBack)
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Volver",
            tint = Navy,
        )
        Text(
            text = title,
            color = Navy,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 8.dp),
        )
    }
}

/** Small gray caption used above form fields (e.g. "HORA", "Nombre de la alarma"). */
@Composable
fun SectionLabel(
    text: String,
    modifier: Modifier = Modifier,
    uppercase: Boolean = true,
) {
    Text(
        text = if (uppercase) text.uppercase() else text,
        color = Gray,
        fontSize = 12.sp,
        letterSpacing = 0.5.sp,
        modifier = modifier,
    )
}

/** The "(+)  value  (-)" row reused for the hour and the snooze-limit pickers. */
@Composable
fun CounterStepper(
    label: String,
    onDecrement: () -> Unit,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        StepperButton(symbol = "+", contentDescription = "Aumentar", onClick = onIncrement)
        Text(
            text = label,
            color = Navy,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
        )
        StepperButton(symbol = "-", contentDescription = "Disminuir", onClick = onDecrement)
    }
}

@Composable
private fun StepperButton(
    symbol: String,
    contentDescription: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .size(44.dp)
            .clip(CircleShape)
            .border(1.dp, Navy, CircleShape)
            .clickable(onClickLabel = contentDescription, onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = symbol,
            color = Navy,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}

/** Full-width primary (gold) button shared by every screen's main action. */
@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Gold, contentColor = Navy),
    ) {
        Text(text = text, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Navy)
    }
}
