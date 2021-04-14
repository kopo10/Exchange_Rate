package EXCHANGE.EXCHANGE2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class File {

	public void write(int M, double Won, int ExMoney, int Charge) throws IOException {
		FileOutputStream output = new FileOutputStream("C:\\Users\\류한열\\Desktop\\out13.csv", true);                     //내가 만들 파일의 위치를 출력하고 true를 입력하면 그 값이 저장 되고 다시 입력하면
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); //날짜 시간 입력 형태 							//그 밑에 연속해서 출력된다.
		Calendar time = Calendar.getInstance(); //"YYYY-MM-dd HH:mm:ss"의 형태로 날짜와 시간을 받아주기 위해서 필요한 클래스이다  
		ConstValueClass val = new ConstValueClass(); //환율을 불러오기 위해 필요하다.
		OutputClass out = new OutputClass(); // 다양한 메소드를 불러오기 위해 필요하다
		RunExchangeClass run = new RunExchangeClass();
		int N = M;
		String USD_Error = out.BALANCE_ERROR_USD(); //USD달러가 부족할 때 출력할 메시지이다.
		String EUR_Error = out.BALANCE_ERROR_EUR(); //EUR달러가 부족할 때 출력할 메시지이다.
		String JPY_Error = out.BALANCE_ERROR_JPY(); //JPY달러가 부족할 때 출력할 메시지이다.
		String write = " ";

		if (N == 1) { // write인자의 첫번째 M이 1이라면 ( run함수에서 USD를 환전할 떄는 1이라고 해줬기 때문에 1을 입력해준다.
			if (run.Check_Balance_USD(ExMoney) == true) { //교환할려는 원화의 금액이 교환할려는 통화의 밸런스보다 작을 때
				write = sdf.format(time.getTime())  //시간과 원하는 정보를 입력해준다.
						+ String.format("\n요청금액, 환전통화, 환전금액, 거스름돈, 남은 달러\n%d원,%s,%d달러,%d원,%d달러\n", (int) Won, "USD",
								ExMoney, Charge, ConstValueClass.BALANCE_USD);
				output.write(write.getBytes()); //csv파일에 입력
				output.close(); //입력 종료
			} else { //통화의 밸런스가 더 작을 때
				write = sdf.format(time.getTime()) + "\n" + USD_Error + "\n"; // Error메시지를 표시해준다.
				output.write(write.getBytes());
				output.close();
			}

		} else if (N == 2) { //첫번째 인자가 2일 때 유로를 계산해주기로 햇다.
			if ((int) Won < (ExMoney * ConstValueClass.BALANCE_EUR)) { //달러와 같은 방식으로 해준다
				write = sdf.format(time.getTime())
						+ String.format("\n요청금액, 환전통화, 환전금액, 거스름돈, 남은 유로\n%d원,%s,%d유로,%d원,%d유로\n", (int) Won, "UER",
								ExMoney, Charge, ConstValueClass.BALANCE_EUR);
				output.write(write.getBytes());
				output.close();
			} else {
				write = sdf.format(time.getTime()) + "\n" + EUR_Error + "\n";
				output.write(write.getBytes());
				output.close();
			}

		} else if (N == 3) { //첫번째 인자가 2일 때 엔화를 계산해주기로 햇다.
			if ((int) Won > (ExMoney * ConstValueClass.BALANCE_JPY)) { //달러와 같은 방식으로 계산

				write = sdf.format(time.getTime())
						+ String.format("\n요청금액, 환전통화, 환전금액, 거스름돈, 남은 엔\n%d원,%s,%d엔,%d원,%d엔\n", (int) Won, "YEN",
								ExMoney, Charge, ConstValueClass.BALANCE_JPY);
				output.write(write.getBytes());
				output.close();
			} else {
				write = sdf.format(time.getTime()) + "\n" + JPY_Error + "\n";
				output.write(write.getBytes());
				output.close();
			}
		}
	}

}
