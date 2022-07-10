package component

import csstype.*
import emotion.react.css
import react.*
import react.dom.html.InputType
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.input
import redax.*


fun isEmailValid(email: String): Boolean {
    val EMAIL_REGEX = "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    return EMAIL_REGEX.toRegex().matches(email);
}


val Form = FC<Props>("meForm") { props ->

    val (state, dispatch) = useReducer(markReducer, testState())

    useEffect {
        if ((state.email != "" && state.emailError == "") && (state.password != "" && state.passwordError == "")) {
            dispatch(setFormValid(false))
        } else {
            dispatch(setFormValid(true))
        }
    }

    div {
        css {
            padding = 50.px
            backgroundColor = rgb(8, 97, 22)
            color = rgb(56, 246, 137)
            width = 400.px
        }
        h1 {
            +"Регистрация"
        }

        // email
        if (state.emailDirty && (state.emailError != "")) {
            div {
                css {
                    color = rgb(255, 0, 0)
                }
                +state.emailError
            }
        }
        input {
            css {
                display = Display.block
                width = 300.px
                marginBottom = 50.px
            }
            placeholder = "Введите email"
            type = InputType.email
            name = "email"

            value = state.email

            onBlur = {
                dispatch(setEmailDirty(true))
            }

            onChange = { event ->
                dispatch(setEmail(event.target.value))

                if (!isEmailValid(event.target.value)) {
                    dispatch(setEmailError("Неправельно введён email"))
                } else {
                    dispatch(setEmailError(""))
                }

                if (event.target.value == "") {
                    dispatch(setEmailError("Email не должен быть пустым"))
                }
            }
        }

        // PASSWORD
        if (state.passwordDirty && (state.passwordError != "")) {
            div {
                css {
                    color = rgb(255, 0, 0)
                }
                +state.passwordError
            }
        }
        input {
            css {
                display = Display.block
                width = 300.px
                marginBottom = 50.px
            }
            placeholder = "Введите пароль"
            type = InputType.password
            name = "password"

            value = state.password

            onBlur = {
                dispatch(setPasswordDirty(true))
            }

            onChange = { event ->
                dispatch(setPassword(event.target.value))

                if (event.target.value.length < 6 || event.target.value.length > 10) {
                    dispatch(setPasswordError("Пароль должен быть от 6 до 10 символов"))
                } else {
                    dispatch(setPasswordError(""))
                }

                if (event.target.value == "") {
                    dispatch(setPasswordError("Пароль не должен быть пустым"))
                }
            }
        }

        // BUTTON
        ReactHTML.button {
            css {
                display = Display.block
                width = 150.px
            }
            +"Зарегистрироваться"

            disabled = state.formValid
        }
    }
}