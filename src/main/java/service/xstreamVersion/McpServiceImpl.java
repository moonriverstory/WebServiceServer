package service.xstreamVersion;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import org.apache.log4j.Logger;
import pojo.FindVendorsResponse;
import pojo.ImportVendersResponse;
import pojo.VendorItemPojo;
import pojo.VendorSiteInfoItemPojo;
import service.McpService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(serviceName = "McpService", portName = "McpServicePort", endpointInterface = "service.McpService")
public class McpServiceImpl implements McpService {

    private static Logger logger = Logger.getLogger(McpServiceImpl.class);

    @Override
    public String update(String req) {
        logger.debug("update req: " + req);

        ImportVendersResponse response = new ImportVendersResponse();
        response.setReturnFlag("Y");
        response.setReturnMessage("success");
        response.setBoeHeaderId("654321");
        response.setBoeNum("2333");

        //设置json解析器
        XStream xStream = new XStream(new JettisonMappedXmlDriver());
        xStream.setMode(XStream.NO_REFERENCES);
        xStream.alias("response", response.getClass());//TODO 怎么忽略头名称字段呢？
        String respJson = xStream.toXML(response);
        logger.debug("update respJson: " + respJson);
        return respJson;
    }

    @Override
    public String find(String req) {

        logger.debug("find req: " + req);

        //创建应答消息
        FindVendorsResponse response = new FindVendorsResponse();

        response.setErrorFlag("Y");
        response.setErrorMessage("");
        response.setCurrent_PAGE("1");
        response.setPage_SIZE("10");
        response.setTotal_PAGE("1");

        response.setTotal_RECORD("1");

        List<VendorItemPojo> vendorList = new ArrayList<VendorItemPojo>();
        VendorItemPojo vendor1 = new VendorItemPojo();
        vendor1.setVendorId("123");
        vendor1.setVendorNumber("666");
        vendor1.setVendorName("hehe");
        vendor1.setVendorType("SYNC_EMPLOYEE");
        vendor1.setVendorEnabledFlag("Y");
        vendor1.setVatFLAG("?");
        vendor1.setVatRegistrationNum("778899");
        vendor1.setOrgcertNumber("5566");
        List<VendorSiteInfoItemPojo> vendorSiteInfo = new ArrayList<VendorSiteInfoItemPojo>();
        VendorSiteInfoItemPojo siteInfoItem1 = new VendorSiteInfoItemPojo();
        siteInfoItem1.setVendorSiteId("571");
        siteInfoItem1.setVendorSiteCode("hz");
        siteInfoItem1.setOrgId("cmc");
        siteInfoItem1.setInactiveDate("2100-01-01");
        siteInfoItem1.setBankAccountId("321654987");
        siteInfoItem1.setBankAccountNum("2");
        siteInfoItem1.setBankAccountName("cb");
        siteInfoItem1.setBankName("");
        siteInfoItem1.setBankBranchName("");
        siteInfoItem1.setEnabledFlag("");
        siteInfoItem1.setBankNo("");
        siteInfoItem1.setCpId("111");
        vendorSiteInfo.add(siteInfoItem1);
        vendor1.setVendorSiteInfo(vendorSiteInfo);
        vendorList.add(vendor1);
        response.setVendorList(vendorList);

        //设置json解析器
        XStream xStream = new XStream(new JettisonMappedXmlDriver());
//        XStream xStream = new XStream(new JsonHierarchicalStreamDriver()
//        {
//            public HierarchicalStreamWriter createWriter(Writer writer)
//            {
//                return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
//            }
//        });
        xStream.setMode(XStream.NO_REFERENCES);
        //TODO 怎么忽略头名称字段呢？
        xStream.alias("response", FindVendorsResponse.class);
        xStream.alias("vendorItem",VendorItemPojo.class);
        xStream.alias("vendorSiteInfoItem",VendorSiteInfoItemPojo.class);
        String respJson = xStream.toXML(response);
        logger.debug("find respJson: " + respJson);
        logger.debug("length" + respJson.length());
        logger.debug("indexOf" + respJson.indexOf(":"));
        logger.debug("lastIndexOf" + respJson.lastIndexOf("}"));
        respJson = respJson.substring(respJson.indexOf(":") + 1, respJson.lastIndexOf("}"));
        return respJson;
    }

}
