package study.ssg.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import study.ssg.com.controller.ArticleController;
import study.ssg.com.dto.Article;
import study.ssg.com.dto.Member;

public class App {
	
	Scanner scanner = new Scanner(System.in);
	private ArticleController articleController = new ArticleController(scanner);
	
	
	public void start() {
		System.out.println("==== 프로그램 시작 ====");

		articleController.makeTestData();

		while (true)

		{
			System.out.printf("명령어 입력: ");
			String command = scanner.nextLine();

			if (command.equals("article write")) {

				articleController.doWrite();

			} else if (command.startsWith("article list")) {
				
				articleController.showList(command);

			} else if (command.startsWith("article detail ")) {

				articleController.showDetail(command);

			} else if (command.startsWith("article modify ")) {

				articleController.doModify(command);

			} else if (command.startsWith("article delete ")) {

				articleController.doDelete(command);

			} else if (command.equals("member join")) {
				String loginId;
				String loginPw;
				String loginPwConfirm;
				
				while (true) {
					System.out.printf("로그인 ID: ");
					loginId = scanner.nextLine();
					boolean passCheck = false;
					
					if(members.size() == 0) {
						passCheck = true;
					} else {
						for(Member member : members) {
							if(!member.loginId.equals(loginId)) {
								passCheck = true;
								break;
							}
						}
					}
					
					if(passCheck) {
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
					
					if(!loginPw.equals(loginPwConfirm)) {
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
				
			} else if (command.equals("system exit")) {
				break;
			} else {
				System.out.println("잘못된 명령어입니다.");
			}
		}

		System.out.println("==== 프로그램 끝 ====");
	}

}
