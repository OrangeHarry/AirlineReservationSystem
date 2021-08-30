package Wilderness;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Join {
	private Scanner sc;
	static Map<String, MemberMNG> memberMap;

	public Join() {
		memberMap = new HashMap<>();
		sc = new Scanner(System.in);
		// memberMap.put("admin", new MemberMNG("admin", "admin", "namju"));
	}

	// ����޼ҵ�
	public String run() {
		int key = 0;
		String id = null;
		while (true) {
			try {
				key = menu();
				switch (key) {
				case 1:
					id = Login();
					break;
				case 2:
					id = MemberJoin();
					break;
				case 0:
					System.out.println("~~~~~~~�߰���~~~~~~~���� �ؾ��~~~~~");
					System.exit(0);
					break;
				default:
					System.out.println("�߸��� �Է°��Դϴ�.�ٽ� �Է��ϼ���");
					continue;

				}
			} catch (Exception e) {
				System.out.println("�߸��Է��Ͽ����ϴ�. �ٽ� �Է��ϼ���");
				continue;
			}
			break;
		}

		return id;
	}

	// ȸ������
	private String MemberJoin() {
		// int count =0;
		String id;
		while (true) {
			id = getStrInput("              ID : ");
			if (memberMap.get(id) != null) {
				System.out.println("�ߺ��� ID�Դϴ�.");
				continue;
			}

			String pw = getStrInput("         PassWord : ");
			String pw2 = getStrInput("Password Confirm : ");

			// pw, pwcheck�� �������� Ȯ��
			if (pw.equals(pw2)) {
				String name = getStrInput("           Name : ");

				memberMap.put(id, new MemberMNG(id, pw, name));
				System.out.println(id + "�� ������ ���ϵ帳�ϴ�.");
				break;
				// ���� ui�� ������ ��
			} else {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. Ȯ�����ּ���.");
			}
		}
		return id;
	}

	private String Login() {
		String id = getStrInput("      ID : ");
		String pw = getStrInput("PassWord : ");

		if (!memberMap.containsKey(id)) {
			// System.out.println(member); //null
			System.out.println("��ϵ��� ���� ID�Դϴ�.");
			System.out.println("�ٽ� �Է����ֽðų� ȸ�������� ������ �ּ���");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			run();

		} else {
			// key ���־�
			// pw�� ��ġ�ϴ°��
			if (memberMap.get(id).getPW().equals(pw)) {
				System.out.println("[" + memberMap.get(id).getName() + "]�� ���� �α��� �ϼ̽��ϴ�.");
			} else { // pw �� ��ġ���� �ʴ� ���
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				pw = getStrInput("PassWord : ");
				if (memberMap.get(id).getPW().equals(pw)) {
					System.out.println("[" + memberMap.get(id).getName() + "]�� ���� �α��� �ϼ̽��ϴ�.");

				}

			}
		}
		return id;
	}

	// ������� �Է��� �޾��ִ� �޼ҵ�
	private String getStrInput(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}

	// �޴��� �޴����� ����� �Է±��� �޾ƿͼ� choice�� return
	private int menu() throws NumberFormatException {
		System.out.println("       [1]�α��� [2]ȸ������ [0]����");
		int choice = 0;
		choice = Integer.parseInt(sc.nextLine());
		return choice;
	}
}