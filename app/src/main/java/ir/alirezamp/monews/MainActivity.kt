package ir.alirezamp.monews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ir.alirezamp.components.BottomNavigation
import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.designsystem.theme.MoNewsTheme
import ir.alirezamp.monews.navigation.ComposeNewsNavHost


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var baseViewModel: BaseViewModel by remember {
                mutableStateOf(BaseViewModel())
            }
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            /*val bottomNavVisible = */

            MoNewsTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentColor = MaterialTheme.colorScheme.background,
                    /*   topBar = {
                           TopAppBar(
                               bottomNavController = bottomNavController,
                           )
                       },*/
                    bottomBar = {
                        AnimatedVisibility(
                            visible = true,
                            enter = slideInVertically { it },
                            exit = slideOutVertically { it },
                        ) {

                        }
                        BottomNavigation(
                            currentRoute = currentRoute ?: "",
                            onItemClick = { newRoute ->
                                navController.navigate(newRoute) {
                                    popUpTo(currentRoute ?: "") {
                                        saveState = true
                                        inclusive = true

                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                ) {
                    Surface(
                        modifier = Modifier.padding(it),
                        color = MaterialTheme.colorScheme.background,
                    ) {
                        ComposeNewsNavHost(
                            navController = navController,
                            modifier = Modifier,
                            onProvideBaseViewModel = { viewModel ->
                                baseViewModel = viewModel
                            }
                        )
                    }
                }
            }
        }
    }
}