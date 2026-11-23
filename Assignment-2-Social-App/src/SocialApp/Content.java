package SocialApp;

public abstract class Content {
    protected int id;
    protected String author;
    protected String text;
    public static final int MAX_COMMENTS = 10;

    Content() {
        id = 0;
        author = "Unknown";
        text = "";
    }

    Content(int id, String author, String text) {
        this.id = id;
        this.author = author;
        this.text = text;
    }

    abstract void display();

    void showHeader() {
        System.out.println("Post " + id + " by " + author);
    }

    final String getAuthor() {
        return author;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    String getText() {
        return text;
    }

    void setText(String text) {
        this.text = text;
    }
}
