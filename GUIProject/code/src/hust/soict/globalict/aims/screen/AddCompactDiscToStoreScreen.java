package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.Cart;
import hust.soict.globalict.aims.CompactDisc;
import hust.soict.globalict.aims.Media;
import hust.soict.globalict.aims.Store;
import hust.soict.globalict.aims.Track;

import javax.swing.JTextField;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist = new JTextField();
    private JTextField tfTrackTitle = new JTextField();
    private JTextField tfTrackLength = new JTextField();

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add CD");
        buildScreen();
    }

    @Override
    protected void addSpecificFields() {
        addField("Artist", tfArtist);
        addField("Track title", tfTrackTitle);
        addField("Track length", tfTrackLength);
    }

    @Override
    protected Media createMedia() {
        CompactDisc cd = new CompactDisc(tfTitle.getText().trim(), tfCategory.getText().trim(), readCost(), tfArtist.getText().trim());
        if (!tfTrackTitle.getText().trim().isEmpty() && !tfTrackLength.getText().trim().isEmpty()) {
            cd.addTrack(new Track(tfTrackTitle.getText().trim(), readInt(tfTrackLength)));
        }
        return cd;
    }
}
