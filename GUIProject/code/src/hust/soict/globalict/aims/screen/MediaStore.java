package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.Cart;
import hust.soict.globalict.aims.Media;
import hust.soict.globalict.aims.Playable;
import hust.soict.globalict.aims.exception.PlayerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        setLayout(new BorderLayout(5, 5));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel lblTitle = new JLabel(media.getTitle(), SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblTitle, BorderLayout.NORTH);

        JLabel lblCategory = new JLabel(media.getCategory(), SwingConstants.CENTER);
        add(lblCategory, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new BorderLayout(5, 5));
        JLabel lblCost = new JLabel(String.format("%.2f $", media.getCost()), SwingConstants.CENTER);
        southPanel.add(lblCost, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnAddToCart = new JButton("Add to cart");
        buttonPanel.add(btnAddToCart);
        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            buttonPanel.add(btnPlay);
            btnPlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ((Playable) media).play();
                        JOptionPane.showMessageDialog(MediaStore.this, "Playing " + media.getTitle());
                    } catch (PlayerException ex) {
                        JOptionPane.showMessageDialog(MediaStore.this, ex.getMessage(), "Playback error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }
        southPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(southPanel, BorderLayout.SOUTH);

        btnAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cart.addMedia(media);
                    JOptionPane.showMessageDialog(MediaStore.this, media.getTitle() + " added to cart.");
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(MediaStore.this, ex.getMessage(), "Cart error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
