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
	ReservationFix rf = new ReservationFix(); // �װ��� ���� �������� ���� ����
	public static final String COMPANY_ACCOUNT = "���� 110-369-681992, ������ : ����";

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
				System.out.println("�ٽ� �Է����ּ���");
				continue;
			}
			return;
		}
	}

	// ī���� �� ī����� �޼ҵ�
	public void card(String id) throws MessagingException {

		MemberMNG mng = Join.memberMap.get(id);
		TicketInformation tickinfo = mng.ticketinfo;
		String ticketInfo = " �������� : " + mng.getTicketinfo().GoDate + "\n �������� : " + mng.getTicketinfo().BackDate
				+ "\n ������� : " + mng.getTicketinfo().startplace + "\n ��������: " + mng.getTicketinfo().arrplace;

		mng.setPrice(ReservationFix.totalprice);// ��������
		while (true) {
			try {
				System.out.println("�����Ͻ� ī�� ������ ������ּ���");
				System.out.print("ī���(����,����)�� �Է����ּ��� ex) > ");
				mng.setCardCompany(sc.nextLine());
				System.out.print("ī���ȣ(-���� ���ڸ�)�� �Է����ּ��� > ");
				mng.setCardNum(Long.parseLong(sc.nextLine()));
				System.out.print("ī��޸��� CVC��ȣ 3�ڸ��� �Է����ּ��� > ");
				mng.setCvcNum(Integer.parseInt(sc.nextLine()));
				System.out.println("ī�� ��ȿ�Ⱓ�� �Է����ּ���(mmYY) > ");
				mng.setValidity(Integer.parseInt(sc.nextLine()));
				System.out.print("�Һ� ������ �Է��� �ּ��� > ");
				mng.setInstallment(Integer.parseInt(sc.nextLine()));
			} catch (Exception e) {
				System.out.println("�Է°��� ������ �߸��Ǿ����ϴ�. ���ڷ� �Է����ּ��� ");
				continue;
			}
			break;
		}

		while (true) {
			System.out.println("=======================���� ����=======================");
			System.out.println("�װ���      ��� ");
			System.out.println(ticketInfo);
			// rf.totalPlaneInfo();
			System.out.println("����        : " + mng.getPrice() + "��");
			System.out.println("ī���     : " + mng.getCardCompany());
			System.out.println("ī���ȣ  : " + mng.getCardNum());
			System.out.println("CVC��ȣ : " + mng.getCvcNum());
			System.out.println("��ȿ�Ⱓ  : " + mng.getValidity());
			System.out.println("�Һΰ���  : " + mng.getInstallment());
			System.out.println("���������� �Ͻðڽ��ϱ�?");
			System.out.println("  1.Yes   2.No");
			System.out.print("���� > ");

			switch (sc.nextLine()) {
			case "1":
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");

				System.out.println("=======================���� ����=======================");
				System.out.println("�װ���      ��� ");
				System.out.println(ticketInfo);
				// rf.totalPlaneInfo();
				System.out.println("����        : " + mng.getPrice() + "��");//
				System.out.println("ī���     : " + mng.getCardCompany());
				System.out.println("ī���ȣ  : " + mng.getCardNum());
				System.out.println("CVC��ȣ : " + mng.getCvcNum());
				System.out.println("��ȿ�Ⱓ  : " + mng.getValidity());
				System.out.println("�Һΰ���  : " + mng.getInstallment());
				System.out.println("���� ���� : " + TimeStamp());
				System.out.println("�������ּż� �����մϴ� �ູ�� ���� �Ǽ���^^");
				break;
			case "2":
				break;
			default:
				System.out.println("�Է°��� �߸��Ǿ����ϴ�. �ٽ��ѹ� Ȯ�����ּ���");
				continue;
			}
			break;
		}
		System.out.println("�����ý����� ����Ǿ����ϴ�.");
		while (true) {
			System.out.println("=====================================================");
			System.out.println("    1.���Ϻ�����                  2.����");
			System.out.print("���� > ");
			switch (sc.nextLine()) {
			case "1":

				// sm.mail(id);
				break;
			case "2":
				break;
			default:
				System.out.println("�Է°��� �߸��Ǿ����ϴ�. �ٽ��ѹ� Ȯ�����ּ���");
				continue;
			}
			break;
		}

	}

	// �������Ա� �޼ҵ�
	public void account(String id) {

		MemberMNG mng = Join.memberMap.get(id);

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		cal.add(Calendar.DATE, +3); // 3�ϵ� �ð�
		mng.setPrice(ReservationFix.totalprice);// ���� ����
		String ticketInfo = " �������� : " + mng.getTicketinfo().GoDate + "\n �������� : " + mng.getTicketinfo().BackDate
				+ "\n ������� : " + mng.getTicketinfo().startplace + "\n ��������: " + mng.getTicketinfo().arrplace;

		try {
			System.out.println("=======================���� ����=======================");
			System.out.println("�Աݰ���     : " + COMPANY_ACCOUNT);
			System.out.println("����           : " + mng.getPrice() + "��");
			System.out.println("�װ���        ��� ");
			System.out.println(ticketInfo);
			// mng.setTicketInformation(ticketInformation);
			System.out.println("�̸� : " + mng.getName());
			System.out.println("�Աݱ���     : " + df.format(cal.getTime()) + "����");
			System.out.println();
			System.out.println("��ſ� ���࿡ ���� ���߿� �Բ��� �ּż� �����մϴ�.");
			System.out.println("���� ��õ� ���ѱ��� �Ա����� ���� ��� �ڵ����� ���� ��� ó�� �˴ϴ�.");
			while (true) {
				System.out.println("=====================================================");
				System.out.println("    1.���Ϻ�����                   2.����");
				System.out.print("���� > ");
				switch (sc.nextLine()) {
				case "1":
					// sm.mail(id);
					break;
				case "2":
					break;
				default:
					System.out.println("�Է°��� �߸��Ǿ����ϴ�. �ٽ��ѹ� Ȯ�����ּ���");
					continue;
				}
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ���� ùȭ�� �޼ҵ�
	public void paymentFirstView() {
		System.out.println("----------------------------");
		System.out.println("     �ڡڡڰ��� ����� �����ϼ���ڡڡ�");
		System.out.println();
		System.out.println("    1.ī�����     2.�������Ա�");
		System.out.println("----------------------------");
		System.out.print("���� > ");
	}

	// ����ð� ����ִ� �޼ҵ�
	private static String TimeStamp() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy�� MM�� dd�� hh�� mm�� ss��");
		return format.format(new Date());// ���� �ð��� ������ �� �ִ�.
	}
}