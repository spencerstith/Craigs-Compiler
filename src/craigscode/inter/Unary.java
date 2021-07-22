package craigscode.inter;

import craigscode.lexer.*;
import craigscode.symbols.*;

public class Unary extends Op {
    public final Expr expr;
    public Unary(Token tok, Expr x) {
        super(tok, null);
        expr = x;
        type = Type.max(Type.Int, expr.type);
        if (type == null) {
            error("type error");
        }
    }

    public Expr gen() {
        return new Unary(op, expr.reduce());
    }

    public String toString() {
        return op.toString() + " " + expr.toString();
    }
}
