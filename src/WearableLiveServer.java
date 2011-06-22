import java.net.*;
import java.io.*;

public class WearableLiveServer {
	
	public static void main(String[] args) throws IOException {
		System.out.println("IP Address: " + InetAddress.getLocalHost().getHostAddress());
		System.out.println("Port Number: 4444");
		
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(4444);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 4444");
			System.exit(1);
		}
		
		System.out.println("Waiting for client connection.....");
		
		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
			System.out.println("Connection from client succesful.");
		} catch (IOException e) {
			System.err.println("Connection from client has failed.");
			System.exit(1);
		}
		
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Input Message for Client: ");
		String data = null;
		
		try {
			data = input.readLine();
			out.println(data);
//			while((data = input.readLine())!= null) {
//				out.println(data);
//			}
		} catch (IOException ioe) {
			System.err.println("Error Reading User Input");
			System.exit(1);
		}
		
		
		
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}

}
