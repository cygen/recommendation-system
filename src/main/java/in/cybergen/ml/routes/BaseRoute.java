package in.cybergen.ml.routes;

import in.cybergen.ml.controllers.BaseController;
import in.cybergen.ml.data.DataSource;
import org.jboss.netty.handler.codec.http.HttpMethod;
import org.restexpress.RestExpress;

/**
 * Created by vishnu on 19/2/15.
 */
public class BaseRoute {

    public static void define(RestExpress server, DataSource dataSource) {
        server.uri("/get/posts/for/tag/{tag}", new BaseController(dataSource)).action("getPostsForTag", HttpMethod.GET).noSerialization();
        server.uri("/get/tags/all", new BaseController(dataSource)).action("getAllTags", HttpMethod.GET).noSerialization();
    }
}
