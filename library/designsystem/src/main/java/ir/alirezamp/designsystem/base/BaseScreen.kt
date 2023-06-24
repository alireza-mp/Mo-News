package ir.alirezamp.designsystem.base

import android.app.Activity
import android.view.KeyEvent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.alirezamp.components.widget.ErrorView
import ir.alirezamp.components.widget.InitializeView
import ir.alirezamp.components.widget.LoadingView
import ir.alirezamp.designsystem.util.collectInLaunchedEffect
import ir.alirezamp.designsystem.util.useBase


@Composable
fun BaseRoute(
    baseViewModel: BaseViewModel,
    content: @Composable () -> Unit,
) {

    val (baseState, baseEffect, baseEvent) = useBase(viewModel = baseViewModel)

    val activity = content as? Activity

    baseEffect.collectInLaunchedEffect { effect ->
        when (effect) {
            BaseContract.BaseEffect.OnBackPressed -> {
                activity?.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK))
            }
        }
    }

    BaseScreen(
        baseState = baseState,
        content = content,
        onRetry = {
            baseEvent(BaseContract.BaseEvent.OnRetryPressed)
        }
    )

}

@Composable
fun BaseScreen(
    baseState: BaseContract.BaseState,
    content: @Composable () -> Unit,
    onRetry: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        when (baseState) {
            BaseContract.BaseState.OnLoading -> LoadingView()
            BaseContract.BaseState.OnSuccess -> content()
            BaseContract.BaseState.OnInitialize -> InitializeView(content)
            is BaseContract.BaseState.OnError -> ErrorView(
                baseState.message,
                onRetry = onRetry
            )
        }
    }
}
