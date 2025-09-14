class Lookahead {
    private String input;
    private int pos = 0;
    private Token currentToken;
    private String currentText;

    public Lookahead(String input) {
        this.input = input;
        advance(); // 初始化第一个 token
    }

    public Token currentToken() {
        return currentToken;
    }

    public String currentText() {
        return currentText;
    }

    public void advance() {
        skipWhitespace();
        if (pos >= input.length()) {
            currentToken = Token.EOF;
            return;
        }

        char ch = input.charAt(pos);

        switch (ch) {
            case '+': currentToken = Token.PLUS; pos++; break;
            case '-': currentToken = Token.MINUS; pos++; break;
            case '*': currentToken = Token.TIMES; pos++; break;
            case '/': currentToken = Token.DIVIDE; pos++; break;
            case '(': currentToken = Token.LPAREN; pos++; break;
            case ')': currentToken = Token.RPAREN; pos++; break;
            default:
                if (Character.isDigit(ch)) {
                    int start = pos;
                    while (pos < input.length() && Character.isDigit(input.charAt(pos))) pos++;
                    currentText = input.substring(start, pos);
                    currentToken = Token.NUMBER;
                } else {
                    throw new RuntimeException("Unexpected character: " + ch);
                }
        }
    }

    private void skipWhitespace() {
        while (pos < input.length() && Character.isWhitespace(input.charAt(pos))) pos++;
    }
}