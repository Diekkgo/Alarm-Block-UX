package com.example.alarmblock.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * Holds the in-progress values for the "new alarm" wizard (Setup -> Limits ->
 * Confirmation). It is hoisted once in MainActivity and passed down to each
 * screen, so the values chosen in one step are still there in the next one.
 */
class AlarmDraftState {

    var hour24 by mutableIntStateOf(6)
        private set
    var minute by mutableIntStateOf(30)
        private set

    var name by mutableStateOf("")
    var sound by mutableStateOf(DEFAULT_SOUND)

    var snoozeLimit by mutableIntStateOf(3)
        private set

    val formattedTime: String
        get() {
            val period = if (hour24 < 12) "AM" else "PM"
            val displayHour = when (val h = hour24 % 12) {
                0 -> 12
                else -> h
            }
            return "%d:%02d %s".format(displayHour, minute, period)
        }

    fun incrementTime() {
        if (minute == 0) {
            minute = 30
        } else {
            minute = 0
            hour24 = (hour24 + 1) % 24
        }
    }

    fun decrementTime() {
        if (minute == 30) {
            minute = 0
        } else {
            minute = 30
            hour24 = (hour24 + 23) % 24
        }
    }

    fun incrementSnoozeLimit() {
        if (snoozeLimit < MAX_SNOOZE_LIMIT) snoozeLimit++
    }

    fun decrementSnoozeLimit() {
        if (snoozeLimit > 0) snoozeLimit--
    }

    /** Resets the draft back to its defaults, called each time "+ Nueva Alarma" is tapped. */
    fun reset() {
        hour24 = 6
        minute = 30
        name = ""
        sound = DEFAULT_SOUND
        snoozeLimit = 3
    }

    private companion object {
        const val DEFAULT_SOUND = "Predeterminado"
        const val MAX_SNOOZE_LIMIT = 10
    }
}
