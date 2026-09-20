package com.example.alarmblock.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alarmblock.data.AlarmDraftState
import com.example.alarmblock.ui.components.CounterStepper
import com.example.alarmblock.ui.components.PrimaryButton
import com.example.alarmblock.ui.components.ScreenHeader
import com.example.alarmblock.ui.theme.Gray
import com.example.alarmblock.ui.theme.InfoBackground
import com.example.alarmblock.ui.theme.White

@Composable
fun NewAlarmLimitsScreen(
    draft: AlarmDraftState,
    onBack: () -> Unit,
    onSave: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = 24.dp, vertical = 24.dp),
    ) {
        ScreenHeader(title = "Límite de posponer", onBack = onBack)

        Spacer(Modifier.height(20.dp))

        Text(
            text = "¿Cuántas veces como máximo quieres poder posponer esta alarma?",
            color = Gray,
            fontSize = 14.sp,
        )

        Spacer(Modifier.height(24.dp))

        // Centered horizontally, unlike the Setup screen's left-aligned hour stepper.
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            CounterStepper(
                label = draft.snoozeLimit.toString(),
                onDecrement = draft::decrementSnoozeLimit,
                onIncrement = draft::incrementSnoozeLimit,
            )
        }

        Spacer(Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(InfoBackground)
                .padding(16.dp),
        ) {
            Text(
                text = "Al llegar al límite, deberás completar la misión para apagar la " +
                    "alarma - ya no podrás posponerla de nuevo.",
                color = Gray,
                fontSize = 13.sp,
            )
        }

        Spacer(Modifier.height(32.dp))

        PrimaryButton(
            text = "Guardar alarma",
            onClick = onSave,
            modifier = Modifier.fillMaxWidth().height(52.dp),
        )
    }
}
