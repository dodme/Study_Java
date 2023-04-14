import java.util.Scanner;
public class game {

	static Scanner input = new Scanner(System.in);
	static Creature user = new Human();
	static Creature monster = EnterMonster();
	static int killCount = 0;
	static int potion = 3;
	
	public static void main(String[] args) 
	{
		System.out.println("����� ������ �������ϴ�.");
		System.out.println("��𼱰� �ڲٸ� ���Ͱ� Ƣ����� �ֽ��ϴ�.");
		System.out.println("������ ���ؼ� �׵��� �����ľ� �� �̴ϴ�.");
		Sleep(1.0f);
		
		game:
			while(true)
			{
				PrintState();  // ���� ���¸� ������
				if ( !UserAction( UserInput() ) )    // !�� ���̹Ƿν� ���� ��  false�� ������ �ٽ� ó������ �ǵ��� �شٴ� �ǹ�
				{
					continue game;
				};
				Sleep(0.5f);
				MonsterAction();
				Sleep(0.5f);
				if ( !UserDeathCheck() )
				{
					break game;
				};
			};
			
			System.out.println("----------------------------------------");
			System.out.println(killCount + "������ ���͸� ����ϰ�");
			if(potion > 0)
			{
				System.out.println("���ǰ��� ��ٰ� �׾����ϴ�.");
			}
			else
			{
				System.out.println("���Ǳ��� �� ������� �������̾����ϴ�.");
			};
			System.out.println("����� ������ ���⼭ �������ϴ�.");
	}
	
	public static void PrintState()
	{
		System.out.println("-----------------------------------------");
		System.out.println("[" + user.getName() + "]        |   [" + monster.getName() + "]");
		System.out.println("[" + user.getCurHealth() + "/" + user.getMaxHealth() + "]   | "
				+ "  [" +monster.getCurHealth() + "/" + monster.getMaxHealth() + "]" );
		System.out.println("���� ���� ��: " + killCount + " | ���� ����: " + potion);
        if(user.skillCooldown > 0)
        {
        	System.out.println("���� ��Ÿ��: " + user.skillCooldown);
        }
        else
        {
        	System.out.println("��ų ��� ����");
        };
		System.out.println("-----------------------------------------");
		System.out.println("1. ����  2. ��ų  3. ����");
	}
	public static void Sleep(float second)
	{
		try
		{
			Thread.sleep( (int) (second * 1000) );
		}
		catch(Exception e)
		{
			
		};
	}

	public static int UserInput()    // ������ �Է��� ����
	{
		String CurrentInput = input.next();
		
		if(CurrentInput.length() > 0)
		{
			switch(CurrentInput.charAt(0)) 
			{
			case '1' : return 1;
			case '2' : return 2;
			case '3' : return 3;
			default : return 0;
			}
		}
		else
		{
			return 0;
		}
	}
	
	public static boolean UserAction(int number)   // �Է� ���� ���� �׼����� ����
	{
		switch(number)
		{
		case 1 : 
			  user.DoAttack(monster);
			  return true;
		case 2 : 
			  if(user.skillCooldown <= 0)
			  {
				  user.Skill(monster);
				  return true;
			  }
			  else
			  {
				  System.out.println("�̹� �������� �̹� ��ų�� ����ϼ̽��ϴ�.");
				  return false;
			  }
			
		case 3 : 
			  if(potion > 0)
			  {
				  --potion;
				  int totalHeal = user.TakeHeal(100);
				  System.out.println("������ ����Ͽ� ������� " + totalHeal + " ȸ���ߴ�!");
				  
				  return true;
			  }
			  else
			  {
				  System.out.println("���� ������ �����ϴ�.");
				  return false;
			  }
		default : return false;
		}
	}
	
	public static boolean UserDeathCheck()
	{
		return user.getAlive();
	}

	public static void MonsterAction()
	{
		if(monster.getAlive())
		{
			monster.AI(user);
		}
		else
		{
			monster.Death(user);
			++killCount;
			System.out.println(monster.getName() + ", �����߷ȴ�!" );
			
			CloseBattle(); 
		};
	}
	
	public static void CloseBattle()
	{
		user.skillCooldown -= 1;  // ������ �� ���� ���� ������ ��Ÿ�� 1�� �پ��
		Sleep(1.0f);
		monster = EnterMonster();
		System.out.println("�� ƴ ���� " + monster.getName() + "�� ����!");
	}
 
	public static Creature EnterMonster()
	{
		//���� �ڸ� ������� �����ϼ���.
		int currentMonster = Creature.Random(0, 5);
		switch( currentMonster )
		{
		case 0 : return new Goblin();
		case 1 : return new Orc();
		case 2 : return new Dragon();
		case 3 : return new Vampire();
		case 4 : return new Gambler();
		default : return new Human();
		}
	}
}
