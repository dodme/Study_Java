package NumberBaseBall;

import java.util.Scanner;

public class NumberBaseBall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		//������ �Ǵ� �迭�Դϴ�.
		int[] answerArray = new int[4];
        //���� �޾Ƽ� �迭�� �ֽ��ϴ�.
		int[] selectArray = new int[answerArray.length]; //answerArray�� �迭 ���̿� �����ϰ� ����. 4
		//������ �Է��ϴ� ���� ���Դϴ�.
		int select = 0;
				
		int currentDigit = 1 ;
		//��Ʈ����ũ�� ���� ���߿� �ֱ� ���ؼ� ��������ϴ�.
		int strike, ball = 0;
		
		//�ߺ��� ���� ������ ���ϴ�.
		for(int i = 0; i < answerArray.length; i++)
		{   
			//���� ���� �����
			answerArray[i] = (int)Math.floor(Math.random() * 9d +1);
			//�ߺ�Ȯ��
			for(int j = 0; j < i; j++)
			{
				if(answerArray[i] == answerArray[j])
				{
					--i;
				};
			};
		};
		
		System.out.println("�غ�ƾ��.");
		
		/*
		for(int i = 0; i < answerArray.length; i++)
		{
			System.out.print(answerArray[i]);
		};
		System.out.println();
		*/
		
		game:
		while(true) //true �ϴ� �׳� �����϶�� �ǹ� (���Ӱ��� ��쿡�� ����� �� ������ ��� �������ϹǷ�) , while(true)�� �ؿ� ���� ���� ������ �ȵ�.
		{
			select = input.nextInt();
			
			//�÷��̾��� �Է��� 4�ڸ����� �����մϴ�.
			select = select % 10000;
			if(select >= 1000)
			{
				System.out.println(select);
			}
			else
			{
				System.out.println("�߸� �Է��߾��.");
				continue;  //���⼭ while���� �� �� �����ٴ� �ǹ�. break�� ���� ���� ������ ��. continue�� ���Ⱑ ���̱� �ѵ� �ٽ� �����ض�� �ǹ�.
			};
		
    	    for(int i = 0; i < answerArray.length; i++)
    	    {
    		currentDigit = (int)Math.pow(10, 3-i);
    		selectArray[i] = select / currentDigit;
    	    select %= currentDigit;
    	    };
			
    	    
    	    strike = 0;
    	    ball = 0;
    	    
    	   //select �ϳ��� ��� answer�� �ϳ��ϳ� ���ϴ� ����
    	    for(int sel = 0; sel < selectArray.length; sel++)
    	    {
    	    	answerCheck:
    	    	for(int ans = 0; ans < answerArray.length; ans++)
    	    	{
    	    		
    	    		if(selectArray[sel] == answerArray[ans])
    	    		{
    	    			 if(ans == sel)
    	    	    	{
    	    	    		++strike;  //ans�� sel�� ���� ���� Ȯ��. ���ٸ� strike�� �ϳ� �߰�
    	    	    		} 
    	    	         else 
    	    	    	{
    	    	    		++ball;  //�ٸ��ٸ� ball�� �߰�
    	    	    		} 
    	    	    	break answerCheck;
    	    		};
    	    	};
    	    };
    	    
    	    
    	    if(strike >= answerArray.length) //strike >= 4�� ����
    	    {
    	    	System.out.println("�����Դϴ�!");
    	    	break game;
    	    }
    	    else
    	    {
    	    	System.out.println(strike + "��Ʈ����ũ");
    	    	System.out.println(ball + "��");
    	    };
			
		}
		
		

	}

}