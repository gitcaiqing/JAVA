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
		//1.定义socket
		Socket socket = new Socket("127.0.0.1", 9999);
		FileInputStream fin = new FileInputStream(new File("1.jpg"));
		OutputStream os = socket.getOutputStream();
		//2.定义文件输入流
		byte[] b = new byte[1024];
		int len;
		while( (len = fin.read(b)) != -1 ){
			//3.定义输入流
		
			os.write(b, 0, len);
		}
		//4.声明信息发送完成
		socket.shutdownOutput();
		
		//5.接收服务端的响应
		InputStream in = socket.getInputStream();
		byte[] bin = new byte[1024];
		int lenIn;
		while( (lenIn = in.read(bin)) != -1 ){
			String str = new String(bin,0,lenIn);
			System.out.println("服务端响应信息："+str);
		}
		
		//关闭流
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
		System.out.println("收到来自于客户端"+socket.getInetAddress().getHostName()+"的图片");
		
		OutputStream os = socket.getOutputStream();
		os.write("你发送的图片我已收到".getBytes());
		
		os.close();
		fos.close();
		in.close();
		socket.close();
		serverSocket.close();
	}
}
























