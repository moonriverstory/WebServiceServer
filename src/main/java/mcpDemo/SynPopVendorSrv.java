package mcpDemo;

import javax.jws.WebService;

@WebService
public interface SynPopVendorSrv {
    /**
     * SynPopVendorSrv-importVenders
     *
     * @param req
     * @return
     */
    String importVenders(String req);

}
