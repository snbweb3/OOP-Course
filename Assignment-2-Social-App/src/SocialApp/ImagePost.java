package SocialApp;

public class ImagePost extends Post {
    private String imageName;

    ImagePost(int postId, String author, String text, int totalCopies,
            String imageName) {
        super(postId, author, text, totalCopies);
        this.imageName = imageName;
    }

    String getImageName() {
        return imageName;
    }

    void setImageName(String imageName) {
        this.imageName = imageName;
    }

    void display() {
        super.display();
        System.out.println("Image: " + imageName);
    }
}
