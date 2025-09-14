public class Main {
    public static void main(String[] args) {
        String expr = "3 + 4 * (2 - 1)"; // 测试表达式
        Lookahead lookahead = new Lookahead(expr);
        Parser parser = new Parser(lookahead);

        try {
            parser.expr();
            if (lookahead.currentToken() != Token.EOF) {
                System.out.println("未解析完全部输入！");
            } else {
                System.out.println("解析成功！");
            }
        } catch (SyntaxError e) {
            System.out.println("语法错误: " + e.getMessage());
        }
    }
}