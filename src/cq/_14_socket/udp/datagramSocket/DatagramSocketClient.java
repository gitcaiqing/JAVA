package cq._14_socket.udp.datagramSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP  用户数据报协议，
 * User Datagram Protocol
 * @author Administrator
 *
 */

public class DatagramSocketClient {
	//定义发送数据包的目的地址
	public static final int port = 30000;
	public static final String ip = "127.0.0.1";
	byte[] inBuff = new byte[4096];
	//以指定的字节数组创建准备接收网络数据的字节数组
	private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
	
	//定义一个用于发送的DatagramPacket对象
	private DatagramPacket outPacket = null;
	
	public void init() throws IOException{
		try {
			//创建一个客户端的DatagramSocket，使用默认地址,随机端口
			DatagramSocket socket = new DatagramSocket();
			
			//要发送的数据报本身包含目标地址和端口号
			outPacket = new DatagramPacket(new byte[0], 0, InetAddress.getByName(ip),port);
			//键盘录入
			//Scanner scan = new Scanner(System.in);
			//while(scan.hasNextLine()){
				//转成数组
			//	byte[] buff = scan.nextLine().getBytes();
			//	System.out.println(buff);
			//}
			String message = "client's message";
			byte[] buff = message.getBytes();
			//设置发送用的DatagramPacket
			outPacket.setData(buff);
			//发送数据报
	System.out.println("client发送到服务端的数据报："+outPacket);
			socket.send(outPacket);
		
		
			//读取Soket中的数据，读到的数据放在inPacket所封装的字节数组中
			socket.receive(inPacket);
	System.out.println("client接收服务端的数据报："+outPacket);

	System.out.println(new String(inBuff,0,inPacket.getLength()));
			
		} catch (SocketException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("客户端start...");

		new DatagramSocketClient().init();
		
		System.out.println("客户端end...");
	}
}


























