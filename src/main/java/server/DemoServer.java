package server;

import org.apache.log4j.Logger;

import javax.xml.ws.Endpoint;

public class DemoServer {
    private static Logger logger = Logger.getLogger(DemoServer.class);

    public static void main(String[] args) {
        String addressFind = "http://localhost:7070/webservice/UpdateService";
        UpdateService service = new UpdateServiceImpl();

        Endpoint.publish(addressFind,service);
        logger.info("Server UpdateService start up ! WebService is published !");

        String addressUpdate = "http://localhost:7070/webservice/FindService";
        FindService serviceUpdate = new FindServiceImpl();

        Endpoint.publish(addressUpdate,serviceUpdate);
        logger.info("Server FindService start up ! WebService is published !");
    }
}
