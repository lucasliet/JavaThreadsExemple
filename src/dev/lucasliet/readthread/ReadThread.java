package dev.lucasliet.readthread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ReadThread implements Runnable {

	private String file;
	private String name;

	public ReadThread(String file, String name) {
		this.file = file;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			Scanner scan = new Scanner(new File(file));
			
			var lines = new HashMap<Integer, String>();
			
			int lineNumber = 1;
			
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				
				if (line.toLowerCase().contains(name))
					lines.put(lineNumber, line);
				
				lineNumber++;
			}
			
			if (!lines.isEmpty()) {
				final String[] result = {""};
				
				lines.forEach((key, value) -> {
					result[0]+= String.format("[ %16s - %3s - %-18s ]%n", file, key, value);
				});
				
				result[0]+=String.format("[ %32s %10s ]%n", "END " + Thread.currentThread().getName() , " ").replace(' ', '-');
				System.out.print(result[0]);
			}
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
	}

}
