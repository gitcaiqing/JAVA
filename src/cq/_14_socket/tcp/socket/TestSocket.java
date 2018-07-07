package cq._14_socket.tcp.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**TCP:�������Э��
 * Transmission Control Protocol
 * @author Administrator
 *
 */
public class TestSocket {
	
	/**
	 * �ͻ���
	 */
	@Test
	public void client(){
		
		Socket socket = null;
		OutputStream os = null;
		InputStream in = null;
		
		//1.����socket
		try {
			socket = new Socket(InetAddress.getLocalHost(), 9999);
			//1.1���������
			os = socket.getOutputStream();
			//1.2�������(��������ֽ�����)
			os.write("���ǿͻ���".getBytes());
			//1.3�������shutdownOutput() ��ʾ���߷������������
			socket.shutdownOutput();
			
			//2.1��ȡ��������Ӧ������
			byte[] b =new byte[20];
			in = socket.getInputStream();
			int len;
			while( ( len = in.read(b) ) != -1 ){
				String str = new String(b, 0, len);
				System.out.println("�������Ӧ���ͻ��ˣ�"+str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//3.�ر�
			try {in.close();} catch (IOException e) {e.printStackTrace();}
			try {os.close();} catch (IOException e) {e.printStackTrace();}
			try {socket.close();} catch (IOException e) {e.printStackTrace();}
		}
	}
	/**
	 * �����
	 */
	@Test
	public void server(){
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream in = null;
		OutputStream os = null;
		
		try {		
			//1.����ServerSocket
			serverSocket = new ServerSocket(9999);
			//2.��������serverSocket����socket;
			socket = serverSocket.accept();
			//3.1��ȡ������
			in = socket.getInputStream();
			//3.2.����ȡ�� �ͻ��˷���������Ϣ ��ӡ�ڿ���̨
			byte[] b = new byte[20];
			int len;
			
			while( (len = in.read(b)) != -1 ){
				String str = new String(b,0,len);
				System.out.println("������յ��ͻ��˵���Ϣ��"+str);
			}		
			//4.1��Ӧ��Ϣ���ͻ���
			os = socket.getOutputStream();
			os.write("�յ�������".getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{			
			try {os.close();} catch (IOException e) {e.printStackTrace();}
			try {in.close();} catch (IOException e) {e.printStackTrace();}
			try {socket.close();} catch (IOException e) {e.printStackTrace();}
			try {serverSocket.close();} catch (IOException e) {e.printStackTrace();}
		}		
	}
}
