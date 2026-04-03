package team.nazah.customer;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FeedbackController
{
    @javafx.fxml.FXML
    private TextField commentTextField;
    @javafx.fxml.FXML
    private Label feedbackStatusLabel;
    @javafx.fxml.FXML
    private ComboBox ratingComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitFeedbackButtonOnAction(ActionEvent actionEvent) {
    }
}