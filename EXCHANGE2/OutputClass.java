package EXCHANGE.EXCHANGE2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OutputClass {

	public String BALANCE_ERROR_USD() {    //달러 보유가 부족할 시 에러표시
		String a = "달러 보유액이 부족합니다";    //처음에는 void로 받았는데 나중에 csv 파일로 받을 때
		return a;  							//String 으로 받는게 더 좋아서 변경
	}

	public String BALANCE_ERROR_EUR() {    // 유로가 부족 할 때
		String a = "유로 보유액이 부족합니다";
		return a;
	}

	public String BALANCE_ERROR_JPY() {   // 엔화가 부족 할 때
		String a = "엔화 보유액이 부족합니다";
		return a;
	}

	public void BALANCE_USD(int BalanceUSD) {                //달러 벨런스를 표시해준다. 
		System.out.println("보유 미화 " + BalanceUSD + " 달러"); //BALANCE_USD의 인자를 출력해준다.
	}														  //run함수에서 사용할 텐데 그때 인자를  ConstValueClass에 있는 밸런스를 사용한다 

	public void BALANCE_EUR(int BalanceEUR) {				//유로 벨런스를 표시해준다.
		System.out.println("보유 유로 " + BalanceEUR + " 유로");
	}

	public void BALANCE_JPY(int BalanceJPY) {				//엔화 벨런스를 표시해준다.
		System.out.println("보유 엔화 " + BalanceJPY + " 엔");
	}

	private void printResultUSD(int returnRealUSD, int outputUSD100, int outputUSD50, int outputUSD10) { //  75line의 outputResultUSD메소드부터 보고 오자.
		System.out.println(returnRealUSD + " 달러");														 //75라인에서와 같이 인자를 입력해준후 출력해준다.
		System.out.println("100 달러 지폐 " + outputUSD100 + " 장 ");
		System.out.println("50 달러 지폐" + outputUSD50 + " 장 ");
		System.out.println("10 달러 지폐 " + outputUSD10 + " 장 \n");
	}

	private void printResultEUR(int outputEUR500, int outputEUR100, int outputEUR50, int outputEUR20, int outputEUR10, // 달러와 마찬가지로 각각 인자를 생성후 입력
			int outputEUR5, int outputEUR2, int outputEUR1, int returnRealEUR) { 
		System.out.println(returnRealEUR + " 유로");
		System.out.println("500 유로 지폐 " + outputEUR500 + " 장 ");
		System.out.println("100 유로 지폐 " + outputEUR100 + " 장 ");
		System.out.println("50 유로 지폐 " + outputEUR50 + " 장 ");
		System.out.println("20 유로 지폐 " + outputEUR20 + " 장 ");
		System.out.println("10 유로 지폐 " + outputEUR10 + " 장 ");
		System.out.println("5 유로 지폐 " + outputEUR5 + " 장 ");
		System.out.println("2 유로 동전 " + outputEUR2 + " 개 ");
		System.out.println("1 유로 동전 " + outputEUR1 + " 개 \n");
	}

	private void printResultJPY(int returnRealJPY, int outputJPY10000, int outputJPY5000, int outputJPY1000) { // 엔화도 같은 방식으로 해준다.
		System.out.println(returnRealJPY + " 엔 ");
		System.out.println("10000 엔 지폐 " + outputJPY10000 + " 장 ");
		System.out.println("5000 엔 지폐 " + outputJPY5000 + " 장 ");
		System.out.println("1000 엔 지폐 " + outputJPY1000 + " 장 \n");
	}

	private void printResultWON(int charge, int charge5000, int charge1000, int charge500, int charge100, int charge50, //잔돈도 같은 방법이다.
			int charge10) {
		System.out.println("잔돈 = " + charge + " 원 ");
		System.out.println("5000 원 지폐 " + charge5000 + " 장 ");
		System.out.println("1000 원 지폐 " + charge1000 + " 장 ");
		System.out.println("500 원 지폐 " + charge500 + " 장 ");
		System.out.println("100 원 지폐 " + charge100 + " 장 ");
		System.out.println("50 원 지폐 " + charge50 + " 장 ");
		System.out.println("10 원 지폐 " + charge10 + " 장 ");
	}

	public void outputResultUSD(int returnRealUSD) {    // 이 메소드의 인자는 정말로 확전할 달러로 이 값을 받아서 각 단위별 화폐의 수량을 파악 할 수 있다
		int outputUSD100, outputUSD50, outputUSD10;     //환전할 금액을 받아서 계산 후 계산한 값을 순서에 맞춰서 입력해준다. 다시 37line으로 가자
		outputUSD100 = returnRealUSD / ConstValueClass.CHANGE_USD_100;  //  ConstValueClass.CHANGE_USD_100 이 값은 100으로도 대체가 가능하지만 코딩의 이해를 높히기 위해 입력해줬다.
		outputUSD50 = (returnRealUSD % ConstValueClass.CHANGE_USD_100) / 50;
		outputUSD10 = ((returnRealUSD % ConstValueClass.CHANGE_USD_100) % 50) / 10;
		printResultUSD(returnRealUSD, outputUSD100, outputUSD50, outputUSD10);
	}

	public void outputResultEUR(int returnRealEUR) {  // 유로 계산 메소드로 유로 화폐를 계산해준다.
		int outputEUR500, outputEUR100, outputEUR50, outputEUR20;
		int outputEUR10, outputEUR5, outputEUR2, outputEUR1;

		outputEUR500 = returnRealEUR / ConstValueClass.CHANGE_EUR_500;
		outputEUR100 = (returnRealEUR % ConstValueClass.CHANGE_EUR_500) / 100;
		outputEUR50 = ((returnRealEUR % ConstValueClass.CHANGE_EUR_500) % 100) / 50;
		outputEUR20 = (((returnRealEUR % ConstValueClass.CHANGE_EUR_500) % 100) % 50) / 20;
		outputEUR10 = ((((returnRealEUR % ConstValueClass.CHANGE_EUR_500) % 100) % 50) % 20) / 10;
		outputEUR5 = (((((returnRealEUR % ConstValueClass.CHANGE_EUR_500) % 100) % 50) % 20) % 10) / 5;
		outputEUR2 = (returnRealEUR % 5) / 2;
		outputEUR1 = (returnRealEUR % 5) % 2;

		printResultEUR(outputEUR500, outputEUR100, outputEUR50, outputEUR20, outputEUR10, outputEUR5, outputEUR2,
				outputEUR1, returnRealEUR);
	}

	public void outputResultJPY(int returnRealJPY) { //엔화 계산 메소드로 엔화 화폐를 계산해준다.
		int outputJPY10000, outputJPY5000, outputJPY1000;
		outputJPY10000 = returnRealJPY / ConstValueClass.CHANGE_JPY_10000;
		outputJPY5000 = (returnRealJPY % ConstValueClass.CHANGE_JPY_10000) / 5000;
		outputJPY1000 = ((returnRealJPY % ConstValueClass.CHANGE_JPY_10000) % 5000) / 1000;
		printResultJPY(returnRealJPY, outputJPY10000, outputJPY5000, outputJPY1000);
	}

	public void outputResultWON(int charge) { //잔돈 계산 메소드로 잔돈 화폐를 계산해준다.
		int charge5000, charge1000, charge500, charge100, charge50, charge10;

		charge5000 = charge / ConstValueClass.CHARGE_KOR_5000;
		charge1000 = (charge % ConstValueClass.CHARGE_KOR_5000) / 1000;
		charge500 = ((charge % ConstValueClass.CHARGE_KOR_5000) % 1000) / 500;
		charge100 = (((charge % ConstValueClass.CHARGE_KOR_5000) % 1000) % 500) / 100;
		charge50 = ((((charge % ConstValueClass.CHARGE_KOR_5000) % 1000) % 500) % 100) / 50;
		charge10 = (((((charge % ConstValueClass.CHARGE_KOR_5000) % 1000) % 500) % 100) % 50) / 10;

		printResultWON(charge, charge5000, charge1000, charge500, charge100, charge50, charge10);
	}
}

//3
//입력 클레스와 상수 클레스를 생성 후 환전금과 잔돈을 출력할 메소드를 생성해준다.
//아직 밸런스와 잔액 부족과 같은 것은 생각하지말고 환전금액과 잔액만을 생각한다.
//환전받을 돈의 화폐단위와 잔돈의 화폐 단위를 생각해서 각각 계산해준다.
//그다음 출력메소드를 만들어서 형식에 맞게 입력한다 (인자를 입력할 때 순서 잘 맞게 하기)
