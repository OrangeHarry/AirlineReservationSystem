package Wilderness;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.mail.MessagingException;

public class ImplementsClass {
	private Scanner sc;
	CustomerSign custSign = new CustomerSign();
	SendEmail sm = new SendEmail();
	ReservationFix rf = new ReservationFix(); // 항공권 정보 가져오기 위한 목적
	public static final String COMPANY_ACCOUNT = "신한 110-369-681992, 예금주 : 광야";

	public ImplementsClass() {
		sc = new Scanner(System.in);
	}

	public void run(String id) throws MessagingException {

		while (true) {
			paymentFirstView();
			switch (sc.nextLine()) {
			case "1":
				card(id);
				break;
			case "2":
				account(id);
				break;
			default:
				System.out.println("다시 입력해주세요");
				continue;
			}
			return;
		}
	}

	// 카드등록 및 카드결제 메소드
	public void card(String id) throws MessagingException {

		MemberMNG mng = Join.memberMap.get(id);
		TicketInformation tickinfo = mng.ticketinfo;
		String ticketInfo = " ＊가는편 : " + mng.getTicketinfo().GoDate + "\n ＊오는편 : " + mng.getTicketinfo().BackDate
				+ "\n ＊출발지 : " + mng.getTicketinfo().startplace + "\n ＊도착지: " + mng.getTicketinfo().arrplace;

		mng.setPrice(ReservationFix.totalprice);// 최종가격
		while (true) {
			try {
				System.out.println("결제하실 카드 정보를 등록해주세요");
				System.out.print("카드사(신한,국민)를 입력해주세요 ex) > ");
				mng.setCardCompany(sc.nextLine());
				System.out.print("카드번호(-없이 숫자만)를 입력해주세요 > ");
				mng.setCardNum(Long.parseLong(sc.nextLine()));
				System.out.print("카드뒷면의 CVC번호 3자리를 입력해주세요 > ");
				mng.setCvcNum(Integer.parseInt(sc.nextLine()));
				System.out.println("카드 유효기간을 입력해주세요(mmYY) > ");
				mng.setValidity(Integer.parseInt(sc.nextLine()));
				System.out.print("할부 개월을 입력해 주세요 > ");
				mng.setInstallment(Integer.parseInt(sc.nextLine()));
			} catch (Exception e) {
				System.out.println("입력값이 형식이 잘못되었습니다. 숫자로 입력해주세요 ");
				continue;
			}
			break;
		}

		while (true) {
			System.out.println("=======================결제 정보=======================");
			System.out.println("항공권      ↓↓ ");
			System.out.println(ticketInfo);
			// rf.totalPlaneInfo();
			System.out.println("가격        : " + mng.getPrice() + "원");
			System.out.println("카드사     : " + mng.getCardCompany());
			System.out.println("카드번호  : " + mng.getCardNum());
			System.out.println("CVC번호 : " + mng.getCvcNum());
			System.out.println("유효기간  : " + mng.getValidity());
			System.out.println("할부개월  : " + mng.getInstallment());
			System.out.println("결제진행을 하시겠습니까?");
			System.out.println("  1.Yes   2.No");
			System.out.print("선택 > ");

			switch (sc.nextLine()) {
			case "1":
				System.out.println("결제가 완료되었습니다.");

				System.out.println("=======================결제 정보=======================");
				System.out.println("항공권      ↓↓ ");
				System.out.println(ticketInfo);
				// rf.totalPlaneInfo();
				System.out.println("가격        : " + mng.getPrice() + "원");//
				System.out.println("카드사     : " + mng.getCardCompany());
				System.out.println("카드번호  : " + mng.getCardNum());
				System.out.println("CVC번호 : " + mng.getCvcNum());
				System.out.println("유효기간  : " + mng.getValidity());
				System.out.println("할부개월  : " + mng.getInstallment());
				System.out.println("결제 일자 : " + TimeStamp());
				System.out.println("결제해주셔서 감사합니다 행복한 여행 되세요^^");
				break;
			case "2":
				break;
			default:
				System.out.println("입력값이 잘못되었습니다. 다시한번 확인해주세요");
				continue;
			}
			break;
		}
		System.out.println("결제시스템이 종료되었습니다.");
		while (true) {
			System.out.println("=====================================================");
			System.out.println("    1.메일보내기                  2.종료");
			System.out.print("선택 > ");
			switch (sc.nextLine()) {
			case "1":

				// sm.mail(id);
				break;
			case "2":
				break;
			default:
				System.out.println("입력값이 잘못되었습니다. 다시한번 확인해주세요");
				continue;
			}
			break;
		}

	}

	// 무통장입금 메소드
	public void account(String id) {

		MemberMNG mng = Join.memberMap.get(id);

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		cal.add(Calendar.DATE, +3); // 3일뒤 시간
		mng.setPrice(ReservationFix.totalprice);// 최종 가격
		String ticketInfo = " ＊가는편 : " + mng.getTicketinfo().GoDate + "\n ＊오는편 : " + mng.getTicketinfo().BackDate
				+ "\n ＊출발지 : " + mng.getTicketinfo().startplace + "\n ＊도착지: " + mng.getTicketinfo().arrplace;

		try {
			System.out.println("=======================결제 정보=======================");
			System.out.println("입금계좌     : " + COMPANY_ACCOUNT);
			System.out.println("가격           : " + mng.getPrice() + "원");
			System.out.println("항공권        ↓↓ ");
			System.out.println(ticketInfo);
			// mng.setTicketInformation(ticketInformation);
			System.out.println("이름 : " + mng.getName());
			System.out.println("입금기한     : " + df.format(cal.getTime()) + "까지");
			System.out.println();
			System.out.println("즐거운 여행에 저희 광야와 함께해 주셔서 감사합니다.");
			System.out.println("위에 명시된 기한까지 입금하지 않을 경우 자동으로 예약 취소 처리 됩니다.");
			while (true) {
				System.out.println("=====================================================");
				System.out.println("    1.메일보내기                   2.종료");
				System.out.print("선택 > ");
				switch (sc.nextLine()) {
				case "1":
					// sm.mail(id);
					break;
				case "2":
					break;
				default:
					System.out.println("입력값이 잘못되었습니다. 다시한번 확인해주세요");
					continue;
				}
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 결제 첫화면 메소드
	public void paymentFirstView() {
		System.out.println("----------------------------");
		System.out.println("     ★★★결제 방법을 선택하세요★★★");
		System.out.println();
		System.out.println("    1.카드결제     2.무통장입금");
		System.out.println("----------------------------");
		System.out.print("선택 > ");
	}

	// 현재시간 찍어주는 메소드
	private static String TimeStamp() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		return format.format(new Date());// 현재 시간을 리턴할 수 있다.
	}
}