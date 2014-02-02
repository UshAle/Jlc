package main_pack;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Core {

	/**
	 * Метод создаёт и запускает треды с соммандами
	 * 
	 * @param ll
	 *            Аргументы и названия комманд
	 * @param ctx
	 *            Контекст исполнения
	 */
	public static void doit(LinkedList<LinkedList<String>> ll,
			ExecutionContext ctx) {
		try {
			String name;
			String[] args;

			Configuration conf = new Configuration("files/commands.xml");
			InputStream in = System.in;
			PrintStream ps;
			PrintStream out;
			PrintStream es = ctx.gerErrorsteam();
			Command c = null;
			ExecutorService exse = Executors.newCachedThreadPool();
			LinkedList<String> iter;

			if (ll.get(ll.size() - 1).get(0).equals(">")) {
				File file = new File(ll.get(ll.size() - 1).get(1));
				ll.remove(ll.size() - 1);
				if (!file.exists()) {
					try {
						file.createNewFile();
						out = new PrintStream(file);
					} catch (IOException e) {
						es.println("Can't create a file");
						out = System.out;
					}
				} else {
					out = new PrintStream(file);
				}

			} else {
				out = System.out;
			}

			int i;
			for (i = 0; i < ll.size(); i++) {
				iter = ll.get(i);
				name = iter.get(0);
				iter.remove(0);
				args = Arrays.copyOf(iter.toArray(), iter.size(),
						String[].class);
				try {
					c = (Command) Class.forName(conf.getClassName(name))
							.newInstance();
				} catch (ClassNotFoundException e) {
					ctx.gerErrorsteam().println(
							"Command " + name + " doesn't exist");
					exse.shutdownNow();
					break;
				}

				c.setArgs(args);
				c.setErrorStream(es);
				c.setInput(in);
				if (i == ll.size() - 1) {
					c.setPrint(out);
				} else {

					in = new PipedInputStream();
					ps = new PrintStream(new PipedOutputStream(
							(PipedInputStream) in));
					c.setPrint(ps);
				}
				c.setContext(ctx);
				exse.execute(c);

			}
			exse.shutdown();
			while (!exse.isTerminated()) {

			}

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
