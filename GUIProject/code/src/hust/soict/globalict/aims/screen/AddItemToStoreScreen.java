package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.Cart;
import hust.soict.globalict.aims.Media;
import hust.soict.globalict.aims.Store;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected Cart cart;
    protected JTextField tfTitle = new JTextField();
    protected JTextField tfCategory = new JTextField();
    protected JTextField tfCost = new JTextField();
    protected JPanel formPanel = new JPanel(new GridLayout(0, 2, 8, 8));

    public AddItemToStoreScreen(Store store, Cart cart, String title) {
        super(title);
        this.store = store;
        this.cart = cart;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));
        setJMenuBar(createMenuBar());

        addCommonFields();
    }

    protected void buildScreen() {
        addSpecificFields();
        add(formPanel, BorderLayout.CENTER);

        JButton btnAdd = new JButton("Add to store");
        btnAdd.addActionListener(e -> addItem());
        add(btnAdd, BorderLayout.SOUTH);

        setSize(420, 280);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu options = new JMenu("Options");
        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> openStoreScreen());
        options.add(viewStore);
        menuBar.add(options);
        return menuBar;
    }

    private void addCommonFields() {
        addField("Title", tfTitle);
        addField("Category", tfCategory);
        addField("Cost", tfCost);
    }

    protected void addField(String label, JTextField textField) {
        formPanel.add(new JLabel(label));
        formPanel.add(textField);
    }

    protected abstract void addSpecificFields();

    protected abstract Media createMedia();

    private void addItem() {
        try {
            store.addMedia(createMedia());
            JOptionPane.showMessageDialog(this, "Item added to store.");
            openStoreScreen();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Input error", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected float readCost() {
        return Float.parseFloat(tfCost.getText().trim());
    }

    protected int readInt(JTextField textField) {
        return Integer.parseInt(textField.getText().trim());
    }

    protected void openStoreScreen() {
        dispose();
        new StoreScreen(store, cart);
    }
}
