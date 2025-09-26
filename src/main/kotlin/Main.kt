package com.bojanludajic

fun main() {
    val program: Stmt = Stmt.Block(
        Stmt.Assign(Expr.Var("x"), Expr.Const(0)),
        Stmt.If(
            Expr.Var("a"),
            Stmt.Assign(Expr.Var("y"), Expr.Const(5)),
            Stmt.Assign(Expr.Var("y"), Expr.Const(1))
        ),
        Stmt.Return(
            Expr.Plus(
                Expr.Mul(Expr.Var("x"), Expr.Const(2)),
                Expr.Var("y")
            )
        )
    )

    val cfg = Converter.generateCFG(program)

    println(cfg.stringify())
}