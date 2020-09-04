package dev.lucasliet.readthread;

public class ReadNames {
	public static void main(String[] args) {
		String nome = "da";
		
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
