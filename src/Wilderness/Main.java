package Wilderness;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.mail.MessagingException;

public class Main {
	public static void main(String[] args) throws IOException, MessagingException, NullPointerException {
		System.out.print("┌──────────────────────────────────────────────────────────────────────┐\n"
				+ "|┌────────────────────────────────────────────────────────────────────┐|\n"
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
				+ "|└────────────────────────────────────────────────────────────────────┘|\n"
				+ "└──────────────────────────────────────────────────────────────────────┘\n");

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~[광야에 오신 여러분 환영합니다]~~~~~~~~");
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
				System.out.println("[1] 예약하기 [2] 예약 확인 [3]예약취소 [4] 문의하기[0]종료");
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
					System.out.println("안녕히계세요~");
					break;
				}
			} catch (IOException e) {
				System.out.println("잘못입력하였습니다. 다시 입력하세요");
				continue;
			} catch (NoSuchElementException ex) {
				System.out.println("예약내역이 없습니다");
				continue;

				// } catch(NullPointerException exx) {
				// System.out.println("예약내역이 없습니다.");2
				// }
			}
			// sc.close();
		}
	}
}
