package Wilderness;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.mail.MessagingException;

public class Main {
	public static void main(String[] args) throws IOException, MessagingException, NullPointerException {
		System.out.print("������������������������������������������������������������������������������������������������������������������������������������������������\n"
				+ "|��������������������������������������������������������������������������������������������������������������������������������������������|\n"
				+ "||  # ###                                      ###     ##           * ||  \n"
				+ "|| ##  ##  ##       ##  ####  ##   ##    ####    ##   #     ####   *  ||\n"
				+ "||###      ##      ##  ## #  ###  ##   ##  ##    ## #     ## ##   *   ||\n"
				+ "||### ###  ##     ##  #####  #### ##  ##          ##      ## ##    *  ||\n"
				+ "||###  ##  ## #  ##  ##  ##  ## ####  ## ####     ##     ## ###     * ||\n"
				+ "|| ##  ##  ## # ##   ##  ##  ##  ###  ##   ##     ##     ##  ##       ||\n"
				+ "||  # ##   ## ####  ##   ##  ##   ##   ##  ##    ####   ##   ##       ||\n"
				+ "||         ##   ##  ##  ###  ##   ##    ####            ##  ###       ||\n"
				+ "||*                                                                   ||\n"
				+ "|| *     ##                     ####                                  ||	\n"
				+ "|   *   # #    ####    #####    ##        ####   ##   ##   ######     ||\n"
				+ "|| *   # ##     ##    ##   ##   ##         ##    ###  ##  ##          || \n"
				+ "||*   #  ##     ##    ##   ##   ##         ##    #### ##  ##          || \n"
				+ "||   # ####     ##    ## ###    ##   #     ##    ## ####  ####        || \n"
				+ "||   #   ##     ##    ##  ##    ##  ##     ##    ##  ###  ##          || \n"
				+ "||  ### ###     ##    ##   ##  #######     ##    ##   ##  ##          || \n"
				+ "||             ####   ##   ##             ####   ##   ##  #######     ||  \n"
				+ "|��������������������������������������������������������������������������������������������������������������������������������������������|\n"
				+ "������������������������������������������������������������������������������������������������������������������������������������������������\n");

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~[���߿� ���� ������ ȯ���մϴ�]~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		Join join = new Join();
		csQA cs = new csQA();
		Scanner sc = new Scanner(System.in);
		CustomerSign customer = new CustomerSign();
		ReservationFix rf = new ReservationFix();
		checkReservation cr = new checkReservation();
		ImplementsClass im = new ImplementsClass();
		SendEmail sm = new SendEmail();
		String id = null;

		boolean stop = true;
		id = join.run();

		while (stop) {
			try {
				System.out.println("[1] �����ϱ� [2] ���� Ȯ�� [3]������� [4] �����ϱ�[0]����");
				int menuNum = sc.nextInt();

				switch (menuNum) {
				case 1:
					rf.runReservation(id);
					customer.customerInformation(id);
					im.run(id);
					sm.mail(id);
					break;
				case 2:
					cr.check();
					break;
				case 3:
					cr.remov();
					break;
				case 4:
					cs.customercenter();
					break;

				case 0:
					stop = false;
					System.out.println("�ȳ����輼��~");
					break;
				}
			} catch (IOException e) {
				System.out.println("�߸��Է��Ͽ����ϴ�. �ٽ� �Է��ϼ���");
				continue;
			} catch (NoSuchElementException ex) {
				System.out.println("���೻���� �����ϴ�");
				continue;

				// } catch(NullPointerException exx) {
				// System.out.println("���೻���� �����ϴ�.");2
				// }
			}
			// sc.close();
		}
	}
}
