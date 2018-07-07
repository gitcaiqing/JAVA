package cq._10_IO.OtherStream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * 标准输入输出流
 * @author Administrator
 *
 */
public class TestStandardStream {

	/*
	 * 标准的输入输出流：
	 * 标准的输出流：System.out
	 * 标准的输入流：System.in
	 * 
	 * 题目：
	 * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，
	 * 直至当输入“e”或者“exit”时，退出程序。

	 */
	@Test
	public void standardStream(){
		BufferedReader br = null;
		try {
			//键盘输入流 
			//转换为字节流
			InputStreamReader isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			
			String str;
			while(true){
				System.out.println("请输入字符：");
				str = br.readLine();
				if(str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit")){
					break;
				}
				str = str.toUpperCase();
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}












