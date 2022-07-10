package redax

import react.Reducer

class State (
    val email: String,
    val password: String,
    val emailDirty: Boolean,
    val passwordDirty: Boolean,
    val emailError: String,
    val passwordError: String,
    val formValid: Boolean
 )


fun testState(): State =
    State(
        "",
        "",
        false,
        false,
        "",
        "",
        false
    )