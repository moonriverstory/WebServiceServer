package service.demo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService(targetNamespace = "http://127.0.0.1:7070/jdk")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class HelloService {

    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:7070/jdk", new HelloService());
    }

    @WebMethod
    public String sayHello() {
        System.out.println("hello--server");
        return "hello";
    }
}