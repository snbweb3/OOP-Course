package SocialApp;

public class Post extends Content implements Likeable, Shareable {
    private int likes;
    protected Comment[] comments = new Comment[MAX_COMMENTS];
    protected int commentCount;
    private int totalCopies;
    private int copiesCollected;

    Post() {
        super();
        likes = 0;
        commentCount = 0;
        totalCopies = 0;
        copiesCollected = 0;
    }

    Post(int postId, String author, String text, int totalCopies) {
        super(postId, author, text);
        this.totalCopies = totalCopies;
        likes = 0;
        commentCount = 0;
        copiesCollected = 0;
    }

    public void like() {
        likes++;
    }

    public void like(int count) {
        likes = likes + count;
    }

    public int getLikes() {
        return likes;
    }

    void setLikes(int likes) {
        this.likes = likes;
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

    void collectCopy() {
        copiesCollected++;
    }

    int getTotalCopies() {
        return totalCopies;
    }

    void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    int getCopiesCollected() {
        return copiesCollected;
    }

    void setCopiesCollected(int copiesCollected) {
        this.copiesCollected = copiesCollected;
    }

    public void share() {
        System.out.println("Post " + super.id + " was shared");
    }

    public void share(User user) {
        System.out.println("Post " + super.id + " was shared with "
                + user.getUsername());
    }

    void display() {
        super.showHeader();
        System.out.println(super.text);
        System.out.println("Likes: " + likes);
        System.out.println("Comments:");
        for (int i = 0; i < commentCount; i++) {
            comments[i].display();
        }
        System.out.println("Copies Collected: " + copiesCollected + " of "
                + totalCopies);
    }

    void display(boolean showComments) {
        super.showHeader();
        System.out.println(super.text);
        System.out.println("Likes: " + likes);
        if (showComments) {
            System.out.println("Comments:");
            for (int i = 0; i < commentCount; i++) {
                comments[i].display();
            }
        }
        System.out.println("Copies Collected: " + copiesCollected + " of "
                + totalCopies);
    }

    PostStats getStats() {
        PostStats stats = new PostStats(likes, commentCount);
        return stats;
    }

    public static class PostStats {
        private int likeCount;
        private int commentCount;

        PostStats(int likeCount, int commentCount) {
            this.likeCount = likeCount;
            this.commentCount = commentCount;
        }

        int getLikeCount() {
            return likeCount;
        }

        int getCommentCount() {
            return commentCount;
        }

        void display() {
            System.out.println("Likes: " + likeCount);
            System.out.println("Comments: " + commentCount);
        }
    }
}
