package �������غ��ô�;

class Character
{
	enum Job
	{
		����,
		�ü�,
		����,
		������
	}
	
	public String name;
	public int atk;
	public int def;
	public Job job;
	
	public void PrintCharacterInfo()
	{
		System.out.println("���� : " + job);
		System.out.println("�̸� : " + name);
		System.out.println("���ݷ� : " + atk);
		System.out.println("�濩�� : " + def);
	}
	
}

public class ����_Ŭ����_01 {

	public static void main(String[] args) {
		
		Character Player1 = new Character();
		Character Player2 = new Character();
		
		Player1.job = Character.Job.����;
		Player1.name = "������ĳ��";
		Player1.atk = 200;
		Player1.def = 50;
		
		Player1.PrintCharacterInfo();
		
		System.out.println();
		
		Player2.job = Character.Job.����;
		Player2.name = "���簭�ؿ�";
		Player2.atk = 100;
		Player2.def = 5;
		
		Player2.PrintCharacterInfo();
	}

}




//Character Ŭ������ ����ϴ�.
/// �̸�
/// ����
/// ���ݷ�
/// �濩��

//output
/// �̸� : @@@
/// ���� : @@@
/// ���ݷ� : 00
/// �濩�� : 00



