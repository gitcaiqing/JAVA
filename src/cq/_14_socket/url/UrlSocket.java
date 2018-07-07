package cq._14_socket.url;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL 统一资源定位符 编程
 * @author Administrator
 *
 */
public class UrlSocket {
	
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://localhost:8080/examples/hello.txt?a=b");
		/*
		 *  public String getProtocol(  )     获取该URL的协议名
			public String getHost(  )           获取该URL的主机名
			public String getPort(  )            获取该URL的端口号
			public String getPath(  )           获取该URL的文件路径
			public String getFile(  )             获取该URL的文件名
			public String getRef(  )             获取该URL在文件中的相对位置
			public String getQuery(   )        获取该URL的查询名
		 */
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getPath());
		System.out.println(url.getFile());
		System.out.println(url.getRef());
		System.out.println(url.getQuery());
		System.out.println("");
		System.out.println("----------------------");
		System.out.println("");
		
		//开启输入流
		InputStream in = url.openStream();
		FileOutputStream fos = new FileOutputStream(new File("copyOfhello.txt"));
		//定义字节数组
		byte[] b =new byte[1024];
		int len;
		while( (len = (in.read(b)))!= -1){
			//通过文件输出流输出到本地
			fos.write(b,0,len);
		}
		fos.close();
		in.close();
		
	}
	
}
