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
	String Go = "���� �������� �ʾҽ��ϴ�.";
	String Back = "���� �������� �ʾҽ��ϴ�.";
	static int totalprice = 0;

	public void runReservation(String id) throws MessagingException {

		date(id);// ��¥ ����
		city(id);// ���� ����
		Plane(id);// ��������ϱ�
		addFood(id);// �⳻�� �߰�
		addBaggage(id);// ��ȭ�� �߰�
		upSeat(id);// �¼� ���׷��̵�
		totalPlaneInfo(id);// �����
		totalPlaneprice(id);// ��������
		// mail();
	}

	public void date(String id) {
		MemberMNG mng = Join.memberMap.get(id);
		TicketInformation tickinfo = mng.ticketinfo;

		System.out.println("������ ������� �����ּ���\nyyyy-MM-dd");
		tickinfo.GoDate = getsc("�����������");
		System.out.println("������ ����ϸ� �����ּ���\nyyyy-MM-dd");
		tickinfo.BackDate = getsc("�����������");
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.print("������ ������\n" + mng.getTicketinfo().GoDate + "\n");
		System.out.print("������ ������\n" + mng.getTicketinfo().BackDate + "\n");

		ss(id);
	}

	public void city(String id) {

		MemberMNG mng = Join.memberMap.get(id);
		TicketInformation tickinfo = mng.ticketinfo;
		// ���� ���α׷� ���� ���ϱ�
		// ������ ���ÿ� �°� startplace �� arrplace�� �⺻ �ּҿ��� 3���� ���� �ּҷιٲ�

		while (true) {
			System.out.println("[���� ���α׷�]                                           ");

			printBox("QQQ", "QQQ", "��ߵ��� ����> 1.��õ 2.����");

			String Scity = sc.nextLine();

			if (Scity.equals("1") || Scity.contains("��")) {
				startplace = "ICN";
				printBox("ICN", "QQQ", "�������� ����> 1.���� 2.�λ�");

				String Acity = sc.nextLine();
				if (Acity.equals("1") || Acity.contains("��")) {
					arrplace = "CJU";
					printBox("ICN", "CJU", "");
					break;

				} else if (Acity.equals("2") || Acity.contains("��")) {
					arrplace = "PUS";
					printBox("ICN", "PUS", "");
					break;
				} else {
					System.out.println("�ٽ� �Է��� �ּ���");
					continue;
				}

			}
			if (Scity.equals("2") || Scity.contains("��")) {
				startplace = "GMP";
				printBox("GMP", "QQQ", "�������� ����> 1.���� 2.�λ�");

				String Acity2 = sc.nextLine();
				if (Acity2.equals("1") || Acity2.contains("��")) {

					arrplace = "CJU";
					printBox("GMP", "CJU", "");
					break;

				} else if (Acity2.equals("2") || Acity2.contains("��")) {

					arrplace = "PUS";
					printBox("GMP", "CJU", "");
					break;
				} else {
					System.out.println("�ٽ� �Է��� �ּ���");
					continue;
				}

			} else {
				System.out.println("�ٽ� �Է��� �ּ���");
				continue;
			}

		}

		System.out.println(startplace + "->" + arrplace);
		System.out.println();
		System.out.println();
		System.out.println("�����ϱ�->");
		tickinfo.startplace = startplace;
		tickinfo.arrplace = arrplace;
	}

	// ������ �����
	// ����� ������ price �� ����ȴ�.
	// price�� Total Ŭ�������� �� ����ݾ� allPrice�� ��������.
	public void Plane(String id) {
		MemberMNG mng = Join.memberMap.get(id);
		TicketInformation tickinfo = mng.ticketinfo;
		String p1 = "��� 7:00~ ���� 9:10";
		String p2 = "��� 7:10~ ���� 9:30";
		String p3 = "��� 8:00~ ���� 9:50";
		String p4 = "��� 9:00~ ���� 10:00";
		String p6 = "��� 14:10~ ���� 16:10";
		String p7 = "��� 15:00~ ���� 16:40";
		String p8 = "��� 15:40~ ���� 17:10";
		String p9 = "��� 18:00~ ���� 20:00";
		String p10 = "���18:50~ ���� 21:00";

		String s = startplace;
		String a = arrplace;

		if (s.equals("GMP")) {
			try {
				printBox("����������", "\t            " + p1, "\t            " + p3, "\t            " + p6);

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
				printBox("����������", "\t            " + p2, "\t            " + p4, "\t            " + p7);

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
				printBox("����������", "\t            " + p7, "\t            " + p9, "\t            " + p10);

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
				printBox("����������", "\t            " + p6, "\t            " + p8, "\t            " + p9);

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

		System.out.println("\n\n�̿��Ͻô� ��������\n������ �����[" + Go + "]�Դϴ�.\n������ �����[" + Back + "]�Դϴ�.");
		System.out.println();
		System.out.println("�� �����ݾ��� " + price + "�� �Դϴ�.");
		System.out.println("�߰�����â���� �Ѿ�ϴ�.");
	}

	String Food = "���� �ʾҽ��ϴ�.";
	String Baggage = "���� �ʾҽ��ϴ�.";
	String SeatUp = "�¼��� ���׷��̵� ���� �ʽ��ϴ�.";
	int seatPrice = 0;
	int addPrice = 0;

	public void addFood(String id) {
		MemberMNG mng = Join.memberMap.get(id);
		TicketInformation tickinfo = mng.ticketinfo;
		try {
			System.out.println("�⳻���� �߰��մϴ�.");

			printBox("   1.> �Ϲݽ�  |2.> ��̽� |3.> ������ |4.> �Ҷ��� |5.> ��ǽ�|6.>�߰������ʴ´�.");
			System.out.printf("���� >");
			String num2 = sc.nextLine();

			if (num2.equals("1") || num2.contains("�Ϲ�")) {
				Food = "�Ϲݽ�";
				printBox("                 �Ϲݽ��� �߰��մϴ�  price : 10000��");
				addPrice += 10000;
				totalprice += 10000;

			} else if (num2.equals("2") || num2.contains("���")) {
				Food = "��̽�";
				printBox("      ��̽��� �߰��մϴ�  price : 8000��");

				addPrice += 8000;
				totalprice += 8000;

			} else if (num2.equals("3") || num2.contains("����")) {
				Food = "������";
				printBox("         �������� �߰��մϴ�  price : 11000��");

				addPrice += 11000;
				totalprice += 11000;

			} else if (num2.equals("4") || num2.contains("�Ҷ�")) {
				Food = "�Ҷ���";
				printBox("         �Ҷ����� �߰��մϴ�  price : 9000��");

				addPrice += 9000;
				totalprice += 9000;

			} else if (num2.equals("5") || num2.contains("���")) {
				Food = "��ǽ�";
				printBox("         ��ǽ��� �߰��մϴ�  price : 8000��");

				addPrice += 8000;
				totalprice += 8000;
			} else {
				Food = "�⳻�� �߰� ����";
				printBox(">�߰����� �ʴ´�.");

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
			System.out.println("��ȭ���� �߰� �մϴ�.");
			printBox("      1. �߰� ��ȭ�� 10kg |2. �߰� ��ȭ�� 15kg |3. �������� �ʴ´�.");

			String num3 = sc.nextLine();
			if (num3.equals("1") || num3.contains("10")) {
				Baggage = "�߰� ��ȭ�� 10kg";
				printBox("      �߰���ȭ�� 10kg�� �߰��մϴ�. price : 50000��");

				addPrice += 50000;
				totalprice += 50000;
			} else if (num3.equals("2") || num3.contains("15")) {
				Baggage = "�߰� ��ȭ�� 15kg";
				printBox("      �߰���ȭ�� 15kg�� �߰��մϴ�. price : 70000��");

				addPrice += 70000;
				totalprice += 70000;
			} else {
				Baggage = "�߰� ��ȭ�� ����";
				System.out.println(">��ȭ���� �߰����� �ʽ��ϴ�.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		tickinfo.Baggage = Baggage;
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("��                        ��");
		System.out.println("            �߰������ " + addPrice + "�� �Դϴ�.");
		System.out.println("��                        ��");
		System.out.println();

	}

	// ��Ʈ ���׷��̵�
	/// ��Ʈ ���׷��̵� ������ seatPrice �� ����ȴ�.
	// seatPrice�� Total Ŭ�������� �� ����ݾ� allPrice�� ��������.
	public void upSeat(String id) {
		MemberMNG mng = Join.memberMap.get(id);
		TicketInformation tickinfo = mng.ticketinfo;

		printBox("                 �¼��� ���׷��̵� �Ͻðڽ��ϴ�?");

		System.out.println("> 1.����Ͻ� ���׷��̵� | 2.��� ");

		String num = sc.nextLine();
		if (num.equals("1")) {
			SeatUp = "�¼��� ���׷��̵� �߽��ϴ�.";
			printBox("                 �¼��� ����Ͻ��� ���׷��̵� �Ǿ����ϴ�. price : 50000��");

			seatPrice += 50000;
			totalprice += 50000;

		} else {
			printBox("                 �¼��� ���׷��̵� ���� �ʽ��ϴ�.");

		}
		tickinfo.SeatUp = SeatUp;
		System.out.println(">�߰��� ��� :" + seatPrice);

	}

	void totalPlaneInfo(String id) {
		MemberMNG mng = Join.memberMap.get(id);
		TicketInformation tickinfo = mng.ticketinfo;

		String DateInfo = ("������ ��¥:" + tickinfo.GoDate + "\n������ ��¥:" + tickinfo.BackDate + "\n");
		String ResInfo = (startplace + "->" + arrplace + "\n");
		String SSSInfo = ("���������� :" + Go + "\n" + "���������� :" + Back + "\n");
		String ExtraInfo = ("�⳻�� :" + Food + "\n�߰� ��ȭ�� :" + Baggage + "\n");
		String SeatUpInfo = ("�¼� ���׷��̵�:" + SeatUp + "\n");

		String totalInfo = (DateInfo + ResInfo + SSSInfo + ExtraInfo + SeatUpInfo);

//		MemberMNG mng = Join.memberMap.get(id);
//		mng.setTicketInformation(totalInfo);

		System.out.println(totalInfo);

	}

	void totalPlaneprice(String id) {
		MemberMNG mng = Join.memberMap.get(id);
		TicketInformation tickinfo = mng.ticketinfo;

		System.out.println("�� ���� ������ " + totalprice + "�Դϴ�.");
	}

	public void printBox(String msg) {
		System.out.println("�Ȧ������������������������������������������������������������    AirLine������������������������������������������������������������");
		System.out.println();
		System.out.println(msg);
		System.out.println();
		System.out.println("�Ʀ�������������������������������������������������������������������������������������������������������������������������������������������");
	}

	public void printBox(String g, String f1, String f2, String f3) {
		System.out.println(g);
		System.out.println("time table");
		System.out.println("1.");
		System.out.println("�Ǧ���������������������������������������������������������������������������������������");
		System.out.println("   " + f1 + "        ");
		System.out.println("�Ŧ���������������������������������������������������������������������������������������");
		System.out.println("2.");
		System.out.println("�Ǧ���������������������������������������������������������������������������������������");
		System.out.println("   " + f2 + " ");
		System.out.println("�Ŧ���������������������������������������������������������������������������������������");
		System.out.println("3.");
		System.out.println("�Ǧ���������������������������������������������������������������������������������������");
		System.out.println("   " + f3 + "");
		System.out.println("�Ŧ���������������������������������������������������������������������������������������");
		System.out.println();
		System.out.println("�̿��Ͻ� �������� ������ �ּ���");

	}

	public void printBox(String startplace, String arrplace, String city) {

		System.out.println("                                             ");
		System.out.println("            ��� ����                                                ���� ���� ");
		System.out.println("����������������������������������         ����������������������������������");
		System.out.println("��      " + startplace + "      ��  ---->  ��      " + arrplace + "      ��");
		System.out.println("����������������������������������         ����������������������������������");
		System.out.println("                                                              ");
		System.out.println(city);
		System.out.println("---------------------------------------------------------��");
	}

	public void printBoxg(String go, int p, int tp) {
		Go = go;
		price += p;
		totalprice += tp;

		System.out.println("\n[" + Go + "]���� �̿��մϴ�. ����:" + p + "��");
	}

	public void printBoxb(String back, int p, int tp) {
		Back = back;
		price += p;
		totalprice += tp;

		System.out.println("\n[" + Back + "]���� �̿��մϴ�. ����:" + p + "��");
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
			System.out.println("����������" + dateFormat.format(date1));
			System.out.println("����������" + dateFormat.format(date2));
			if (date2.before(date1)) {
				System.out.println("���������Ⱑ ���������⺸�� �����ϴ�.\n�ٽ� �Է��� �ּ���");
				date(id);
			}
		} catch (ParseException ex) {
		}
		System.out.println("\n���������� �ԷµǾ����ϴ�.");
	}
}
