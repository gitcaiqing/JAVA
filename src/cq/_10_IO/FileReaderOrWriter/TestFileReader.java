package cq._10_IO.FileReaderOrWriter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class TestFileReader {
	@Test
	public void fileReader(){
		File file = new File("testFileReader.txt");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			char[] c = new char[1024];
			int len;
			while((len = fr.read(c)) != -1){
				String str = new String(c, 0, len);
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}












