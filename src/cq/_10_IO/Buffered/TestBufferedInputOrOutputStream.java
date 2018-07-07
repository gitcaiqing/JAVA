package cq._10_IO.Buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/*
 * �������			�ڵ������ļ�����                                  ����������������һ��,���������ļ�������Ч�ʣ�
 * InputStream		FileInputStream	 <-�����ֽ���ͼƬ����Ƶ��-> BufferedInputStream
 * OutputStream		FileOutputStream <-�����ֽ���ͼƬ����Ƶ��-> BufferedOutputStream  (flush())
 * Reader			FileReader       <-�����ı��ļ� �ַ���->    BufferedReader  (readLine())
 * Writer			FileWriter       <-�����ı��ļ� �ַ���->    BufferedWriter  (flush())
 */

//BufferedInputStream/OutputStreamЧ�ʸ���


public class TestBufferedInputOrOutputStream {
	@Test
	public void bufferInputOrOutputStream(){
	
		long start = System.currentTimeMillis();
		//1.�ṩ���������ļ�
		File file1 = new File("1.jpg");
		File file2 = new File("3.jpg");
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
	
		try {
			//2.������Ӧ�ýڵ���
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			//3.�������Ľڵ����Ķ�����Ϊ�βδ��ݸ��������Ĺ�������
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			//4.����ļ�
			byte[] b = new byte[1024];
			int len;
			while((len = bis.read(b)) != -1){
				bos.write(b, 0, len);
				bos.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bos != null){
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(bis != null){
			try {
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(fos != null){
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(fis != null){
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		long end = System.currentTimeMillis();
		long blank = (end - start);
		System.out.println("���ѵ�ʱ�䣺"+blank);
	}
	
}
