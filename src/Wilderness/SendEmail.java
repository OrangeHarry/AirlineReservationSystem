package Wilderness;

import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

class SendEmail {
	void mail(String id) throws MessagingException {

		ReservationFix r = new ReservationFix();
		MemberMNG mng = Join.memberMap.get(id);

		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("���� �߼��� ���Ͻô� �ּҸ� �Է����ּ���");
			String mailadress = sc.nextLine();
			System.out.println("��� ��ٷ� �ּ���");
			// ���� ���� ����
			String host = "smtp.gmail.com";
			String username = "hhm7761@gmail.com";
			String password = "awdA~4862852";

			// ���� ����
			String recipient = mailadress;
			String subject = "�װ� ���� ���� �Դϴ�.";
			String body =

					        "=========================================="+
							"\n<Ƽ������>"+
							"\n������ : " + mng.getTicketinfo().GoDate + 
							"\n������ : " + mng.getTicketinfo().BackDate + 
							"\n����� : "+ mng.getTicketinfo().startplace + 
							"\n������: " + mng.getTicketinfo().arrplace+
							"\n�߰��⳻��:" +mng.getTicketinfo().Food+
							"\n�߰���ȭ��:" +mng.getTicketinfo().Baggage+
							"\n�¼� ���׷��̵�:" +mng.getTicketinfo().SeatUp+
							"\n=========================================="+
							"\n�������ּż� �����մϴ� �ູ�� ���� �Ǽ���^^";

			// properties ����
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.enable","true");
			// ���� ����
			Session session = Session.getDefaultInstance(props);
			MimeMessage msg = new MimeMessage(session);

			// ���� ����
			msg.setSubject(subject);
			msg.setText(body);
			msg.setFrom(new InternetAddress(username));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

			// �߼� ó��
			Transport transport = session.getTransport("smtp");
			transport.connect(host, username, password);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();

			System.out.println("�߼��� �Ϸ����ϴ�.");

		} catch (Exception e) {
			System.out.println("�߸� �Է���ϴ�.");
			e.printStackTrace();
		}
	}
}
