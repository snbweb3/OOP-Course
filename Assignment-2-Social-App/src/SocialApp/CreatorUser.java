package SocialApp;

public class CreatorUser extends VerifiedUser {
    private int totalShares;

    CreatorUser(String username, String bio, String badge) {
        super(username, bio, badge);
        totalShares = 0;
    }

    int getTotalShares() {
        return totalShares;
    }

    void sharePost(Post post) {
        post.share();
        totalShares++;
    }

    void sharePost(Post post, User user) {
        post.share(user);
        totalShares++;
    }

    void showProfile() {
        super.showProfile();
        System.out.println("Total Shares: " + totalShares);
    }
}
