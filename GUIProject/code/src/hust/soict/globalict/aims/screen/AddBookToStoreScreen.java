package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.Book;
import hust.soict.globalict.aims.Cart;
import hust.soict.globalict.aims.Media;
import hust.soict.globalict.aims.Store;

import javax.swing.JTextField;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthors = new JTextField();

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add Book");
        buildScreen();
    }

    @Override
    protected void addSpecificFields() {
        addField("Authors", tfAuthors);
    }

    @Override
    protected Media createMedia() {
        Book book = new Book(tfTitle.getText().trim(), tfCategory.getText().trim(), readCost());
        for (String author : tfAuthors.getText().split(",")) {
            book.addAuthor(author.trim());
        }
        return book;
    }
}
