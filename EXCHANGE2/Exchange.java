package EXCHANGE.EXCHANGE2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Exchange {

	public static void main(String[] args) throws IOException { //���� Ŭ������ ������ �� ª�� ������.
		// TODO Auto-generated method stub
		double moneyKOR1 = 0;
		int input = 0;
		String a = "";
		String b = "";
		InputClass inputClass = new InputClass(); // InputClass�� �޾ƿ´�.
		RunExchangeClass runClass = new RunExchangeClass(); //RunExchangeClass�� �޾ƿ´�.
		while (true) {															
			moneyKOR1 = inputClass.inpuFromConsoleWon(); // InputClass�� inpuFromConsoleWon return����  
			if ((moneyKOR1) == 0)					     // moneyKOR1��� ���ִ� ���̱� ������ ���� ��û�ݾ��̵ȴ�.
				break;									// (moneyKOR1) == 0 �� �Ǹ� ��û�ݾ��� 0�̱� ������ �����Ѵ�.
			input = inputClass.inpuFromConsoleType(); 	// input��  InputClass�� inpuFromConsoleType�� return������ �ޱ� ������ ��ȭ�� �����ϴ� ������ �Ѵ�.
			if (input == 4) //��¿� 4���� �Է��ϸ� Exit��� ������ ������ 4���� �Է��ϸ� �����ϰ� �ȴ�.
				break;
			switch (input) {
			case ConstValueClass.CHANGE_TYPE_USD: //1�� ���� �ǹ������� �ڵ��� �� ���� �����ϱ� ���� �ٲ��.
				runClass.changeToUSD(moneyKOR1);
				break;

			case ConstValueClass.CHANGE_TYPE_EUR: //2�� ���� �ǹ������� �ڵ��� �� ���� �����ϱ� ���� �ٲ��.
				runClass.changeToEUR(moneyKOR1);
				break;

			case ConstValueClass.CHANGE_TYPE_JPY: //3�� ���� �ǹ������� �ڵ��� �� ���� �����ϱ� ���� �ٲ��.
				runClass.changeToJPY(moneyKOR1);
				break;
			}
		}
	}
}

// 5
// ȯ�� ���α׷��� ���� Ŭ�����̴�. InputClass�� RunExchangeClass�� �޴´�.
// 13, 14 line���ο��� ���� ���ϴ� �ݾװ� ȯ�� ��ȭ�� �����ش�.
// do while���ȿ� switch�� �־ ������ ��ȭ���� case�� �����ش�.
// ������ case���� runClass���� ȯ�� ��� ���� �����´�.
// ���� ȯ���� ���ϴ� ��ȭ�� 0���̰ų� Exit ��ȣ�� 4���� ������ ������ ��� �ݺ��Ѵ�.
