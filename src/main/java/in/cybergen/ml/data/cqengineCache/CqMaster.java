package in.cybergen.ml.data.cqengineCache;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.gson.JsonObject;
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
    
    public static JsonObject getTagList(){
        JsonObject jsonObject = new JsonObject();
        for(String tag : weightedGraph.columnKeySet()){
            Long totalCount = 0l;
            for(AtomicLong counter : weightedGraph.row(tag).values()){
               totalCount = totalCount+counter.get();
             }
            jsonObject.addProperty(tag,totalCount);
        }
        return jsonObject;
    }
    
    public static void addPost(Post post){
        indexedPosts.add(post);
        ArrayList<String> tags = new ArrayList<String>(post.getTags());
        if(tags.size()>1){
            for(String outerTag :tags){
                for(String innerTag :tags){
                    if(weightedGraph.contains(outerTag, innerTag)){
                        weightedGraph.get(tags.get(0), tags.get(0)).incrementAndGet();                                    
                    }else{
                        weightedGraph.put(outerTag, innerTag,new AtomicLong(1L));
                    }
                }                    
            }
        }else if(tags.size()==1){
            if(weightedGraph.contains(tags.get(0), tags.get(0))){
                weightedGraph.get(tags.get(0), tags.get(0)).incrementAndGet();
            }else{
                weightedGraph.put(tags.get(0), tags.get(0),new AtomicLong(1L));
            }
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
