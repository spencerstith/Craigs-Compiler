package craigscode.inter;

import craigscode.symbols.*;

public class If extends Node {
    Expr expr;
    Stmt stmt;

    public If(Expr x, Stmt s) {
        expr = x;
        stmt = s;
        if (expr.type != Type.Bool) {
            expr.error("boolean required in if");
        }
    }

    public void gen(int b, int a) {
        int label = newLabel();
        expr.jumping(0, a);
        emitLabel(label);
        stmt.gen(label, a);
    }
}