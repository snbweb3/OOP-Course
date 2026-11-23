package SocialApp;

public class Post {
    int postId;
    String author;
    String text;
    int likes;
    Comment[] comments = new Comment[10];
    int commentCount;
    int totalCopies;
    int copiesCollected;

    Post() {
        postId = 0;
        author = "Unknown";
        text = "";
        likes = 0;
        commentCount = 0;
        totalCopies = 0;
        copiesCollected = 0;
    }

    Post(int postId, String author, String text, int totalCopies) {
        this.postId = postId;
        this.author = author;
        this.text = text;
        this.totalCopies = totalCopies;
        likes = 0;
        commentCount = 0;
        copiesCollected = 0;
    }

    void like() {
        likes++;
    }

    void addComment(Comment comment) {
        if (commentCount < comments.length) {
            comments[commentCount] = comment;
            commentCount++;
        }
    }

    boolean isAvailable() {
        if (copiesCollected < totalCopies) {
            return true;
        } else {
            return false;
        }
    }

    void display() {
        System.out.println("Post " + postId + " by " + author);
        System.out.println(text);
        System.out.println("Likes: " + likes);
        System.out.println("Comments:");
        for (int i = 0; i < commentCount; i++) {
            comments[i].display();
        }
        System.out.println("Copies Collected: " + copiesCollected + " of " + totalCopies);
        System.out.println();
    }
}
