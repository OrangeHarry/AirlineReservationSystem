package Wilderness;

public class Test1 {
//	public static void main(String[] args) throws MessagingException {
//		SendEmail sm = new SendEmail();
////		String id = "dd";
////		MemberMNG mng = Join.memberMap.get(id);
//		Join join = new Join();
//		String id = null; 
////		id = join.run();
//		sm.mail(id);
//	}
}
//package Wilderness;
//
//import java.util.Properties;
//import java.util.Scanner;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//class SendEmail {
//	void mail(String id) throws MessagingException {
//		ReservationFix r = new ReservationFix();
//		MemberMNG mng = Join.memberMap.get(id);
//		Scanner sc = new Scanner(System.in);
//		
//		// ���� ���� ����
//		String host = "smtp.gmail.com";
//		String username = "hhm7761@gmail.com";
//		String password = "awdA~4862852";
//
//		// properties ���� (SMTP ���� ���� ����(���̹�)
//		Properties props = new Properties();
//		props.put("mail.smtp.host", host);
//		props.put("mail.smtp.port", "465");
//		props.put("mail.smtps.auth", "true");
//		props.put("mail.transport.protocol", "smtp");
//		
//		// ���� ����
//		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(username, password);
//			}
//		});
////		Authenticator auth = new Authenticator() {
////			protected PasswordAuthentication getPasswordAuthentication() {
////				return new PasswordAuthentication(username, password);
////			}
////		};
////		Session session = Session.getDefaultInstance(props, auth);
//		MimeMessage msg = new MimeMessage(session);
//		
//		
//		try {
//			
//			System.out.println("���� �߼��� ���Ͻô� �ּҸ� �Է����ּ���");
//			String mailadress = sc.nextLine();
//			System.out.println("��� ��ٷ� �ּ���");
//
//			// ���� ����
//			String recipient = mailadress;
//			String subject = "�װ� ���� ���� �Դϴ�.";
//			String body = "gg";
////
////					"==========================================" + "\n<Ƽ������>" + "\n������ : " + mng.getTicketinfo().GoDate
////							+ "\n������ : " + mng.getTicketinfo().BackDate + "\n����� : " + mng.getTicketinfo().startplace
////							+ "\n������: " + mng.getTicketinfo().arrplace + "\n�߰��⳻��:" + mng.getTicketinfo().Food
////							+ "\n�߰���ȭ��:" + mng.getTicketinfo().Baggage + "\n�¼� ���׷��̵�:" + mng.getTicketinfo().SeatUp
////							+ "\n==========================================" + "\n�������ּż� �����մϴ� �ູ�� ���� �Ǽ���^^";
//
//
//			// ���� ����
//			msg.setSubject(subject);
//			msg.setText(body);
//			msg.setFrom(new InternetAddress(username));
//			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
//
//			// �߼� ó��
//			Transport transport = session.getTransport("smtp");
//			transport.connect(host, username, password);
//			transport.sendMessage(msg, msg.getAllRecipients());
//			transport.close();
//
//			System.out.println("�߼��� �Ϸ����ϴ�.");
//
//		} catch (Exception e) {
//			System.out.println("�߸� �Է���ϴ�.");
//			e.printStackTrace();
//		}
//	}
//}
