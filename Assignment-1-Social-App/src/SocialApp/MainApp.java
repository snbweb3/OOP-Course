package SocialApp;

public class MainApp {
    public static void main(String[] args) {
        User ali = new User("ali", "I love photography");
        User sara = new User("sara", "Student at NUML");
        User guest = new User();

        sara.follow(ali);
        guest.follow(ali);
        ali.follow(sara);

        Post sunsetPost = ali.createPost(1, "Sunset at Margalla Hills", 2);
        Post examPost = sara.createPost(2, "Midterms are coming", 1);
        Post emptyPost = new Post();

        sunsetPost.like();
        sunsetPost.like();
        examPost.like();

        Comment saraComment = new Comment("sara", "Beautiful view");
        Comment aliComment = new Comment("ali", "Best of luck");
        Comment emptyComment = new Comment();
        sunsetPost.addComment(saraComment);
        examPost.addComment(aliComment);
        emptyPost.addComment(emptyComment);

        sara.collect(sunsetPost);
        guest.collect(sunsetPost);
        ali.collect(sunsetPost);
        ali.collect(examPost);

        sunsetPost.display();
        examPost.display();

        ali.showProfile();
        sara.showProfile();
    }
}
