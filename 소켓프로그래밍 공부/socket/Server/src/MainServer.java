import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

	public static void main(String[] args) {
		try { 
			
			//���� ���� ������ ��Ʈ �ѹ� ����
			ServerSocket s_socket = new ServerSocket(8888);
			
			//Ŭ���̾�Ʈ�� �ش� ��Ʈ�� ������ �õ��Ѵٸ� aceept�� ��⸦Ǯ��
			//Ŭ���̾�Ʈ�� �����Ű�� "Socket" Ŭ������ �����Ͽ� ��ȯ��.
			Socket c_socket = s_socket.accept();
			
			OutputStream output_data = c_socket.getOutputStream();
			
			String sendDataString = "Welcome to my Server";
			output_data.write(sendDataString.getBytes());
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}

}
