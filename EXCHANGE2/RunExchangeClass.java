package EXCHANGE.EXCHANGE2;

import java.io.IOException;

public class RunExchangeClass {
	public OutputClass outClass = null;
	public File file = null;

	public RunExchangeClass() {
		outClass = new OutputClass();
		file = new File();
	}
	
	public boolean Check_Balance_USD(int Re_USD) {    //밸런스를 확인 할 때 사용하는 메소드이다.
		if (Re_USD <= ConstValueClass.BALANCE_USD) {  // 고객이 원하는 금액보다 적은 금액을 가지고 있다면 교환을 못해주기 때문에			
			return true;                              // 확인을 해야한다.
		} else {
			return false;
		}
	}

	public boolean Check_Balance_EUR(int Re_EUR) {   //유로 밸런스 확인 메소드
		if (Re_EUR <= ConstValueClass.BALANCE_EUR) {
			return true;
		} else {
			return false;
		}
	}

	public boolean Check_Balance_JPY(int Re_JPY) {  //엔화 밸런스 확인 메소드
		if (Re_JPY <= ConstValueClass.BALANCE_JPY) {
			return true;
		} else {
			return false;
		}
	}

	public int changeToUSD(double moneyKOR) throws IOException {  //달러를 계산하는 메소드이다. 이 메소드는 중요하다고 생각한다.
		double returnUSD;										  // 처음에 returnUSD을 double로 선언하는 이유는 환율 계산을 하게 되면 소수점이 발생하기 때문에다.
		int returnRealUSD = 0; 									 // 그 후에 returnRealUSD를 통해서 원하는 단위만큼 끊어준다. 이 코드는 달러가 10달러단위까지 교환해주기 때문에
		int charge;												 // returnUSD - (returnUSD % 10) 을 해주면된다. (returnUSD % 10)을 하게 되면 일의 자리만 남게 되고 
		returnUSD = moneyKOR / ConstValueClass.EX_USD;		     // 교환할려는 달러에 빼주게 되면 1의 자리는 없어진다.
		returnRealUSD = (int) (returnUSD - (returnUSD % 10));

		charge = (int) (moneyKOR - returnRealUSD * ConstValueClass.EX_USD);  // 잔돈은 고객이 요청한 한국돈에서 returnRealUSD 실제로 바꿀려는 통화금액에 환율을 곱해주면 된다.
		charge = (charge / 10) * 10;  // 1원 단위는 은행 돈^^ //한국돈은 10원 단위가 최소 단위기 때무문에 1의 자리는 없애준다.
		if (Check_Balance_USD(returnRealUSD)) { //14line에서 만든 메소드를 이용해서 고객의 요청금액보다 보유 밸런스가 많은지 확인한다.
		
			outClass.outputResultUSD(returnRealUSD); // 교환할 달러를 입력
			outClass.outputResultWON(charge); //잔돈			
			ConstValueClass.BALANCE_USD -= returnRealUSD; // 교환해준 달러를 밸런스에서 빼줘야하기 때문에 필요하다.
			outClass.BALANCE_USD(ConstValueClass.BALANCE_USD); // 남은 밸런스 표시
			file.write(1, moneyKOR, returnRealUSD, charge); //아직 설명하지 않았는데 csv파일로 출력하기 위해서 필요하다. 1번은 통화선택,요청금액,교환금액,잔돈순이다.
			
		} else { //요청하는 금액이 현재 보유하고 있는 밸런스보다 많게 되면 교환을 해줄 수 없게 된다.
			System.out.println(outClass.BALANCE_ERROR_USD()); // 잔액이 부족하다는 표시의 메소드를 이용해준다(OutputClass에 있다)
			file.write(1, 0, returnRealUSD, 0); //잔액이 없다는 표시로 csv파일에 표시하기 위해서다.
		}
		return ConstValueClass.BALANCE_USD; //밸런스를 retrun값으로 받아준다.
	}

	public int changeToEUR(double moneyKOR) throws IOException { //달러와 같은 방식으로 풀어준다.
		double returnEUR;
		int returnRealEUR;
		int charge;
		returnEUR = moneyKOR / ConstValueClass.EX_EUR;
		returnRealEUR = (int) returnEUR; //유로는 1유로까지 교환가능 하기 때문에 %을 사용할 필요가 없다.
		charge = (int) (moneyKOR - returnRealEUR * ConstValueClass.EX_EUR);
		charge = (charge / 10) * 10; // 1원 단위는 은행 돈^^

		if (Check_Balance_EUR(returnRealEUR)) {
			outClass.outputResultEUR(returnRealEUR);
			outClass.outputResultWON(charge);
			ConstValueClass.BALANCE_EUR -= returnRealEUR;
			outClass.BALANCE_EUR(ConstValueClass.BALANCE_EUR);
			file.write(2, moneyKOR, returnRealEUR, charge);
			
		} else {
			System.out.println(outClass.BALANCE_ERROR_EUR());
			file.write(2, 0, 0, 0);
		}
			return ConstValueClass.BALANCE_EUR;
			
	}

	public int changeToJPY(double moneyKOR) throws IOException { //달러와 같은 방식이다.
		double returnJPY;
		int returnRealJPY;
		int charge;
		returnJPY = moneyKOR / ConstValueClass.EX_JPY;
		returnRealJPY = (int) (returnJPY - (returnJPY % 1000)); //엔화는 1000엔이 가장 작은 교환단위이기 때문에 1000엔 이하는 전부 잔돈으로 돌려준다.

		charge = (int) (moneyKOR - returnRealJPY * ConstValueClass.EX_JPY);
		charge = (charge / 10) * 10;  // 1원 단위는 은행 돈^^
		if (Check_Balance_JPY(returnRealJPY)) {

			outClass.outputResultJPY(returnRealJPY);
			outClass.outputResultWON(charge);
			ConstValueClass.BALANCE_JPY -= returnRealJPY;
			outClass.BALANCE_JPY(ConstValueClass.BALANCE_JPY);
			file.write(3, moneyKOR, returnRealJPY, charge);
			
		} else {
			System.out.println(outClass.BALANCE_ERROR_JPY());
			file.write(3, 0, 0, 0);
		}
			return ConstValueClass.BALANCE_JPY;
	}

}

//4
//입력 클레스와 상수 클레스를 생성 후 환전 계산을 할 수 있는 클레스를 생선한다.
//먼저 if(Check_Balance)를 생각하지 말고 outClass를 가져와서 온다.
//그리고 메인클레스에 가서 출력을해보고 값이 맞다면 다시 돌아온다.
//그리고 boolean클레스를 만들어서 환전할 값이랑 상수 클레스에 만들어준 잔액이랑 비교를 한다.
//환전 수식 메소드에 if로 환전금액이 밸런스보다 더 많을 때랑 적을 때로 나눠주고 리턴 값으로 밸런스 값을 넣어주면 밸런스 값이 업데이트된다.
//밸런스가 고객이 원하는 금액보다 적을 수 있기 때문에 에러 메시지 메소드도 만들어 준다.

//환전을 할 때 동전이나 작은 단위는 환전을 안해주는 경우가 있기 때문에 자신이 원하는 단위만큼 환전을 해주기 위해서
//원하는 통화 환율로 나누고 그 통화를 통화의 원하는 단위만큼 %로 나눠준 값을 환전할 금액에서 빼준다.
//그 값이 환전해 줄 금액이다.

//- (필수추가) 환전 진행했던 모든 데이터를 File로 저장하는 기능 추가, 날짜/시간/요청금액/환전금액/거스름돈 모두 저장
//(더 많이 구현해보기) 위 저장한 내용이 매 실행마다 불려와져서 데이터 축적하기 
