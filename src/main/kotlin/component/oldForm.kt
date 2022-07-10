package component//import csstype.*
//import emotion.react.css
//import react.*
//import react.dom.html.InputType
//import react.dom.html.ReactHTML
//import react.dom.html.ReactHTML.div
//import react.dom.html.ReactHTML.h1
//import react.dom.html.ReactHTML.input
//
//
//fun isEmailValid(email: String): Boolean {
//    val EMAIL_REGEX = "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
//    return EMAIL_REGEX.toRegex().matches(email);
//}
//
//
//val Form = FC<Props>("meForm") { props ->
//
//    val (email,setEmail) = useState("")
//    val (password,setPassword) = useState("")
//
//    val (emailDirty, setEmailDirty) = useState(false)
//    val (passwordDirty, setPasswordDirty) = useState(false)
//
//    val (emailError, setEmailError) = useState("")
//    val (passwordError, setPasswordError) = useState("")
//
//    val (formValid, setFormValid) = useState(false)
//
//    useEffect {
//        if((email != "" && emailError == "") && (password != "" && passwordError == "")) {
//            setFormValid(false)
//        } else {
//            setFormValid(true)
//        }
//    }
//
//    div {
//        css {
//            padding = 50.px
//            backgroundColor = rgb(8, 97, 22)
//            color = rgb(56, 246, 137)
//            width = 400.px
//        }
//        h1 {
//            +"Регистрация"
//        }
//
//        // email
//        if(emailDirty && (emailError !="")) {
//            div {
//                css {
//                    color = rgb(255, 0, 0)
//                }
//                +emailError
//            }
//        }
//        input {
//            css {
//                display = Display.block
//                width = 300.px
//                marginBottom = 50.px
//            }
//            placeholder = "Введите email"
//            type = InputType.email
//            name = "email"
//
//            value = email
//
//            onBlur = {
//                setEmailDirty(true)
//            }
//
//            onChange = { event ->
//                setEmail(event.target.value)
//
//                if(!isEmailValid(event.target.value)) {
//                    setEmailError("Неправельно введён email")
//                } else {
//                    setEmailError("")
//                }
//
//                if(event.target.value == "") {
//                    setEmailError("Email не должен быть пустым")
//                }
//            }
//        }
//
//        // PASSWORD
//        if(passwordDirty && (passwordError !="")) {
//            div {
//                css {
//                    color = rgb(255, 0, 0)
//                }
//                +passwordError
//            }
//        }
//        input {
//            css {
//                display = Display.block
//                width = 300.px
//                marginBottom = 50.px
//            }
//            placeholder = "Введите пароль"
//            type = InputType.password
//            name = "password"
//
//            value = password
//
//            onBlur = {
//                setPasswordDirty(true)
//            }
//
//            onChange = { event ->
//                setPassword(event.target.value)
//
//                if(event.target.value.length < 6 || event.target.value.length > 10) {
//                    setPasswordError("Пароль должен быть от 6 до 10 символов")
//                } else {
//                    setPasswordError("")
//                }
//
//                if(event.target.value == "") {
//                    setPasswordError("Пароль не должен быть пустым")
//                }
//            }
//        }
//
//        // BUTTON
//        ReactHTML.button {
//            css {
//                display = Display.block
//                width = 150.px
//            }
//            +"Зарегистрироваться"
//
//            disabled = formValid
//        }
//    }
//}