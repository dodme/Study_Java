public class game {

	public static void main(String[] args) {
		monster target = new monster();
		monster newOne = new monster(1024);
		
		target = null;
		//���� ������ �ִ�. ġ��.
		System.gc();
		
		monster monsterArray[] = { new monster(), new monster()};

		for(monster current : monsterArray)
		{
			System.out.println(current.ShowLife());
		};
		
		for(int i = 0; i < monsterArray.length; i++)
		{
			System.out.println(monsterArray[i].ShowLife());
		};
		
		try
		{
			Thread.sleep(1000);
			target.Hit(50);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("������");
		};
		
		
		//System.out.println("Ÿ�� �� : " + target.ShowLife());
		System.out.println("���� �� : " + newOne.ShowLife());
		
		System.out.println("��ü ���� : " + monster.currentNumber);
	}

}