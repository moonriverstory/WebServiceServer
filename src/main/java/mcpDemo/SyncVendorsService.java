package mcpDemo;

import javax.jws.WebService;

@WebService
public interface SyncVendorsService {

    /**
     * syncVendorsService-findVendors
     *
     * @param req
     * @return
     */
    String findVendors(String req);
}
