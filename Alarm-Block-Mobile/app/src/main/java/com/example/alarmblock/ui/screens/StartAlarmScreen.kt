package com.example.alarmblock.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alarmblock.ui.theme.Gold
import com.example.alarmblock.ui.theme.Gray
import com.example.alarmblock.ui.theme.Navy
import com.example.alarmblock.ui.theme.White

@Composable
fun StartAlarmScreen(
    onTurnOff: () -> Unit = {},
    onSnooze: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(
                    top = 256.dp,
                    start = 24.dp,
                    end = 24.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Icono circular de alarma
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(
                        color = Navy,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "Alarma",
                    modifier = Modifier.size(36.dp),
                    tint = White
                )
            }

            Spacer(
                modifier = Modifier.height(11.dp)
            )

            // Hora
            Text(
                text = "6:30 AM",
                color = Navy,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 44.sp
            )

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            // Nombre de alarma
            Text(
                text = "Trabajo",
                color = Gray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp
            )

            Spacer(
                modifier = Modifier.height(11.dp)
            )

            // Apagar
            Button(
                onClick = onTurnOff,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Gold,
                    contentColor = Color.Black
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Apagar",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(17.dp)
            )

            // Posponer
            Button(
                onClick = onSnooze,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Navy,
                    contentColor = White
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Posponer",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}