package Wilderness;

import java.util.Scanner;

public class CustomerSign {
	private Scanner sc;

	public CustomerSign() {
		sc = new Scanner(System.in);
	}

	// ������ ���� ���
	public void customerInformation(String id) {

		String gender;
		String email;
		String birth;

		MemberMNG mng = Join.memberMap.get(id);

		while (true) {
			try {
				System.out.println("\n==================================");
				System.out.println("������ ������ �Է����ּ���");
				System.out.print("������ �������ּ���(M or F) > \n");
				switch (gender = sc.nextLine()) {
				case "M":
					gender = "����";
					break;
				case "m":
					gender = "����";
					break;
				case "F":
					gender = "����";
					break;
				case "f":
					gender = "����";
					break;
				default:
					continue;
				}
				mng.setIsMan(gender);
				System.out.print("��������� 6�ڸ��� �Է����ּ��� (931126) > ");
				birth = (sc.nextLine());

				System.out.print("�̸����� �Է����ּ��� > ");
				email = (sc.nextLine());

				System.out.println("==================================");
				System.out.println("       ������ ������ Ȯ���Ͽ� �ֽʽÿ�");
				System.out.println("�̸�         : " + mng.getName());

				System.out.println("����         : " + gender);
				System.out.println("�������   : " + birth);
				System.out.println("�̸���      : " + email);
				System.out.println("==================================");
				System.out.println("  1.����        2.�ٽ� �ۼ�");
				System.out.print("���� >  ");

				switch (sc.nextInt()) {
				case 1:
					break;
				case 2:
					continue;
				case 3:
					break;
				}
				mng.setBirth(birth);
				mng.setEmail(email);

			} catch (Exception e) {
				System.out.println("�Է°��� �߸��Ǿ����ϴ�. �ٽ� �Է����ּ���");
				continue;
			}
			break;
		}
	}
}