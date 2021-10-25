package study.ssg.com;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("==== 프로그램 시작 ====");
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.printf("명령어 입력: ");
			String command = scanner.nextLine();
			
			if(command.equals("article list")) {
				System.out.println("article list");
			} else if(command.equals("article write")) {
				System.out.println("article write");
			} else if(command.equals("article modify")) {
				System.out.println("article modify");
			} else if(command.equals("article delete")) {
				System.out.println("article delete");
			} else if(command.equals("system exit")) {
				System.out.println("system exit");
				break;
			} else {
				System.out.println("잘못된 명령어입니다.");
			}
		}
		
		System.out.println("==== 프로그램 끝 ====");
		
	}
}
