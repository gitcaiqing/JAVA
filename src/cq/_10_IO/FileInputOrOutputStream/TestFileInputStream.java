package cq._10_IO.FileInputOrOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

/**
 * /*
 * 1.流的分类：
 * 按照数据流向的不同：输入流  输出流
 * 按照处理数据的单位的不同：字节流  字符流（处理的文本文件）
 * 按照角色的不同：节点流（直接作用于文件的）  处理流
 * 
 * 2.IO的体系
 * 抽象基类			节点流（文件流）                                缓冲流（处理流的一种）
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
	 * 文件输入流
	 * @throws IOException 
	 */
	@Test
	public void fileInputStream(){
		
		//2.定义文件的输入流
		FileInputStream fis = null;
		try {
			//1.定义一个file对象
			File file = new File("testFile22.txt");
			fis = new FileInputStream(file);
			//3.从文件中读取 输入到程序中
			//循环该文件字节 如果值为 -1 说明读取完毕
			byte[] fileByte = new byte[5];
			
			int len;//每次读入到fileByte的长度 5...2...
			while ((len = fis.read(fileByte)) != -1) {
				//读取方法一
				/*for(int i=0; i<len; i++){
					System.out.print((char)fileByte[i]);
				}*/
				//读取方法二
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






















