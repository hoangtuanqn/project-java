
public class Menu {
	public static void displayMenu() {
		String[] messages = { "Kiểm tra file có thể thực thi", "Kiểm tra file có thể đọc", "Kiểm tra file có thể ghi",
				"In đường dẫn", "In tên tệp tin / thư mục", "Kiểm tra file là thư mục hoặc tập tin",
				"In ra cây thư mục", "In ra các file ẩn trong thư mục", "Đổi tên tệp tin / thư mục hiện tại", "Di chuyển tệp tin / thư mục",
				"Xóa tệp tin / thư mục" };

		int length = messages.length;

		System.out.println("------MENU------");
		for (int i = 0; i < length; ++i) {
			System.out.println(i + 1 + ". " + messages[i]);
		}
		System.out.println("0. Thoát chương trình");
		System.out.print("Chọn (0-" + length + "): ");
	}

	public static void displayMenuWarning() {
		ConsoleColor.message("Bạn có chắc chắn muốn thực hiện thao tác không. Nó có thể gây ảnh hưởng đến dữ liệu.",
				"warning");
		System.out.println("1. Tiếp tục");
		System.out.println("0. Dừng lại");
		System.out.print("Chọn: ");
	}

}
