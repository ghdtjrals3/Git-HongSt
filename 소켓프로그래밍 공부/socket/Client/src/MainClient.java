import java.net.Socket;

public class MainClient {

	public static void main(String[] args) {
		try {
			//Socket ��ü�� �����Ͽ� ������ �õ���
			//������ IP�ּҿ� Port��ȣ�� �Ű������� �Ѱ��־�� �ش� �ּҷ� ������.
			Socket c_socket = new Socket("192.168.0.2", 8888);
		}catch (Exception e) {
		}

	}

}
