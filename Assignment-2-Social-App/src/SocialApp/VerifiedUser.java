package SocialApp;

public class VerifiedUser extends User {
    protected String badge;

    VerifiedUser(String username, String bio, String badge) {
        super(username, bio);
        this.badge = badge;
    }

    String getBadge() {
        return badge;
    }

    void setBadge(String badge) {
        this.badge = badge;
    }

    void showProfile() {
        super.showProfile();
        System.out.println("Badge: " + badge);
    }
}
