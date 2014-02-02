package commands;

import java.io.InputStream;
import java.io.PrintStream;

import main_pack.Command;
import main_pack.ExecutionContext;

public class Exit extends Command{
	private PrintStream pr;
	private InputStream in;
	private PrintStream es;
	private String[] arg;
	private ExecutionContext con; 
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
		this.con=ctx;
	}
	
	public void run(){
		this.con.getCmd().setAct(false);
		if (!pr.equals(System.out)) {
			pr.close();
		}
	}
}
