package in.cybergen.ml.data.cqengineCache;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.googlecode.cqengine.CQEngine;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.index.hash.HashIndex;
import in.cybergen.ml.models.Post;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import static com.googlecode.cqengine.query.QueryFactory.contains;

/**
 * Created by vishnu on 19/2/15.
 */
public class CqMaster {
    private static IndexedCollection indexedPosts = CQEngine.newInstance();
    private static Table<String, String, AtomicLong> weightedGraph = HashBasedTable.create();
    
    public static void initialize() {
        indexedPosts.addIndex(HashIndex.onAttribute(PostData.ANSWER_COUNT));
        indexedPosts.addIndex(HashIndex.onAttribute(PostData.COMMENT_COUNT));
        indexedPosts.addIndex(HashIndex.onAttribute(PostData.FAVORITE_COUNT));
        indexedPosts.addIndex(HashIndex.onAttribute(PostData.ID));
        indexedPosts.addIndex(HashIndex.onAttribute(PostData.LAST_EDITOR_USER_ID));
        indexedPosts.addIndex(HashIndex.onAttribute(PostData.OWNER_USER_ID));
        indexedPosts.addIndex(HashIndex.onAttribute(PostData.SCORE));
        indexedPosts.addIndex(HashIndex.onAttribute(PostData.VIEW_COUNT));
        indexedPosts.addIndex(HashIndex.onAttribute(PostData.TAGS));
    }
    
    public static void addPost(Post post){
        indexedPosts.add(post);
        ArrayList<String> tags = new ArrayList<String>(post.getTags());
        if(tags.size()>1){
            for(String outerTag :tags){
                for(String innerTag :tags){
                    weightedGraph.get(outerTag,innerTag).incrementAndGet();
                }                    
            }
        }else if(tags.size()==1){
            weightedGraph.get(tags.get(0),tags.get(0)).incrementAndGet();
        }
    }
    public static Set<Post> getPostsWithTag(String tag) {
        Set<Post> posts = new HashSet<Post>();
        for (Object obj : indexedPosts.retrieve(contains(PostData.TAGS,tag))) {
            posts.add((Post) obj);
        }
        return posts;
    }
}
