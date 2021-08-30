package Wilderness;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Join {
	private Scanner sc;
	static Map<String, MemberMNG> memberMap;

	public Join() {
		memberMap = new HashMap<>();
		sc = new Scanner(System.in);
		// memberMap.put("admin", new MemberMNG("admin", "admin", "namju"));
	}

	// 실행메소드
	public String run() {
		int key = 0;
		String id = null;
		while (true) {
			try {
				key = menu();
				switch (key) {
				case 1:
					id = Login();
					break;
				case 2:
					id = MemberJoin();
					break;
				case 0:
					System.out.println("~~~~~~~잘가라~~~~~~~나를 잊어라~~~~~");
					System.exit(0);
					break;
				default:
					System.out.println("잘못된 입력값입니다.다시 입력하세요");
					continue;

				}
			} catch (Exception e) {
				System.out.println("잘못입력하였습니다. 다시 입력하세요");
				continue;
			}
			break;
		}

		return id;
	}

	// 회원가입
	private String MemberJoin() {
		// int count =0;
		String id;
		while (true) {
			id = getStrInput("              ID : ");
			if (memberMap.get(id) != null) {
				System.out.println("중복된 ID입니다.");
				continue;
			}

			String pw = getStrInput("         PassWord : ");
			String pw2 = getStrInput("Password Confirm : ");

			// pw, pwcheck가 동일한지 확인
			if (pw.equals(pw2)) {
				String name = getStrInput("           Name : ");

				memberMap.put(id, new MemberMNG(id, pw, name));
				System.out.println(id + "님 가입을 축하드립니다.");
				break;
				// 예약 ui가 들어가야할 곳
			} else {
				System.out.println("비밀번호가 일치하지 않습니다. 확인해주세요.");
			}
		}
		return id;
	}

	private String Login() {
		String id = getStrInput("      ID : ");
		String pw = getStrInput("PassWord : ");

		if (!memberMap.containsKey(id)) {
			// System.out.println(member); //null
			System.out.println("등록되지 않은 ID입니다.");
			System.out.println("다시 입력해주시거나 회원가입을 진행해 주세요");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			run();

		} else {
			// key 가있어
			// pw가 일치하는경우
			if (memberMap.get(id).getPW().equals(pw)) {
				System.out.println("[" + memberMap.get(id).getName() + "]님 께서 로그인 하셨습니다.");
			} else { // pw 가 일치하지 않는 경우
				System.out.println("비밀번호가 틀렸습니다.");
				pw = getStrInput("PassWord : ");
				if (memberMap.get(id).getPW().equals(pw)) {
					System.out.println("[" + memberMap.get(id).getName() + "]님 께서 로그인 하셨습니다.");

				}

			}
		}
		return id;
	}

	// 사용자의 입력을 받아주는 메소드
	private String getStrInput(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}

	// 메뉴와 메뉴선택 사용자 입력까지 받아와서 choice로 return
	private int menu() throws NumberFormatException {
		System.out.println("       [1]로그인 [2]회원가입 [0]종료");
		int choice = 0;
		choice = Integer.parseInt(sc.nextLine());
		return choice;
	}
}