package in.cybergen.ml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import in.cybergen.ml.data.DataSource;
import in.cybergen.ml.models.Post;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by vishnu on 19/2/15.
 */
public class LoadFile {
    private static final Logger LOG = LoggerFactory.getLogger(LoadFile.class);

    public static void processFile(String filePath,DataSource dataSource){
        SAXBuilder saxBuilder = new SAXBuilder();
        File xmlFile = new File(filePath);
        try {

            Document document = (Document) saxBuilder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List<Element> posts = rootNode.getChildren("row");
            LOG.info("total number of posts in file "+xmlFile.getName()+" is " + posts.size());
            for(int i=posts.size()-10;i<posts.size();i++){ Element post = posts.get(i);
                //for (Element post : posts) {
                try {
                    Post.PostBuilder postBuilder = new Post.PostBuilder();
                    postBuilder.setBody(post.getAttributeValue("Body"));
                    postBuilder.setTitle(post.getAttributeValue("Title"));
                    postBuilder.setViewCount(Integer.parseInt(post.getAttributeValue("ViewCount")));

                    String tagsString = post.getAttributeValue("Tags");
                    List<String> tags = new ArrayList<String>();
                    if(tagsString!=null) {
                        tagsString = tagsString.replaceAll("<", "");
                        for (String tag : tagsString.split(">")) {
                            if (!"".equals(tag)) {
                                tags.add(tag);
                            }
                        }
                    }
                    postBuilder.setTags(tags);

                    dataSource.loadEntry(postBuilder.createPost());
                }catch (Exception e){
                    LOG.debug(e.getMessage());                    
                }
            }

        } catch (IOException io) {
            LOG.error(io.getMessage());
        } catch (JDOMException jdomex) {
            LOG.error(jdomex.getMessage());
        }
    }
}
