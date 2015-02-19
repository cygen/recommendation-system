package in.cybergen.ml.data;

import in.cybergen.ml.models.Post;

import java.util.List;

/**
 * Created by vishnu on 19/2/15.
 */
public interface DataSource {
    public void loadEntry(Post post);
    public List<Post> getPostsForTag(String tag);
}
