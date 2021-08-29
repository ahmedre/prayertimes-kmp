package app.salah.android.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.*
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview

@ExperimentalComposeUiApi
@Composable
fun SearchBar(onLocationChanged: (String) -> Unit) {
    val textState = remember { mutableStateOf("") }
    TextField(
        value = textState.value,
        label = {
            Text("Enter a Location")
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions { onLocationChanged(textState.value) },
        onValueChange = { textState.value = it },
        modifier = Modifier
            .onPreviewKeyEvent { keyEvent ->
                if (keyEvent.key.keyCode == Key.Enter.keyCode) {
                    if (keyEvent.type == KeyEventType.KeyUp) {
                        onLocationChanged(textState.value)
                    }
                    true
                } else {
                    false
                }
            }
            .fillMaxWidth()
    )
}

@ExperimentalComposeUiApi
@Preview
@Composable
fun SearchBarPreview() {
    SearchBar {}
}