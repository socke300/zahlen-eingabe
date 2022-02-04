interface FloatInput {
    fun put(c: Char): Boolean // input char by char, true if char is accepted
    fun getFloat(): Float // get float value of input for computations
    fun undo() // undo last input if there are chars left
    override fun toString(): String // get string representation of input
}
