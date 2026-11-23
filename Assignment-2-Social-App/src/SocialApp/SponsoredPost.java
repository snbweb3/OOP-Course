package SocialApp;

public class SponsoredPost extends Post implements Promotable {
    private String brand;

    SponsoredPost(int postId, String author, String text, int totalCopies,
            String brand) {
        super(postId, author, text, totalCopies);
        this.brand = brand;
    }

    String getBrand() {
        return brand;
    }

    void setBrand(String brand) {
        this.brand = brand;
    }

    public void like() {
        super.like();
        super.like();
    }

    public void promote() {
        System.out.println("Post " + super.id + " is promoted by " + brand);
    }

    void display() {
        super.display();
        System.out.println("Sponsored by " + brand);
    }
}
