package in.cybergen.ml.data.cqengineCache;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.MultiValueAttribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import in.cybergen.ml.models.Post;

import java.util.List;

/**
 * Created by vishnu on 19/2/15.
 */
public class PostData {
    List<String> tags ;
    int viewCount;
    String body;
    String title;

    public PostData(Post post) {
        this.tags = post.getTags();
        this.viewCount = post.getViewCount();
        this.body = post.getBody();
        title = post.getTitle();
    }
    public static final Attribute<PostData, String> USER_NAME = new SimpleAttribute<PostData, String>() {
        @Override
        public String getValue(PostData post) {
            return post.title;
        }
    };

}
