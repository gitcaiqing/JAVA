package cq._14_socket.tcp.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * ��ȡip��ַ
 * ip��ַ + �˿ں� ---> �����׽���
 * @author Administrator
 *
 */
public class TestInetAddress {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress inet = null;
		try {
		//	inet = InetAddress.getByName("www.wx.91wego.com");
			inet = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.out.println("inet:"+inet);
	}

}
