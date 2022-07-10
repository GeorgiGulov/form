import kotlinx.browser.document
import react.create
import react.dom.client.createRoot
import component.Form

fun main() {
    val container = document.createElement("div")
    document.body!!.appendChild(container)

    val form = Form.create()
    createRoot(container).render(form)
}