package redax

import redux.RAction
import redux.Reducer

val markReducer: Reducer<State, RAction> =
    { state, action ->
        when (action) {
            is setEmail -> changeEmail(state, action)
            is setPassword -> changePassword(state, action)
            is setEmailDirty -> changeDirtyEmail(state, action)
            is setPasswordDirty -> changeDirtyPassword(state, action)
            is setEmailError -> changeErrorEmail(state, action)
            is setPasswordError -> changeErrorPassword(state, action)
            is setFormValid -> changeErrorPassword(state, action)
            else -> state
        }
}

fun changeEmail(state: State, action: setEmail): State {
    return State(
            action.str,
            state.password,
            state.emailDirty,
            state.passwordDirty,
            state.emailError,
            state.passwordError,
            state.formValid
        )
}

fun changePassword(state: State, action: setPassword): State {
    return State(
        state.email,
        action.str,
        state.emailDirty,
        state.passwordDirty,
        state.emailError,
        state.passwordError,
        state.formValid
    )
}

fun changeDirtyEmail(state: State, action: setEmailDirty): State {
    return State(
        state.email,
        state.password,
        action.bool,
        state.passwordDirty,
        state.emailError,
        state.passwordError,
        state.formValid
    )
}

fun changeDirtyPassword(state: State, action: setPasswordDirty): State {
    return State(
        state.email,
        state.password,
        state.emailDirty,
        action.bool,
        state.emailError,
        state.passwordError,
        state.formValid
    )
}

fun changeErrorEmail(state: State, action: setEmailError): State {
    return State(
        state.email,
        state.password,
        state.emailDirty,
        state.passwordDirty,
        action.str,
        state.passwordError,
        state.formValid
    )
}

fun changeErrorPassword(state: State, action: setPasswordError): State {
    return State(
        state.email,
        state.password,
        state.emailDirty,
        state.passwordDirty,
        state.emailError,
        action.str,
        state.formValid
    )
}


fun changeErrorPassword(state: State, action: setFormValid): State {
    return State(
        state.email,
        state.password,
        state.emailDirty,
        state.passwordDirty,
        state.emailError,
        state.passwordError,
        action.bool
    )
}