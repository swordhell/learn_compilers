class Parser {
    private Lookahead lookahead;

    public Parser(Lookahead lookahead) {
        this.lookahead = lookahead;
    }

    public void expr() {
        term();
        while (lookahead.currentToken() == Token.PLUS || lookahead.currentToken() == Token.MINUS) {
            match(lookahead.currentToken());
            term();
        }
    }

    private void term() {
        factor();
        while (lookahead.currentToken() == Token.TIMES || lookahead.currentToken() == Token.DIVIDE) {
            match(lookahead.currentToken());
            factor();
        }
    }

    private void factor() {
        if (lookahead.currentToken() == Token.NUMBER) {
            match(Token.NUMBER);
        } else if (lookahead.currentToken() == Token.LPAREN) {
            match(Token.LPAREN);
            expr();
            match(Token.RPAREN);
        } else {
            throw new SyntaxError("Unexpected token: " + lookahead.currentToken());
        }
    }

    private void match(Token expected) {
        if (lookahead.currentToken() == expected) {
            lookahead.advance();
        } else {
            throw new SyntaxError("Expected " + expected + " but found " + lookahead.currentToken());
        }
    }
}