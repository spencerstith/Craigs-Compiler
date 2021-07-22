package craigscode.symbols;

import craigscode.lexer.*;

public class Array extends Type {
    public final Type of;
    public final int size;

    public Array(int sz, Type p) {
        super("[]", Tag.INDEX, sz * p.width);
        size = sz;
        of = p;
    }

    public String toString() {
        return "[" + size + "] " + of.toString();
    }
}
