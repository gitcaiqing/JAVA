package cq._10_IO.Buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestBufferedReaderOrWriter {
	
	@Test
	public void bufferedReader(){
		File file1 = new File("buffered.txt");
		File file2 = new File("buffered2.txt");
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			fr = new FileReader(file1);
			fw = new FileWriter(file2);
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			//readLine()一行一行读
			String str = null;
			while(( str = br.readLine()) != null){
				//System.out.println(str);
				//bw.write(str + "\n");
				bw.write(str);
				//重新起一行
				bw.newLine();
				bw.flush();
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











