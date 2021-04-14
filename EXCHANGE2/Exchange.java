package EXCHANGE.EXCHANGE2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Exchange {

	public static void main(String[] args) throws IOException { //메인 클래스로 가능한 한 짧게 만들어줁다.
		// TODO Auto-generated method stub
		double moneyKOR1 = 0;
		int input = 0;
		String a = "";
		String b = "";
		InputClass inputClass = new InputClass(); // InputClass를 받아온다.
		RunExchangeClass runClass = new RunExchangeClass(); //RunExchangeClass를 받아온다.
		while (true) {															
			moneyKOR1 = inputClass.inpuFromConsoleWon(); // InputClass의 inpuFromConsoleWon return값을  
			if ((moneyKOR1) == 0)					     // moneyKOR1라고 해주는 것이기 때문에 고객의 요청금액이된다.
				break;									// (moneyKOR1) == 0 이 되면 요청금액이 0이기 때문에 종료한다.
			input = inputClass.inpuFromConsoleType(); 	// input을  InputClass의 inpuFromConsoleType의 return값으로 받기 때문에 통화를 결정하는 역할을 한다.
			if (input == 4) //출력에 4번을 입력하면 Exit라고 적었기 때문에 4번을 입력하면 종료하게 된다.
				break;
			switch (input) {
			case ConstValueClass.CHANGE_TYPE_USD: //1과 같은 의미이지만 코딩을 더 쉽게 이해하기 위해 바꿨다.
				runClass.changeToUSD(moneyKOR1);
				break;

			case ConstValueClass.CHANGE_TYPE_EUR: //2와 같은 의미이지만 코딩을 더 쉽게 이해하기 위해 바꿨다.
				runClass.changeToEUR(moneyKOR1);
				break;

			case ConstValueClass.CHANGE_TYPE_JPY: //3과 같은 의미이지만 코딩을 더 쉽게 이해하기 위해 바꿨다.
				runClass.changeToJPY(moneyKOR1);
				break;
			}
		}
	}
}

// 5
// 환전 프로그램의 메인 클래스이다. InputClass와 RunExchangeClass를 받는다.
// 13, 14 line라인에서 고객이 원하는 금액과 환전 통화를 정해준다.
// do while문안에 switch를 넣어서 각각의 통화마다 case를 나눠준다.
// 각각의 case마다 runClass에서 환전 계산 식을 가져온다.
// 고객이 환전을 원하는 원화가 0원이거나 Exit 번호인 4번을 누르기 전까지 계속 반복한다.
