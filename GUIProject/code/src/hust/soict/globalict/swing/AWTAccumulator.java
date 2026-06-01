package hust.soict.globalict.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;

    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2));

        add(new Label("Enter a number:"));
        tfInput = new TextField();
        add(tfInput);
        tfInput.addActionListener(new TextFieldListener());

        add(new Label("Accumulated sum:"));
        tfOutput = new TextField("0");
        tfOutput.setEditable(false);
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    private class TextFieldListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int value = Integer.parseInt(tfInput.getText().trim());
                sum += value;
                tfOutput.setText(String.valueOf(sum));
            } catch (NumberFormatException ex) {
                tfOutput.setText("Invalid number");
            }
            tfInput.setText("");
        }
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }
}
