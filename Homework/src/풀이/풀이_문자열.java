package Ǯ��;

import java.util.Scanner;

public class Ǯ��_���ڿ� {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		// ���ڿ� ������~
		String inputStr = scan.nextLine();
		
		scan.close();
		
		for(int i = inputStr.length() - 1; i >= 0; i--)
		{
			System.out.print(inputStr.charAt(i));
		}
		
		
	}

}
