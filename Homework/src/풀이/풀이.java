package Ǯ��;

import java.util.Scanner;

public class Ǯ�� {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		//���ϴ� �ð�
		int workTime = 8;
		//�����ӱ�
		int pay = 8590;
		int nightTime = 0;
		int startworkTime = Integer.parseInt(scan.nextLine());


		if(startworkTime < 24)
		{
			if(startworkTime > 14)
			{
				//�߰�����
				nightTime = startworkTime - 14;
				pay += (500 * nightTime);
				System.out.println((8590 * (workTime - nightTime)) + pay);
			}
			else
			{
				System.out.println((pay * workTime));
			}
				
		}
		else
			System.out.println("�Ϸ簡 ��ð�����..?");
		
		scan.close();
	}

}