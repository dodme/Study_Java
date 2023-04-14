import java.util.Scanner;

public class game {
	//Ÿ���� [������� / O / X ] �� ���� �����ϱ� ���� enum�� ����մϴ�.
	enum gridState
	{
		None,
		O,
		X
	}

	public static void main(String[] args) 
	{
		//���Դϴ�.
		gridState currentGrid[][] =
		{
			{gridState.None, gridState.None, gridState.None}, 
			{gridState.None, gridState.None, gridState.None},
			{gridState.None, gridState.None, gridState.None}
		};
		
		//�Է��� �ޱ� ���� ��ĳ�ʸ� �غ��մϴ�.
		Scanner input = new Scanner(System.in);
		
		//�Է¹��� ������ �����ϴ� �����Դϴ�.
		String currentInput;
		
		//���� �Է��� X��� Y�� ������ �����մϴ�.
		int lastInputX = 0;
		int lastInputY = 0;
		
		//���� X�� ���̸� true, O�� ���̸� false�� �����ϱ� ���� �ֽ��ϴ�.
		boolean turnX = true;
		
		//���� ������ ���ư��� �ݺ����Դϴ�.
		//�տ� game�̶�� �̸��� �ٿ��� ������ ������ �ߴ��� �� �ְ� �մϴ�.
		game:
		while(true)
		{
			//X��� Y�� �Է��� �ޱ� ���� �ʱ�ȭ�մϴ�.
			lastInputX = 0;
			lastInputY = 0;
			
			//�Է��� �ޱ� ���� ������ ������ �˷��ݴϴ�.
			if(turnX)
			{
				System.out.println("X�� ���Դϴ�!");
			}
			else
			{
				System.out.println("O�� ���Դϴ�!");
			};
			
			//���� �Է��� �޴� �κ�.
			//[a~c] [0~2]���� �Է��� �� �ֽ��ϴ�. (���� : a1)
			currentInput = input.next();
			
			//a1�� ���� �Է��� ���� ��, �� ���� �̻� ���� ������ ������ �߻��մϴ�.
			//�̸� �����ϱ� ���� ���� ���̸� Ȯ���մϴ�.
			if(currentInput.length() < 2)
			{
				System.out.println("�ٽ� �Է��ϼ���.");
				continue;
			}
			else
			{
				//���� ���̰� Ȯ�εǸ�, �� ���ڿ� 'a'�� '0'�� ���ϴ�
				//����� ���������̼� 50P ~ 62P ����
				lastInputY = currentInput.charAt(0) - 'a';
				lastInputX = currentInput.charAt(1) - '0';
				
				//���� [0][0]���� [2][2]������ �ֱ� ������
				//�� ������ �Ѵ� ���� �޾��� ������ ������ �˷��ְ�
				//ó������ ���ư��ϴ�.
				if( (lastInputY < 0 || lastInputY > 2) || (lastInputX < 0 || lastInputX > 2) )
				{
					System.out.println("������ �Ѿ����ϴ�.");
					continue;
				}
				else
				{
					//���� �������� ��ġ�� ������� ������, Ÿ���� �����ϴ�.
					if(currentGrid[lastInputY][lastInputX] == gridState.None)
					{
						if(turnX)
						{
							currentGrid[lastInputY][lastInputX] = gridState.X;
						}
						else
						{
							currentGrid[lastInputY][lastInputX] = gridState.O;
						};
					}
					//�������� ��ġ�� �ٸ� ���� �ִٸ�, ������ �˸��� �ǵ��ư��ϴ�.
					else
					{
						System.out.println("�̹� �־�� �̤�");
						continue;
					};
				};
			};
			
			
			//���� ���� ��� ����մϴ�.
			for(int y = 0; y < currentGrid.length; y++)
			{
				for(int x = 0; x < currentGrid[y].length; x++)
				{
					//���� �����ϰ� �ִ� ��ġ�� ����
					//���� ���ڸ� ������� ���մϴ�.
					switch(currentGrid[y][x])
					{
					case None:
						System.out.print("��");
						break;
					case X:
						System.out.print("X");
						break;
					case O:
						System.out.print("O");
						break;
					default:
						System.out.print(currentGrid[y][x]);
					};
				};
				//�� ���� ��� ���� �ڿ� ���� �ٷ� �Ѿ�� ���ؼ�
				//�� �� �Ѿ�� �ڵ带 ���⿡ �ֽ��ϴ�.
				// System.out.println();�� ���� ������ �մϴ�.
				System.out.print("\n");
			}
			
			//���ο� ���θ� ���鼭, ������ �̰���� Ȯ���մϴ�.
			//����� ���������̼� 19P ~ 24P����
			for(int i =0 ; i < currentGrid.length; i++)
			{
				if(currentGrid[0][i] == currentGrid[1][i] && currentGrid[0][i] == currentGrid[2][i])
				{
					if(currentGrid[0][i] != gridState.None)
					{
						System.out.println(currentGrid[0][i] + "�� �̰���.");
						break game;
					};
				};
				if(currentGrid[i][0] == currentGrid[i][1] && currentGrid[i][0] == currentGrid[i][2])
				{
					if(currentGrid[i][0] != gridState.None)
					{
						System.out.println(currentGrid[i][0] + "�� �̰���.");
						break game;
					};
				};
			};
			
			//�밢���� Ȯ���մϴ�.
			//����� ���������̼� 25P
			if(currentGrid[1][1] == currentGrid[2][0] && currentGrid[1][1] == currentGrid[0][2])
			{
				if(currentGrid[1][1] != gridState.None)
				{
					System.out.println(currentGrid[1][1] + "�� �̰���.");
					break game;
				};
			};
			//���������� �ݴ��� �밢���� Ȯ���մϴ�.
			//����� ���������̼� 26P
			if(currentGrid[1][1] == currentGrid[0][0] && currentGrid[1][1] == currentGrid[2][2])
			{
				if(currentGrid[1][1] != gridState.None)
				{
					System.out.println(currentGrid[1][1] + "�� �̰���.");
					break game;
				};
			};
			
			//���� ���� Ȯ���ؼ� X�� ���̸� O��, O�� ���̸� X�� �ٲߴϴ�.
			//����� ���������̼� 74P ~ 81P
			turnX = !turnX;
			
			//���ºθ� Ȯ���ϱ� ���� ��� ĭ�� ���ִ��� Ȯ���մϴ�.
			//�׷��� ���� �켱 ���� ���� ĭ�� 0���� �ʱ�ȭ�մϴ�.
			int currentFill = 0;

			//��� ĭ�� ���鼭, None�� �ƴ� Ÿ���� �ִٸ�
			//�����ΰ� ����ִٴ� ������ �ؼ��Ͽ�
			//ī��Ʈ�� 1�� ���մϴ�.
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					if( currentGrid[i][j] != gridState.None )
					{
						++currentFill;
					};
				};
			};

			//������ ī��Ʈ�� �� ������ 9�� �̻��̸�, ��� ĭ�� �� �ִٴ� ������
			//���ºζ�� ��� ��, ������ �����մϴ�.
			if(currentFill >= 9)
			{
				System.out.print("���º��Դϴ�~");
				break game;
			};
		};
		
		input.close();
	}

}



