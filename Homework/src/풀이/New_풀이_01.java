package ����;

import java.util.Scanner;

public class New_Ǯ��_01 {

	public static void main(String[] args) {
		
		// �� ���� �ִ������� ���ϼ���
		// �� ���� �Է¹�������
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter The Integer : ");
		int A = Integer.parseInt(scan.nextLine());
		
		System.out.print("Enter The Integer : ");
		int B = Integer.parseInt(scan.nextLine());
		
		int result = 0;
		// ��� : � ���� ������ ������ �� �������� 0�� �Ǵ� ��
		
		while(B > 0)
		{
			result = A % B;
			A = B;
			B = result;
		}
		
		System.out.println(A);
		
		scan.close();
	}

}
