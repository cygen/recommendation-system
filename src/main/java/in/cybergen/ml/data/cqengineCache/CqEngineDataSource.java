package in.cybergen.ml.data.cqengineCache;


import in.cybergen.ml.data.DataSource;
import in.cybergen.ml.models.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by vishnu on 19/2/15.
 */
public class CqEngineDataSource implements DataSource {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Override
    public void loadEntry(Post post) {
        
    }

    @Override
    public List<Post> getPostsForTag(String tag) {
        
        return null;
    }
}
