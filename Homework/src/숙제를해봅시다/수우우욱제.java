package �������غ��ô�;

import java.util.Scanner;

public class �������� {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int workTime = 8;
		int pay = 8590;
		int startTime = Integer.parseInt(scan.nextLine());
		
		if(startTime <= 24 && startTime >= 0)
		{
			if(startTime >= 6 && startTime <= 14)
				System.out.println(workTime * pay + "��");
			else if(startTime > 14)
				System.out.println((workTime * pay) + ((startTime - 14) * 500) + "��");
			else
				System.out.println((workTime * pay) + ((6 - startTime) * 500) + "��");
		}
		else
			System.out.println("0 ~ 24������ �ð��� �Է����ּ���.");
		
		
		scan.close();
		
	}

}
