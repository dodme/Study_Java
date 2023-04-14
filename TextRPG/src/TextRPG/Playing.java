package TextRPG;

import TextRPG.Character.Job;
import TextRPG.Monster.MonJob;

public class Playing {

	public static void main(String[] args) throws InterruptedException {

		Character Player1 = new Character();
		Player1.SetCharacterInfo("���� �ʹ� ��ƴ�", Job.Archor);
		Player1.PrintCharacterInfo();

		Monster Monster1 = new Monster();
		Monster1.SetMonsterInfo(MonJob.Dragon);
		Monster1.PrintMonsterInfo();

		int p1Hp = Player1.GetHp();
		int m1Hp = Monster1.GetHp();

		Thread.sleep(1000);
		System.out.println("������ �����մϴ�.");
		Thread.sleep(1000);


		while(p1Hp > 0 && m1Hp > 0)
		{
			Thread.sleep(1000);
			if (p1Hp > 0)
			{
				System.out.println("�÷��̾��� ����!");
				if((Player1.GetAtk() - Monster1.GetDef()) > 0)
				{
					System.out.println((Player1.GetAtk() - Monster1.GetDef()) + "�� �������� �������ϴ�.");
					m1Hp -= (Player1.GetAtk() - Monster1.GetDef());
				}
				else
				{
					System.out.println("0�� �������� �������ϴ�.");
				}
			}
			Thread.sleep(1000);
			if(m1Hp > 0)
			{
				System.out.println("������ ����!");
				if((Monster1.GetAtk() - Player1.GetDef()) > 0)
				{
					System.out.println((Monster1.GetAtk() - Player1.GetDef()) + "�� �������� �Ծ����ϴ�.");
					p1Hp -= (Monster1.GetAtk() - Player1.GetDef());
				}
				else
				{
					System.out.println("0�� �������� �Ծ����ϴ�.");
				}
			}
			Thread.sleep(1000);
			
			
			System.out.println("�÷��̾� ���� HP : " + p1Hp);
			System.out.println("���� ���� HP : " + m1Hp);
			
			
			if(p1Hp <= 0)
				System.out.println("�÷��̾ �й��߽��ϴ�.");
			else if(m1Hp <= 0) 
				System.out.println("�÷��̾ �¸��߽��ϴ�.");
			
		}

		System.out.println("������ ����Ǿ����ϴ�.");

	}

}
