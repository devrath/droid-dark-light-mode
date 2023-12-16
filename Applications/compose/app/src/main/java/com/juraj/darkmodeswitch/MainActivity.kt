package com.juraj.darkmodeswitch

import MaterialAppTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juraj.darkmodeswitch.composables.Switch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialAppTheme {
                var isDarkMode by remember { mutableStateOf(false) }
                CurrentScreen(isDarkMode){
                    isDarkMode = it
                }
            }
        }
    }

    @Composable
    private fun CurrentScreen(
        isDarkMode: Boolean,onModeChange:(Boolean)-> Unit) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.background(
                    color = if(isDarkMode){ Color.Black} else { Color.White }
                )
            ) {
                Card(
                    modifier = Modifier.size(300.dp),
                    shape = CircleShape,
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )
                ) {
                    Image(
                        if (isDarkMode) {
                            painterResource(R.drawable.dark_mode_image)
                        } else {
                            painterResource(R.drawable.light_mode_image)
                        },
                        contentDescription = if(isDarkMode){ "Dark Mode" }else{ "Light Mode"},
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.height(50.dp))

                Text(
                    text = if (isDarkMode) { "Dark mode text" } else { "Light mode text" },
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontFamily = FontFamily.Monospace,
                    color = if(isDarkMode){ Color.White} else { Color.Black }
                )

                Spacer(modifier = Modifier.height(50.dp))

                Switch(checked = isDarkMode, modifier = Modifier){
                    onModeChange.invoke(it)
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun DarkModeSwitchPreview() {
        MaterialAppTheme {
            CurrentScreen(isDarkMode = true){}
        }
    }
}

