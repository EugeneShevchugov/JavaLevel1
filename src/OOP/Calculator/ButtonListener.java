package OOP.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private final JTextField textField;
    private String command = "";
    private double bRes = 0; // промежуточный результат
    private double answer;
    private boolean start = false;

    public double getbRes() {
        return bRes;
    }

    public void setbRes(double bRes) {
        this.bRes = bRes;
    }

    public ButtonListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String lastCommand = e.getActionCommand();
        JButton jButton = (JButton) e.getSource();
        if (!start) {
            if (lastCommand.equals("*") || lastCommand.equals("/")) {
                answer = 1;
            }
            start = true;
            textField.setText(String.valueOf(answer));
            command = lastCommand;
            calculate(Double.parseDouble(String.valueOf(getbRes())));
            textField.setText("");
            return;
        }
        switch (jButton.getText()) {
            case "+":
                calculate(Double.parseDouble(String.valueOf(getbRes())));
                command = "+";
                textField.setText("");
                break;
            case "-":
                calculate(Double.parseDouble(String.valueOf(getbRes())));
                command = "-";
                textField.setText("");
                break;
            case "*":
                calculate(Double.parseDouble(String.valueOf(getbRes())));
                command = "*";
                textField.setText("");
                break;
            case "/":
                calculate(Double.parseDouble(String.valueOf(getbRes())));
                command = "/";
                textField.setText("");
                break;
            case "=":
                calculate(Double.parseDouble(String.valueOf(getbRes())));
                this.textField.setText(String.valueOf(answer));
                command = "";
                break;
        }
    }

    public void calculate(double x) {
        switch (command) {
            case "+":
                answer += x;
                setbRes(0);
                break;
            case "-":
                answer -= x;
                setbRes(0);
                break;
            case "*":
                answer *= x;
                setbRes(0);
                break;
            case "/":
                answer /= x;
                setbRes(0);
                break;
            case "=":
                answer = x;
                setbRes(0);
                break;
        }
        textField.setText("" + answer);
    }
}
