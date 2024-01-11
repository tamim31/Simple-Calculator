/*import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyParenthesisButton extends Button implements ActionListener {

    MyCalculator cl;
    char parenthesis; // '(' or ')'

    MyParenthesisButton(int x, int y, int width, int height, String cap, MyCalculator clc, char paren) {
        super(cap);
        setBounds(x, y, width, height);
        this.cl = clc;
        this.parenthesis = paren;
        this.cl.add(this);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        String displayText = cl.displayLabel.getText();

        if (parenthesis == '(') {
            // Allow '(' only at the beginning or after an operator or opening parenthesis
            if (displayText.isEmpty() || displayText.endsWith("+") || displayText.endsWith("-") ||
                    displayText.endsWith("*") || displayText.endsWith("/") || displayText.endsWith("(")) {
                cl.displayLabel.setText(displayText + parenthesis);
            }
        } else if (parenthesis == ')') {
            // Allow ')' only if there are matching opening parentheses and a number follows
            int openParenCount = 0;
            int closeParenCount = 0;

            for (char c : displayText.toCharArray()) {
                if (c == '(') {
                    openParenCount++;
                } else if (c == ')') {
                    closeParenCount++;
                }
            }

            if (openParenCount > closeParenCount && (displayText.endsWith(")") || Character.isDigit(displayText.charAt(displayText.length() - 1)))) {
                cl.displayLabel.setText(displayText + parenthesis);
            }

            // Evaluate the expression when a closing parenthesis is added
            cl.evaluateExpression();
        }
    }
}
*/