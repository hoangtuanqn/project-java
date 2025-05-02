import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class PlayGame {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		TaiXiu game = new TaiXiu();
		int choiceGame, betMoney;

		Locale lc = new Locale("vi", "VN");
		NumberFormat nf = NumberFormat.getCurrencyInstance(lc);

		do {
			game.viewChoice();
			choiceGame = sc.nextInt();
			do {
				if(choiceGame != 1 && choiceGame != 2) {
					System.out.println("Chỉ được phép chọn Tài hoặc Xỉu.");
					break;
				}
			} while(choiceGame != 1 && choiceGame != 2);

			System.out.print("Yêu cầu nhập số tiền đặt cược: ");
			betMoney = sc.nextInt();
			if (!game.checkMoney(betMoney)) {
				System.out.println("Số tiền đặt cược không hợp lệ.");
				break;
			}
			

			boolean isWin = game.playGame(betMoney, choiceGame);
			if (isWin) {
				System.out.println(game.GREEN + "Chúc mừng bạn đã chiến thắng " + nf.format(betMoney) + game.RESET);
			} else {
				System.out.println(
						game.RED + "Rất tiếc. Bạn đã thua và mất đi " + nf.format(betMoney) + " đã cược!" + game.RESET);
			}
			System.out.println();

		} while (true);

		System.out.println("Trò chơi đã thoát");
	}
}
