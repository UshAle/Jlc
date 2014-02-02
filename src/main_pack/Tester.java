package main_pack;

import java.io.File;
import java.io.IOException;

public class Tester {


	public static void main(String[] args) {
		File fil = new File("/home/ush/workspace/JLC/test.txt");
		try {
			fil.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cmd cmd =new Cmd();
		cmd.start("/",System.out);
	}

}