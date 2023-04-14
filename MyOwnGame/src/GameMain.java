
import java.time.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameMain 
{
	static WindowMain myWindow = new WindowMain();
	static KeyInput checkKey = new KeyInput();
	public static void main(String[] args) 
	{
		myWindow.addKeyListener(checkKey);
		
		Update currentUpdate = new Update();
		Timer jobScheduler = new Timer();
		jobScheduler.scheduleAtFixedRate(currentUpdate, 0, 33);
	}
}

class Update extends TimerTask
{
	int lastSecond = 0;
	int runnedTime = 0;
	
	public void run()
	{
		int currentSecond = LocalTime.now().getSecond();
		
		//���� ���� �ִ� ȭ���� �Է��� ��� ó��
		GameMain.myWindow.currentScreen.InputCheck();
		//�Է��� �ʱ�ȭ
		GameMain.checkKey.keyInitialize();
		
		//�� ������ ��Ŀ���� �ش�
		GameMain.myWindow.requestFocus();
		
		++runnedTime;
		if(lastSecond != currentSecond)
		{
			GameMain.myWindow.setTitle("�ٿ �� FPS : " + runnedTime);
			runnedTime = 0;
			lastSecond = currentSecond;
		};
	}
}