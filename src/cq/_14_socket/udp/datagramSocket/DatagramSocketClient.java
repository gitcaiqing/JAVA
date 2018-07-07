package cq._14_socket.udp.datagramSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP  �û����ݱ�Э�飬
 * User Datagram Protocol
 * @author Administrator
 *
 */

public class DatagramSocketClient {
	//���巢�����ݰ���Ŀ�ĵ�ַ
	public static final int port = 30000;
	public static final String ip = "127.0.0.1";
	byte[] inBuff = new byte[4096];
	//��ָ�����ֽ����鴴��׼�������������ݵ��ֽ�����
	private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
	
	//����һ�����ڷ��͵�DatagramPacket����
	private DatagramPacket outPacket = null;
	
	public void init() throws IOException{
		try {
			//����һ���ͻ��˵�DatagramSocket��ʹ��Ĭ�ϵ�ַ,����˿�
			DatagramSocket socket = new DatagramSocket();
			
			//Ҫ���͵����ݱ��������Ŀ���ַ�Ͷ˿ں�
			outPacket = new DatagramPacket(new byte[0], 0, InetAddress.getByName(ip),port);
			//����¼��
			//Scanner scan = new Scanner(System.in);
			//while(scan.hasNextLine()){
				//ת������
			//	byte[] buff = scan.nextLine().getBytes();
			//	System.out.println(buff);
			//}
			String message = "client's message";
			byte[] buff = message.getBytes();
			//���÷����õ�DatagramPacket
			outPacket.setData(buff);
			//�������ݱ�
	System.out.println("client���͵�����˵����ݱ���"+outPacket);
			socket.send(outPacket);
		
		
			//��ȡSoket�е����ݣ����������ݷ���inPacket����װ���ֽ�������
			socket.receive(inPacket);
	System.out.println("client���շ���˵����ݱ���"+outPacket);

	System.out.println(new String(inBuff,0,inPacket.getLength()));
			
		} catch (SocketException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("�ͻ���start...");

		new DatagramSocketClient().init();
		
		System.out.println("�ͻ���end...");
	}
}


























