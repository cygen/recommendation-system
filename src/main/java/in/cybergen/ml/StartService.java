package in.cybergen.ml;

import in.cybergen.ml.data.DataSource;
import in.cybergen.ml.data.cqengineCache.CqEngineDataSource;
import in.cybergen.ml.routes.BaseRoute;
import org.restexpress.RestExpress;
import org.restexpress.pipeline.SimpleConsoleLogMessageObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Recommendation System
 *
 */
public class StartService
{
    private static final Logger LOG = LoggerFactory.getLogger(StartService.class);
    private static final String SERVICE_NAME = "Recommendation Service";
    private static final int DEFAULT_EXECUTOR_THREAD_POOL_SIZE = 2;
    private static final int SERVER_PORT = 9009;
    private static final DataSource dataSource = new CqEngineDataSource();
    public static void main( String[] args )
    {
        LOG.info("Starting Application");
        String filePath="/home/vishnu/projects/ml-sample/ml-sample/src/main/resources/dataSource/arduino.stackexchange.com/Posts.xml";

        LoadFile.processFile(filePath,dataSource);

        LOG.info(" posts for arduino "+dataSource.getPostsForTag("arduino").size());

        RestExpress server = null;
        try {
            server = initializeServer(args);
            LOG.info("Awaiting Server Shutdown .......");
            server.awaitShutdown();
            LOG.info("Server Is Shutting Down .......");
        } catch (IOException e) {
            LOG.info(e.getMessage());
        }
        
    }

    public static RestExpress initializeServer(String[] args) throws IOException {
        RestExpress server = new RestExpress()
                .setName(SERVICE_NAME)
                .setBaseUrl("http://localhost:" + SERVER_PORT)
                .setExecutorThreadCount(DEFAULT_EXECUTOR_THREAD_POOL_SIZE)
                .addMessageObserver(new SimpleConsoleLogMessageObserver());
        BaseRoute.define(server,dataSource);
        server.bind(SERVER_PORT);
        return server;
    }
    
}
