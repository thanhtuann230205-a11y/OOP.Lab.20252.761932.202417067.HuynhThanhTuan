package hust.soict.globalict.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete;
    private JButton btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        super("Number Grid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        tfDisplay = new JTextField("", 20);
        tfDisplay.setEditable(false);
        add(tfDisplay, BorderLayout.NORTH);

        JPanel panelButtons = new JPanel(new GridLayout(4, 3, 5, 5));
        add(panelButtons, BorderLayout.CENTER);

        addButtons(panelButtons);

        setSize(320, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addButtons(JPanel panelButtons) {
        ButtonListener listener = new ButtonListener();

        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            btnNumbers[i].addActionListener(listener);
            panelButtons.add(btnNumbers[i]);
        }

        btnDelete = new JButton("DEL");
        btnDelete.addActionListener(listener);
        panelButtons.add(btnDelete);

        btnNumbers[0] = new JButton("0");
        btnNumbers[0].addActionListener(listener);
        panelButtons.add(btnNumbers[0]);

        btnReset = new JButton("C");
        btnReset.addActionListener(listener);
        panelButtons.add(btnReset);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            for (int i = 0; i < btnNumbers.length; i++) {
                if (source == btnNumbers[i]) {
                    tfDisplay.setText(tfDisplay.getText() + i);
                    return;
                }
            }

            if (source == btnDelete) {
                String text = tfDisplay.getText();
                if (!text.isEmpty()) {
                    tfDisplay.setText(text.substring(0, text.length() - 1));
                }
            } else if (source == btnReset) {
                tfDisplay.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NumberGrid::new);
    }
}
