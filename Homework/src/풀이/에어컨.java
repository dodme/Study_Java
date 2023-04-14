package Ǯ��;

class AirConditioner
{
	
	public enum Power
	{
		On,
		Off
	}
	
	private int _temp;
	// private boolean isPower;
	private Power _power;
	
	public void SetPower(Power power)
	{
		_power = power;
		PrintPower();
	}
	
	//Public void PowerOnOff() { _power = !_power; }
	
	public void PrintPower()
	{
		/*
		 * if(_power == Power.On) { System.out.println("������ �մϴ�!"); }
		 */
		
		System.out.println((_power == Power.On) ? "������ �մϴ�." : "������ ���ϴ�.");
	}
	
	public void UpTemp()
	{
		System.out.println("�µ��� �ø��ϴ�.");
		_temp++;
		PrintNowTemp();
	}
	
	public void DownTemp()
	{
		System.out.println("�µ��� �����ϴ�.");
		_temp--;
		PrintNowTemp();
	}
	
	public void PrintNowTemp()
	{
		System.out.println("����µ���" + _temp + "�Դϴ�.");
	}
	
	public void SetTemp(int temp)
	{
		_temp = temp;
	}
	
}

public class ������ {

	public static void main(String[] args) {
		
		AirConditioner air = new AirConditioner();
		
		air.SetTemp(18);
		
		air.SetPower(AirConditioner.Power.On);
		air.PrintNowTemp();
		air.DownTemp();
		air.UpTemp();
		air.SetPower(AirConditioner.Power.Off);
		
	}

}
