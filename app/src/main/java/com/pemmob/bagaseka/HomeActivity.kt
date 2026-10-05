package com.pemmob.bagaseka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pemmob.bagaseka.ui.screen.BasicInfoScreen
import com.pemmob.bagaseka.ui.screen.DaftarProductScreen
import com.pemmob.bagaseka.ui.screen.HubungiKamiScreen
import com.pemmob.bagaseka.ui.theme.BagasekaTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BagasekaTheme(darkTheme = true) {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "daftar_produk") {
                    composable("daftar_produk") {
                        DaftarProductScreen(navController = navController)
                    }
                    composable("hubungi_kami") {
                        HubungiKamiScreen(navController = navController)
                    }
                    composable("basic_info") {
                        BasicInfoScreen(
                            onNavigateToContact = { navController.navigate("hubungi_kami") },
                            onNavigateToProducts = { navController.navigate("daftar_produk") }
                        )
                    }
                }
            }
        }
    }
}
