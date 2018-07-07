package cq._14_socket.tcp.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * 获取ip地址
 * ip地址 + 端口号 ---> 网络套接字
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
