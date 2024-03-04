package pl.dnajdrowski.core_ui.components.states

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay

@Composable
fun rememberTypewriterState(
    textToDisplay: String
): TypewriterState {
    return remember {
        TypewriterState(
            textToDisplay = textToDisplay
        )
    }
}

class TypewriterState(
    private val textToDisplay: String = ""
) {
    private var currentTextIndex =  mutableIntStateOf(0)
    var currentText = mutableStateOf("")
    suspend fun animate() {
        while (currentTextIndex.intValue <= textToDisplay.length) {
            currentText.value = textToDisplay
                .substring(
                    startIndex = 0,
                    endIndex = currentTextIndex.intValue
                )
            delay(TYPING_DELAY)
            currentTextIndex.intValue = currentTextIndex.intValue + 1
        }
    }

    companion object {
        const val TYPING_DELAY = 100L
    }
}