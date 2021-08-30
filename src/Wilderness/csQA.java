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
		System.out.println(" 1. 홈페이지에서 미리 좌석을 선택할 수 있나요?\n " + "2. 가족 등록 신청, 변경, 삭제는 어떻게 해야 하나요?\n "
				+ "3. 홈페이지에서 가족 마일리지를 합산하는 방법을 알고 싶어요\n " + "4. 홈페이지에서 좌석 선택은 어디에서 할 수 있나요?\n "
				+ "5. 스카이패스 마일리지를 사용하면 어떤 서비스나 상품을 이용할 수 있나요?\n " + "6. 1:1문의하기\n" + " 0. 종료\n");
		while (play) {
			try {
				Scanner sc = new Scanner(System.in);

				System.out.println();
				System.out.print("질문을 선택해주세요> ");
				num = sc.nextInt();

				switch (num) {

				case 1:

					System.out.println("1. 홈페이지에서 미리 좌석을 선택할 수 있나요?");
					System.out.println("네, 가능합니다. 대한항공 홈페이지, 서비스 센터, 지점, 공항 및 여행사를 통하여 '좌석 배정'을 할 수 있습니다. \n"
							+ "일등석 및 프레스티지석 승객 : 항공권 예약 시 혹은 구매 후 모두 가능 (출발 361일 전부터 출발 24시간 전까지) \n"
							+ "일반석 승객 : 항공권 구매 이후 가능 (출발 361일 전부터 출발 48시간 전까지)");
					break;
				case 2:
					System.out.println("2. 가족 등록 신청, 변경, 삭제는 어떻게 해야 하나요?");
					System.out.println(
							"가족 등록은 회원 본인과 등록할 가족과의 관계가 표시된 1년 이내의 가족증빙서류를 첨부하여 홈페이지 [My > 나의 가족] 에서 신청할 수 있습니다.\n"
									+ "혹은 가족등록신청서와 가족증빙서류를 가까운 대한항공 지점 및 서비스 센터에 제출할 수도 있습니다. 등록된 가족의 변경 및 삭제도 동일한 방법으로 신청할 수 있습니다.");

					break;
				case 3:
					System.out.println("3. 홈페이지에서 가족 마일리지를 합산하는 방법을 알고 싶어요.");
					System.out.println("마일리지를 제공할 회원이 홈페이지에 로그인 후 [My > 나의 가족] 에서 마일리지를 사용할 가족에게 합산 동의합니다.\n"
							+ "가족 등록이 되지 않은 경우 먼저 가족 등록을 신청해 주세요.\n"
							+ "마일리지를 사용할 회원이 홈페이지에 로그인하면 합산 동의한 가족의 잔여 마일리지를 확인할 수 있으며, 마일리지를 합산하여 보너스를 발급할 수 있습니다.");

					break;
				case 4:
					System.out.println("4. 홈페이지에서 좌석 선택은 어디에서 할 수 있나요?");
					System.out.println("항공권 예매 중 또는 구매 완료 후 좌석을 선택할 수 있습니다.\n"
							+ "항공권 구매 후 홈페이지 [MY > 나의 여행] 에서 예약 조회 후 [부가서비스 > 좌석 배정] 에서 좌석을 선택할 수 있습니다.");

					break;
				case 5:
					System.out.println("5. 스카이패스 마일리지를 사용하면 어떤 서비스나 상품을 이용할 수 있나요?");
					System.out.println(
							"적립하신 스카이패스 마일리지는 항공권 발급부터 제휴사 서비스까지 다양한 방법으로 사용하실 수 있습니다. 대한항공 보너스 항공권 및 좌석 승급 보너스, \n"
									+ "제휴 항공사 보너스 항공권과 대한항공이 별도로 정한 상품 (호텔, 투어, 초과 수하물, KAL 라운지 보너스, 비동반 소아 서비스 수수료, KAL스토어 등) 이용이 가능합니다.\n"
									+ "대한항공 홈페이지 [스카이패스 > 마일리지 사용]과  [스카이패스 > 마일리지 몰]을 방문해주세요.");

					break;
				case 6:

					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					String str;

					System.out.print("질문을 입력하여 주세요 >");

					str = br.readLine();
					// System.out.println(str);

					BufferedOutputStream bs = null;
					try {
						bs = new BufferedOutputStream(new FileOutputStream("C:\\Temp\\Q&A.txt"));

						bs.write(str.getBytes()); // Byte형으로만 넣을 수 있음

					} catch (IOException e) {
						System.out.println("잘못된 입력입니다. 다시 선택하여 주세요");
						// e.getStackTrace();

					} finally {
						System.out.println("정상처리되었습니다. ");
						bs.close();
					}
					break;
				case 0:
					play = false;
//               sc.close();
				}
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
			}
		}
	}
}