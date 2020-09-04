package dev.lucasliet.readthread;

import java.util.Scanner;

public class ReadNames {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o nome, ou parte do nome que deseja procurar nos arquivos:");
		String nome = scan.next();
		
		new Thread(
				new ReadThread("autores.txt", nome),
				"ReadNames Thread 1"
			).start();
		new Thread(
				new ReadThread("assinaturas1.txt", nome),
				"ReadNames Thread 2"
			).start();
		new Thread(
				new ReadThread("assinaturas2.txt", nome),
				"ReadNames Thread 3"
			).start();
	}
}
