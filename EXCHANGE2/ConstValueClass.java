package EXCHANGE.EXCHANGE2;

public class ConstValueClass {
	final static double EX_USD = 1133.9; //환율을 위한 상수
	final static double EX_EUR = 1333.1; //환율을 위한 상수
	final static double EX_JPY = 10.3;   //환율을 위한 상수
	final static int CHANGE_TYPE_USD = 1; //switch문 사용시 어떤 통화인지 확인용
	final static int CHANGE_TYPE_EUR = 2; //switch문 사용시 어떤 통화인지 확인용
	final static int CHANGE_TYPE_JPY = 3; //switch문 사용시 어떤 통화인지 확인용
	
	final static int CHARGE_KOR_5000 = 5000; //코드를 볼 때 이해가 더 쉽게 된다.
	final static int CHANGE_USD_100 = 100; //코드를 볼 때 이해가 더 쉽게 된다.
	final static int CHANGE_EUR_500 = 500; //코드를 볼 때 이해가 더 쉽게 된다.
	final static int CHANGE_JPY_10000 = 10000; //코드를 볼 때 이해가 더 쉽게 된다.
	
	public static int BALANCE_USD = 5000; //달러 밸런스
	public static int BALANCE_EUR = 5000; //유로 밸런스
	public static int BALANCE_JPY = 1000000; //엔화 밸러스
}

//2
//final롤로 값을 고정하고 싶은 값이나 balance값 같은 값을 계속 저장하고 싶은 값들을 모아둔 클래스다