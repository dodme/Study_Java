package Ǯ��;

import java.util.Scanner;

public class Ǯ��_�迭_01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String[] arrStr = new String[] {"����", "����", "����", "java"};
		
		/* int[] arrScore = new int[] {20,30,48,50}; */
		
		/*
		 * for(int i = 0; i < 4; i++) { System.out.print(arrStr[i]);
		 * System.out.println(arrScore[i]); }
		 */
		
		for(String str : arrStr)
		{
			System.out.print(str + "���� : ");
			int score = Integer.parseInt(scan.nextLine());
			System.out.println(score);
		}
		
		scan.close();
		
	}

}
