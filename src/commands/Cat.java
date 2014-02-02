package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import main_pack.Command;
import main_pack.ExecutionContext;

public class Cat extends Command{
	private PrintStream pr;
	private InputStream in;
	private PrintStream es;
	private String[] arg;
	private ExecutionContext context;

	// private String res;
	public void setPrint(PrintStream print) {
		pr = print;
	}

	public void setErrorStream(PrintStream pr) {
		this.es = pr;
	}

	public PrintStream getErrorStream() {
		return this.es;
	}

	public void setInput(InputStream input) {
		in = input;
	}

	public void setArgs(String[] args) {
		arg = args;
	}

	public PrintStream getPrint() {
		return pr;
	}

	public String[] getArgs() {
		return arg;
	}

	public InputStream getInput() {
		return in;
	}

	public void setContext(ExecutionContext ctx) {
		this.context = ctx;
	}
	
	public ExecutionContext getContext(ExecutionContext ctx) {
		return this.context;
	}

	public void run() {
		String path;
		if(this.arg.length == 0){
			path = "";
		}else{
			path = arg[0];
		}
		File fil = new File(path);
		if (fil.exists()) {
			if (fil.canRead()) {
				try {
					BufferedReader br = new BufferedReader(new FileReader(fil));
					String line ="";
					while (line != null) {
			            line = br.readLine();
			            pr.println(line);
			        }
					br.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				this.es.println("Can not read the file");
			}
		} else {
			this.es.println("File "+arg[0]+" doesn't exist");
		}
		if (!pr.equals(System.out)) {
			pr.close();
		}
		// TODO Auto-generated catch block

	}
}
