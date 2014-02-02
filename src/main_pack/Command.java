package main_pack;

import java.io.InputStream;

import java.io.PrintStream;


/**
 * Класс от которого будут наследоваться все команды.
 *
 */
public class Command implements Runnable {
	public void setPrint(PrintStream pr) {

	}

	public void setInput(InputStream pr) {

	}

	public void setErrorStream(PrintStream pr) {

	}

	public PrintStream getErrorStream() {
		return null;
	}

	public void setArgs(String[] args) {

	}

	public PrintStream getPrint() {
		return null;
	}

	public InputStream getInput() {
		return null;
	}

	public String[] getArgs() {
		return null;
	}

	public void run() {

	}

	public void setContext(ExecutionContext ctx) {

	}
	
	public ExecutionContext getContext(ExecutionContext ctx) {
		return null;
	}
}