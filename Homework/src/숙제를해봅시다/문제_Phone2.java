package �������غ��ô�;

import java.util.Scanner;

class Phone
{
	public void From() { System.out.print("From."); }
	
	public void To() { System.out.print("To."); }
}

// ������
class YPhone extends Phone
{
	private String UserName = "����";
	
	// ���� �޼����� ������ �ڵ�
	public void SendMessage(String username, String message)
	{
		super.From();
		System.out.println(UserName);
		System.out.println(message);
		super.To();
		System.out.println(username);
		System.out.println();
		
	}
	
	public String GetUserName() { return UserName; }
}

// ö����
class CPhone extends Phone
{
	private String UserName = "ö��";
	
	// ö���� �޼����� ������ �ڵ�
	public void SendMessage(String username, String message)
	{
		super.From();
		System.out.println(UserName);
		System.out.println(message);
		super.To();
		System.out.println(username);
		System.out.println();
	}
	
	public String GetUserName() { return UserName; }
}



public class ����_Phone2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// ����
		YPhone yh = new YPhone();
		// ö��
		CPhone cs = new CPhone();
		
		System.out.print("ö������ ���� ���� ������ �Է��ϼ��� : ");
		String messagec = scan.nextLine();
		yh.SendMessage(cs.GetUserName(), messagec);
		
		System.out.print("���񿡰� ���� ���� ������ �Է��ϼ��� : ");
		String messagey = scan.nextLine();
		cs.SendMessage(yh.GetUserName(), messagey);
		
		scan.close();
	}

}
