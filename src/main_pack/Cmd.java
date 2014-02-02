package main_pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;

/**
 * Класс реализующий командную строку.
 */
public class Cmd {
	private boolean active;

	
	public Cmd() {
		this.active = true;
	}

	public void start(String startFolder, PrintStream errorStr) {
		LinkedList<LinkedList<String>> ll;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ExecutionContext ec = new ExecutionContext(startFolder,errorStr,this);
		while (active) {
			try {
				System.out.print(ec.getFolder()+":");
				ll = Syntax.input(br.readLine());
				Core.doit(ll, ec);
//				this.active =false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void setAct(boolean b) {
		this.active = b;
	}

	public boolean getAct() {
		return this.active;
	}
}
