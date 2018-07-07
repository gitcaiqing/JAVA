package cq._10_IO.RandomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

/**
 * �������
 * �ȿ��Գ䵱һ����������Ҳ���Գ䵱�����
 * ֧�ִ�����λ�ö�ȡ����������
 * @author Administrator
 *
 */
public class TestRandomAccessFile {
	
	/**
	 * RandomAccessFile��Ϊ���������
	 */
	@Test
	public void randomAccessFile(){
		//�䵱�������������
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
	 * ����λ�ò�������
	 */
	@Test
	public void writeDateOfrandomAccessFile(){
		
		//1.����ɶ�д�ļ�
		RandomAccessFile rafi = null;
		try {
			rafi = new RandomAccessFile("random.txt", "rw");
			//2.ָ��ָ�����λ��
			rafi.seek(4);
			//���ֱ�ӽ�Ҫ�������ݲ�����4λ����Ὣԭ�������ݸ���
			//��Ҫ��ԭ����4��֮�������ȡ��
			byte[] b = new byte[20];
			int len;
			//�����ַ�������������С�����ݵĴ�С�ı�
			StringBuffer sbf = new StringBuffer();
			while((len = rafi.read(b)) != -1){
				sbf.append(new String(b, 0, len));
			}
			//ִ��������Ĳ��裬ָ��ָ������λ���轫������ָ��4λ��
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
























