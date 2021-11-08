package study.ssg.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import study.ssg.com.controller.ArticleController;
import study.ssg.com.controller.Controller;
import study.ssg.com.controller.MemberController;
import study.ssg.com.dto.Article;
import study.ssg.com.dto.Member;

public class App {
	
	Scanner scanner = new Scanner(System.in);
	// articleController의 부모 컨트롤러가 이 프로그램에서는 최상단 컨트롤러, 즉 진짜 컨트롤러
	// 하지만 더 최상단 컨트롤러를 만든다면 바뀔 수 있다.
	private ArticleController articleController = new ArticleController(scanner);
	private MemberController memberController = new MemberController(scanner);
	
	public void start() {
		System.out.println("==== 프로그램 시작 ====");

		articleController.makeTestData();
		memberController.makeTestData();

		while (true)

		{
			System.out.printf("명령어 입력: ");
			String command = scanner.nextLine();
			
			if (command.equals("system exit")) {
				break;
			}
			
			String[] commandBits = command.split(" ");
			
			String controllerName = commandBits[0];
			String actionMethodName = commandBits[1];
			
			Controller controller = null;
			
			if (commandBits.length <= 1) {
				// 예외 처리
			}
			
			// Front Controller (대분류)
			if(controllerName.equals("article")) {
				controller = articleController;
			} else if(controllerName.equals("member")) {
				controller = memberController;
			} else {
				System.out.println("잘못된 명령어입니다.");
			}
			
			// 발작 버튼
			controller.doAction(command, actionMethodName);
		}

		System.out.println("==== 프로그램 끝 ====");
	}

}
