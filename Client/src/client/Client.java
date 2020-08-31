package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			System.out.println("Aguardando conexão...");
			Socket socket = new Socket("0.tcp.ngrok.io" , 13464);
			System.out.println("Conectado!");

			PrintStream output = new PrintStream(socket.getOutputStream());
			
			Scanner sc = new Scanner(System.in);
			
			
			while(true) {
				String mensagem = sc.nextLine();
				if(mensagem.equals("/sair")) {
					System.out.println("Você se desconectou.");
					break;
				}
				output.println(mensagem);
			}
			
			output.close();
			sc.close();
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
