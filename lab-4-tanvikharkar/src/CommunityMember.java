import java.util.*;

public class CommunityMember {
	private CMemberKind kind;
	private float money;
	private ArrayList<Float> moneyOverTime;
    Random random = new Random();
	private int red, green, blue;

	//constructor
	public CommunityMember(CMemberKind pK, float startFunds) {
		this.kind = pK;
		this.money = startFunds;
		this.moneyOverTime = new ArrayList<Float>();
		this.moneyOverTime.add(startFunds);
		this.red = this.random.nextInt(100);
		this.green = this.random.nextInt(100);
		this.blue = this.random.nextInt(100);

		//overall blue tint to POORLY_PAID	
		if (this.kind == CMemberKind.WELL_PAID) {
			this.red += 100;
		} else {
			this.blue += 100;
		}
	}

	public int getR() { return this.red; }
	public int getG() { return this.green; }
	public int getB() { return this.blue; }
	public float getMoney() { return this.money; }
	public CMemberKind getKind() { return this.kind; }
	public ArrayList<Float> getFunds() { return this.moneyOverTime; }
	public void updateMoneyEachYear() {this.moneyOverTime.add(this.money);}
	public void addMoney(float money) {this.money = money + this.money;}

	public HashSet<Integer> playRandom(int min, int max) {	// min = 1, max = 42
		HashSet<Integer> hSet = new HashSet<>();
		int randomNum = 0;
		int check = 0;
		while (check < 5){
			randomNum = random.nextInt((max - min) + 1) + min;
			if (check == 0) {
				System.out.println(randomNum);
				hSet.add(randomNum);
				check++;
			}
			else if (check >= 1 && hSet.contains(randomNum)) {	// check if random number is already in hash set
				// do nothing
				 check = check;
			}
			else {
				System.out.println(randomNum);
				hSet.add(randomNum);
				check++;
			}
		}
		return hSet;
	}
}
