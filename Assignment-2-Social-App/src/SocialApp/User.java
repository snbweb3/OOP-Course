package SocialApp;

public class User {
    protected String username;
    private String bio;
    protected int followers;
    protected int postCount;
    private Post[] collectedPosts = new Post[10];
    private int collectedCount;

    User() {
        username = "Unknown";
        bio = "";
        followers = 0;
        postCount = 0;
        collectedCount = 0;
    }

    User(String username, String bio) {
        this.username = username;
        this.bio = bio;
        followers = 0;
        postCount = 0;
        collectedCount = 0;
    }

    String getUsername() {
        return username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    String getBio() {
        return bio;
    }

    void setBio(String bio) {
        this.bio = bio;
    }

    int getFollowers() {
        return followers;
    }

    void setFollowers(int followers) {
        this.followers = followers;
    }

    int getPostCount() {
        return postCount;
    }

    int getCollectedCount() {
        return collectedCount;
    }

    Post createPost(int postId, String text, int totalCopies) {
        postCount++;
        Post post = new Post(postId, username, text, totalCopies);
        return post;
    }

    ImagePost createPost(int postId, String text, int totalCopies,
            String imageName) {
        postCount++;
        ImagePost post = new ImagePost(postId, username, text, totalCopies,
                imageName);
        return post;
    }

    SponsoredPost createSponsoredPost(int postId, String text,
            int totalCopies, String brand) {
        postCount++;
        SponsoredPost post = new SponsoredPost(postId, username, text,
                totalCopies, brand);
        return post;
    }

    void follow(User other) {
        other.followers++;
        System.out.println(username + " followed " + other.username);
    }

    void collect(Post post) {
        if (post.isAvailable()) {
            post.collectCopy();
            collectedPosts[collectedCount] = post;
            collectedCount++;
            System.out.println(username + " collected post " + post.getId());
        } else {
            System.out.println("No copies left of post " + post.getId());
        }
    }

    void showProfile() {
        System.out.println("Username: " + username);
        System.out.println("Bio: " + bio);
        System.out.println("Followers: " + followers);
        System.out.println("Posts: " + postCount);
        System.out.println("Collected Posts: " + collectedCount);
    }
}
