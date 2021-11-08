package study.ssg.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import study.ssg.com.dto.Article;

public class App {
	private List<Article> articles = new ArrayList<>();
	
	public void start() {
		System.out.println("==== 프로그램 시작 ====");
		Scanner scanner = new Scanner(System.in);

		makeTestData();

		while (true)

		{
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

				if (articles.size() == 0) {
					System.out.println("게시물이 존재하지 않습니다.");
					continue;
				}

				System.out.printf("  번호 /    제목\n");
				for (Article article : articles) {
					System.out.printf("%4d / %10s\n", article.articleId, article.title);
				}

			} else if (command.startsWith("article detail ")) {

				String input = command.substring("article detail ".length()).trim();

				if (input.equals("")) {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}

				// 정수인지 확인하는 정규표현식으로 문자열 검토
				boolean cmdCheck = input.matches("-?\\d+");

				int foundId = 0;
				if (cmdCheck) {
					foundId = Integer.parseInt(input);
				} else {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}

				Article foundArticle = getFoundArticleById(foundId);

				if (foundArticle != null) {
					System.out.printf("번호: %d\n", foundArticle.articleId);
					System.out.printf("작성날짜: %s\n", foundArticle.regDate);
					System.out.printf("제목: %s\n", foundArticle.title);
					System.out.printf("내용: %s\n", foundArticle.body);
					System.out.println("===========");
				} else {
					System.out.println(foundId + "번 게시물이 존재하지 않습니다.");
					continue;
				}

			} else if (command.startsWith("article modify ")) {

				String input = command.substring("article modify ".length()).trim();

				if (input.equals("")) {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}

				// 정수인지 확인하는 정규표현식으로 문자열 검토
				boolean cmdCheck = input.matches("-?\\d+");

				int foundId = 0;
				if (cmdCheck) {
					foundId = Integer.parseInt(input);
				} else {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}

				Article foundArticle = getFoundArticleById(foundId);

				if (foundArticle != null) {
					System.out.printf("제목: ");
					String title = scanner.nextLine();

					System.out.printf("내용: ");
					String body = scanner.nextLine();

					foundArticle.title = title;
					foundArticle.body = body;

					System.out.println(foundArticle.articleId + "번 게시물이 수정되었습니다.");
				} else {
					System.out.println(foundId + "번 게시물이 존재하지 않습니다.");
					continue;
				}

			} else if (command.startsWith("article delete ")) {

				String input = command.substring("article delete ".length()).trim();

				if (input.equals("")) {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}

				// 정수인지 확인하는 정규표현식으로 문자열 검토
				boolean cmdCheck = input.matches("-?\\d+");

				int foundId = 0;
				if (cmdCheck) {
					foundId = Integer.parseInt(input);
				} else {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}

				Article foundArticle = getFoundArticleById(foundId);

				if (foundArticle != null) {

					articles.remove(foundArticle);

					System.out.println(foundArticle.articleId + "번 게시물이 삭제되었습니다.");
				} else {
					System.out.println(foundId + "번 게시물이 존재하지 않습니다.");
					continue;
				}

			} else if (command.equals("system exit")) {
				break;
			} else {
				System.out.println("잘못된 명령어입니다.");
			}
		}

		System.out.println("==== 프로그램 끝 ====");
	}

	private void makeTestData() {
		System.out.println("테스트 데이터를 생성합니다.");

		articles.add(new Article("title1", "body1"));
		articles.add(new Article("title2", "body2"));
		articles.add(new Article("title3", "body3"));
	}
	
	private Article getFoundArticleById(int foundId) {
		Article foundArticle = null;
		
		for (Article article : articles) {
			if (article.articleId == foundId) {
				foundArticle = article;
			}
		}
		
		return foundArticle;
	}
}
