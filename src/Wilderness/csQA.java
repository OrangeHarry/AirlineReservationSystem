package Wilderness;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class csQA {

	public void customercenter() throws IOException {
		int num = 0;
		boolean play = true;
		System.out.println(" 1. Ȩ���������� �̸� �¼��� ������ �� �ֳ���?\n " + "2. ���� ��� ��û, ����, ������ ��� �ؾ� �ϳ���?\n "
				+ "3. Ȩ���������� ���� ���ϸ����� �ջ��ϴ� ����� �˰� �;��\n " + "4. Ȩ���������� �¼� ������ ��𿡼� �� �� �ֳ���?\n "
				+ "5. ��ī���н� ���ϸ����� ����ϸ� � ���񽺳� ��ǰ�� �̿��� �� �ֳ���?\n " + "6. 1:1�����ϱ�\n" + " 0. ����\n");
		while (play) {
			try {
				Scanner sc = new Scanner(System.in);

				System.out.println();
				System.out.print("������ �������ּ���> ");
				num = sc.nextInt();

				switch (num) {

				case 1:

					System.out.println("1. Ȩ���������� �̸� �¼��� ������ �� �ֳ���?");
					System.out.println("��, �����մϴ�. �����װ� Ȩ������, ���� ����, ����, ���� �� ����縦 ���Ͽ� '�¼� ����'�� �� �� �ֽ��ϴ�. \n"
							+ "�ϵ �� ������Ƽ���� �°� : �װ��� ���� �� Ȥ�� ���� �� ��� ���� (��� 361�� ������ ��� 24�ð� ������) \n"
							+ "�Ϲݼ� �°� : �װ��� ���� ���� ���� (��� 361�� ������ ��� 48�ð� ������)");
					break;
				case 2:
					System.out.println("2. ���� ��� ��û, ����, ������ ��� �ؾ� �ϳ���?");
					System.out.println(
							"���� ����� ȸ�� ���ΰ� ����� �������� ���谡 ǥ�õ� 1�� �̳��� �������������� ÷���Ͽ� Ȩ������ [My > ���� ����] ���� ��û�� �� �ֽ��ϴ�.\n"
									+ "Ȥ�� ������Ͻ�û���� �������������� ����� �����װ� ���� �� ���� ���Ϳ� ������ ���� �ֽ��ϴ�. ��ϵ� ������ ���� �� ������ ������ ������� ��û�� �� �ֽ��ϴ�.");

					break;
				case 3:
					System.out.println("3. Ȩ���������� ���� ���ϸ����� �ջ��ϴ� ����� �˰� �;��.");
					System.out.println("���ϸ����� ������ ȸ���� Ȩ�������� �α��� �� [My > ���� ����] ���� ���ϸ����� ����� �������� �ջ� �����մϴ�.\n"
							+ "���� ����� ���� ���� ��� ���� ���� ����� ��û�� �ּ���.\n"
							+ "���ϸ����� ����� ȸ���� Ȩ�������� �α����ϸ� �ջ� ������ ������ �ܿ� ���ϸ����� Ȯ���� �� ������, ���ϸ����� �ջ��Ͽ� ���ʽ��� �߱��� �� �ֽ��ϴ�.");

					break;
				case 4:
					System.out.println("4. Ȩ���������� �¼� ������ ��𿡼� �� �� �ֳ���?");
					System.out.println("�װ��� ���� �� �Ǵ� ���� �Ϸ� �� �¼��� ������ �� �ֽ��ϴ�.\n"
							+ "�װ��� ���� �� Ȩ������ [MY > ���� ����] ���� ���� ��ȸ �� [�ΰ����� > �¼� ����] ���� �¼��� ������ �� �ֽ��ϴ�.");

					break;
				case 5:
					System.out.println("5. ��ī���н� ���ϸ����� ����ϸ� � ���񽺳� ��ǰ�� �̿��� �� �ֳ���?");
					System.out.println(
							"�����Ͻ� ��ī���н� ���ϸ����� �װ��� �߱޺��� ���޻� ���񽺱��� �پ��� ������� ����Ͻ� �� �ֽ��ϴ�. �����װ� ���ʽ� �װ��� �� �¼� �±� ���ʽ�, \n"
									+ "���� �װ��� ���ʽ� �װ��ǰ� �����װ��� ������ ���� ��ǰ (ȣ��, ����, �ʰ� ���Ϲ�, KAL ����� ���ʽ�, �񵿹� �Ҿ� ���� ������, KAL����� ��) �̿��� �����մϴ�.\n"
									+ "�����װ� Ȩ������ [��ī���н� > ���ϸ��� ���]��  [��ī���н� > ���ϸ��� ��]�� �湮���ּ���.");

					break;
				case 6:

					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					String str;

					System.out.print("������ �Է��Ͽ� �ּ��� >");

					str = br.readLine();
					// System.out.println(str);

					BufferedOutputStream bs = null;
					try {
						bs = new BufferedOutputStream(new FileOutputStream("C:\\Temp\\Q&A.txt"));

						bs.write(str.getBytes()); // Byte�����θ� ���� �� ����

					} catch (IOException e) {
						System.out.println("�߸��� �Է��Դϴ�. �ٽ� �����Ͽ� �ּ���");
						// e.getStackTrace();

					} finally {
						System.out.println("����ó���Ǿ����ϴ�. ");
						bs.close();
					}
					break;
				case 0:
					play = false;
//               sc.close();
				}
			} catch (Exception e) {
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��ϼ���.");
			}
		}
	}
}