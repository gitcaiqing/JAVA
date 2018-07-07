package cq._10_IO.FileInputOrOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

/**
 * /*
 * 1.���ķ��ࣺ
 * ������������Ĳ�ͬ��������  �����
 * ���մ������ݵĵ�λ�Ĳ�ͬ���ֽ���  �ַ�����������ı��ļ���
 * ���ս�ɫ�Ĳ�ͬ���ڵ�����ֱ���������ļ��ģ�  ������
 * 
 * 2.IO����ϵ
 * �������			�ڵ������ļ�����                                ����������������һ�֣�
 * InputStream		FileInputStream			BufferedInputStream
 * OutputStream		FileOutputStream		BufferedOutputStream
 * Reader			FileReader				BufferedReader
 * Writer			FileWriter				BufferedWriter
 *
 * @author Administrator
 *
 */
public class TestFileInputStream {
	
	/**
	 * �ļ�������
	 * @throws IOException 
	 */
	@Test
	public void fileInputStream(){
		
		//2.�����ļ���������
		FileInputStream fis = null;
		try {
			//1.����һ��file����
			File file = new File("testFile22.txt");
			fis = new FileInputStream(file);
			//3.���ļ��ж�ȡ ���뵽������
			//ѭ�����ļ��ֽ� ���ֵΪ -1 ˵����ȡ���
			byte[] fileByte = new byte[5];
			
			int len;//ÿ�ζ��뵽fileByte�ĳ��� 5...2...
			while ((len = fis.read(fileByte)) != -1) {
				//��ȡ����һ
				/*for(int i=0; i<len; i++){
					System.out.print((char)fileByte[i]);
				}*/
				//��ȡ������
				String str = new String(fileByte, 0, len);
				System.out.print(str);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {fis.close();} catch (IOException e) {e.printStackTrace();}
		}
	}
	
	
	
	
	@Test
	public void readFile(){
		File file = new File("E://TEST/cqfiletest.txt");
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			byte[] b = new byte[512];
			int len = 0;
			while ( (len = fileInputStream.read(b)) != -1 ) {
				System.out.println(new String(b, 0, len));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(fileInputStream != null)	try {	fileInputStream.close();} catch (IOException e) {e.printStackTrace();}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}






















