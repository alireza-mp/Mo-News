package ir.alirezamp.designsystem.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest

data class StateEffectDispatch<EVENT, EFFECT, STATE>(
    val state: STATE,
    val effectFlow: Flow<EFFECT>,
    val dispatch: (EVENT) -> Unit,
)

data class StateDispatch<EVENT, STATE>(
    val state: STATE,
    val dispatch: (EVENT) -> Unit,
)

interface UniDirectionalViewModel<EVENT, STATE> {
    val state: StateFlow<STATE>
    fun event(event: EVENT)
}


interface BaseUniDirectionalViewModel<BASE_EVENT, BASE_EFFECT, BASE_STATE> {
    val baseState: StateFlow<BASE_STATE>
    val baseEffect: Flow<BASE_EFFECT>
    fun baseEvent(event: BASE_EVENT)
}


@Composable
inline fun <reified EVENT, STATE> use(
    viewModel: UniDirectionalViewModel<EVENT, STATE>,
): StateDispatch<EVENT, STATE> {

    val state by viewModel.state.collectAsState()

    val dispatch: (EVENT) -> Unit = { event ->
        viewModel.event(event)
    }

    return StateDispatch(
        state = state,
        dispatch = dispatch,
    )
}


@Composable
inline fun <reified BASE_EVENT, BASE_EFFECT, BASE_STATE> useBase(
    viewModel: BaseUniDirectionalViewModel<BASE_EVENT, BASE_EFFECT, BASE_STATE>,
): StateEffectDispatch<BASE_EVENT, BASE_EFFECT, BASE_STATE> {

    val state by viewModel.baseState.collectAsState()

    val dispatch: (BASE_EVENT) -> Unit = { event ->
        viewModel.baseEvent(event)
    }

    return StateEffectDispatch(
        state = state,
        effectFlow = viewModel.baseEffect,
        dispatch = dispatch,
    )
}

@Suppress("ComposableNaming")
@Composable
fun <T> Flow<T>.collectInLaunchedEffect(function: suspend (value: T) -> Unit) {
    val flow = this
    LaunchedEffect(key1 = flow) {
        flow.collectLatest(function)
    }
}






