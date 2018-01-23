package mcpDemo;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import pojo.FindVendorsResponse;
import pojo.VendorItemPojo;
import pojo.VendorSiteInfoItemPojo;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(serviceName = "SyncVendorsService", portName = "SyncVendorsServicePort", endpointInterface = "mcpDemo.SyncVendorsService")
public class SyncVendorsServiceImpl implements SyncVendorsService {

    private static Logger logger = Logger.getLogger(SyncVendorsServiceImpl.class);

    @Override
    public String findVendors(String req) {

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
        String respJson = JSON.toJSONString(response);

        logger.debug("find resp: " + respJson);

        return respJson;
    }

}
