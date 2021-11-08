package study.ssg.com.dto;

import study.ssg.com.util.Util;

public class Member extends Dto {
	// static 힙 메모리로 들어가면서
	// 처음 선언된 딱 한번만 초기화가 된다.
	// 그 뒤로는 값이 누적
	public static int index = 0;
	public int memberId;
	public String loginId;
	public String loginPw;
	public String name;
	public String regDate;

	public Member(String loginId, String loginPw, String name) {
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.name = name;
		this.index++;
		this.memberId = this.index;
		this.regDate = Util.getNowDateStr();
	}
}