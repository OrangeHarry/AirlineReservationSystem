package Wilderness;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.mail.MessagingException;

public class ReservationFix {
	SendEmail sm = new SendEmail();

//	MemberMNG mng;
//	TicketInformation tickinfo = mng.ticketinfo;

	Scanner sc = new Scanner(System.in);
	String Date = "yyyy-MM-dd";
	String GoDate = "";
	String BackDate = "";
	String startplace = "QQQ";
	String arrplace = "ZZZ";
	int price = 0;
	String Go = "아직 정해지지 않았습니다.";
	String Back = "아직 정해지지 않았습니다.";
	static int totalprice = 0;

	public void runReservation(String id) throws MessagingException {

		date(id);// 날짜 고르기
		city(id);// 도시 고르기
		Plane(id);// 비행기정하기
		addFood(id);// 기내식 추가
		addBaggage(id);// 수화물 추가
		upSeat(id);// 좌석 업그레이드
		totalPlaneInfo(id);// 비행기
		totalPlaneprice(id);// 가격정보
		// mail();
	}

	public void date(String id) {
		MemberMNG mng = Join.memberMap.get(id);
		TicketInformation tickinfo = mng.ticketinfo;

		System.out.println("가는편 출발일을 정해주세요\nyyyy-MM-dd");
		tickinfo.GoDate = getsc("가는편출발일");
		System.out.println("오는편 출발일를 정해주세요\nyyyy-MM-dd");
		tickinfo.BackDate = getsc("오는편출발일");
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.print("가는편 츨발일\n" + mng.getTicketinfo().GoDate + "\n");
		System.out.print("오는편 츨발일\n" + mng.getTicketinfo().BackDate + "\n");

		ss(id);
	}

	public void city(String id) {

		MemberMNG mng = Join.memberMap.get(id);
		TicketInformation tickinfo = mng.ticketinfo;
		// 예약 프로그램 도시 정하기
		// 선택한 도시에 맞게 startplace 와 arrplace가 기본 주소에서 3글자 공항 주소로바뀜

		while (true) {
			System.out.println("[예약 프로그램]                                           ");

			printBox("QQQ", "QQQ", "출발도시 선택> 1.인천 2.김포");

			String Scity = sc.nextLine();

			if (Scity.equals("1") || Scity.contains("인")) {
				startplace = "ICN";
				printBox("ICN", "QQQ", "도착도시 선택> 1.제주 2.부산");

				String Acity = sc.nextLine();
				if (Acity.equals("1") || Acity.contains("제")) {
					arrplace = "CJU";
					printBox("ICN", "CJU", "");
					break;

				} else if (Acity.equals("2") || Acity.contains("부")) {
					arrplace = "PUS";
					printBox("ICN", "PUS", "");
					break;
				} else {
					System.out.println("다시 입력해 주세요");
					continue;
				}

			}
			if (Scity.equals("2") || Scity.contains("김")) {
				startplace = "GMP";
				printBox("GMP", "QQQ", "도착도시 선택> 1.제주 2.부산");

				String Acity2 = sc.nextLine();
				if (Acity2.equals("1") || Acity2.contains("제")) {

					arrplace = "CJU";
					printBox("GMP", "CJU", "");
					break;

				} else if (Acity2.equals("2") || Acity2.contains("부")) {

					arrplace = "PUS";
					printBox("GMP", "CJU", "");
					break;
				} else {
					System.out.println("다시 입력해 주세요");
					continue;
				}

			} else {
				System.out.println("다시 입력해 주세요");
				continue;
			}

		}

		System.out.println(startplace + "->" + arrplace);
		System.out.println();
		System.out.println();
		System.out.println("예약하기->");
		tickinfo.startplace = startplace;
		tickinfo.arrplace = arrplace;
	}

	// 가는편 비행기
	// 비행기 가격은 price 에 저장된다.
	// price는 Total 클래스에서 총 결재금액 allPrice에 더해진다.
	public void Plane(String id) {
		MemberMNG mng = Join.memberMap.get(id);
		TicketInformation tickinfo = mng.ticketinfo;
		String p1 = "출발 7:00~ 도착 9:10";
		String p2 = "출발 7:10~ 도착 9:30";
		String p3 = "출발 8:00~ 도착 9:50";
		String p4 = "출발 9:00~ 도착 10:00";
		String p6 = "출발 14:10~ 도착 16:10";
		String p7 = "출발 15:00~ 도착 16:40";
		String p8 = "출발 15:40~ 도착 17:10";
		String p9 = "출발 18:00~ 도착 20:00";
		String p10 = "출발18:50~ 도착 21:00";

		String s = startplace;
		String a = arrplace;

		if (s.equals("GMP")) {
			try {
				printBox("가는편비행기", "\t            " + p1, "\t            " + p3, "\t            " + p6);

				String num = sc.nextLine();
				if (num.equals("1")) {
					printBoxg(p1, 100000, 100000);

				} else if (num.equals("2")) {
					printBoxg(p3, 110000, 110000);

				} else if (num.equals("3")) {
					printBoxg(p6, 90000, 110000);

				} else {
					Plane(id);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (s.equals("ICN")) {
			try {
				printBox("가는편비행기", "\t            " + p2, "\t            " + p4, "\t            " + p7);

				String num = sc.nextLine();
				if (num.equals("1")) {
					printBoxg(p1, 100000, 100000);

				} else if (num.equals("2")) {
					printBoxg(p3, 110000, 110000);

				} else if (num.equals("3")) {
					printBoxg(p6, 90000, 110000);

				} else {
					Plane(id);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (a.equals("PUS")) {
			try {
				printBox("오는편비행기", "\t            " + p7, "\t            " + p9, "\t            " + p10);

				String num = sc.nextLine();
				if (num.equals("1")) {
					printBoxb(p7, 100000, 100000);

				} else if (num.equals("2")) {
					printBoxb(p9, 110000, 110000);

				} else if (num.equals("3")) {
					printBoxb(p10, 90000, 90000);

				} else {
					Plane(id);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (a.equals("CJU")) {
			try {
				printBox("오는편비행기", "\t            " + p6, "\t            " + p8, "\t            " + p9);

				String num = sc.nextLine();
				if (num.equals("1")) {
					printBoxb(p7, 100000, 100000);

				} else if (num.equals("2")) {
					printBoxb(p9, 110000, 110000);

				} else if (num.equals("3")) {
					printBoxb(p10, 90000, 90000);

				} else {
					Plane(id);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("\n\n이용하시는 비행편은\n가는편 비행기[" + Go + "]입니다.\n오는편 비행기[" + Back + "]입니다.");
		System.out.println();
		System.out.println("총 결제금액은 " + price + "원 입니다.");
		System.out.println("추가결제창으로 넘어갑니다.");
	}

	String Food = "고르지 않았습니다.";
	String Baggage = "고르지 않았습니다.";
	String SeatUp = "좌석을 업그레이드 하지 않습니다.";
	int seatPrice = 0;
	int addPrice = 0;

	public void addFood(String id) {
		MemberMNG mng = Join.memberMap.get(id);
		TicketInformation tickinfo = mng.ticketinfo;
		try {
			System.out.println("기내식을 추가합니다.");

			printBox("   1.> 일반식  |2.> 어린이식 |3.> 저염식 |4.> 할랄식 |5.> 비건식|6.>추가하지않는다.");
			System.out.printf("선택 >");
			String num2 = sc.nextLine();

			if (num2.equals("1") || num2.contains("일반")) {
				Food = "일반식";
				printBox("                 일반식을 추가합니다  price : 10000원");
				addPrice += 10000;
				totalprice += 10000;

			} else if (num2.equals("2") || num2.contains("어린이")) {
				Food = "어린이식";
				printBox("      어린이식을 추가합니다  price : 8000원");

				addPrice += 8000;
				totalprice += 8000;

			} else if (num2.equals("3") || num2.contains("저염")) {
				Food = "저염식";
				printBox("         저염식을 추가합니다  price : 11000원");

				addPrice += 11000;
				totalprice += 11000;

			} else if (num2.equals("4") || num2.contains("할랄")) {
				Food = "할랄식";
				printBox("         할랄식을 추가합니다  price : 9000원");

				addPrice += 9000;
				totalprice += 9000;

			} else if (num2.equals("5") || num2.contains("비건")) {
				Food = "비건식";
				printBox("         비건식을 추가합니다  price : 8000원");

				addPrice += 8000;
				totalprice += 8000;
			} else {
				Food = "기내식 추가 없음";
				printBox(">추가하지 않는다.");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		tickinfo.Food = Food;

	}

	public void addBaggage(String id) {
		MemberMNG mng = Join.memberMap.get(id);
		TicketInformation tickinfo = mng.ticketinfo;

		try {
			System.out.println();
			System.out.println();
			System.out.println("NEXT");
			System.out.println();
			System.out.println();
			System.out.println("수화물을 추가 합니다.");
			printBox("      1. 추가 수화물 10kg |2. 추가 수화물 15kg |3. 선택하지 않는다.");

			String num3 = sc.nextLine();
			if (num3.equals("1") || num3.contains("10")) {
				Baggage = "추가 수화물 10kg";
				printBox("      추가수화물 10kg을 추가합니다. price : 50000원");

				addPrice += 50000;
				totalprice += 50000;
			} else if (num3.equals("2") || num3.contains("15")) {
				Baggage = "추가 수화물 15kg";
				printBox("      추가수화물 15kg을 추가합니다. price : 70000원");

				addPrice += 70000;
				totalprice += 70000;
			} else {
				Baggage = "추가 수화물 없음";
				System.out.println(">수화물을 추가하지 않습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		tickinfo.Baggage = Baggage;
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("┌                        ┐");
		System.out.println("            추가요금은 " + addPrice + "원 입니다.");
		System.out.println("└                        ┘");
		System.out.println();

	}

	// 시트 업그레이드
	/// 시트 업그레이드 가격은 seatPrice 에 저장된다.
	// seatPrice는 Total 클래스에서 총 결재금액 allPrice에 더해진다.
	public void upSeat(String id) {
		MemberMNG mng = Join.memberMap.get(id);
		TicketInformation tickinfo = mng.ticketinfo;

		printBox("                 좌석을 업그레이드 하시겠습니다?");

		System.out.println("> 1.비즈니스 업그레이드 | 2.취소 ");

		String num = sc.nextLine();
		if (num.equals("1")) {
			SeatUp = "좌석을 업그레이드 했습니다.";
			printBox("                 좌석이 비즈니스로 업그레이드 되었습니다. price : 50000원");

			seatPrice += 50000;
			totalprice += 50000;

		} else {
			printBox("                 좌석을 업그레이드 하지 않습니다.");

		}
		tickinfo.SeatUp = SeatUp;
		System.out.println(">추가된 요금 :" + seatPrice);

	}

	void totalPlaneInfo(String id) {
		MemberMNG mng = Join.memberMap.get(id);
		TicketInformation tickinfo = mng.ticketinfo;

		String DateInfo = ("가는편 날짜:" + tickinfo.GoDate + "\n오는편 날짜:" + tickinfo.BackDate + "\n");
		String ResInfo = (startplace + "->" + arrplace + "\n");
		String SSSInfo = ("가는편비행기 :" + Go + "\n" + "오는편비행기 :" + Back + "\n");
		String ExtraInfo = ("기내식 :" + Food + "\n추가 수화물 :" + Baggage + "\n");
		String SeatUpInfo = ("좌석 업그레이드:" + SeatUp + "\n");

		String totalInfo = (DateInfo + ResInfo + SSSInfo + ExtraInfo + SeatUpInfo);

//		MemberMNG mng = Join.memberMap.get(id);
//		mng.setTicketInformation(totalInfo);

		System.out.println(totalInfo);

	}

	void totalPlaneprice(String id) {
		MemberMNG mng = Join.memberMap.get(id);
		TicketInformation tickinfo = mng.ticketinfo;

		System.out.println("총 결제 가격은 " + totalprice + "입니다.");
	}

	public void printBox(String msg) {
		System.out.println("┍━━━━━━━━━━━━━━━━━━━━━━━━━━━━━廣野    AirLine━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┑");
		System.out.println();
		System.out.println(msg);
		System.out.println();
		System.out.println("┕━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┙");
	}

	public void printBox(String g, String f1, String f2, String f3) {
		System.out.println(g);
		System.out.println("time table");
		System.out.println("1.");
		System.out.println("┎━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┒");
		System.out.println("   " + f1 + "        ");
		System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┚");
		System.out.println("2.");
		System.out.println("┎━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┒");
		System.out.println("   " + f2 + " ");
		System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┚");
		System.out.println("3.");
		System.out.println("┎━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┒");
		System.out.println("   " + f3 + "");
		System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┚");
		System.out.println();
		System.out.println("이용하실 비행편을 선택해 주세요");

	}

	public void printBox(String startplace, String arrplace, String city) {

		System.out.println("                                             ");
		System.out.println("            출발 도시                                                도착 도시 ");
		System.out.println("┌───────────────┐         ┌───────────────┐");
		System.out.println("│      " + startplace + "      │  ---->  │      " + arrplace + "      │");
		System.out.println("└───────────────┘         └───────────────┘");
		System.out.println("                                                              ");
		System.out.println(city);
		System.out.println("---------------------------------------------------------◁");
	}

	public void printBoxg(String go, int p, int tp) {
		Go = go;
		price += p;
		totalprice += tp;

		System.out.println("\n[" + Go + "]편을 이용합니다. 가격:" + p + "원");
	}

	public void printBoxb(String back, int p, int tp) {
		Back = back;
		price += p;
		totalprice += tp;

		System.out.println("\n[" + Back + "]편을 이용합니다. 가격:" + p + "원");
	}

	private String getsc(String s) {
		System.out.println();
		System.out.println(s);
		return sc.nextLine();
	}

	public void ss(String id) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			Date date1 = dateFormat.parse(GoDate);
			Date date2 = dateFormat.parse(BackDate);
			System.out.println("가는편비행기" + dateFormat.format(date1));
			System.out.println("오는편비행기" + dateFormat.format(date2));
			if (date2.before(date1)) {
				System.out.println("오는편비행기가 가는편비행기보다 빠릅니다.\n다시 입력해 주세요");
				date(id);
			}
		} catch (ParseException ex) {
		}
		System.out.println("\n비행정보가 입력되었습니다.");
	}
}
