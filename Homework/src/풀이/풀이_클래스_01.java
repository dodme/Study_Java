package Ǯ��;

// ���� ��ɹ�
/// ī��ǥ��� : ù �ܾ��� ù���ڴ� �ҹ���, �ι�°�ܾ��� ù���ڴ� �빮��(��������) ex) int arrNum;
/// �Ľ�Įǥ��� : ù �ܾ��� ù���ڵ� �빮��, �ι�°�ܾ��� ù���ڵ� �빮��(�޼���, ������, Ŭ���� ��) ex) int ArrNum;

class Character
{
	enum CharacterJob
	{
		�����,
		ȫ��õ,
		ȫĥõ,
		���ʵ�,
		�εν�
	}
	
	// default ���̳� private�� ��� �̸� �տ� _�� ���� ���δ�.
	String _name;
	CharacterJob _job;
	int _damage;
	int _defence;
	
	public void SetCharacterInfo(String name, CharacterJob job, int damage, int defence)
	{
		_name = name;
		_job = job;
		_damage = damage;
		_defence = defence;
	}
	
	public void PrintCharacterInfo()
	{
		System.out.println(_name);
		System.out.println(_job);
		System.out.println(_damage);
		System.out.println(_defence);
	}
	
}




public class Ǯ��_Ŭ����_01 {

	public static void main(String[] args) {
		
		Character player1 = new Character();
		player1.SetCharacterInfo("�ڹٴ� ��վ�~?", Character.CharacterJob.�εν�, 10, 10);
		player1.PrintCharacterInfo();
		
		Character player2 = new Character();
		player2.SetCharacterInfo("�ڹٴ� ��վ�~?", Character.CharacterJob.�εν�, 20, 30);
		player2.PrintCharacterInfo();
	}

}
