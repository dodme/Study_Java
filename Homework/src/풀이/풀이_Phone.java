package Ǯ��;

class ApplePhone
{
	enum User 
	{ ö��, ���� }

	private User Sender;  // ������ ��
	private User Receiver;  // �޴� ��
	
	public ApplePhone(User sender, User receiver)
	{
		Sender = sender;
		Receiver = receiver;
	}
	
	public void SendMessage(String msg)
	{
		System.out.println("From." + Sender);
		System.out.println("���� ���� : " + msg);
		System.out.println("To." + Receiver);
	}
	
	public void GetMessage(String msg)
	{
		System.out.println("From." + Receiver);
		System.out.println("���� ���� : " + msg);
		System.out.println("To." + Sender);
	}

}
public class Ǯ��_Phone {

	public static void main(String[] args) {
		ApplePhone cs = new ApplePhone(ApplePhone.User.ö��, ApplePhone.User.����);
		
		cs.SendMessage("������..?");
		cs.GetMessage("�� ��ģ �����");
		cs.GetMessage("�� ���� ���� ���� ����");

	}

}
