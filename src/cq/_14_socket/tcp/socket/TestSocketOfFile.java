package cq._14_socket.tcp.socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

public class TestSocketOfFile {
	@Test
	public void client() throws IOException{
		//1.����socket
		Socket socket = new Socket("127.0.0.1", 9999);
		FileInputStream fin = new FileInputStream(new File("1.jpg"));
		OutputStream os = socket.getOutputStream();
		//2.�����ļ�������
		byte[] b = new byte[1024];
		int len;
		while( (len = fin.read(b)) != -1 ){
			//3.����������
		
			os.write(b, 0, len);
		}
		//4.������Ϣ�������
		socket.shutdownOutput();
		
		//5.���շ���˵���Ӧ
		InputStream in = socket.getInputStream();
		byte[] bin = new byte[1024];
		int lenIn;
		while( (lenIn = in.read(bin)) != -1 ){
			String str = new String(bin,0,lenIn);
			System.out.println("�������Ӧ��Ϣ��"+str);
		}
		
		//�ر���
		in.close();
		os.close();
		fin.close();
		socket.close();
	}
	@Test
	public void server() throws IOException{
		
		ServerSocket serverSocket = new ServerSocket(9999);
		Socket socket = serverSocket.accept();
		InputStream in = socket.getInputStream();
		FileOutputStream fos = new FileOutputStream(new File("2.jpg"));
		byte[] b = new byte[1024];
		int len;
		while((len = in.read(b)) != -1){
			fos.write(b,0,len);
		}
		System.out.println("�յ������ڿͻ���"+socket.getInetAddress().getHostName()+"��ͼƬ");
		
		OutputStream os = socket.getOutputStream();
		os.write("�㷢�͵�ͼƬ�����յ�".getBytes());
		
		os.close();
		fos.close();
		in.close();
		socket.close();
		serverSocket.close();
	}
}
























