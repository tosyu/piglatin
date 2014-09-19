package pl.bytehog.piglang;

import pl.bytehog.piglang.*;

public class Token {
    private TokenType type;
    private String data;

    public Token(TokenType type, String data) {
        setType(type);
        setData(data);
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public TokenType getType() {
        return type;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
