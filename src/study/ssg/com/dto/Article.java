package study.ssg.com.dto;

import study.ssg.com.util.Util;

public class Article {
	// static 힙 메모리로 들어가면서
	// 처음 선언된 딱 한번만 초기화가 된다.
	// 그 뒤로는 값이 누적
	public static int index = 0;
	public int articleId;
	public String title;
	public String body;
	public String regDate;

	public Article(String title, String body) {
		this.title = title;
		this.body = body;
		this.index++;
		this.articleId = this.index;
		this.regDate = Util.getNowDateStr();
	}
}