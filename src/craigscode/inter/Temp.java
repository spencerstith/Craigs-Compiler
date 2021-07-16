package craigscode.inter;

import craigscode.lexer.*;
import craigscode.symbols.*;

public class Temp extends Expr {
    static int count = 0;
    int number;

    public Temp(Type p) {
        super(Word.temp, p);
        number = ++count;
    }

    public String toString() {
        return "t" + number;
    }
}
