package com.pemmob.bagaseka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pemmob.bagaseka.ui.screen.BasicInfoScreen
import com.pemmob.bagaseka.ui.screen.DaftarProductScreen
import com.pemmob.bagaseka.ui.screen.DetailProductScreen
import com.pemmob.bagaseka.ui.screen.HubungiKamiScreen
import com.pemmob.bagaseka.ui.theme.BagasekaTheme
import com.pemmob.bagaseka.ui.viewmodel.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BagasekaTheme(darkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val productViewModel: ProductViewModel = viewModel()
                    NavHost(navController = navController, startDestination = "basic_info") {
                        composable(route = "basic_info") {
                            BasicInfoScreen(
                                onNavigateToContact = { navController.navigate(route = "form_screen") },
                                onNavigateToProducts = { navController.navigate(route = "daftar_produk") }
                            )
                        }
                        composable(route = "form_screen") {
                            HubungiKamiScreen(navController = navController)
                        }
                        composable(route = "daftar_produk") {
                            DaftarProductScreen(
                                navController = navController,
                                viewModel = productViewModel
                            )
                        }
                        composable(
                            route = "detail/{productId}",
                            arguments = listOf(navArgument("productId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val productId = backStackEntry.arguments?.getInt("productId") ?: 0
                            DetailProductScreen(
                                productId = productId,
                                navController = navController,
                                viewModel = productViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}
