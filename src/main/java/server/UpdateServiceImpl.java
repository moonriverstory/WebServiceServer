package server;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import pojo.FindVendorsResponse;
import pojo.ImportVendersResponse;
import pojo.VendorItemPojo;
import pojo.VendorSiteInfoItemPojo;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(serviceName = "UpdateService", portName = "UpdateServicePort", endpointInterface = "server.UpdateService")
public class UpdateServiceImpl implements UpdateService {

    private static Logger logger = Logger.getLogger(UpdateServiceImpl.class);

    @Override
    public String update(String req) {
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
