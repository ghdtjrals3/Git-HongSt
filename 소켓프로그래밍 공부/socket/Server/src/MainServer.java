import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

	public static void main(String[] args) {
		try { 
			
			//내가 만들 서버의 포트 넘버 설정
			ServerSocket s_socket = new ServerSocket(8888);
			
			//클라이언트가 해당 포트로 연결을 시도한다면 aceept는 대기를풀고
			//클라이언트와 연결시키는 "Socket" 클래스를 생성하여 반환함.
			Socket c_socket = s_socket.accept();
			
			OutputStream output_data = c_socket.getOutputStream();
			
			String sendDataString = "Welcome to my Server";
			output_data.write(sendDataString.getBytes());
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}

}
