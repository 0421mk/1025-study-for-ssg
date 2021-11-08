package study.ssg.com.controller;

import java.util.Scanner;

import study.ssg.com.dto.Member;

public class MemberController extends Controller {
	Scanner scanner;

	public MemberController(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void doAction(String command, String actionMethodName) {
		switch (actionMethodName) {
		case "join":
			doJoin();
			break;
		default:
			System.out.println("존재하지 않는 메서드입니다.");
			break;
		}
	}

	public void doJoin() {

		String loginId;
		String loginPw;
		String loginPwConfirm;

		while (true) {
			System.out.printf("로그인 ID: ");
			loginId = scanner.nextLine();
			boolean passCheck = false;

			if (members.size() == 0) {
				passCheck = true;
			} else {
				for (Member member : members) {
					if (!member.loginId.equals(loginId)) {
						passCheck = true;
						break;
					}
				}
			}

			if (passCheck) {
				break;
			} else {
				System.out.println("이미 존재하는 아이디입니다.");
				continue;
			}

		}

		while (true) {
			System.out.printf("로그인 PW: ");
			loginPw = scanner.nextLine();

			System.out.printf("로그인 PW 확인: ");
			loginPwConfirm = scanner.nextLine();

			if (!loginPw.equals(loginPwConfirm)) {
				System.out.println("비밀번호를 확인해주세요.");
				continue;
			}

			break;
		}

		System.out.printf("이름: ");
		String name = scanner.nextLine();

		Member member = new Member(loginId, loginPw, name);
		members.add(member);

		System.out.println(member.name + "님이 회원가입 하셨습니다.");

	}
}
