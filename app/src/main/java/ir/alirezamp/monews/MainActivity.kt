package ir.alirezamp.monews

import android.app.Activity
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ir.alirezamp.designsystem.base.BaseRoute
import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.designsystem.theme.MoNewsTheme
import ir.alirezamp.monews.navigation.MoNewsNavHost
import ir.alirezamp.navigation.BottomNavigation
import java.util.Locale


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAppLanguage(this)
        setContent {
            var baseViewModel: BaseViewModel by remember {
                mutableStateOf(BaseViewModel())
            }
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            /*val bottomNavVisible = */
            val appbarVisible = false

            MoNewsTheme {
                SetStatusBarColor()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentColor = MaterialTheme.colorScheme.surface,
                    bottomBar = {
                        AnimatedVisibility(
                            visible = true,
                            enter = slideInVertically { it },
                            exit = slideOutVertically { it },
                        ) {
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
                    }
                ) {
                    BaseRoute(baseViewModel = baseViewModel) {
                        Surface(
                            modifier = Modifier.padding(it),
                            color = MaterialTheme.colorScheme.background,
                        ) {
                            MoNewsNavHost(
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
}

@Composable
private fun SetStatusBarColor() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val systemBarColor = MaterialTheme.colorScheme.surfaceVariant
    val statusBarColor = MaterialTheme.colorScheme.surface

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = statusBarColor.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = useDarkIcons
        }
    }

    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(
            color = systemBarColor,
            darkIcons = useDarkIcons
        )
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = useDarkIcons
        )
        onDispose {}
    }
}

private fun setAppLanguage(activity: Activity, language: String = "fa") {
    val locale = Locale(language)
    Locale.setDefault(locale)
    val config: Configuration = activity.resources.configuration
    config.setLocale(locale)
    activity.resources.updateConfiguration(config, activity.resources.displayMetrics)
}