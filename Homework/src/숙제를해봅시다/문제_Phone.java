package �������غ��ô�;

// Phone�� ����ϴ�.

// ö���� �ڵ����� ������ �ڵ����� �����,
// ö���� ���� ���ڸ� ���� �޵��� �ϰ�,
// ���� ö������ ������ ������ ���α׷��� �ۼ��ϼ���.

// ���ڳ��� �������� �������� �޴���

// output
// From. ö��
// ���ڳ���
// To. ����

//From. ����
//���ڳ���
//To. ö��

class Phone
{
	public void From()
	{
		System.out.print("From.");
	}
	
	public void To()
	{
		System.out.print("To.");
	}
}

class YPhone extends Phone
{
	private static String UserName;
	private String Message;
	
	public YPhone(String userName, String message)
	{
		UserName = userName;
		Message = message;
	}
	
	public void SendMessage()
	{
		super.From();
		System.out.println(YPhone.UserName);
		System.out.println(Message);
		super.To();
		System.out.println(CPhone.UserName);
	}
	
	public String GetUserName() { return UserName; }
}

class CPhone extends Phone
{
	private static String UserName;
	private String Message;
	
	public CPhone(String userName, String message)
	{
		UserName = userName;
		Message = message;
	}
	
	public void SendMessage()
	{
		super.From();
		System.out.println(CPhone.UserName);
		System.out.println(Message);
		super.To();
		System.out.println(YPhone.UserName);
	}
	
	public String GetUserName() { return UserName; }
}



public class ����_Phone {

	public static void main(String[] args) {
		
		
		
	}

}
