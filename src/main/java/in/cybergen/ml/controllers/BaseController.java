package in.cybergen.ml.controllers;

import com.google.gson.JsonArray;
import in.cybergen.ml.data.DataSource;
import in.cybergen.ml.models.Post;
import org.restexpress.Request;
import org.restexpress.Response;

import java.util.Set;

/**
 * Created by vishnu on 19/2/15.
 */
public class BaseController {
    private final DataSource dataSource;

    public BaseController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void getPostsForTag(Request request, Response response){
        String tag = request.getHeader("tag");
        Set<Post> posts = dataSource.getPostsForTag(tag);
        JsonArray postsJson = new JsonArray();
        for(Post post : posts){
            postsJson.add(post.toJsonObject());
        }
        response.setBody(postsJson);
        response.setContentType("application/json");
    }
    
    
}
