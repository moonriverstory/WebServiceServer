package mcpDemo;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import pojo.ImportVendersResponse;

import javax.jws.WebService;

@WebService(serviceName = "SynPopVendorSrv", portName = "SynPopVendorSrvPort", endpointInterface = "mcpDemo.SynPopVendorSrv")
public class SynPopVendorSrvImpl implements SynPopVendorSrv {

    private static Logger logger = Logger.getLogger(SynPopVendorSrvImpl.class);

    @Override
    public String importVenders(String req) {
        logger.debug("update req: " + req);

        ImportVendersResponse response = new ImportVendersResponse();
        response.setReturnFlag("Y");
        response.setReturnMessage("success");
        response.setBoeHeaderId("654321");
        response.setBoeNum("2333");

        String respJson = JSON.toJSONString(response);
        logger.debug("update respJson: " + respJson);
        return respJson;
    }

}
