class Human extends Creature
{
	boolean doubleAttack = false;
	
	public Human()
	{
		super("���", 100, 5, 15);  // super �����ڸ� �ҷ��´�
		this.skillMaxCool = 2; // this: ����� �޴ٺ��ϱ�, �ٸ� ���̶� �򰥸� �� �����Ƿ�, this�� ��������
	}
	
	/*
	 * public int Skill(Creature target) { doubleAttack = true;
	 * System.out.println("����� ���� ����!"); super.DoAttack(target);
	 * super.DoAttack(target); this.skillCooldown = this.skillMaxCool; return 0; }
	 */

	public int Skill(Creature target)
    {
		int totalDamage = target.TakeDamage(this, this.maxDamage);
        System.out.println("�����þ�!");
        System.out.println(name + "�� ����! " + totalDamage + "�� ���ظ� ������!");
        this.skillCooldown = this.skillMaxCool;
        
        return totalDamage;
    }
	
	public void AI(Creature target)
	{
		DoAttack(target);
	}
}

class Gambler extends Creature
{	
	enum CardType
	{
		None,
		Clover,
		Heart,
		Diamond,
		Spade,
	}
	
	CardType currentCard = CardType.None;
	int leaf = 0;
	
	public Gambler()
	{
		super("���ڻ�", 100, 0, 20);  // super �����ڸ� �ҷ��´�
	}

	public int DoAttack(Creature target)
	{
		int totalDamage = super.DoAttack(target);
		switch(currentCard)
		{
		case Clover:
			if(leaf < 2)
			{
				System.out.println("Ŭ�ι� ī��� Ŭ�ι� ���� �ϳ� ��Ҵ�.");
				++leaf;
				System.out.println("���� ���� ���� : " + leaf);
			}
			else
			{
				System.out.println("Ŭ�ι� ���� �� ���� ��� ��Ҵ�.");
				System.out.println("��� ���� ����� ����!");
				while(leaf > 0)
				{
					game.Sleep(0.1f);
					totalDamage += super.DoAttack(target);
					--leaf;
				}
				game.Sleep(0.5f);
				System.out.println("���� ��� �Ҹ�Ǿ���.");
			}
			break;
			
		case Heart:
			System.out.println("��Ʈ ī��� ������ ������� ���ѾҴ�.");
			this.TakeHeal(totalDamage);
			break;
			
		case Diamond:
			System.out.println("���̾Ƹ�� ī��� ������� ��ų�� �����Ѵ�!");
			target.Skill(this);
			break;
			
		case Spade:
			System.out.println("�����̵� ī��� �ٽ� ����!");
			totalDamage += super.DoAttack(target);
			break;
			
		default:
			currentCard = CardType.None;
			break;
		}
		
		currentCard = CardType.None;
		return totalDamage;
	}
	
	public CardType DrawCard()
	{
		int currentNumber = super.Random(0,  10);
		if(currentNumber < 4)
		{
			System.out.println("���ڻ�� Ŭ�ι��� �̾Ҵ�.");
			return CardType.Clover;
		}
		else if(currentNumber < 7)
		{
			System.out.println("���ڻ�� ��Ʈ�� �̾Ҵ�.");
			return CardType.Heart;
		}
		else if(currentNumber < 9)
		{
			System.out.println("���ڻ�� ���̾Ƹ�带 �̾Ҵ�.");
			return CardType.Diamond;
		}
		else
		{
			System.out.println("���ڻ�� �����̵带 �̾Ҵ�.");
			return CardType.Spade;
		}
	}
	
	public int Skill(Creature target)
    {
		int totalDamage = 0;
        
		if(currentCard == CardType.None)
		{
			currentCard = DrawCard();
		}
		else
		{
			if(currentCard == DrawCard())
			{
				switch(currentCard)
				{
				case Clover:
					currentCard = CardType.None;
					leaf += 4;
					System.out.println("Ŭ�ι� ���� �� 4���� �����Ǿ���.");
					System.out.println("��� ���� ����� ����!");
					while(leaf > 0)
					{
						game.Sleep(0.1f);
						totalDamage += super.DoAttack(target);
						--leaf;
					}
					game.Sleep(0.5f);
					System.out.println("���� ��� �Ҹ��Ͽ���.");
					break;
					
				case Heart:
					currentCard = CardType.None;
					totalDamage += target.FixedDamage(this, target.maxHealth / 2);
					System.out.println("��Ʈ ���� ����� ����� ������ �����´�!");
					this.TakeHeal(totalDamage);
					break;
					
				case Diamond:
					currentCard = CardType.None;
					System.out.println("���̾Ƹ�� ���� ����� ��ų�� ���ο��� �����ϰ� �Ѵ�");
					totalDamage = target.Skill(target);
					break;
					
				case Spade:
					currentCard = CardType.None;
					System.out.println("�����̵� ���� ��븦 ����Ų��.");
					target.Death(this);
					break;
					
				default:
					currentCard = CardType.None;
					break;
				}
				
				System.out.println("��ų�� ���� ī�带 ��� �Ҹ��Ͽ����ϴ�.");
			}
			else
			{
				currentCard = CardType.None;
				System.out.println("�� �����߽��ϴ�! ȿ�� ���� ī�带 �����ϴ�.");
				totalDamage = super.DoAttack(target);
			}
		}
		
        return totalDamage;
    }
	
	public void AI(Creature target)
	{
		this.Skill(target);
	}
}

class Goblin extends Creature
{
	public Goblin()
	{
		super("���", 30, 5, 10);  // super �����ڸ� �ҷ��´�
		this.skillMaxCool = 3; // this: ����� �޴ٺ��ϱ�, �ٸ� ���̶� �򰥸� �� �����Ƿ�, this�� ��������
	}
	
	public int Skill(Creature target)
	{
		System.out.println("����� �ʹ� ���ļ� ���Ḧ �ҷ��Դ�!");
		this.name = "�����";
		this.maxHealth = 80;
		this.TakeHeal(50);
		this.minDamage = 10;
		this.maxDamage = 30;
		this.skillCooldown = this.skillMaxCool;
		return 0;
	}
	
	public void AI(Creature target)
	{
		if(this.skillCooldown <= 0 && this.currentHealth < 5)
		{
			Skill(target);
		}
		else
		{
			DoAttack(target);
		};
	}
}

class Orc extends Creature
{
	int defendLeft = 0;
	
	public Orc()
	{
		super("��ũ", 60, 2, 20);  // super �θ� << �׷��� �θ��� ������
		this.skillMaxCool = 3; // this: ����� �޴ٺ��ϱ�, �ٸ� ���̶� �򰥸� �� �����Ƿ�, this�� ��������
	}
	
	@Override
	public int TakeDamage(Creature from, int damage)
	{
		if(defendLeft > 0)
		{
			System.out.println("��ũ�� ����� ������ ���Ƴ´�!");
			from.TakeDamage(this, damage / 2);
			System.out.println((damage / 2) + "�� ���ظ� �����־���.");
			--defendLeft;
			return 0;
		}
		else
		{
			return super.TakeDamage(from, damage);
		}
	}
	
	public int Skill(Creature target)
	{
		System.out.println("��ũ�� ��Ƽ�⸦ �����ߴ�!");
		defendLeft = 2;
		this.skillCooldown = this.skillMaxCool;
		return 0;
	}
	
	public void AI(Creature target)
	{
		if(this.skillCooldown <= 0 && this.currentHealth < 20)
		{
			Skill(target);
		}
		else
		{
			DoAttack(target);
		};
	}
}

class Dragon extends Creature
{
int breathCharge = 0;

    public Dragon()
    {
        super("�巡��", 150, 20, 40);  // super �θ� << �׷��� �θ��� ������
        this.skillMaxCool = 4; // this: ����� �޴ٺ��ϱ�, �ٸ� ���̶� �򰥸� �� �����Ƿ�, this�� ��������
    }

    @Override
    public int TakeDamage(Creature from, int damage)
    {
        if(breathCharge > 0)
        {
            //�극�� �������ȿ� �޴µ����� 2��
            System.out.println("�巡���� ������ �����ϰ��ִ�.");
            return super.TakeDamage(from, damage * 2);
        }
        else
        {
            // �ƹ� �ൿ�� ���� �������� �޴µ����� ����
            return super.TakeDamage(from, damage / 2);
        }
    }

    public int Skill(Creature target)
    {
        System.out.println("�巡���� �극���� �������ִ�...");
        breathCharge = 2;
        this.skillCooldown = this.skillMaxCool;
        return 0;
    }

    public void AI(Creature target)
    {
        // �극���� �����ؼ� �����Ҷ� �ܿ��� �������� ����
        if(this.skillCooldown <= 0)
        {
            Skill(target);
        }
        else if(breathCharge == 0)
        {
            DoAttack(target);
        }
        else if(breathCharge < 0)
        {
            System.out.println("�巡���� �ƹ� �ൿ�� ���� �ʰ��ִ�.");
        };
        --breathCharge;
        --this.skillCooldown;
    };
}
class Vampire extends Creature
{
    int evasion = 2;
    boolean isEvasion = false;

    public Vampire()
    {
        super("�����̾�", 50, 5, 30); 
        this.skillMaxCool = 4; 
    }

    @Override       // �θ� �־���  TakeDamage�� �����Ű�� �ʰ�, ���� TakeDamage�� ��������ְڴٴ� �ǹ�
    public int TakeDamage(Creature from, int damage)  // ���� ��� ���� �Լ�����
    {
        if(evasion > 0 && this.currentHealth < 40)   // ���� 0�������� �޴� ��
        {
            System.out.println("�����̾�� ����� �����ؼ� ������ ȸ���Ͽ���.");
            --evasion;
            isEvasion = true;
            return 0;
        }
        else
        {
            return super.TakeDamage(from, damage);   //super�� �θ� �θ��� ���̹Ƿ�, defendLeft�� �����ٸ� ������� �´� ����
        }
    }

    @Override
    public int DoAttack(Creature target)
    {
        if(isEvasion)
        {
            System.out.println("�����̾�� ȸ���ϴ��� ������ �� �� ������.");
            isEvasion = false;
            return 0;
        }
        else
        {
            return super.DoAttack(target);
        }
    }

    public int Skill(Creature target)
    {
        if(isEvasion)
        {
            System.out.println("�����̾�� ȸ���ϴ��� ������ �� �� ������.");
            isEvasion = false;
            return 0;
        };

        int bloodSucking = this.DoAttack(target);
        System.out.println("�� ������");
        this.TakeHeal(bloodSucking);
        System.out.println(bloodSucking + "�� ȸ���Ǿ����ϴ�.");
        this.skillCooldown = this.skillMaxCool;

        return 0;
    }

    public void AI(Creature target)
    {
        if(isEvasion)
        {
            System.out.println("�����̾�� ȸ���ϴ��� ������ �� �� ������.");
            isEvasion = false;
            /*
            evasion = 3;
            this.skillCooldown = this.skillMaxCool;
            */
        }
        else if(this.skillCooldown <= 0 && this.currentHealth < 20)
        {
            Skill(target);
        }
        else
        {
            DoAttack(target);
        }
    }
}

public abstract class Creature 
{
	protected String name;
	protected int currentHealth = 100;
	protected int maxHealth = 100;
	protected int minDamage;
	protected int maxDamage;
	protected int skillCooldown = 0;
	protected int skillMaxCool = 2;
	private boolean isAlive = true;  //����ִ���
	
	//protected�� ��� ���� �ֵ鸸 ����� �� �ְ� ����. ��, �ڽĵ鸸 ����� �� �ִ� ��
	protected Creature(String wantName, int wantMaxHealth, int wantMinDmg, int wantMaxDmg)
	{
		name = wantName;
		maxHealth = wantMaxHealth;
		currentHealth = maxHealth;  //������ ���� �ִ� ü���� �� �ֵ��� ����
		minDamage = wantMinDmg;
		maxDamage = wantMaxDmg;
}
	
	public String getName()
	{
		return name;
	}
	public int getCurHealth()
	{
		return currentHealth;
	}
	public int getMaxHealth()
	{
		return maxHealth;
	}
	public boolean getAlive()
	{
		return isAlive;
	}
	public int DoAttack(Creature target)  //�´� ����� ��������(���ڷ� �޴´�)
	{
		int damage = Random(minDamage, maxDamage);
		damage = target.TakeDamage(this, damage);
		
		System.out.println(name + "�� ����! " + damage + "�� ���ظ� ������!");
		
		return damage;
	}
	
	public int TakeHeal(int heal)
	{
		int totalHeal = heal;
		if(currentHealth + heal <= 0)
		{
			totalHeal = currentHealth;
			currentHealth = 0;
			isAlive = false;
		}
		else if(currentHealth + heal > maxHealth)
		{
			totalHeal = maxHealth - currentHealth; //������ �ִ� ü�±����� �ǰ� ȸ���� ���̹Ƿ�
			currentHealth = maxHealth;
		}
		else
		{
			currentHealth += heal;
		};
		
		return totalHeal;
	}
	
	protected int TakeDamage(Creature from, int damage)
	{
		int totalDamage = damage;
		if(currentHealth <= damage)
		{
			totalDamage = currentHealth;
			currentHealth = 0;
			isAlive = false;
		}
		else if(currentHealth - damage > maxHealth)  //ü�� ȸ���� -�������� �̿��ؼ� ��
		{
			//���� ü��(50) - ���� ������(-60) > �ִ� ü��(100)
			//110 > 100
			totalDamage = maxHealth - currentHealth; //������ �ִ� ü�±����� �ǰ� ȸ���� ���̹Ƿ�
			currentHealth = maxHealth;
		}
		else
		{
			currentHealth -= damage;
		};
		
		return totalDamage;
	}
	
	protected int FixedDamage(Creature from, int damage)
	{
		int totalDamage = damage;
		if(currentHealth <= damage)
		{
			totalDamage = currentHealth;
			currentHealth = 0;
			isAlive = false;
		}
		else if(currentHealth - damage > maxHealth)  //ü�� ȸ���� -�������� �̿��ؼ� ��
		{
			//���� ü��(50) - ���� ������(-60) > �ִ� ü��(100)
			//110 > 100
			totalDamage = maxHealth - currentHealth; //������ �ִ� ü�±����� �ǰ� ȸ���� ���̹Ƿ�
			currentHealth = maxHealth;
		}
		else
		{
			currentHealth -= damage;
		};
		
		return totalDamage;
	}
	
	public abstract int Skill(Creature target);
	
	public abstract void AI(Creature target);
	
	public void Death(Creature target)
	{
		isAlive = false;
	}
	
	public static int Random(int min, int max)
	{
		return (int)( (Math.random() * (max - min)) + min );  //(max - min): ������ �����ְ�, + min���� �ּڰ����� ����
	}
}
