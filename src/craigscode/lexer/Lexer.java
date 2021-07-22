package craigscode.lexer;

import java.io.*;
import java.util.*;
import craigscode.symbols.*;

public class Lexer {
    public static int line = 1;
    char peek = ' ';
    final HashMap<String, Word> words = new HashMap<>();
    BufferedReader reader;

    void reserve(Word w) {
        words.put(w.lexeme, w);
    }

    public Lexer() throws IOException {
        reserve(new Word("if", Tag.IF));
        reserve(new Word("else", Tag.ELSE));
        reserve(new Word("while", Tag.WHILE));
        reserve(new Word("do", Tag.DO));
        reserve(new Word("break", Tag.BREAK));
        reserve(Word.True);
        reserve(Word.False);
        reserve(Type.Int);
        reserve(Type.Char);
        reserve(Type.Bool);
        reserve(Type.Float);
        
        reader = new BufferedReader(new FileReader("test"));
    }

    void readChar() throws IOException {
        peek = (char)reader.read();
    }

    boolean readChar(char c) throws IOException {
        readChar();
        if (peek != c) return false;
        peek = ' ';
        return true;
    }

    public Token scan() throws IOException {
        for (; ; readChar()) {
            if (peek != ' ' && peek != '\t') {
                if (peek == '\n') line++;
                else break;
            }
        }
        switch(peek) {
            case '&':
                if (readChar('&')) return Word.and;
                else return new Token('&');
            case '|':
                if (readChar('|')) return Word.or;
                else return new Token('|');
            case '=':
                if (readChar('=')) return Word.eq;
                else return new Token('=');
            case '!':
                if (readChar('=')) return Word.ne;
                else return new Token('!');
            case '<':
                if (readChar('=')) return Word.le;
                else return new Token('<');
            case '>':
                if (readChar('=')) return Word.ge;
                else return new Token('>');
        }

        if (Character.isDigit(peek)) {
            int v = 0;
            do {
                v = 10 * v + Character.digit(peek, 10);
                readChar();
            } while(Character.isDigit(peek));
            if (peek != '.') return new Num(v);
            float x = v;
            float d = 10;
            for (;;) {
                readChar();
                if (!Character.isDigit(peek)) break;
                x += Character.digit(peek, 10) / d;
                d *= 10;
            }
            return new Real(x);
        }

        if (Character.isLetter(peek)) {
            StringBuilder b = new StringBuilder();
            do {
                b.append(peek);
                readChar();
            } while(Character.isLetterOrDigit(peek));
            String s = b.toString();
            Word w = words.get(s);
            if (w != null) return w;
            w = new Word(s, Tag.ID);
            words.put(s, w);
            return w;
        }

        Token tok = new Token(peek);
        peek = ' ';
        return tok;
    }

}
