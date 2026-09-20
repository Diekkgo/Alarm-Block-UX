package com.example.alarmblock.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.alarmblock.data.AlarmDraftState
import com.example.alarmblock.ui.components.CounterStepper
import com.example.alarmblock.ui.components.PrimaryButton
import com.example.alarmblock.ui.components.ScreenHeader
import com.example.alarmblock.ui.components.SectionLabel
import com.example.alarmblock.ui.theme.White

private val soundOptions = listOf("Predeterminado", "Campana", "Sirena", "Melodía suave")

@Composable
fun NewAlarmSetupScreen(
    draft: AlarmDraftState,
    onBack: () -> Unit,
    onNext: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = 24.dp, vertical = 24.dp),
    ) {
        ScreenHeader(title = "Nueva Alarma", onBack = onBack)

        Spacer(Modifier.height(24.dp))

        SectionLabel("HORA")
        Spacer(Modifier.height(8.dp))
        CounterStepper(
            label = draft.formattedTime,
            onDecrement = draft::decrementTime,
            onIncrement = draft::incrementTime,
        )

        Spacer(Modifier.height(28.dp))

        SectionLabel("Nombre de la alarma", uppercase = false)
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = draft.name,
            onValueChange = { draft.name = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
        )

        Spacer(Modifier.height(20.dp))

        SectionLabel("Sonido", uppercase = false)
        Spacer(Modifier.height(8.dp))
        SoundDropdown(
            selected = draft.sound,
            onSelected = { draft.sound = it },
        )

        Spacer(Modifier.height(32.dp))

        PrimaryButton(
            text = "Siguiente →",
            onClick = onNext,
            modifier = Modifier.fillMaxWidth().height(52.dp),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SoundDropdown(
    selected: String,
    onSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
        modifier = modifier,
    ) {
        OutlinedTextField(
            value = selected,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
                .fillMaxWidth(),
        )
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            soundOptions.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onSelected(option)
                        expanded = false
                    },
                )
            }
        }
    }
}
