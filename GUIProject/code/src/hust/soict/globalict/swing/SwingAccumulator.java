package hust.soict.globalict.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        super("Swing Accumulator");

        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));

        cp.add(new JLabel("Enter a number:"));
        tfInput = new JTextField();
        cp.add(tfInput);
        tfInput.addActionListener(new TextFieldListener());

        cp.add(new JLabel("Accumulated sum:"));
        tfOutput = new JTextField("0");
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        SwingUtilities.invokeLater(SwingAccumulator::new);
    }
}
