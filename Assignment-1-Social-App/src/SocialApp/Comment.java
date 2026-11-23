package SocialApp;

public class Comment {
    String commenter;
    String text;

    Comment() {
        commenter = "Unknown";
        text = "";
    }

    Comment(String commenter, String text) {
        this.commenter = commenter;
        this.text = text;
    }

    void display() {
        System.out.println(commenter + ": " + text);
    }
}
