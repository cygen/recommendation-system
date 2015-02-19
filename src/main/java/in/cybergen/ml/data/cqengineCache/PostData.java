package in.cybergen.ml.data.cqengineCache;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import in.cybergen.ml.models.Post;

/**
 * Created by vishnu on 19/2/15.
 */
public class PostData {

    public static final Attribute<Post ,Long> ACCEPTED_ANSWER_ID = new SimpleAttribute<Post ,Long>(){
        @Override
        public Long getValue(Post post){
            return post.getAcceptedAnswerId();
        }
    };
    public static final Attribute<Post ,Long> ANSWER_COUNT = new SimpleAttribute<Post ,Long>(){
        @Override
        public Long getValue(Post post){
            return post.getAnswerCount();
        }
    };
    public static final Attribute<Post ,Long> COMMENT_COUNT = new SimpleAttribute<Post ,Long>(){
        @Override
        public Long getValue(Post post){
            return post.getCommentCount();
        }
    };
    public static final Attribute<Post ,Long> FAVORITE_COUNT = new SimpleAttribute<Post ,Long>(){
        @Override
        public Long getValue(Post post){
            return post.getFavoriteCount();
        }
    };
    public static final Attribute<Post ,Long> ID = new SimpleAttribute<Post ,Long>(){
        @Override
        public Long getValue(Post post){
            return post.getId();
        }
    };
    public static final Attribute<Post ,Long> LAST_EDITOR_USER_ID = new SimpleAttribute<Post ,Long>(){
        @Override
        public Long getValue(Post post){
            return post.getLastEditorUserId();
        }
    };
    public static final Attribute<Post ,Long> OWNER_USER_ID = new SimpleAttribute<Post ,Long>(){
        @Override
        public Long getValue(Post post){
            return post.getOwnerUserId();
        }
    };
    public static final Attribute<Post ,Long> POST_TYPE_ID = new SimpleAttribute<Post ,Long>(){
        @Override
        public Long getValue(Post post){
            return post.getPostTypeId();
        }
    };
    public static final Attribute<Post ,Long> SCORE = new SimpleAttribute<Post ,Long>(){
        @Override
        public Long getValue(Post post){
            return post.getScore();
        }
    };
    public static final Attribute<Post ,Long> VIEW_COUNT = new SimpleAttribute<Post ,Long>(){
        @Override
        public Long getValue(Post post){
            return post.getViewCount();
        }
    };


    public static final Attribute<Post ,String> TAGS = new SimpleAttribute<Post ,String>(){
        @Override
        public String getValue(Post post){
            return post.getTags().toString();
        }
    };
    public static final Attribute<Post ,String> BODY = new SimpleAttribute<Post ,String>(){
        @Override
        public String getValue(Post post){
            return post.getBody();
        }
    };
    public static final Attribute<Post ,String> CREATION_DATE = new SimpleAttribute<Post ,String>(){
        @Override
        public String getValue(Post post){
            return post.getCreationDate();
        }
    };
    public static final Attribute<Post ,String> LAST_ACTIVITY_DATE = new SimpleAttribute<Post ,String>(){
        @Override
        public String getValue(Post post){
            return post.getLastActivityDate();
        }
    };
    public static final Attribute<Post ,String> LAST_EDIT_DATE = new SimpleAttribute<Post ,String>(){
        @Override
        public String getValue(Post post){
            return post.getLastEditDate();
        }
    };
    public static final Attribute<Post ,String> TITLE = new SimpleAttribute<Post ,String>(){
        @Override
        public String getValue(Post post){
            return post.getTitle();
        }
    };
    
}
