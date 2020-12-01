import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class MainClient {

	public static void main(String[] args) {
		try {
			//Socket 객체를 생성하여 연결을 시도함
			//연결할 IP주소와 Port번호를 매개변수로 넘겨주어야 해당 주소로 연결함.
			Socket c_socket = new Socket("192.168.0.2", 8888);
			
			
			//만약 연결이 완료 되었다면 데이터를 스트림 형태로 받아와서 콘솔에 출력
			InputStream input_data = c_socket.getInputStream();
			
			byte[] receiveBuffer = new byte[100];
			input_data.read(receiveBuffer);
			
			System.out.println(new String(receiveBuffer));
			
			c_socket.close();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
