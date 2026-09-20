package com.example.alarmblock.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alarmblock.ui.theme.Alert
import com.example.alarmblock.ui.theme.Gold
import com.example.alarmblock.ui.theme.Gray
import com.example.alarmblock.ui.theme.Navy
import com.example.alarmblock.ui.theme.White

private enum class StreakDayState {
    COMPLETED,
    SNOOZED,
    NO_DATA
}

@Composable
fun StreakDetailsScreen(
    onBack: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    val days = listOf(
        StreakDayState.COMPLETED,
        StreakDayState.COMPLETED,
        StreakDayState.NO_DATA,
        StreakDayState.COMPLETED,
        StreakDayState.NO_DATA,

        StreakDayState.SNOOZED,
        StreakDayState.COMPLETED,
        StreakDayState.COMPLETED,
        StreakDayState.COMPLETED,
        StreakDayState.SNOOZED
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(White)
    ) {

        Row(
            modifier = Modifier
                .padding(
                    start = 18.dp,
                    top = 20.dp
                )
                .height(30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.ChevronLeft,
                contentDescription = "Volver",
                tint = Navy,
                modifier = Modifier.size(30.dp)
            )

            Spacer(Modifier.width(7.dp))

            Text(
                text = "Tu Racha",
                color = Navy,
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 28.sp
            )
        }

        // Contenido
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 131.dp,
                    start = 28.dp,
                    end = 28.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // 5 días
            Text(
                text = "5 días",
                color = Navy,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 44.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.height(44.dp)
            )

            // Sin posponer
            Text(
                text = "Sin posponer la alarma",
                color = Gray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.height(20.dp)
            )

            Spacer(Modifier.height(32.dp))

            // Últimos 14 días
            Text(
                text = "Últimos 14 días",
                color = Gray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
            )

            Spacer(Modifier.height(21.dp))

            // Rachas
            Column(
                modifier = Modifier
                    .width(338.dp)
                    .height(101.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                StreakRow(
                    states = days.take(5)
                )

                StreakRow(
                    states = days.drop(5)
                )
            }

            Spacer(Modifier.height(21.dp))

            // Leyenda
            StreakLegend(
                modifier = Modifier
                    .width(197.dp)
                    .align(Alignment.Start)
            )

            Spacer(Modifier.height(36.dp))

            // Card Inferior
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(122.dp)
                    .border(
                        width = 1.dp,
                        color = Gray,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(
                        horizontal = 24.dp,
                        vertical = 24.dp
                    )
            ) {
                Text(
                    text = "¡Vas muy bien !",
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 30.sp
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "Sigue así para superar tu racha",
                    color = Gray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 20.sp
                )
            }
        }
    }
}

@Composable
private fun StreakRow(
    states: List<StreakDayState>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        states.forEach { state ->
            StreakDay(
                state = state
            )
        }
    }
}

@Composable
private fun StreakDay(
    state: StreakDayState
) {
    val shape = RoundedCornerShape(8.dp)

    when (state) {

        StreakDayState.COMPLETED -> {
            Box(
                modifier = Modifier
                    .size(
                        width = 50.dp,
                        height = 40.dp
                    )
                    .background(
                        color = Gold,
                        shape = shape
                    )
            )
        }

        StreakDayState.NO_DATA -> {
            Box(
                modifier = Modifier
                    .size(
                        width = 50.dp,
                        height = 40.dp
                    )
                    .background(
                        color = White,
                        shape = shape
                    )
                    .border(
                        width = 1.dp,
                        color = Gray,
                        shape = shape
                    )
            )
        }

        StreakDayState.SNOOZED -> {
            Box(
                modifier = Modifier
                    .size(
                        width = 50.dp,
                        height = 40.dp
                    )
                    .background(
                        color = White,
                        shape = shape
                    )
                    .border(
                        width = 1.dp,
                        color = Alert,
                        shape = shape
                    )
            )
        }
    }
}

@Composable
private fun StreakLegend(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            LegendItem(
                state = StreakDayState.COMPLETED,
                text = "Sin posponer"
            )

            Spacer(Modifier.weight(1f))

            LegendItem(
                state = StreakDayState.NO_DATA,
                text = "Sin datos"
            )
        }

        Spacer(Modifier.height(2.dp))

        LegendItem(
            state = StreakDayState.SNOOZED,
            text = "Pospuesta"
        )
    }
}

@Composable
private fun LegendItem(
    state: StreakDayState,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        LegendIndicator(
            state = state
        )

        Spacer(Modifier.width(6.dp))

        Text(
            text = text,
            color = Gray,
            fontSize = 11.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 16.sp
        )
    }
}

@Composable
private fun LegendIndicator(
    state: StreakDayState
) {
    val shape = RoundedCornerShape(2.dp)

    when (state) {

        StreakDayState.COMPLETED -> {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(
                        color = Gold,
                        shape = shape
                    )
            )
        }

        StreakDayState.NO_DATA -> {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .border(
                        width = 1.dp,
                        color = Gray,
                        shape = shape
                    )
            )
        }

        StreakDayState.SNOOZED -> {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .border(
                        width = 1.dp,
                        color = Alert,
                        shape = shape
                    )
            )
        }
    }
}