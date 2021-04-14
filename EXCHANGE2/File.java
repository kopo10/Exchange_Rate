package EXCHANGE.EXCHANGE2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class File {

	public void write(int M, double Won, int ExMoney, int Charge) throws IOException {
		FileOutputStream output = new FileOutputStream("C:\\Users\\���ѿ�\\Desktop\\out13.csv", true);                     //���� ���� ������ ��ġ�� ����ϰ� true�� �Է��ϸ� �� ���� ���� �ǰ� �ٽ� �Է��ϸ�
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); //��¥ �ð� �Է� ���� 							//�� �ؿ� �����ؼ� ��µȴ�.
		Calendar time = Calendar.getInstance(); //"YYYY-MM-dd HH:mm:ss"�� ���·� ��¥�� �ð��� �޾��ֱ� ���ؼ� �ʿ��� Ŭ�����̴�  
		ConstValueClass val = new ConstValueClass(); //ȯ���� �ҷ����� ���� �ʿ��ϴ�.
		OutputClass out = new OutputClass(); // �پ��� �޼ҵ带 �ҷ����� ���� �ʿ��ϴ�
		RunExchangeClass run = new RunExchangeClass();
		int N = M;
		String USD_Error = out.BALANCE_ERROR_USD(); //USD�޷��� ������ �� ����� �޽����̴�.
		String EUR_Error = out.BALANCE_ERROR_EUR(); //EUR�޷��� ������ �� ����� �޽����̴�.
		String JPY_Error = out.BALANCE_ERROR_JPY(); //JPY�޷��� ������ �� ����� �޽����̴�.
		String write = " ";

		if (N == 1) { // write������ ù��° M�� 1�̶�� ( run�Լ����� USD�� ȯ���� ���� 1�̶�� ����� ������ 1�� �Է����ش�.
			if (run.Check_Balance_USD(ExMoney) == true) { //��ȯ�ҷ��� ��ȭ�� �ݾ��� ��ȯ�ҷ��� ��ȭ�� �뷱������ ���� ��
				write = sdf.format(time.getTime())  //�ð��� ���ϴ� ������ �Է����ش�.
						+ String.format("\n��û�ݾ�, ȯ����ȭ, ȯ���ݾ�, �Ž�����, ���� �޷�\n%d��,%s,%d�޷�,%d��,%d�޷�\n", (int) Won, "USD",
								ExMoney, Charge, ConstValueClass.BALANCE_USD);
				output.write(write.getBytes()); //csv���Ͽ� �Է�
				output.close(); //�Է� ����
			} else { //��ȭ�� �뷱���� �� ���� ��
				write = sdf.format(time.getTime()) + "\n" + USD_Error + "\n"; // Error�޽����� ǥ�����ش�.
				output.write(write.getBytes());
				output.close();
			}

		} else if (N == 2) { //ù��° ���ڰ� 2�� �� ���θ� ������ֱ�� �޴�.
			if ((int) Won < (ExMoney * ConstValueClass.BALANCE_EUR)) { //�޷��� ���� ������� ���ش�
				write = sdf.format(time.getTime())
						+ String.format("\n��û�ݾ�, ȯ����ȭ, ȯ���ݾ�, �Ž�����, ���� ����\n%d��,%s,%d����,%d��,%d����\n", (int) Won, "UER",
								ExMoney, Charge, ConstValueClass.BALANCE_EUR);
				output.write(write.getBytes());
				output.close();
			} else {
				write = sdf.format(time.getTime()) + "\n" + EUR_Error + "\n";
				output.write(write.getBytes());
				output.close();
			}

		} else if (N == 3) { //ù��° ���ڰ� 2�� �� ��ȭ�� ������ֱ�� �޴�.
			if ((int) Won > (ExMoney * ConstValueClass.BALANCE_JPY)) { //�޷��� ���� ������� ���

				write = sdf.format(time.getTime())
						+ String.format("\n��û�ݾ�, ȯ����ȭ, ȯ���ݾ�, �Ž�����, ���� ��\n%d��,%s,%d��,%d��,%d��\n", (int) Won, "YEN",
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
