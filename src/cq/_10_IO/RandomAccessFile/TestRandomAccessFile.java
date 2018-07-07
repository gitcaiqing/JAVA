package cq._10_IO.RandomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

/**
 * 随机访问
 * 既可以充当一个输入流，也可以充当输出流
 * 支持从任意位置读取、插入内容
 * @author Administrator
 *
 */
public class TestRandomAccessFile {
	
	/**
	 * RandomAccessFile作为输入输出流
	 */
	@Test
	public void randomAccessFile(){
		//充当输入流和输出流
		RandomAccessFile rafi = null;
		RandomAccessFile rafo = null;
		try {
			rafi = new RandomAccessFile("random.txt", "r");
			rafo = new RandomAccessFile("random2.txt", "rw");
			
			byte[] b = new byte[10];
			int len;
			while((len = rafi.read(b)) != -1){
				rafo.write(b, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rafo != null){
				try {
					rafo.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(rafi != null){
				try {
					rafi.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	/**
	 * 任意位置插入数据
	 */
	@Test
	public void writeDateOfrandomAccessFile(){
		
		//1.定义可读写文件
		RandomAccessFile rafi = null;
		try {
			rafi = new RandomAccessFile("random.txt", "rw");
			//2.指针指向插入位置
			rafi.seek(4);
			//如果直接将要插入内容插入在4位置则会将原来的数据覆盖
			//需要将原来的4及之后的数据取出
			byte[] b = new byte[20];
			int len;
			//定义字符串缓冲区，大小随内容的大小改变
			StringBuffer sbf = new StringBuffer();
			while((len = rafi.read(b)) != -1){
				sbf.append(new String(b, 0, len));
			}
			//执行完上面的步骤，指针指向最后的位置需将其重新指向4位置
			rafi.seek(4);
			rafi.write("_NEW_".getBytes());
			rafi.write(sbf.toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rafi != null){
				try {
					rafi.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}
}
























