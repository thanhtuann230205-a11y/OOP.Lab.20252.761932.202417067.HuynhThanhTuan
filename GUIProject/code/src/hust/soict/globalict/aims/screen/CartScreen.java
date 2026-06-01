package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.io.IOException;

public class CartScreen extends JFrame {
    public CartScreen(Cart cart, Runnable viewStoreAction) {
        super("AIMS Cart");
        JFXPanel fxPanel = new JFXPanel();
        add(fxPanel);

        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
                Runnable wrappedViewStoreAction = () -> {
                    dispose();
                    if (viewStoreAction != null) {
                        viewStoreAction.run();
                    }
                };
                loader.setController(new CartScreenController(cart, wrappedViewStoreAction));
                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));
            } catch (IOException e) {
                SwingUtilities.invokeLater(() -> {
                    throw new RuntimeException("Cannot load cart screen.", e);
                });
            }
        });

        setVisible(true);
    }
}
