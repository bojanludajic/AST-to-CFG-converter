package com.bojanludajic

fun Node.stringify(indent: String = ""): String = when (this) {
    is Node.Assign ->
        "$indent  ASSIGN: ${variable.stringify()} = ${value.stringify()}\n" +
        next.stringify(indent)

    is Node.Return -> "$indent   RETURN: ${result.stringify()}"

    is Node.Condition -> "IF ${cond.stringify()}" +
            "\n$indent  THEN:\n ${nextIfTrue.stringify(indent + "    ")}" +
            "\n$indent  ELSE:\n ${nextIfFalse.stringify(indent + "    ")}"

    is Node.Quit -> ""
}

fun Expr.stringify(): String = when (this) {
    is Expr.Const -> value.toString()
    is Expr.Var -> name

    is Expr.Eq -> "${left.stringify()} == ${right.stringify()}"
    is Expr.NEq -> "${left.stringify()} != ${right.stringify()}"
    is Expr.Lt -> "${left.stringify()} < ${right.stringify()}"

    is Expr.Plus -> "${left.stringify()} + ${right.stringify()}"
    is Expr.Minus -> "${left.stringify()} - ${right.stringify()}"
    is Expr.Mul -> "${left.stringify()} * ${right.stringify()}"
}