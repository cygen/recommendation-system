package in.cybergen.ml;

import in.cybergen.ml.data.DataSource;
import in.cybergen.ml.data.cqengineCache.CqEngineDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App
{
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        LOG.info("Starting Application");
        String filePath="/home/vishnu/projects/ml-sample/ml-sample/src/main/resources/dataSource/arduino_Posts.xml";

        DataSource dataSource = new CqEngineDataSource();
        LoadFile.processFile(filePath,dataSource);

    }
}
