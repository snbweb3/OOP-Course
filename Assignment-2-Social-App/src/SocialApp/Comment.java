package SocialApp;

public class Comment {
    private String commenter;
    private String text;

    Comment() {
        commenter = "Unknown";
        text = "";
    }

    Comment(String commenter, String text) {
        this.commenter = commenter;
        this.text = text;
    }

    String getCommenter() {
        return commenter;
    }

    void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    String getText() {
        return text;
    }

    void setText(String text) {
        this.text = text;
    }

    void display() {
        System.out.println(commenter + ": " + text);
    }
}
