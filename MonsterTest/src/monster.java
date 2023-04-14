public class monster {
	//���� �����
	private int life = 100;
	//���� ������
	public static int currentNumber = 0;
	
	monster(int wantLife)
	{
		life = wantLife;
		++currentNumber;
	}
	//�μ��� �Է����� �ʾ����� ���� �⺻����
	monster()
	{
		life = 100;
		++currentNumber;
	}
	
	//���Ϳ� �ش�� �޸� ����
	protected void finalize() throws Throwable
	{
		--currentNumber;
	}
	
	public void Hit(int amount)
	{
		life -= amount;
	}
	
	public int ShowLife()
	{
		return life;
	}
}