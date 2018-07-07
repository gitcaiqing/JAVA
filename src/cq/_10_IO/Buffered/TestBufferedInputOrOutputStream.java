package cq._10_IO.Buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/*
 * 抽象基类			节点流（文件流）                                  缓冲流（处理流的一种,可以提升文件操作的效率）
 * InputStream		FileInputStream	 <-处理字节流图片，视频等-> BufferedInputStream
 * OutputStream		FileOutputStream <-处理字节流图片，视频等-> BufferedOutputStream  (flush())
 * Reader			FileReader       <-处理文本文件 字符流->    BufferedReader  (readLine())
 * Writer			FileWriter       <-处理文本文件 字符流->    BufferedWriter  (flush())
 */

//BufferedInputStream/OutputStream效率更高


public class TestBufferedInputOrOutputStream {
	@Test
	public void bufferInputOrOutputStream(){
	
		long start = System.currentTimeMillis();
		//1.提供读入和输出文件
		File file1 = new File("1.jpg");
		File file2 = new File("3.jpg");
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
	
		try {
			//2.创建对应得节点流
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			//3.将创建的节点流的对象作为形参传递给缓冲流的构造器中
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			//4.输出文件
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
		System.out.println("花费的时间："+blank);
	}
	
}
