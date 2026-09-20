package com.example.alarmblock.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alarmblock.ui.theme.Gold
import com.example.alarmblock.ui.theme.Gray
import com.example.alarmblock.ui.theme.Navy
import com.example.alarmblock.ui.theme.White

@Composable
fun MandatoryMissionScreen(
    onVerify: (String) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    var answer by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(White)
    ) {

        // Título superior
        Text(
            text = "Misión obligatoria",
            color = Navy,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(
                    start = 39.dp,
                    top = 24.dp
                )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 283.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Texto principal
            Text(
                text = "Resuelve la operación para continuar",
                color = Navy,
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 28.sp,
                textAlign = TextAlign.Center,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(28.dp)
            )

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            // Operación matemática
            Text(
                text = "7  +  5  =  ?",
                color = Navy,
                fontSize = 36.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 44.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(194.dp)
                    .height(46.dp)
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // Campo de respuesta
            OutlinedTextField(
                value = answer,
                onValueChange = { value ->
                    if (value.all { it.isDigit() }) {
                        answer = value
                    }
                },
                modifier = Modifier
                    .width(100.dp)
                    .height(52.dp),
                singleLine = true,
                textStyle = TextStyle(
                    color = Navy,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Navy,
                    unfocusedBorderColor = Color(0xFFD0D0D0),
                    cursorColor = Navy,
                    focusedContainerColor = White,
                    unfocusedContainerColor = White
                )
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // Texto auxiliar
            Text(
                text = "Digita tu respuesta",
                color = Gray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(129.dp)
                    .height(20.dp)
            )

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            // Botón Verificar
            Button(
                onClick = {
                    onVerify(answer)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(36.dp),
                shape = RoundedCornerShape(4.dp),
                contentPadding = ButtonDefaults.ContentPadding,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Gold,
                    contentColor = Navy
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Verificar",
                    color = Navy,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}