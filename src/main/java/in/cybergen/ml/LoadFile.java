package in.cybergen.ml;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
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

    public static void processPostsFile(String filePath, DataSource dataSource){
        SAXBuilder saxBuilder = new SAXBuilder();
        File xmlFile = new File(filePath);
        try {

            Document document = (Document) saxBuilder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List<Element> posts = rootNode.getChildren("row");
            LOG.info("total number of posts in file "+xmlFile.getName()+" is " + posts.size());
            for (Element post : posts) {
                try {
                    Post.PostBuilder postBuilder = new Post.PostBuilder();
                    postBuilder.setAcceptedAnswerId(Long.parseLong(post.getAttributeValue("AcceptedAnswerId")!=null?post.getAttributeValue("AcceptedAnswerId"):"0"));
                    postBuilder.setAnswerCount(Long.parseLong(post.getAttributeValue("AnswerCount")!=null?post.getAttributeValue("AnswerCount"):"0"));
                    postBuilder.setCommentCount(Long.parseLong(post.getAttributeValue("CommentCount")!=null?post.getAttributeValue("CommentCount"):"0"));
                    postBuilder.setFavoriteCount(Long.parseLong(post.getAttributeValue("FavoriteCount")!=null?post.getAttributeValue("FavoriteCount"):"0"));
                    postBuilder.setId(Long.parseLong(post.getAttributeValue("Id")!=null?post.getAttributeValue("Id"):"0"));
                    postBuilder.setLastEditorUserId(Long.parseLong(post.getAttributeValue("LastEditorUserId")!=null?post.getAttributeValue("LastEditorUserId"):"0"));
                    postBuilder.setOwnerUserId(Long.parseLong(post.getAttributeValue("OwnerUserId")!=null?post.getAttributeValue("OwnerUserId"):"0"));
                    postBuilder.setPostTypeId(Long.parseLong(post.getAttributeValue("PostTypeId")!=null?post.getAttributeValue("PostTypeId"):"0"));
                    postBuilder.setScore(Long.parseLong(post.getAttributeValue("Score")!=null?post.getAttributeValue("Score"):"0"));
                    postBuilder.setViewCount(Long.parseLong(post.getAttributeValue("ViewCount")!=null?post.getAttributeValue("ViewCount"):"0"));

                    postBuilder.setBody(post.getAttributeValue("Body")!=null?post.getAttributeValue("Body"):"");
                    postBuilder.setCreationDate(post.getAttributeValue("CreationDate") != null ? post.getAttributeValue("CreationDate") : "");
                    postBuilder.setLastActivityDate(post.getAttributeValue("LastActivityDate") != null ? post.getAttributeValue("LastActivityDate") : "");
                    postBuilder.setLastEditDate(post.getAttributeValue("LastEditDate")!=null?post.getAttributeValue("LastEditDate"):"");
                    postBuilder.setTitle(post.getAttributeValue("Title")!=null?post.getAttributeValue("Title"):"");

                    String tagsString = post.getAttributeValue("Tags");
                    HashSet<String> tags = new HashSet<String>();
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
                    e.printStackTrace();
                    LOG.info("Exception Caught "+e.toString());
                }
            }

        } catch (IOException io) {
            LOG.error(io.getMessage());
        } catch (JDOMException jdomex) {
            LOG.error(jdomex.getMessage());
        }
    }
}
