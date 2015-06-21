package test;

import javax.xml.namespace.QName;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options; 
import org.apache.axis2.rpc.client.RPCServiceClient;  
public class Testwebsercie {

	/**
	 * @param args
	 * @throws AxisFault
	 */
	public static void main(String[] args) throws AxisFault {
		// TODO Auto-generated method stub
		
		System.out.println(1111);

		// 使用RPC方式调用WebService
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		// 指定调用WebService的URL
		EndpointReference targetEPR = new EndpointReference(
				"http://localhost:8080/webservice1/services/TestService?wsdl");
		options.setTo(targetEPR);

		// 指定要调用的计算机器中的方法及WSDL文件的命名空间：edu.sjtu.webservice。
		QName opAddEntry = new QName("http://service.com", "add");// 加法
		// 指定plus方法的参数值为两个，分别是加数和被加数
		Object[] opAddEntryArgs = new Object[] { 1, 2222222};
		// 指定plus方法返回值的数据类型的Class对象
		Class[] classes = new Class[] { int.class };
		// 调用plus方法并输出该方法的返回值
		System.out.println(serviceClient.invokeBlocking(opAddEntry,
				opAddEntryArgs, classes)[0]);

	}

}
