package team.nazah.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class FeedbackController
{
    @javafx.fxml.FXML
    private TextField commentTextField;
    @javafx.fxml.FXML
    private Label feedbackStatusLabel;
    @javafx.fxml.FXML
    private ComboBox<String> ratingComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        ratingComboBox.getItems().addAll("⭐⭐⭐⭐⭐", "⭐⭐⭐⭐", "⭐⭐⭐", "⭐⭐","⭐");
    }

    private Customer currentCustomer;
    public void receiveData(Customer customer) {
        this.currentCustomer = customer;
    }

    @javafx.fxml.FXML
    public void submitFeedbackButtonOnAction(ActionEvent actionEvent) {

        String comment = commentTextField.getText();
        String ratingString = ratingComboBox.getValue();

        if (comment == null || comment.isEmpty() || ratingString == null) {
            feedbackStatusLabel.setText("Please fill all the fields.");
            return;
        }

        int rating = ratingString.length();
        Random r = new Random();
        String randomFeedbackId = String.format("%06d",r.nextInt(1000000));

        Feedback feedback = new Feedback(
                randomFeedbackId,
                rating,
                comment,
                currentCustomer
        );

        ArrayList<Feedback> feedbacks = Feedback.loadFeedbacks();
        feedbacks.add(feedback);
        Feedback.saveFeedbacks(feedbacks);

        feedbackStatusLabel.setText("Feedback submitted!");
        commentTextField.clear();
        ratingComboBox.getSelectionModel().clearSelection();
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/CustomerDashboard.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        CustomerDashboardController controller = fxmlLoader.getController();
        controller.setCustomer(currentCustomer);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }
}