import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DictionaryManagement manager = new DictionaryManagement();
		do {
			System.out.println("Tra cứu từ điển Anh - Việt");
			System.out.println("1. Thêm từ");
			System.out.println("2. Xóa từ");
			System.out.println("3. Tra từ");
			System.out.println("4. In ra danh sách từ điển");
			System.out.println("5. In ra số lượng từ");
			System.out.println("6. Xóa tất cả các từ");
			System.out.println("0. Thoát");
			System.out.print("Chọn: ");
			int choice = sc.nextInt();
			sc.nextLine(); // Xóa Enter
			switch (choice) {
			case 0:
				ConsoleColor.message("Đã thoát khỏi chương trình.", "success");
				return;
			case 1:
				manager.addWord();
				break;
			case 2:
				manager.deleteOneWord();
				break;
			case 3:
				manager.searchWord();
				break;
			case 4:
				manager.displayWords();
				break;
			case 5:
				manager.getWordCount();
				break;
			case 6:
				manager.clearAllWord();
				break;
			}
		} while (true);
	}
}
