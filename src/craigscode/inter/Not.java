package craigscode.inter;

import craigscode.lexer.*;
import craigscode.symbols.*;

public class Not extends Logical{
    Not(Token tok, Expr x2) {
        super(tok, x2, x2);
    }

    public void jumping(int t, int f) {
        expr2.jumping(f, t);
    }

    public String toString() {
        return op.toString() + " " + expr2.toString();
    }
}