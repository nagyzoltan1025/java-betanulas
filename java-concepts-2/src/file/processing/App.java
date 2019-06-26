package file.processing;

import java.io.File;


public class App {

	public static void main(String[] args) {
		
		StreamExample.fileInputAndOutputStreamExample();
		StreamExample.inputStreamReaderExample();
		StreamExample.fileReaderAndWriterExample();
		StreamExample.byteStreamExample();
		
		FileHandlingExamples.listingDirectories();
		FileHandlingExamples.printPathsInfoExample();
		FileHandlingExamples.createFolderAndFileTest();
		FileHandlingExamples.fileConstructorTest();
	}
	
	
	public static void createSubfolders(int n, File folder) {
		for(int i = 0; i < n; i++) {
			File subfolder = new File(folder, "\\Subfolder" + i);
			subfolder.mkdir();
			System.out.println(subfolder.getPath());
		}
	}
	
	public static void createSubfoldersInSubfolder(int n, File folder) {
		if (n == 0) {
			folder.mkdir();
			System.out.println(folder.getPath());
		} else {
			folder.mkdir();
			System.out.println(folder.getPath());
			App.createSubfoldersInSubfolder(n-1, new File(folder, "\\RecurseFolder" + (n-1)));
		}
	}
	
	
}
