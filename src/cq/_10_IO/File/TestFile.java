package cq._10_IO.File;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

public class TestFile {
	
	/**
	 * ·����
	 * ����·���������̷����ڵ��������ļ�·��
	 * ���·�����ڵ�ǰ�ļ�Ŀ¼�µ��ļ���·��
	 */
	@Test
	public void testFile1(){
		//����·��
		//File file1 = new File("D:/ProjectsOfWorkspace/CqProject/2015CqWebProject/JAVA/src/cq/_10_IO/File/testFile.txt");
		//���·��
		File file = new File("D:/File");
		File file1 = new File("/testFile1.txt");
		File file2 = new File("testFile2.txt");
		//file2����������ļ��� Ҫ���Ȳ�����
		File file3 = new File("testFile3.txt");
		System.out.println(file1.getAbsolutePath());
		System.out.println(file1.getName());
		System.out.println(file1.getPath());
		System.out.println(file1.getParent());
		System.out.println(file1.getAbsoluteFile());
		
		System.out.println(file2.getAbsolutePath());
		System.out.println(file2.getName());
		System.out.println(file2.getPath());
		System.out.println(file2.getParent());
		System.out.println(file2.getAbsoluteFile());
		
		//file2.renameTo(file3);
		
		System.out.println(file1.exists());//�ļ��Ƿ��
		System.out.println(file1.canWrite());//�ļ��Ƿ��д
		System.out.println(file1.canRead());//�ļ��Ƿ�ֻ��
		System.out.println(file1.isFile());//�ļ��Ƿ����ļ�
		
		System.out.println(file2.exists());//�ļ��Ƿ��
		System.out.println(file2.length());
		System.out.println(new Date(file2.lastModified()));

		System.out.println(file.isDirectory());//�Ƿ���isDirectory
	
		
	
	}
	/**
	 * �����ļ�����
	 */
	@Test
	public void createFile() throws IOException{
		File fileNew = new File("E:/TESTfileNew.txt");
		fileNew.delete();
		if(!fileNew.exists()){
			boolean b = fileNew.createNewFile();
			System.out.println(b);
		}else{
			System.out.println("�ļ��Ѵ���");
		}
		
		//�����ļ���
		File file2 = new File("E:/TEST/file/fileNew2");
		if(!file2.exists()){
			System.out.println("�ļ��Ѵ���");
			
			//�����ļ���Ŀ¼ ������ϼ�Ŀ¼�޷�����
			file2.mkdir();
			//������ϼ�Ŀ¼һ������֮
			file2.mkdirs();
			
			System.out.println("�ļ��������");
		}else{
			System.out.println("�ļ��Ѵ���");
		
		}
		System.out.println("list().............");
		File file3 = new File("E:\\TEST");
		//list ��ȡ�ļ��� ���ַ�������ʽ
		String[] str3 = file3.list();
		System.out.println("str3:"+str3);
		for(int i=0; i<str3.length; i++){
			System.out.println(str3[i]);
		}
		
		//��ȡ�ļ�
		System.out.println("");
		System.out.println("listFiles().............");
		File file4 = new File("E:\\TEST");
		File[] fileArr4 = file4.listFiles();
		for(int y=0; y<fileArr4.length; y++){
			System.out.println("fileArr4:"+fileArr4[y].getName());
		}
		
	}
	
}
