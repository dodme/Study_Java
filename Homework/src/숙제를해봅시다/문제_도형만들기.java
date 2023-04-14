package �������غ��ô�;

// ���������
// Shape�� ��ӹ޴�
// Ellipse, RectAngle, TriAngle�� ���弼��!


// output
// ���� �׸��ϴ�.
// �簢���� �׸��ϴ�.
// �ﰢ���� �׸��ϴ�.

class Shape
{
	public void Draw()
	{
		System.out.println("�� �׸��ϴ�.");
	}
}

class Ellipse extends Shape
{
	public void Draw()
	{
		System.out.print("��");
		super.Draw();
	}
}

class RectAngle extends Shape
{
	public void Draw()
	{
		System.out.print("�簢��");
		super.Draw();
	}
}

class TriAngle extends Shape
{
	public void Draw()
	{
		System.out.print("�ﰢ��");
		super.Draw();
	}
}

public class ����_��������� {

	public static void main(String[] args) {
		
		Shape shape[] = { new Ellipse(), new RectAngle(), new TriAngle() };
		
		for(int i = 0; i < 3; i++)
		{
			shape[i].Draw();
		}
		
	}

}
