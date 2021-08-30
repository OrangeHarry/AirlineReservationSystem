package Wilderness;

import java.util.Scanner;

public class CustomerSign {
	private Scanner sc;

	public CustomerSign() {
		sc = new Scanner(System.in);
	}

	// 예약자 정보 얻기
	public void customerInformation(String id) {

		String gender;
		String email;
		String birth;

		MemberMNG mng = Join.memberMap.get(id);

		while (true) {
			try {
				System.out.println("\n==================================");
				System.out.println("예약자 정보를 입력해주세요");
				System.out.print("성별을 선택해주세요(M or F) > \n");
				switch (gender = sc.nextLine()) {
				case "M":
					gender = "남자";
					break;
				case "m":
					gender = "남자";
					break;
				case "F":
					gender = "여자";
					break;
				case "f":
					gender = "여자";
					break;
				default:
					continue;
				}
				mng.setIsMan(gender);
				System.out.print("생년월일을 6자리를 입력해주세요 (931126) > ");
				birth = (sc.nextLine());

				System.out.print("이메일을 입력해주세요 > ");
				email = (sc.nextLine());

				System.out.println("==================================");
				System.out.println("       예약자 정보를 확인하여 주십시오");
				System.out.println("이름         : " + mng.getName());

				System.out.println("성별         : " + gender);
				System.out.println("생년월일   : " + birth);
				System.out.println("이메일      : " + email);
				System.out.println("==================================");
				System.out.println("  1.다음        2.다시 작성");
				System.out.print("선택 >  ");

				switch (sc.nextInt()) {
				case 1:
					break;
				case 2:
					continue;
				case 3:
					break;
				}
				mng.setBirth(birth);
				mng.setEmail(email);

			} catch (Exception e) {
				System.out.println("입력값이 잘못되었습니다. 다시 입력해주세요");
				continue;
			}
			break;
		}
	}
}