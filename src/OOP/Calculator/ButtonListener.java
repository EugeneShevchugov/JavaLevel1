package OOP.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private final JTextField textField;
    private String command;
    private double between = 0; // промежуточный результат
    private double answer;
    private boolean start = false;

    public double getBetween() {
        return between;
    }

    public void setBetween(double between) {
        this.between = between;
    }

    public ButtonListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String lastCommand = e.getActionCommand();
        JButton jButton = (JButton) e.getSource();
        if (checkStart(lastCommand)) {
            return;
        }
        switch (jButton.getText()) {
            case "+":
                calculate(Double.parseDouble(String.valueOf(getBetween())));
                command = "+";
                textField.setText("");
                break;
            case "-":
                calculate(Double.parseDouble(String.valueOf(getBetween())));
                command = "-";
                textField.setText("");
                break;
            case "*":
                calculate(Double.parseDouble(String.valueOf(getBetween())));
                command = "*";
                textField.setText("");
                break;
            case "/":
                calculate(Double.parseDouble(String.valueOf(getBetween())));
                command = "/";
                textField.setText("");
                break;
            case "=":
                calculate(Double.parseDouble(String.valueOf(getBetween())));
                this.textField.setText(String.valueOf(answer));
                command = "";
                break;
        }
    }

    private boolean checkStart(String cmd) {
        if (!start) {
            start = true;
            textField.setText(String.valueOf(answer));
            command = cmd;
            answer = getBetween();
            setBetween(0);
            textField.setText("");
            return true;
        }
        return false;
    }

    private void calculate(double x) {
        switch (command) {
            case "+":
                answer += x;
                setBetween(0);
                break;
            case "-":
                answer -= x;
                setBetween(0);
                break;
            case "*":
                answer *= x;
                setBetween(0);
                break;
            case "/":
                answer /= x;
                setBetween(0);
                break;
            case "=":
                answer = x;
                setBetween(0);
                break;
        }
        textField.setText("" + answer);
    }
}
