package EXCHANGE.EXCHANGE2;

import java.util.Scanner;

public class InputClass {
	Scanner sc = null;
	public InputClass() {
		 sc = new Scanner(System.in);
	}
	
	public int inpuFromConsoleWon() {              //���� ���� ����ϴ� �޼ҵ�� return������ ���� ��ȭ ���� ����Ѵ�
		int moneyKOR;  								//Run�Լ����� 0�� �Է½� ���� ����
		System.out.println("Input your Won");
		moneyKOR = sc.nextInt();
		return moneyKOR;
	}

	public int inpuFromConsoleType() {           //���� ���ϴ� ��ȭ Ÿ���� �����ϴ� ������ return������ ��ȭ�� �����Ѵ�.
		int input;								//Run�Լ����� 4�� �Է½� ���� ����
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
// 5���� Ŭ���� �� �Է°��� ����ϴ� Ŭ�����̴�.
// ���� ��û�ϴ� ��ȭȯ���ݾװ� ȯ����ȭ�� ���� �� ���ִ�.
// return ���� �ް� �ؼ� ��ȭ�� ��ȭ ������ �� �� �ְ� �Ѵ�.