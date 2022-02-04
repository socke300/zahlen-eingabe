class FloatNumber(number: Int) {

    var list: CharArray = CharArray(number)
    var counter: Int = 0
    var decimalPoint: Int = 0

    fun put(c: Char): Boolean {
        if (counter == 0)
            list[0] = '0'
        if (counter >= list.size)
            return false
        if (counter == 0 && c == '0')
            return true
        if (counter == 0 && c == '.') {
            list[1] = '.'
            counter = 2
            decimalPoint = 1
            return true
        }
        if (c == '.') {
            if (decimalPoint == 1)
                return false
            decimalPoint = 1
        }
        if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0' || c == '.') {
            list[counter] = c
            counter++
            return true
        }
        return false
    }

    fun getFloat(): Float {
        var string = ""
        for (element in list)
            string += element
        if (counter == 0) {
            string = "0."
        }
        return string.toFloat()
    }

    fun undo() {
        if (counter == 2 && list[0] == '0') {
            decimalPoint = 0
            list[counter - 1] = '\u0000'
            counter = 0
        }
        if (counter == 0)
            list[0] = '0'
        if (counter > 0) {
            if (list[counter - 1] == '.')
                decimalPoint = 0
            list[counter - 1] = '\u0000'
            counter--
        }
    }

    override fun toString(): String {
        if (counter == 0)
            return "0"
        var string = ""
        for (element in list) {
            string += element.toString()
        }
        return string
    }
}