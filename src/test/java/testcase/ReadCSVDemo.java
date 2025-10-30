package testcase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVDemo {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File("C:\\Users\\praner\\eclipse-workspace\\HDFC5\\src\\test\\java\\testdata\\file1.csv");
			FileReader filereader = new FileReader(file);
			BufferedReader bf = new BufferedReader(filereader);
			String line = "";
			while ((line = bf.readLine()) != null) {
				String[] str = line.split(",");
				for (String s : str) {
					System.out.print(s + " ");
				}
				System.out.println();
				bf.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}