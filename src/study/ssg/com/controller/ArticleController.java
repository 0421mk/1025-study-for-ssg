package study.ssg.com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import study.ssg.com.dto.Article;

public class ArticleController extends Controller {
	Scanner scanner;

	public ArticleController(Scanner scanner) {
		this.scanner = scanner;
	}

	public void doAction(String command, String actionMethodName) {
		switch (actionMethodName) {
		case "write":
			doWrite();
			break;
		case "list":
			showList(command);
			break;
		case "detail":
			showDetail(command);
			break;
		case "modify":
			doModify(command);
			break;
		case "delete":
			doDelete(command);
			break;
		default:
			System.out.println("존재하지 않는 메서드입니다.");
			break;
		}
	}

	public void doWrite() {
		// view
		System.out.printf("제목: ");
		String title = scanner.nextLine();

		System.out.printf("내용: ");
		String body = scanner.nextLine();
		// view

		// Controller -> title, body를 받았다는 것을 인지
		// 전처리 -> 행위를 하는 것 -> Service
		Article article = new Article(title, body); // dto(Database Transfer Object)
		articles.add(article); // dao(Database Access Object)

		// view
		System.out.println(article.articleId + "번 게시물이 생성되었습니다.");
	}

	public void showList(String command) {

		// article list => 목록 출력
		// article list {keyword} => keyword 포함 목록 출력
		if (articles.size() == 0) {
			System.out.println("게시물이 존재하지 않습니다.");
			return;
		}

		String input = command.substring("article list".length()).trim();

		int inputSize = input.length();
		List<Article> foundArticles = new ArrayList<>();
		// foundArticles는 태생부터 리스트
		// 게시물이 없는 경우 null로 체크하는 것이 아니라 size() == 0으로 체크해야 함

		if (inputSize == 0) {
			foundArticles = articles;
		} else {
			for (Article article : articles) {
				if (article.title.contains(input)) {
					foundArticles.add(article);
				}
			}
		}

		if (foundArticles.size() == 0) {
			System.out.println("게시물이 존재하지 않습니다.");
			return;
		}

		System.out.printf("  번호 /    제목\n");
		for (Article article : foundArticles) {
			System.out.printf("%4d / %10s\n", article.articleId, article.title);
		}

	}

	public void showDetail(String command) {

		String input = command.substring("article detail ".length()).trim();

		if (input.equals("")) {
			System.out.println("숫자를 입력해주세요.");
			return;
		}

		// 정수인지 확인하는 정규표현식으로 문자열 검토
		boolean cmdCheck = input.matches("-?\\d+");

		int foundId = 0;
		if (cmdCheck) {
			foundId = Integer.parseInt(input);

		} else {
			System.out.println("숫자를 입력해주세요.");
			return;
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
			return;
		}

	}

	public void doModify(String command) {
		String input = command.substring("article modify ".length()).trim();

		if (input.equals("")) {
			System.out.println("숫자를 입력해주세요.");
			return;
		}

		// 정수인지 확인하는 정규표현식으로 문자열 검토
		boolean cmdCheck = input.matches("-?\\d+");

		int foundId = 0;
		if (cmdCheck) {
			foundId = Integer.parseInt(input);
		} else {
			System.out.println("숫자를 입력해주세요.");
			return;
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
			return;
		}

	}

	public void doDelete(String command) {

		String input = command.substring("article delete ".length()).trim();

		if (input.equals("")) {
			System.out.println("숫자를 입력해주세요.");
			return;
		}

		// 정수인지 확인하는 정규표현식으로 문자열 검토
		boolean cmdCheck = input.matches("-?\\d+");

		int foundId = 0;
		if (cmdCheck) {
			foundId = Integer.parseInt(input);
		} else {
			System.out.println("숫자를 입력해주세요.");
			return;
		}

		Article foundArticle = getFoundArticleById(foundId);

		if (foundArticle != null) {

			articles.remove(foundArticle);

			System.out.println(foundArticle.articleId + "번 게시물이 삭제되었습니다.");
		} else {
			System.out.println(foundId + "번 게시물이 존재하지 않습니다.");
			return;
		}

	}

	public void makeTestData() {
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
