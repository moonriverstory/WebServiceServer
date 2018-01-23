package service;

import org.apache.log4j.Logger;

import javax.xml.ws.Endpoint;

public class McpServer {
    private static Logger logger = Logger.getLogger(McpServer.class);

    public static void main(String[] args) {
        String address = "http://localhost:7070/webservice/mcp";
        McpService service = new McpServiceImpl();

        Endpoint.publish(address,service);
        logger.debug("McpServer start up ! WebService is published !");
    }
}
