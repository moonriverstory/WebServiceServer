package mcpDemo;

import org.apache.log4j.Logger;

import javax.xml.ws.Endpoint;

public class McpDemoServer {
    private static Logger logger = Logger.getLogger(McpDemoServer.class);

    public static void main(String[] args) {
        String addressFind = "http://localhost:7070/webservice/SyncVendorsService";
        SyncVendorsService service = new SyncVendorsServiceImpl();

        Endpoint.publish(addressFind,service);
        logger.info("McpServer SyncVendorsService start up ! WebService is published !");

        String addressUpdate = "http://localhost:7070/webservice/SynPopVendorSrv";
        SynPopVendorSrv serviceUpdate = new SynPopVendorSrvImpl();

        Endpoint.publish(addressUpdate,serviceUpdate);
        logger.info("McpServer SynPopVendorSrv start up ! WebService is published !");
    }
}
