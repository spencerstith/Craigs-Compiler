package craigscode.inter;

public class Break extends Stmt {
    final Stmt stmt;

    public Break() {
        if (Stmt.Enclosing == Stmt.Null) {
            error("unclosed break");
        }
        stmt = Stmt.Enclosing;
    }

    public void gen(int b, int a) {
        emit("goto L" + stmt.after);
    }
}
