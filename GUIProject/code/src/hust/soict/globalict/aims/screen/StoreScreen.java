package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.Cart;
import hust.soict.globalict.aims.Media;
import hust.soict.globalict.aims.Store;

import javax.swing.*;
import java.awt.*;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    public StoreScreen(Store store, Cart cart) {
        super("AIMS Store");
        this.store = store;
        this.cart = cart;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        add(createNorth(), BorderLayout.NORTH);
        add(createCenter(), BorderLayout.CENTER);

        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createNorth() {
        JPanel northPanel = new JPanel(new BorderLayout());
        JMenuBar menuBar = createMenuBar();
        northPanel.add(menuBar, BorderLayout.NORTH);

        JLabel header = new JLabel("AIMS Store", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 28));
        northPanel.add(header, BorderLayout.SOUTH);

        return northPanel;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu viewMenu = new JMenu("View");
        JMenuItem viewStore = new JMenuItem("View Store");
        JMenuItem viewCart = new JMenuItem("View Cart");
        viewStore.addActionListener(e -> refreshStoreScreen());
        viewCart.addActionListener(e -> {
            dispose();
            new CartScreen(cart, () -> new StoreScreen(store, cart));
        });
        viewMenu.add(viewStore);
        viewMenu.add(viewCart);
        menuBar.add(viewMenu);

        JMenu updateMenu = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addBook.addActionListener(e -> {
            dispose();
            new AddBookToStoreScreen(store, cart);
        });
        addCD.addActionListener(e -> {
            dispose();
            new AddCompactDiscToStoreScreen(store, cart);
        });
        addDVD.addActionListener(e -> {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store, cart);
        });
        updateMenu.add(addBook);
        updateMenu.add(addCD);
        updateMenu.add(addDVD);
        menuBar.add(updateMenu);

        return menuBar;
    }

    private JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(0, 3, 10, 10));
        for (Media media : store.getItems()) {
            center.add(new MediaStore(media, cart));
        }
        return center;
    }

    private void refreshStoreScreen() {
        dispose();
        new StoreScreen(store, cart);
    }
}
