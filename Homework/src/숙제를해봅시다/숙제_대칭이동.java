package �������غ��ô�;

class Point
{
	int x;
	int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

public class ����_��Ī�̵� {

	public static void main(String[] args) {
		
		// �� p1
		Point p1 = new Point(3,3);
	
		// ��Ī��
		Point SymmetryPoint = new Point(5,5);
		
		System.out.println("X�� ��Ī�� : p2 = " + 
				(SymmetryPoint.x -((SymmetryPoint.x - p1.x) * 2)) + "," + p1.y);
		
		System.out.println("Y�� ��Ī�� : p2 = " + 
				p1.x + "," +  (SymmetryPoint.y -((SymmetryPoint.y - p1.y) * 2)));
		
		System.out.println("p1�� ��Ī�� : p2 = " +
				(SymmetryPoint.x -((SymmetryPoint.x - p1.x) * 2)) + "," + 
				(SymmetryPoint.y -((SymmetryPoint.y - p1.y) * 2)));
		
	}

}
