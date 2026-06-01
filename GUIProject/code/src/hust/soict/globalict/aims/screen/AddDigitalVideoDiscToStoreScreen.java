package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.Cart;
import hust.soict.globalict.aims.DigitalVideoDisc;
import hust.soict.globalict.aims.Media;
import hust.soict.globalict.aims.Store;

import javax.swing.JTextField;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfLength = new JTextField();

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add DVD");
        buildScreen();
    }

    @Override
    protected void addSpecificFields() {
        addField("Length", tfLength);
    }

    @Override
    protected Media createMedia() {
        return new DigitalVideoDisc(tfTitle.getText().trim(), tfCategory.getText().trim(), readCost(), readInt(tfLength));
    }
}
