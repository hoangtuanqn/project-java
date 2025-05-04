import java.util.*;

public class DictionaryManagement {
	Dictionary dictionary = new Dictionary();
	Scanner sc = new Scanner(System.in);

	public void addWord() {
		String name, meaning;
		do {
			System.out.print("Vui lòng nhập từ muốn thêm: ");
			name = sc.nextLine();
			if (dictionary.isExisted(name)) {
				ConsoleColor.message("Từ \"" + name + "\" đã tồn tại trong từ điển. Vui lòng thêm từ khác.", "error");
			} else {
				break;
			}
		} while (true);

		System.out.print("Vui lòng nhập ý nghĩa của từ \"" + name + "\": ");
		meaning = sc.nextLine();
		dictionary.pushWord(name, meaning);
		ConsoleColor.message("Đã thêm vào từ điển thành công.", "success");
	}

	public void deleteOneWord() {
		String name;
		System.out.print("Nhập từ mà bạn muốn xóa: ");
		name = sc.nextLine();
		if (!dictionary.isExisted(name)) {
			ConsoleColor.message("Từ \"" + name + "\" chưa tồn tại trong từ điển.", "error");
		}
		dictionary.deleteOneWord(name);
		ConsoleColor.message("Đã xóa thành công ra khỏi từ điển.", "error");
	}

	public void searchWord() {
		String name;
		System.out.print("Nhập từ mà bạn muốn tra cứu: ");
		name = sc.nextLine();
		if (!dictionary.isExisted(name)) {
			ConsoleColor.message("Từ \"" + name + "\" chưa tồn tại trong từ điển.", "error");
		}
		System.out.println("Tra cứu thành công, kết quả là " + name + ": " + dictionary.getValue(name));
	}

	public void displayWords() {
		int count = dictionary.getWordCount();
		if (count == 0) {
			ConsoleColor.message("Danh sách từ điển hiện tại đang rỗng.", "error");
			return;
		}
		System.out.println("Danh sánh hiện tại đang có " + count + " từ điển");
		for (Map.Entry<String, String> word : dictionary.getWordAll()) {
			System.out.println(word.getKey() + ": " + word.getValue());
		}
	}

	public void getWordCount() {
		System.out.println("Số lượng hiện có trong danh sách là: " + dictionary.getWordCount() + " từ điển");
	}

	public void clearAllWord() {
		int count = dictionary.getWordCount();
		if(count == 0) {
			ConsoleColor.message("Trong danh sách đang rỗng nên không có gì để xóa.", "error");
			return;
		}
		dictionary.clearAllWord();
		ConsoleColor.message("Đã xóa hết " + count + " từ điển trong danh sách.", "success");
	}

}
