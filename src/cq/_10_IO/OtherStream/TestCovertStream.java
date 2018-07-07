package cq._10_IO.OtherStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

/**
 * ת����
 * @author Administrator
 *
 */
public class TestCovertStream {

	
	/**
	 * ���룺�ַ����� ---> �ֽ���
	 * ���룺�ֽ��� ---> �ַ�����
	 */
	@Test
	public void convertStream(){
		
		File file1 = new File("buffered.txt");
		File file2 = new File("convertStream.txt");
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			//����
			//�ַ�����ת�ֽ���
			FileInputStream fis = new FileInputStream(file1);
			InputStreamReader isr = new InputStreamReader(fis, "GBK");
			br = new BufferedReader(isr);
			
			//����
			FileOutputStream fos = new FileOutputStream(file2);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
			bw = new BufferedWriter(osw);
			
			String str;
			while((str = br.readLine()) != null){
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(bw != null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
