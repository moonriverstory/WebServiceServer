package server;

import javax.jws.WebService;

@WebService
public interface UpdateService {

    /**
     *
     * @param req
     * @return
     */
    String update(String req);
}
