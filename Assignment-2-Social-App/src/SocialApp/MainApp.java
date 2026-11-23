package SocialApp;

public final class MainApp {
    public static void main(String[] args) {
        CreatorUser ali = new CreatorUser("ali", "I love photography",
                "Creator");
        VerifiedUser sara = new VerifiedUser("sara", "Student at NUML",
                "Verified");
        User guest = new User();
        guest.setUsername("guest");
        guest.setBio("Visiting the app");

        sara.follow(ali);
        guest.follow(ali);
        ali.follow(sara);

        Post sunsetPost = ali.createPost(1, "Sunset at Margalla Hills", 2);
        ImagePost examPost = sara.createPost(2, "Midterms are coming", 1,
                "campus.jpg");
        SponsoredPost adPost = ali.createSponsoredPost(3,
                "Photography workshop this Sunday", 5, "Lens Club");
        Post emptyPost = new Post();

        sunsetPost.like();
        System.out.println("Likes after like(): " + sunsetPost.getLikes());
        sunsetPost.like(2);
        System.out.println("Likes after like(2): " + sunsetPost.getLikes());
        examPost.like();
        adPost.like();
        System.out.println("Likes on sponsored post after like(): "
                + adPost.getLikes());

        ali.sharePost(sunsetPost);
        ali.sharePost(examPost, guest);

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

        System.out.println();
        sunsetPost.display();
        System.out.println();
        sunsetPost.display(false);
        System.out.println();

        Content item1 = examPost;
        Content item2 = adPost;
        item1.display();
        System.out.println();
        item2.display();
        System.out.println();

        adPost.promote();
        System.out.println();

        Post.PostStats stats = sunsetPost.getStats();
        stats.display();
        System.out.println();

        User userRef1 = ali;
        User userRef2 = sara;
        userRef1.showProfile();
        System.out.println();
        userRef2.showProfile();
        System.out.println();

        System.out.println("Guest username: " + guest.getUsername());
        System.out.println("Guest bio: " + guest.getBio());
        guest.showProfile();
    }
}
