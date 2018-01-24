package server;

import javax.jws.WebService;

@WebService
public interface FindService {
    /**
     *
     * @param req
     * @return
     */
    String find(String req);

}
