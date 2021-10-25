package study.ssg.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		List<Article> articles = new ArrayList<>();

		System.out.println("==== 프로그램 시작 ====");
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.printf("명령어 입력: ");
			String command = scanner.nextLine();

			if (command.equals("article write")) {

				System.out.printf("제목: ");
				String title = scanner.nextLine();

				System.out.printf("내용: ");
				String body = scanner.nextLine();

				Article article = new Article(title, body);
				articles.add(article);

				System.out.println(article.articleId + "번 게시물이 생성되었습니다.");

			} else if (command.equals("article list")) {
				
				if(articles.size() == 0) {
					System.out.println("게시물이 존재하지 않습니다.");
					continue;
				}
				
				System.out.printf("  번호 /    제목\n");
				for (Article article : articles) {
					System.out.printf("%4d / %10s\n", article.articleId, article.title);
				}

			} else if (command.equals("article modify")) {
				System.out.println("article modify");
			} else if (command.equals("article delete")) {
				System.out.println("article delete");
			} else if (command.equals("system exit")) {
				System.out.println("system exit");
				break;
			} else {
				System.out.println("잘못된 명령어입니다.");
			}
		}

		System.out.println("==== 프로그램 끝 ====");

	}
}

class Article {
	// static 힙 메모리로 들어가면서
	// 처음 선언된 딱 한번만 초기화가 된다.
	// 그 뒤로는 값이 누적
	static int index = 0;
	int articleId;
	String title;
	String body;

	Article(String title, String body) {
		this.title = title;
		this.body = body;
		this.index++;
		this.articleId = this.index;
	}
}