package revisaoProva;

import java.time.LocalDateTime;

public class UserAccount {
    private String email;
    private String userName;
    private Post[] timeline;
    private Post[] posts;
    private UserAccount[] followers;

    private int myPostsIndex=0;

    public UserAccount(String userName, String email) {
        this.userName = userName;
        this.email = email;
        this.timeline = new Post[10];
        this.posts = new Post[20];
    }

    public void publish(String quote){
        this.posts[myPostsIndex].setQuote(quote);

    }
    public void updateTimeline(Post newPost){
        for (int i = 0; i < followers.length; i++) {
            if (newPost.getAccount().getName().equals(followers[i])) {
                for (int j = 0; j < timeline.length; j++) {
                    if (timeline[j] == null) {
                        timeline[j] = newPost;
                        return;
                    }
                }
            }
            }
    }

    public String getName() {
        return userName;
    }
}
