package cq._10_IO.OtherStream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * ��׼���������
 * @author Administrator
 *
 */
public class TestStandardStream {

	/*
	 * ��׼�������������
	 * ��׼���������System.out
	 * ��׼����������System.in
	 * 
	 * ��Ŀ��
	 * �Ӽ��������ַ�����Ҫ�󽫶�ȡ���������ַ���ת�ɴ�д�����Ȼ������������������
	 * ֱ�������롰e�����ߡ�exit��ʱ���˳�����

	 */
	@Test
	public void standardStream(){
		BufferedReader br = null;
		try {
			//���������� 
			//ת��Ϊ�ֽ���
			InputStreamReader isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			
			String str;
			while(true){
				System.out.println("�������ַ���");
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












