package service;

import javax.jws.WebService;

@WebService
public interface McpService {
    /**
     * SynPopVendorSrv-importVenders
     *
     * @param req
     * @return
     */
    String update(String req);

    /**
     * syncVendorsService-findVendors
     *
     * @param req
     * @return
     */
    String find(String req);
}
