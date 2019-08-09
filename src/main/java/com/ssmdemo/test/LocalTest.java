package com.ssmdemo.test;



import net.sf.json.JSONObject;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;
import java.rmi.RemoteException;


public class LocalTest {
    public static void main(String[] args) {
        String endpoint = "http://localhost:8081/wsServeice?wsdl";
        String result = "call failed!";
        Service service = new Service();
        Call call;
        try {
            call = (Call) service.createCall();
            call.setTargetEndpointAddress(endpoint);
            //new QName的URL是要指向的命名空间的名称，这个URL地址在你的wsdl打开后可以看到的，p
            //上面有写着targetNamespace="http://*.*.*/",这个就是你的命名空间值了;
            call.setOperationName(new QName("http://impl.example.com.demo.example.com/","sayHello")); // 调用的方法名
            // 设置参数名 :参数名（不能写具体参数名） ,参数类型:String, 参数模式：'IN' or 'OUT'
            call.addParameter("arg0",XMLType.XSD_STRING,ParameterMode.IN);
            call.setEncodingStyle("UTF-8");
            call.setReturnType(XMLType.XSD_STRING);
            result = (String) call.invoke(new Object[] {"牛博"});// 远程调用

        } catch (ServiceException e) {

        } catch (RemoteException e) {

        }
        System.out.println(result);
    }
}
