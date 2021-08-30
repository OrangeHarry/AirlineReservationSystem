package Wilderness;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class checkReservation {
	// private Map<String, MemberMNG> member;
	private Scanner sc = new Scanner(System.in);

	public void check() {
		try {
			System.out.println("===================================================================");
			System.out.println("                       ticketInformation	");
			System.out.println("===================================================================");

			// 모든 키를 set객체에 담아서 리턴
			Set<String> set = Join.memberMap.keySet();
			Iterator<String> it = set.iterator();

			MemberMNG mng = Join.memberMap.get(it.next());
			System.out.println();
			String tickinfo = "\t가는편 : " + mng.getTicketinfo().GoDate + "\t오는편 : " + mng.getTicketinfo().BackDate
					+ "\t출발지 :" + mng.getTicketinfo().startplace + "\t도착지:" + mng.getTicketinfo().arrplace;
//		while (it.hasNext()) {
			// MemberMNG mng = Join.memberMap.get(it.next());
			if (mng.getTicketinfo().GoDate == null) {
				System.out.println("예약 정보가 없습니다.");

			} else {
				System.out.println(mng.getName() + "\t" + tickinfo + "\t 가격" + mng.getPrice());
			}

		} catch (NullPointerException e) {
			System.out.println("예약이 없습니다.");
		}
	}

	public void remov() {
		String id;
		System.out.println("===================================================================");
		System.out.println("삭제하실 아이디를 입력해주세요");
		id = sc.nextLine();
		// Join.memberMap.remove(id);
		// 모든 키를 set객체에 담아서 리턴
		Set<String> set = Join.memberMap.keySet();
		Iterator<String> it = set.iterator();

		MemberMNG mng = Join.memberMap.get(it.next());
		mng.setTicketinfo(null);
	}
}