package cq._10_IO.FileReaderOrWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestFileWriter {
	@Test
	public void fileReaderWriter(){
		File f1 = new File("testfileReader.txt");
		File f2 = new File("testfileWriter.txt");
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader(f1);
			fw = new FileWriter(f2);
			
			char[] c = new char[1024];
			int len;
			while((len = fr.read(c)) != -1){
				fw.write(c, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
}
