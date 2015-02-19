package in.cybergen.ml.models;

import java.util.List;

/**
 * Created by vishnu on 19/2/15.
 */
public class Post {
    List<String> tags ;
    int viewCount;
    String body;
    String title;
    public List<String> getTags() {
        return tags;
    }

    public int getViewCount() {
        return viewCount;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    private Post(PostBuilder postBuilder) {
        this.tags = postBuilder.tags;
        this.viewCount = postBuilder.viewCount;
        this.body = postBuilder.body;
        title = postBuilder.title;
    }

    public static class PostBuilder{
        private List<String> tags;
        private int viewCount;
        private String body;
        private String title;

        public PostBuilder setTags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public PostBuilder setViewCount(int viewCount) {
            this.viewCount = viewCount;
            return this;
        }

        public PostBuilder setBody(String body) {
            this.body = body;
            return this;
        }

        public PostBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Post createPost() {
            return new Post(this);
        }
    }
}
