package cq._14_socket.tcp.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**TCP:传输控制协议
 * Transmission Control Protocol
 * @author Administrator
 *
 */
public class TestSocket {
	
	/**
	 * 客户端
	 */
	@Test
	public void client(){
		
		Socket socket = null;
		OutputStream os = null;
		InputStream in = null;
		
		//1.创建socket
		try {
			socket = new Socket(InetAddress.getLocalHost(), 9999);
			//1.1创建输出流
			os = socket.getOutputStream();
			//1.2具体输出(输出的是字节数组)
			os.write("我是客户端".getBytes());
			//1.3发送完毕shutdownOutput() 显示告诉服务器发送完毕
			socket.shutdownOutput();
			
			//2.1获取服务器响应的内容
			byte[] b =new byte[20];
			in = socket.getInputStream();
			int len;
			while( ( len = in.read(b) ) != -1 ){
				String str = new String(b, 0, len);
				System.out.println("服务端响应给客户端："+str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//3.关闭
			try {in.close();} catch (IOException e) {e.printStackTrace();}
			try {os.close();} catch (IOException e) {e.printStackTrace();}
			try {socket.close();} catch (IOException e) {e.printStackTrace();}
		}
	}
	/**
	 * 服务端
	 */
	@Test
	public void server(){
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream in = null;
		OutputStream os = null;
		
		try {		
			//1.创建ServerSocket
			serverSocket = new ServerSocket(9999);
			//2.创建根据serverSocket创建socket;
			socket = serverSocket.accept();
			//3.1获取输入流
			in = socket.getInputStream();
			//3.2.将获取到 客户端发送来的信息 打印在控制台
			byte[] b = new byte[20];
			int len;
			
			while( (len = in.read(b)) != -1 ){
				String str = new String(b,0,len);
				System.out.println("服务端收到客户端的信息："+str);
			}		
			//4.1响应信息给客户端
			os = socket.getOutputStream();
			os.write("收到！！！".getBytes());
			
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
