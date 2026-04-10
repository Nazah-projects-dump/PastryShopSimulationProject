package team.nazah.customer;

import common.AppendableObjectOutputStream;

import java.io.*;
import java.util.ArrayList;

public class Feedback implements Serializable {
    private String feedbackId;
    private int rating;
    private String comment;
    private Customer customer;
    private ArrayList<Feedback> feedbacks;
    private static final long serialVersionUID = 1L;

    public Feedback() {
    }

    public Feedback(String feedbackId, int rating, String comment, Customer customer) {
        this.feedbackId = feedbackId;
        this.rating = rating;
        this.comment = comment;
        this.customer = customer;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId='" + feedbackId + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", customer=" + customer +
                '}';
    }

    public static void saveFeedbacks(ArrayList<Feedback> feedbacks) {
        try {
            FileOutputStream fos = new FileOutputStream("Feedback.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(feedbacks);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Feedback> loadFeedbacks() {

        ArrayList<Feedback> feedbacks;

        try {
            FileInputStream fis = new FileInputStream("Feedback.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            feedbacks = (ArrayList<Feedback>) ois.readObject();
            ois.close();

        } catch (Exception e) {
            feedbacks = new ArrayList<>(); // IMPORTANT fallback
        }

        return feedbacks;
    }
}
