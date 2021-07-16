package craigscode.inter;

import craigscode.lexer.*;
import craigscode.symbols.*;

public class Expr extends Node {
    public Token op;
    public Token type;

    Expr(Token tok, Type p) {
        op = tok;
        type = p;
    }
}
