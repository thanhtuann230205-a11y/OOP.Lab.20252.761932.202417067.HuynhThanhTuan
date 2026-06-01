package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.Cart;
import hust.soict.globalict.aims.Media;
import hust.soict.globalict.aims.Playable;
import hust.soict.globalict.aims.exception.PlayerException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.SwingUtilities;

public class CartScreenController {
    private Cart cart;
    private Runnable viewStoreAction;
    private FilteredList<Media> filteredMedia;

    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Label lblTotalCost;

    public CartScreenController(Cart cart, Runnable viewStoreAction) {
        this.cart = cart;
        this.viewStoreAction = viewStoreAction;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        tblMedia.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        filteredMedia = new FilteredList<>(cart.getItemsOrdered(), media -> true);
        tblMedia.setItems(filteredMedia);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        updateTotalCost();

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia());
        radioBtnFilterId.selectedProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia());
        cart.getItemsOrdered().addListener((javafx.collections.ListChangeListener<Media>) change -> updateTotalCost());
    }

    private void updateButtonBar(Media media) {
        boolean selected = media != null;
        btnRemove.setVisible(selected);
        btnPlay.setVisible(media instanceof Playable);
    }

    private void showFilteredMedia() {
        String filter = tfFilter.getText();
        if (filter == null || filter.trim().isEmpty()) {
            filteredMedia.setPredicate(media -> true);
            return;
        }

        String lowerFilter = filter.toLowerCase();
        filteredMedia.setPredicate(media -> {
            if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle() != null && media.getTitle().toLowerCase().contains(lowerFilter);
            }
            return String.valueOf(cart.getItemsOrdered().indexOf(media) + 1).contains(lowerFilter);
        });
    }

    private void updateTotalCost() {
        lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML
    private void playButtonPressed() {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
                showInfo("Playing " + media.getTitle());
            } catch (PlayerException e) {
                showError(e.getMessage());
            }
        }
    }

    @FXML
    private void removeButtonPressed() {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            try {
                cart.removeMedia(media);
                tblMedia.getSelectionModel().clearSelection();
                updateButtonBar(null);
            } catch (RuntimeException e) {
                showError(e.getMessage());
            }
        }
    }

    @FXML
    private void placeOrderPressed() {
        cart.getItemsOrdered().clear();
        showInfo("Order placed successfully.");
    }

    @FXML
    private void viewStorePressed() {
        if (viewStoreAction != null) {
            SwingUtilities.invokeLater(viewStoreAction);
        }
    }

    private void showInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
