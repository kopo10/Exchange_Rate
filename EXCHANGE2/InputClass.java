package EXCHANGE.EXCHANGE2;

import java.util.Scanner;

public class InputClass {
	Scanner sc = null;
	public InputClass() {
		 sc = new Scanner(System.in);
	}
	
	public int inpuFromConsoleWon() {              //고객의 돈을 출력하는 메소드로 return값으로 고객의 원화 돈을 출력한다
		int moneyKOR;  								//Run함수에서 0원 입력시 종료 설정
		System.out.println("Input your Won");
		moneyKOR = sc.nextInt();
		return moneyKOR;
	}

	public int inpuFromConsoleType() {           //고객이 원하는 통화 타입을 선택하는 것으로 return값으로 통화를 선택한다.
		int input;								//Run함수에서 4번 입력시 종료 설정
		System.out.println("Which money do you want?\n"
					+ "1.USD\n\n"
					+ "2.EUR\n\n" 
					+ "3.JPY\n\n" 
					+ "4.Exit");
		input = sc.nextInt();
		return input;
	}
}

// 1
// 5개의 클래스 중 입력값을 담당하는 클래스이다.
// 고객이 요청하는 원화환전금액과 환전통화를 선택 할 수있다.
// return 값을 받게 해서 원화와 통화 선택을 할 수 있게 한다.