package SocialApp;

public class User {
    String username;
    String bio;
    int followers;
    int postCount;
    Post[] collectedPosts = new Post[10];
    int collectedCount;

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

    Post createPost(int postId, String text, int totalCopies) {
        postCount++;
        Post post = new Post(postId, username, text, totalCopies);
        return post;
    }

    void follow(User other) {
        other.followers++;
        System.out.println(username + " followed " + other.username);
    }

    void collect(Post post) {
        if (post.isAvailable()) {
            post.copiesCollected++;
            collectedPosts[collectedCount] = post;
            collectedCount++;
            System.out.println(username + " collected post " + post.postId);
        } else {
            System.out.println("No copies left of post " + post.postId);
        }
    }

    void showProfile() {
        System.out.println("Username: " + username);
        System.out.println("Bio: " + bio);
        System.out.println("Followers: " + followers);
        System.out.println("Posts: " + postCount);
        System.out.println("Collected Posts: " + collectedCount);
        System.out.println();
    }
}
