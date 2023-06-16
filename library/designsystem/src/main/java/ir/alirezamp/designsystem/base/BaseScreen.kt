package ir.alirezamp.designsystem.base

import android.app.Activity
import android.view.KeyEvent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.alirezamp.designsystem.collectInLaunchedEffect
import ir.alirezamp.designsystem.useBase
import ir.alirezamp.designsystem.widget.ErrorView
import ir.alirezamp.designsystem.widget.LoadingView


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
    )

}

@Composable
fun BaseScreen(baseState: BaseContract.BaseState, content: @Composable () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        when (baseState) {
            BaseContract.BaseState.OnLoading -> LoadingView()
            is BaseContract.BaseState.OnError -> ErrorView(baseState.message)
            BaseContract.BaseState.OnSuccess -> content()
        }
    }
}
