package file.processing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * https://www.tutorialspoint.com/java/java_files_io.htm
 * @author NZ-LENOVO
 *	TODO:
 *		Inputstreamből fájlba írás.
 *		jegyzetbe pár szóban meg kell emlékezni az input\output streamekről.
 */
public class StreamExample {

	private static String inputPath = System.getProperty("user.dir") + "\\src\\file\\input\\";
	private static String outputPath = System.getProperty("user.dir") + "\\src\\file\\output\\";
	
	/**
	 * Bájtszinten átmásolja egy fájl teljes tartalmát az input könyvtárból az output könyvtárba.
	 */
	public static void byteStreamExample(){
				
		try (FileInputStream inputStream = new FileInputStream(inputPath + "lorem.txt");
			 FileOutputStream outputStream = new FileOutputStream(outputPath + "lorem.txt")){
			int byteData;
			while ( (byteData = inputStream.read()) != -1) {
				System.out.println(byteData);
				outputStream.write(byteData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Átmásolja a fájl tartalmát egy másik fájlba, de ezúttal FileReader-t és FileWriter-t használva.
	 */
	public static void fileReaderAndWriterExample() {
		
		try (FileReader myFileReader = new FileReader(inputPath + "lorem.txt"); 
				FileWriter myFileWriter = new FileWriter(outputPath + "loremFileWriterOut.txt")) {
			int data;
			while ((data = myFileReader.read()) != -1) {
				System.out.println(data);
				myFileWriter.write(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Az inputStreamből kiolvassuk karakterenként az értékeket, majd kiírjuk az outputstreambe.
	 */
	public static void inputStreamReaderExample() {
		
		try(InputStreamReader myInputStreamReader = new InputStreamReader(System.in)){
			System.out.println("Enter characters, 'q' to quit");
			char c;
			do {
				c = (char) myInputStreamReader.read();
				System.out.print(c);
			} while(c != 'q');
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * fileOutput.txt-be kiír pár karaktert, majd fileOutput.txt tartalmát beolvassa és kiírja konzolra.
	 */
	public static void fileInputAndOutputStreamExample() {
		
		String fileLocation = outputPath + "\\fileOutput.txt";
		
		try(OutputStream myOutputStream = new FileOutputStream(fileLocation)){
			byte[] bWrite = {11,21,3,40,5};
			for(int x = 0; x < bWrite.length; x++) {
				myOutputStream.write(bWrite[x]);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		try(InputStream myInputStream = new FileInputStream(fileLocation)){
			int size = myInputStream.available();
			
			for(int i = 0; i < size; i++) {
				System.out.print((char)myInputStream.read() + " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
