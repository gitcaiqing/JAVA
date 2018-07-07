package cq._10_IO.File;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

public class TestFile {
	
	/**
	 * 路径：
	 * 绝对路径：包括盘符在内的完整的文件路径
	 * 相对路径：在当前文件目录下的文件的路径
	 */
	@Test
	public void testFile1(){
		//绝对路径
		//File file1 = new File("D:/ProjectsOfWorkspace/CqProject/2015CqWebProject/JAVA/src/cq/_10_IO/File/testFile.txt");
		//相对路径
		File file = new File("D:/File");
		File file1 = new File("/testFile1.txt");
		File file2 = new File("testFile2.txt");
		//file2重命名后的文件名 要事先不存在
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
		
		System.out.println(file1.exists());//文件是否存
		System.out.println(file1.canWrite());//文件是否可写
		System.out.println(file1.canRead());//文件是否只读
		System.out.println(file1.isFile());//文件是否是文件
		
		System.out.println(file2.exists());//文件是否存
		System.out.println(file2.length());
		System.out.println(new Date(file2.lastModified()));

		System.out.println(file.isDirectory());//是否是isDirectory
	
		
	
	}
	/**
	 * 测试文件创建
	 */
	@Test
	public void createFile() throws IOException{
		File fileNew = new File("E:/TESTfileNew.txt");
		fileNew.delete();
		if(!fileNew.exists()){
			boolean b = fileNew.createNewFile();
			System.out.println(b);
		}else{
			System.out.println("文件已存在");
		}
		
		//创建文件夹
		File file2 = new File("E:/TEST/file/fileNew2");
		if(!file2.exists()){
			System.out.println("文件已存在");
			
			//创建文件夹目录 如果无上级目录无法创建
			file2.mkdir();
			//如果无上级目录一并创建之
			file2.mkdirs();
			
			System.out.println("文件创建完成");
		}else{
			System.out.println("文件已存在");
		
		}
		System.out.println("list().............");
		File file3 = new File("E:\\TEST");
		//list 获取文件名 以字符串的形式
		String[] str3 = file3.list();
		System.out.println("str3:"+str3);
		for(int i=0; i<str3.length; i++){
			System.out.println(str3[i]);
		}
		
		//获取文件
		System.out.println("");
		System.out.println("listFiles().............");
		File file4 = new File("E:\\TEST");
		File[] fileArr4 = file4.listFiles();
		for(int y=0; y<fileArr4.length; y++){
			System.out.println("fileArr4:"+fileArr4[y].getName());
		}
		
	}
	
}
