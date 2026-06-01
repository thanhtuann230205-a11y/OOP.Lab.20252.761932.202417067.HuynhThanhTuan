package hust.soict.globalict.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton radioEraser;

    @FXML
    private void drawingAreaMouseDragged(MouseEvent event) {
        Color color = radioEraser.isSelected() ? Color.WHITE : Color.BLACK;
        Circle dot = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(dot);
    }

    @FXML
    private void clearButtonPressed() {
        drawingAreaPane.getChildren().clear();
    }
}
