package �������غ��ô�;

public class ����_�ݺ���_02 {

	public static void main(String[] args) {
		
		//����ϰ���� ���� ��
		int line = 5;
		//����� ����
		char star = '*';
		
		
		// *�� line����ŭ �ϳ��� �����ϸ� ���
		for(int i = 1; i <= line; i++)
		{
			for(int num = 1; num <= i; num++)
			{
			System.out.print(star);
			}
			System.out.println();
		}
		
		System.out.println();
		
		// *�� line����ŭ �ϳ��� �����ϸ� ���
		for(int i = line; i >= 1; i--)
		{
			for(int num = 1; num <= i; num++)
			{
			System.out.print(star);
			}
			System.out.println();
		}
		
		System.out.println();
		
		// *�� line�ٸ�ŭ �ﰢ��������� ���
		for(int i = 1; i <= line; i++)
		{
			// ������ ����ϴ� �ڵ�
			for(int num1 = (line - 1); i <= num1; num1--)
			{
			System.out.print(" ");
			}
			// *�� ����ϴ� �ڵ�
			for(int num2 = 1; ((i * 2) - 1) >= num2; num2++)
			{
			System.out.print(star);
			}
			System.out.println();
		}
	}

}
