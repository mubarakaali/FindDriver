package com.northsoltech.framework.states

sealed class UiState{
    object Idle:UiState()
    object Loading:UiState()
    object Success: UiState()
    class Error(e:String):UiState()
}
