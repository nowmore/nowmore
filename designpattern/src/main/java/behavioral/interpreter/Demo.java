package behavioral.interpreter;

public class Demo {

    @FunctionalInterface
    public interface Rule {
        public Expression getRule();
    }
    public static void main(String[] args) {
        Expression or =new OrExpression(
                new TerminalExpression("x"),
                new TerminalExpression("y")
        );

        Expression and = new AndExpression(
                new TerminalExpression("a"),
                new TerminalExpression("b")
        );

        System.out.println("x is bingo? " + or.interpret("x"));
        System.out.println("a and b is right? " + and.interpret("ab"));
    }
}
