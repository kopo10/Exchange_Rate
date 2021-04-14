package EXCHANGE.EXCHANGE2;

import java.io.IOException;

public class RunExchangeClass {
	public OutputClass outClass = null;
	public File file = null;

	public RunExchangeClass() {
		outClass = new OutputClass();
		file = new File();
	}
	
	public boolean Check_Balance_USD(int Re_USD) {    //�뷱���� Ȯ�� �� �� ����ϴ� �޼ҵ��̴�.
		if (Re_USD <= ConstValueClass.BALANCE_USD) {  // ���� ���ϴ� �ݾ׺��� ���� �ݾ��� ������ �ִٸ� ��ȯ�� �����ֱ� ������			
			return true;                              // Ȯ���� �ؾ��Ѵ�.
		} else {
			return false;
		}
	}

	public boolean Check_Balance_EUR(int Re_EUR) {   //���� �뷱�� Ȯ�� �޼ҵ�
		if (Re_EUR <= ConstValueClass.BALANCE_EUR) {
			return true;
		} else {
			return false;
		}
	}

	public boolean Check_Balance_JPY(int Re_JPY) {  //��ȭ �뷱�� Ȯ�� �޼ҵ�
		if (Re_JPY <= ConstValueClass.BALANCE_JPY) {
			return true;
		} else {
			return false;
		}
	}

	public int changeToUSD(double moneyKOR) throws IOException {  //�޷��� ����ϴ� �޼ҵ��̴�. �� �޼ҵ�� �߿��ϴٰ� �����Ѵ�.
		double returnUSD;										  // ó���� returnUSD�� double�� �����ϴ� ������ ȯ�� ����� �ϰ� �Ǹ� �Ҽ����� �߻��ϱ� ��������.
		int returnRealUSD = 0; 									 // �� �Ŀ� returnRealUSD�� ���ؼ� ���ϴ� ������ŭ �����ش�. �� �ڵ�� �޷��� 10�޷��������� ��ȯ���ֱ� ������
		int charge;												 // returnUSD - (returnUSD % 10) �� ���ָ�ȴ�. (returnUSD % 10)�� �ϰ� �Ǹ� ���� �ڸ��� ���� �ǰ� 
		returnUSD = moneyKOR / ConstValueClass.EX_USD;		     // ��ȯ�ҷ��� �޷��� ���ְ� �Ǹ� 1�� �ڸ��� ��������.
		returnRealUSD = (int) (returnUSD - (returnUSD % 10));

		charge = (int) (moneyKOR - returnRealUSD * ConstValueClass.EX_USD);  // �ܵ��� ���� ��û�� �ѱ������� returnRealUSD ������ �ٲܷ��� ��ȭ�ݾ׿� ȯ���� �����ָ� �ȴ�.
		charge = (charge / 10) * 10;  // 1�� ������ ���� ��^^ //�ѱ����� 10�� ������ �ּ� ������ �������� 1�� �ڸ��� �����ش�.
		if (Check_Balance_USD(returnRealUSD)) { //14line���� ���� �޼ҵ带 �̿��ؼ� ���� ��û�ݾ׺��� ���� �뷱���� ������ Ȯ���Ѵ�.
		
			outClass.outputResultUSD(returnRealUSD); // ��ȯ�� �޷��� �Է�
			outClass.outputResultWON(charge); //�ܵ�			
			ConstValueClass.BALANCE_USD -= returnRealUSD; // ��ȯ���� �޷��� �뷱������ ������ϱ� ������ �ʿ��ϴ�.
			outClass.BALANCE_USD(ConstValueClass.BALANCE_USD); // ���� �뷱�� ǥ��
			file.write(1, moneyKOR, returnRealUSD, charge); //���� �������� �ʾҴµ� csv���Ϸ� ����ϱ� ���ؼ� �ʿ��ϴ�. 1���� ��ȭ����,��û�ݾ�,��ȯ�ݾ�,�ܵ����̴�.
			
		} else { //��û�ϴ� �ݾ��� ���� �����ϰ� �ִ� �뷱������ ���� �Ǹ� ��ȯ�� ���� �� ���� �ȴ�.
			System.out.println(outClass.BALANCE_ERROR_USD()); // �ܾ��� �����ϴٴ� ǥ���� �޼ҵ带 �̿����ش�(OutputClass�� �ִ�)
			file.write(1, 0, returnRealUSD, 0); //�ܾ��� ���ٴ� ǥ�÷� csv���Ͽ� ǥ���ϱ� ���ؼ���.
		}
		return ConstValueClass.BALANCE_USD; //�뷱���� retrun������ �޾��ش�.
	}

	public int changeToEUR(double moneyKOR) throws IOException { //�޷��� ���� ������� Ǯ���ش�.
		double returnEUR;
		int returnRealEUR;
		int charge;
		returnEUR = moneyKOR / ConstValueClass.EX_EUR;
		returnRealEUR = (int) returnEUR; //���δ� 1���α��� ��ȯ���� �ϱ� ������ %�� ����� �ʿ䰡 ����.
		charge = (int) (moneyKOR - returnRealEUR * ConstValueClass.EX_EUR);
		charge = (charge / 10) * 10; // 1�� ������ ���� ��^^

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

	public int changeToJPY(double moneyKOR) throws IOException { //�޷��� ���� ����̴�.
		double returnJPY;
		int returnRealJPY;
		int charge;
		returnJPY = moneyKOR / ConstValueClass.EX_JPY;
		returnRealJPY = (int) (returnJPY - (returnJPY % 1000)); //��ȭ�� 1000���� ���� ���� ��ȯ�����̱� ������ 1000�� ���ϴ� ���� �ܵ����� �����ش�.

		charge = (int) (moneyKOR - returnRealJPY * ConstValueClass.EX_JPY);
		charge = (charge / 10) * 10;  // 1�� ������ ���� ��^^
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
//�Է� Ŭ������ ��� Ŭ������ ���� �� ȯ�� ����� �� �� �ִ� Ŭ������ �����Ѵ�.
//���� if(Check_Balance)�� �������� ���� outClass�� �����ͼ� �´�.
//�׸��� ����Ŭ������ ���� ������غ��� ���� �´ٸ� �ٽ� ���ƿ´�.
//�׸��� booleanŬ������ ���� ȯ���� ���̶� ��� Ŭ������ ������� �ܾ��̶� �񱳸� �Ѵ�.
//ȯ�� ���� �޼ҵ忡 if�� ȯ���ݾ��� �뷱������ �� ���� ���� ���� ���� �����ְ� ���� ������ �뷱�� ���� �־��ָ� �뷱�� ���� ������Ʈ�ȴ�.
//�뷱���� ���� ���ϴ� �ݾ׺��� ���� �� �ֱ� ������ ���� �޽��� �޼ҵ嵵 ����� �ش�.

//ȯ���� �� �� �����̳� ���� ������ ȯ���� �����ִ� ��찡 �ֱ� ������ �ڽ��� ���ϴ� ������ŭ ȯ���� ���ֱ� ���ؼ�
//���ϴ� ��ȭ ȯ���� ������ �� ��ȭ�� ��ȭ�� ���ϴ� ������ŭ %�� ������ ���� ȯ���� �ݾ׿��� ���ش�.
//�� ���� ȯ���� �� �ݾ��̴�.

//- (�ʼ��߰�) ȯ�� �����ߴ� ��� �����͸� File�� �����ϴ� ��� �߰�, ��¥/�ð�/��û�ݾ�/ȯ���ݾ�/�Ž����� ��� ����
//(�� ���� �����غ���) �� ������ ������ �� ���ึ�� �ҷ������� ������ �����ϱ� 
