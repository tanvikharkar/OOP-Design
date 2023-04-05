package calculator;

public class BinaryExpression implements Expression {
    // Common data from add, subtract, multiply, divide
    private final Expression lft;
    private final Expression rht;
    private final String operator;  // +, -, *, /

    public BinaryExpression(final Expression lft, final Expression rht, final String operator) {
        this.lft = lft;
        this.rht = rht;
        this.operator = operator;
    }

    public String toString() {
        return "(" + lft + " " + operator + " " + rht + ")";
    };

    protected abstract double _applyOperator(double lft, double rht);

    public double evaluate(final Bindings bindings) {
        double
    }
}
