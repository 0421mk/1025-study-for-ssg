package study.ssg.com;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("==== 프로그램 시작 ====");
		Scanner scanner = new Scanner(System.in);
		
		System.out.printf("명령어 입력: ");
		String command = scanner.nextLine();
		
		System.out.println(command);
		System.out.println("==== 프로그램 끝 ====");
		
		// SSG 게시판, 회원 기능이 들어간 프로그램
		// 게시판은 읽기, 쓰기, 수정, 삭제, 페이징 기능 구현
		// 회원은 회원가입, 로그인
		// 리팩토링 => 코드를 잘게 쪼개는, 하나의 파일을 여러개의 메서드화 시키는 작업
		
	}
}
