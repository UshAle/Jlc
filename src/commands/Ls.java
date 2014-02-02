package commands;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;

import main_pack.Command;
import main_pack.ExecutionContext;

public class Ls extends Command{
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

	public void run() {
		String path;
		if(this.arg.length == 0){
			path = this.context.getFolder();
		}else{
			path = arg[0];
		}
		File dir = new File(path);
		if (dir.exists()) {
			if (dir.isDirectory()) {
				for(String s:dir.list()){
					this.pr.println(s);
				}
			} else {
				this.es.println("Path not a directory");
			}
		} else {
			this.es.println("Directory doesn't exist");
		}
		if (!pr.equals(System.out)) {
			pr.close();
		}
		// TODO Auto-generated catch block

	}
}
