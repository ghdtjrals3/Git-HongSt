import java.net.Socket;

public class MainClient {

	public static void main(String[] args) {
		try {
			//Socket 객체를 생성하여 연결을 시도함
			//연결할 IP주소와 Port번호를 매개변수로 넘겨주어야 해당 주소로 연결함.
			Socket c_socket = new Socket("192.168.0.2", 8888);
		}catch (Exception e) {
		}

	}

}
