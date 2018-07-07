package cq._14_socket.udp.datagramSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramSocketServer {
	public static final int port = 30000;
	//��������������ݵ��ֽ�����
	byte[] inBuff = new byte[4096];
	//������ָ���ֽ����鴴�� ���������ݵ�DatagramPacket����
	private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);

	//���巢�����ݱ���DatagramPacket
	private DatagramPacket outPacket = null;
	//����һ���ַ������� ���������͸�����Ԫ��
	String toClientMsg = "��Ӧ���ݱ�...";
	
	
	public void init() throws IOException{
		try {
			//����socket
			DatagramSocket socket = new DatagramSocket(port);
			//��������
			socket.receive(inPacket);
			
			System.out.println(inBuff == inPacket.getData());
			System.out.println(inPacket.getData());
			System.out.println("server���յ��Ŀͻ��˷��͵����ݣ�"+new String(inBuff, 0, inPacket.getLength()));
			
			//��������
			//1.����
			byte[] sendData = toClientMsg.getBytes();
			System.out.println("server���͸��ͻ��˵�sendData:"+sendData);
			//2.���͵��ͻ��ˣ� �� �ս��յ�DatagramPacket��ԴsocketAddress��ΪĿ���ַ����DatagramPacket
			System.out.println("�ͻ��˵�ַ��"+inPacket.getSocketAddress());
			
			outPacket = new DatagramPacket(sendData, sendData.length, inPacket.getSocketAddress());
			socket.send(outPacket);
			
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("�����start....");
		new DatagramSocketServer().init();
		System.out.println("�����end....");
	}
	

	
}
