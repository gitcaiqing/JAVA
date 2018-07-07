package cq._14_socket.udp.datagramSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramSocketServer {
	public static final int port = 30000;
	//定义接收网络数据的字节数组
	byte[] inBuff = new byte[4096];
	//定义以指定字节数组创建 组别接收数据的DatagramPacket对象
	private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);

	//定义发送数据报的DatagramPacket
	private DatagramPacket outPacket = null;
	//定义一个字符串数组 服务器发送该数组元素
	String toClientMsg = "响应数据报...";
	
	
	public void init() throws IOException{
		try {
			//创建socket
			DatagramSocket socket = new DatagramSocket(port);
			//接收数据
			socket.receive(inPacket);
			
			System.out.println(inBuff == inPacket.getData());
			System.out.println(inPacket.getData());
			System.out.println("server接收到的客户端发送的数据："+new String(inBuff, 0, inPacket.getLength()));
			
			//发送数据
			//1.数据
			byte[] sendData = toClientMsg.getBytes();
			System.out.println("server发送给客户端的sendData:"+sendData);
			//2.发送到客户端： 将 刚接收到DatagramPacket的源socketAddress作为目标地址创建DatagramPacket
			System.out.println("客户端地址："+inPacket.getSocketAddress());
			
			outPacket = new DatagramPacket(sendData, sendData.length, inPacket.getSocketAddress());
			socket.send(outPacket);
			
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("服务端start....");
		new DatagramSocketServer().init();
		System.out.println("服务端end....");
	}
	

	
}
