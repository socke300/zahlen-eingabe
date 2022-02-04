import io.javalin.Javalin
import io.javalin.core.JavalinConfig
import java.math.RoundingMode
import java.text.DecimalFormat

class App {
    init {
        var app: Javalin = Javalin.create() { t: JavalinConfig -> t.addStaticFiles("/index.html") }.start(7070)
        var fl = FloatNumber(25)

        app.get("/sendValue") { ctx ->
            var a = ctx.queryParam("id")
            if (a != null) {
                fl.put(a.toCharArray()[0])
            }
            ctx.result(fl.toString())
        }
        app.get("/sendValueUndo") { ctx ->
            fl.undo()
            ctx.result(fl.toString())
        }
        app.get("/sendValueClear") { ctx ->
            fl = FloatNumber(25)
            ctx.result(fl.toString())
        }
    }
}

fun main() {
    App()
}