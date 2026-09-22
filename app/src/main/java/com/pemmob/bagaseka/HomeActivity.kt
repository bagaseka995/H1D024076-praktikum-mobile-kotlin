package com.pemmob.bagaseka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pemmob.bagaseka.ui.screen.DaftarProductScreen
import com.pemmob.bagaseka.ui.theme.BagasekaTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BagasekaTheme {
                DaftarProductScreen()
            }
        }
    }
}
