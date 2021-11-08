package study.ssg.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import study.ssg.com.controller.ArticleController;
import study.ssg.com.controller.MemberController;
import study.ssg.com.dto.Article;
import study.ssg.com.dto.Member;

public class App {
	
	Scanner scanner = new Scanner(System.in);
	private ArticleController articleController = new ArticleController(scanner);
	private MemberController memberController = new MemberController(scanner);
	
	
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
				
				memberController.doJoin();
				
			} else if (command.equals("system exit")) {
				break;
			} else {
				System.out.println("잘못된 명령어입니다.");
			}
		}

		System.out.println("==== 프로그램 끝 ====");
	}

}
