import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

public class TaiXiu {
	protected int money, score;
	public final String RED = "\u001B[31m";
	public final String GREEN = "\u001B[32m";
	public final String RESET = "\u001B[0m";

	public TaiXiu() {
		this.money = 500000; // Ban đầu có 500k
	}

	public int getMoney() {
		return money;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean checkMoney(int betMoney) {
		if (betMoney < 0 || betMoney > this.money)
			return false;
		return true;
	}

	public int[] scoreRandom() {
		int[] scores = new int[3];
		Random rd = new Random();
		for (int i = 0; i < scores.length; ++i) {
			scores[i] = rd.nextInt(6) + 1; // nextInt(a, b) => [a, b)
		}
		return scores;
	}

	private boolean isWin(int score, int choice) {
		if (choice == 1 && score >= 11 && score <= 17) {
			return true;
		}
		if (choice == 2 && score >= 4 && score <= 10) {
			return true;
		}
		return false;

	}
	public void viewChoice() {
		Locale lc = new Locale("vi", "VN");
		NumberFormat nf = NumberFormat.getCurrencyInstance(lc);
		System.out.println("Vui lòng chọn tài hoặc xỉu. Bạn đang có tổng số tiền là " + this.GREEN + nf.format(this.money) + this.RESET);
		System.out.println("1. Tài");
		System.out.println("2. Xỉu");
		System.out.print("Vui lòng chọn: ");
	}

	/*
	 * Choice 1: Tài 2: Xỉu playGame trả về true: chiến thắng
	 */
	public boolean playGame(int betMoney, int choice) {
		if (!checkMoney(betMoney)) {
			return false;
		}
		if (choice != 1 && choice != 2) {
			return false;
		}
		int total = 0;
		int[] scores = this.scoreRandom();
		System.out.print("Giá trị thảy lần lượt là: ");
		for (int i = 0; i < scores.length; i++) {
			total += scores[i];
			System.out.print(scores[i] + " ");
		}
		System.out.println(". Tổng là " + total);
		boolean isWin = this.isWin(total, choice);
		if(isWin) {
			this.money += betMoney;
		} else {
			this.money -= betMoney;
		}
		return isWin;
	}

}
