package cq._14_socket.url;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL ͳһ��Դ��λ�� ���
 * @author Administrator
 *
 */
public class UrlSocket {
	
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://localhost:8080/examples/hello.txt?a=b");
		/*
		 *  public String getProtocol(  )     ��ȡ��URL��Э����
			public String getHost(  )           ��ȡ��URL��������
			public String getPort(  )            ��ȡ��URL�Ķ˿ں�
			public String getPath(  )           ��ȡ��URL���ļ�·��
			public String getFile(  )             ��ȡ��URL���ļ���
			public String getRef(  )             ��ȡ��URL���ļ��е����λ��
			public String getQuery(   )        ��ȡ��URL�Ĳ�ѯ��
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
		
		//����������
		InputStream in = url.openStream();
		FileOutputStream fos = new FileOutputStream(new File("copyOfhello.txt"));
		//�����ֽ�����
		byte[] b =new byte[1024];
		int len;
		while( (len = (in.read(b)))!= -1){
			//ͨ���ļ���������������
			fos.write(b,0,len);
		}
		fos.close();
		in.close();
		
	}
	
}
