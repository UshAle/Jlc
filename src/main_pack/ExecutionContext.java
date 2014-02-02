package main_pack;

import java.io.File;
import java.io.PrintStream;


/**
 * Класс контекста исполнения
 * 
 */

public class ExecutionContext {
	private String current_folder;
	private PrintStream errorstrem;
	private Cmd cmd;

	public ExecutionContext(String folder, PrintStream es,Cmd c) {
		this.errorstrem = es;
		this.setFolder(folder);
		this.cmd = c;
	}
	
	public PrintStream gerErrorsteam(){
		return this.errorstrem;
	}

	public Cmd getCmd(){
		return this.cmd;
	}
	
	public void setFolder(String folder) {

		File fold = new File(folder);
		if (fold.exists()) {
			if (fold.isDirectory()) {
				this.current_folder = fold.getAbsolutePath();
			} else {
				errorstrem.println("Path not a directory");
			}
		} else {
			errorstrem.println("Directory doesn't exist");
		}
	}

	public String getFolder() {
		return this.current_folder;
	}
}
