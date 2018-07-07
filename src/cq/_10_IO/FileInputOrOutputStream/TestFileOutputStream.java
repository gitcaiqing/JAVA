package cq._10_IO.FileInputOrOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class TestFileOutputStream {
	@Test
	public void fileOutputStream(){
		File file = new File("helloFileOutPutStream.txt");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(new String("Hello OutputStream!!!").getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 文件复制
	 */
	@Test
	public void testFileCopy(){
		
		long start = System.currentTimeMillis();
		
		//1.定义一个输入文件
		File fileIs = new File("1.jpg");
		//File fileIs  = new File("helloFileOutPutStream.txt");
		//2.定义一个输出文件
		File fileOs = new File("4.jpg");
		//File fileOs = new File("copyOfFileIs.txt");
		//3.定义输入 输出流
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			
			//4读入流 输出流
			fis = new FileInputStream(fileIs);
			fos = new FileOutputStream(fileOs);
			
			byte[] b = new byte[20];
			int len;
			while((len = fis.read(b)) != -1){
				//5将输入流文件的内容读入输出流目标文件
				fos.write(b, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if( fos != null){ 
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if( fos != null){ 
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	
}















