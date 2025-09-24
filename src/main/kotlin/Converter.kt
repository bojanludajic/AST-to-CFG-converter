package com.bojanludajic

object Converter {
    fun generateCFG(stmt: Stmt, next: Node = Node.Quit): Node = when (stmt) {
        is Stmt.Assign -> Node.Assign(stmt.variable, stmt.value, next)

        is Stmt.Return -> Node.Return(stmt.result)

        is Stmt.Block -> {
            var acc = next
            for(s in stmt.stmt.reversed()) {
                acc = generateCFG(s, acc)
            }
            acc
        }

        is Stmt.If -> {
            val thenCFG = generateCFG(stmt.thenStmt, next)
            val elseCFG = if(stmt.elseStmt != null) generateCFG(stmt.elseStmt, next) else next
            Node.Condition(stmt.cond, thenCFG, elseCFG)
        }
    }
}