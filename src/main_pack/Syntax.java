package main_pack;

import java.util.LinkedList;
import java.util.Scanner;

public class Syntax {
	public static LinkedList<LinkedList<String>> input(String st){
		Scanner sc = new Scanner(st);
		sc.useDelimiter(">");
		if(sc.hasNext()) {
			String commands = sc.next();
			LinkedList<LinkedList<String>> ll = new LinkedList<>();
			String filename;
			if(sc.hasNext()) {
				String name = sc.next();
				Scanner sc2 = new Scanner(name);
				filename = sc2.next();
				sc2.close();
				if (sc.hasNext()) {
					sc.close();
					throw new IllegalArgumentException();
				}
			
//				System.out.println("file=["+file+"]");
				
			}else{
				filename = "";
//				System.out.println("file=[System.out]");
			}	
			sc.close();
			sc=new Scanner(commands);
			sc.useDelimiter("\\|");
			Scanner sc2;
		
			while(sc.hasNext()){
				sc2 = new Scanner(sc.next());
//				
//				System.out.print("com=["+sc2.next()+"] ");
				
//				while(sc2.hasNext()) System.out.print("arg=["+sc2.next()+"] " );
//				System.out.println();
				LinkedList<String> ls = new LinkedList<>();
				while(sc2.hasNext()) ls.addLast(sc2.next());
				ll.addLast(ls);
				sc2.close();
				
			}
			sc.close();
			if(filename.isEmpty()){
				return ll;
			}else {
				LinkedList<String> ls = new LinkedList<>();
				ls.addLast(">");
				ls.addLast(filename);
				ll.addLast(ls);
				return ll;
			}
		}else{
			sc.close();
			throw new IllegalArgumentException();
		}
		
	}
}
