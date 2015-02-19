package in.cybergen.ml.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vishnu on 19/2/15.
 */
public class Post {
    long acceptedAnswerId;
    long answerCount;
    long commentCount;
    long favoriteCount;
    long id;
    long lastEditorUserId;
    long ownerUserId;
    long postTypeId;
    long score;
    long viewCount;
    HashSet<String> tags;
    String body;
    String creationDate;
    String lastActivityDate;
    String lastEditDate;
    String title;
    
    public long getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public long getAnswerCount() {
        return answerCount;
    }

    public long getCommentCount() {
        return commentCount;
    }

    public long getFavoriteCount() {
        return favoriteCount;
    }

    public long getId() {
        return id;
    }

    public long getLastEditorUserId() {
        return lastEditorUserId;
    }

    public long getOwnerUserId() {
        return ownerUserId;
    }

    public long getPostTypeId() {
        return postTypeId;
    }

    public long getScore() {
        return score;
    }

    public long getViewCount() {
        return viewCount;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public String getBody() {
        return body;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getLastActivityDate() {
        return lastActivityDate;
    }

    public String getLastEditDate() {
        return lastEditDate;
    }

    public String getTitle() {
        return title;
    }

    private Post(PostBuilder postBuilder) {
        this.acceptedAnswerId = postBuilder.acceptedAnswerId;
        this.answerCount = postBuilder.answerCount;
        this.commentCount = postBuilder.commentCount;
        this.favoriteCount = postBuilder.favoriteCount;
        this.id = postBuilder.id;
        this.lastEditorUserId = postBuilder.lastEditorUserId;
        this.ownerUserId = postBuilder.ownerUserId;
        this.postTypeId = postBuilder.postTypeId;
        this.score = postBuilder.score;
        this.viewCount = postBuilder.viewCount;
        this.tags = postBuilder.tags;
        this.body = postBuilder.body;
        this.creationDate = postBuilder.creationDate;
        this.lastActivityDate = postBuilder.lastActivityDate;
        this.lastEditDate = postBuilder.lastEditDate;
        this.title = postBuilder.title;
    }



    public static class PostBuilder{
        private long acceptedAnswerId;
        private long answerCount;
        private long commentCount;
        private long favoriteCount;
        private long id;
        private long lastEditorUserId;
        private long ownerUserId;
        private long postTypeId;
        private long score;
        private long viewCount;
        private HashSet<String> tags;
        private String body;
        private String creationDate;
        private String lastActivityDate;
        private String lastEditDate;
        private String title;

        public PostBuilder setAcceptedAnswerId(long acceptedAnswerId) {
            this.acceptedAnswerId = acceptedAnswerId;
            return this;
        }

        public PostBuilder setAnswerCount(long answerCount) {
            this.answerCount = answerCount;
            return this;
        }

        public PostBuilder setCommentCount(long commentCount) {
            this.commentCount = commentCount;
            return this;
        }

        public PostBuilder setFavoriteCount(long favoriteCount) {
            this.favoriteCount = favoriteCount;
            return this;
        }

        public PostBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public PostBuilder setLastEditorUserId(long lastEditorUserId) {
            this.lastEditorUserId = lastEditorUserId;
            return this;
        }

        public PostBuilder setOwnerUserId(long ownerUserId) {
            this.ownerUserId = ownerUserId;
            return this;
        }

        public PostBuilder setPostTypeId(long postTypeId) {
            this.postTypeId = postTypeId;
            return this;
        }

        public PostBuilder setScore(long score) {
            this.score = score;
            return this;
        }

        public PostBuilder setViewCount(long viewCount) {
            this.viewCount = viewCount;
            return this;
        }

        public PostBuilder setTags(HashSet<String> tags) {
            this.tags = tags;
            return this;
        }

        public PostBuilder setBody(String body) {
            this.body = body;
            return this;
        }

        public PostBuilder setCreationDate(String creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public PostBuilder setLastActivityDate(String lastActivityDate) {
            this.lastActivityDate = lastActivityDate;
            return this;
        }

        public PostBuilder setLastEditDate(String lastEditDate) {
            this.lastEditDate = lastEditDate;
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
    @Override
    public String toString(){
          return "Post Data \n"+
                  "AcceptedAnswerId : "+acceptedAnswerId+",\n"+
                  "AnswerCount : "+answerCount+",\n"+
                  "CommentCount : "+commentCount+",\n"+
                  "FavoriteCount : "+favoriteCount+",\n"+
                  "Id : "+id+",\n"+
                  "LastEditorUserId : "+lastEditorUserId+",\n"+
                  "OwnerUserId : "+ownerUserId+",\n"+
                  "PostTypeId : "+postTypeId+",\n"+
                  "Score : "+score+",\n"+
                  "ViewCount : "+viewCount+",\n"+
                  "Tags : "+tags+",\n"+
                  "Body : "+body+",\n"+
                  "CreationDate : "+creationDate+",\n"+
                  "LastActivityDate : "+lastActivityDate+",\n"+
                  "LastEditDate : "+lastEditDate+",\n"+
                  "Title : "+title+",\n";
    }
    public JsonObject toJsonObject(){
        JsonObject json = new JsonObject();
        json.addProperty("acceptedAnswerId", acceptedAnswerId);
        json.addProperty("answerCount",answerCount);
        json.addProperty("commentCount",commentCount);
        json.addProperty("favoriteCount",favoriteCount);
        json.addProperty("id",id);
        json.addProperty("lastEditorUserId",lastEditorUserId);
        json.addProperty("ownerUserId",ownerUserId);
        json.addProperty("postTypeId",postTypeId);
        json.addProperty("score",score);
        json.addProperty("viewCount",viewCount);
        json.addProperty("body",body);
        json.addProperty("creationDate",creationDate);
        json.addProperty("lastActivityDate",lastActivityDate);
        json.addProperty("lastEditDate",lastEditDate);
        json.addProperty("title",title);
        JsonArray tagsArray = new JsonArray();
        for(String tag : tags){
            tagsArray.add(new JsonPrimitive(tag));
        }
        json.add("tags",tagsArray);
        return json;
    } 
}
