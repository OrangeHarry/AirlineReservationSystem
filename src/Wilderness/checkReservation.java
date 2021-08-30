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

			// ��� Ű�� set��ü�� ��Ƽ� ����
			Set<String> set = Join.memberMap.keySet();
			Iterator<String> it = set.iterator();

			MemberMNG mng = Join.memberMap.get(it.next());
			System.out.println();
			String tickinfo = "\t������ : " + mng.getTicketinfo().GoDate + "\t������ : " + mng.getTicketinfo().BackDate
					+ "\t����� :" + mng.getTicketinfo().startplace + "\t������:" + mng.getTicketinfo().arrplace;
//		while (it.hasNext()) {
			// MemberMNG mng = Join.memberMap.get(it.next());
			if (mng.getTicketinfo().GoDate == null) {
				System.out.println("���� ������ �����ϴ�.");

			} else {
				System.out.println(mng.getName() + "\t" + tickinfo + "\t ����" + mng.getPrice());
			}

		} catch (NullPointerException e) {
			System.out.println("������ �����ϴ�.");
		}
	}

	public void remov() {
		String id;
		System.out.println("===================================================================");
		System.out.println("�����Ͻ� ���̵� �Է����ּ���");
		id = sc.nextLine();
		// Join.memberMap.remove(id);
		// ��� Ű�� set��ü�� ��Ƽ� ����
		Set<String> set = Join.memberMap.keySet();
		Iterator<String> it = set.iterator();

		MemberMNG mng = Join.memberMap.get(it.next());
		mng.setTicketinfo(null);
	}
}