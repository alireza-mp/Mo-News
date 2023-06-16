package ir.alirezamp.designsystem.base

import ir.alirezamp.designsystem.BaseUniDirectionalViewModel

interface BaseContract :
    BaseUniDirectionalViewModel<BaseContract.BaseEvent, BaseContract.BaseEffect, BaseContract.BaseState> {


    sealed class BaseState {
        object OnLoading : BaseState()
        object OnSuccess : BaseState()
        data class OnError(val message: String) : BaseState()
    }

    sealed class BaseEffect {
        object OnBackPressed : BaseEffect()
    }

    sealed class BaseEvent {
        object OnBackPressed : BaseEvent()
        object OnRetryPressed : BaseEvent()
    }

}