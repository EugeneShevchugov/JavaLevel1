package OOP.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFrame extends JFrame {

    public GUIFrame() {
        setBasicSettings();
        JTextField textField = new JTextField();
        ButtonListener buttonListener = new ButtonListener(textField);
        add(textField);
        addNumberButtons(buttonListener, textField);
        addOperationButtons(buttonListener, textField);
        setVisible(true);
    }

    private void setBasicSettings() {
        setTitle("My first Java GUI");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 500);
        GridLayout gridLayout = new GridLayout(3, 3);
        setLayout(gridLayout);
    }

    private void addNumberButtons(ButtonListener buttonListener, JTextField textField) {
        for (int i = 0; i <= 9; i++) {
            JButton jButton = new JButton(String.valueOf(i));
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + jButton.getText());
                    buttonListener.setBetween(buttonListener.getBetween() * 10 + Double.parseDouble(jButton.getText()));
                }
            });
            add(jButton);
        }
    }

    private void addOperationButtons(ButtonListener buttonListener, JTextField textField) {
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton mult = new JButton("*");
        JButton div = new JButton("/");
        JButton equal = new JButton("=");

        plus.addActionListener(buttonListener);
        minus.addActionListener(buttonListener);
        mult.addActionListener(buttonListener);
        div.addActionListener(buttonListener);
        equal.addActionListener(buttonListener);

        add(plus);
        add(minus);
        add(mult);
        add(div);
        add(equal);
    }
}

