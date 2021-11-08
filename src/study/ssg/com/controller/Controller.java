package study.ssg.com.controller;

import java.util.ArrayList;
import java.util.List;

import study.ssg.com.dto.Article;
import study.ssg.com.dto.Member;

public class Controller {
	public List<Article> articles;
	public List<Member> members;
	
	Controller() {
		articles = new ArrayList<>();
		members = new ArrayList<>();
	}
}
