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
//		// 메일 관련 정보
//		String host = "smtp.gmail.com";
//		String username = "hhm7761@gmail.com";
//		String password = "awdA~4862852";
//
//		// properties 설정 (SMTP 서버 정보 설정(네이버)
//		Properties props = new Properties();
//		props.put("mail.smtp.host", host);
//		props.put("mail.smtp.port", "465");
//		props.put("mail.smtps.auth", "true");
//		props.put("mail.transport.protocol", "smtp");
//		
//		// 메일 세션
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
//			System.out.println("메일 발송을 원하시는 주소를 입력해주세요");
//			String mailadress = sc.nextLine();
//			System.out.println("잠시 기다려 주세요");
//
//			// 메일 내용
//			String recipient = mailadress;
//			String subject = "항공 예약 정보 입니다.";
//			String body = "gg";
////
////					"==========================================" + "\n<티켓정보>" + "\n가는편 : " + mng.getTicketinfo().GoDate
////							+ "\n오는편 : " + mng.getTicketinfo().BackDate + "\n출발지 : " + mng.getTicketinfo().startplace
////							+ "\n도착지: " + mng.getTicketinfo().arrplace + "\n추가기내식:" + mng.getTicketinfo().Food
////							+ "\n추가수화물:" + mng.getTicketinfo().Baggage + "\n좌석 업그레이드:" + mng.getTicketinfo().SeatUp
////							+ "\n==========================================" + "\n결제해주셔서 감사합니다 행복한 여행 되세요^^";
//
//
//			// 메일 관련
//			msg.setSubject(subject);
//			msg.setText(body);
//			msg.setFrom(new InternetAddress(username));
//			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
//
//			// 발송 처리
//			Transport transport = session.getTransport("smtp");
//			transport.connect(host, username, password);
//			transport.sendMessage(msg, msg.getAllRecipients());
//			transport.close();
//
//			System.out.println("발송이 완료됬습니다.");
//
//		} catch (Exception e) {
//			System.out.println("잘못 입력됬습니다.");
//			e.printStackTrace();
//		}
//	}
//}
