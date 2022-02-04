import kotlin.system.exitProcess

class FloatNumberTest {
    fun test(){
        println("Running tests ...")

        try {
            assert (false);
            println("ERROR: You forgot to enable asserts!");
            exitProcess(1);
        } catch (e: AssertionError ) { /* everything is fine if error is thrown */ }

        // Numeral aus max. 4 Zeichen (inkl. '.')
        val n = FloatNumber(4);
        // Initialwert ist 0, woran auch ein undo nichts ändert
        assert (n.getFloat() == 0.0f && n.toString() == "0") { "Test 1" }
        n.undo()
        assert (n.getFloat() == 0.0f && n.toString() == "0") { "Test 2" }
        // Vorzeichen spielen bei Zahleneingabe keine Rolle
        assert (!n.put('-'))
        assert (!n.put('+'))
        assert (n.getFloat() == 0.0f && n.toString() == "0") { "Test 3" }
        // Eingabe führender Nullen bleibt ohne Effekt
        assert (n.put('0'))
        assert (n.getFloat() == 0.0f && n.toString() == "0") {"Test 4" }
        assert (n.put('0'))
        assert (n.getFloat() == 0.0f && n.toString() == "0") { "Test 5" }
        // Eingabe 0.34
        assert (n.put('.'))
        println("/" + n.toString() + "/")
        assert (n.getFloat() == 0.0f) {"Test 6" }
        assert (n.put('3'))
        assert (n.getFloat() == 0.3f ) { "Test 7" }
        assert (n.put('4'))
        assert (n.getFloat() == 0.34f ) { "Test 8" }
        // Mehr als vier Zeichen sind nicht erlaubt
        assert (!n.put('5'))
        // Eingabe in wissenschaftlicher Notation nicht möglich
        n.undo()
        n.undo()
        assert (n.getFloat() == 0.0f ) { "Test 9" }
        assert (!n.put('E'))
        assert (!n.put('e'))
        assert (n.getFloat() == 0.0f) { "Test 10" }
        // Sei besser als der Windows-Taschenrechner
        n.undo()
        assert (n.getFloat() == 0.0f){ "Test 11" }
        assert (n.put('0'))
        assert (n.getFloat() == 0.0f && n.toString() == "0") {"Test 12" }
        assert (n.put('7'))
        assert (n.getFloat() == 7.0f ) { "Test 13" }
        assert (n.put('1'))
        assert (n.getFloat() == 71.0f ) { "Test 14" }
    }
}

fun main(){
    var fl = FloatNumberTest()
    fl.test()
}