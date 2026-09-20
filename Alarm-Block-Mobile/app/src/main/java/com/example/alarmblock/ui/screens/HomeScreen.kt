package com.example.alarmblock.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alarmblock.ui.components.PrimaryButton
import com.example.alarmblock.ui.components.SectionLabel
import com.example.alarmblock.ui.theme.DividerGray
import com.example.alarmblock.ui.theme.Gold
import com.example.alarmblock.ui.theme.Gray
import com.example.alarmblock.ui.theme.Navy
import com.example.alarmblock.ui.theme.White

@Composable
fun HomeScreen(
    onCreateAlarm: () -> Unit,
    modifier: Modifier = Modifier,
) {
    // Standalone toggle for the one saved alarm shown on this mock home screen.
    var alarmEnabled by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = 24.dp, vertical = 24.dp),
    ) {
        Text(
            text = "Mis Alarmas",
            color = Navy,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(Gold)
                .padding(16.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Outlined.FavoriteBorder, contentDescription = null, tint = Navy)
                    Spacer(Modifier.width(8.dp))
                    Text("5 días", color = Navy, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
                Icon(Icons.Filled.ChevronRight, contentDescription = null, tint = Navy)
            }
            Spacer(Modifier.height(4.dp))
            Text(
                text = "SIN POSPONER - VER PROGRESO",
                color = Navy,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp,
            )
        }

        Spacer(Modifier.height(24.dp))

        SectionLabel("TUS ALARMAS")

        Spacer(Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .border(1.dp, DividerGray, RoundedCornerShape(12.dp))
                .background(White)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text("6:30 AM", color = Navy, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(2.dp))
                Text(
                    text = "Trabajo - Compañero - Hasta 3x posponer",
                    color = Gray,
                    fontSize = 12.sp,
                )
            }
            Switch(
                checked = alarmEnabled,
                onCheckedChange = { alarmEnabled = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = White,
                    checkedTrackColor = Gold,
                    checkedBorderColor = Gold,
                ),
            )
        }

        Spacer(Modifier.height(20.dp))

        PrimaryButton(
            text = "+ Nueva Alarma",
            onClick = onCreateAlarm,
            modifier = Modifier.fillMaxWidth().height(52.dp),
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Simular alarma",
            color = Gray,
            fontSize = 13.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
