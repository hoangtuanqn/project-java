import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static FileInfoManager manager;

	public static void displayEnterPathFile() {
		System.out.print("Vui lòng nhập đường dẫn của file: ");
		String pathFile = sc.nextLine();
		manager = new FileInfoManager(pathFile);
//		manager = new FileInfoManager("C:\\Users\\MSI\\Downloads\\TestNe");
	}

	public static void displayMenu() {
		String[] messages = { "Kiểm tra file có thể thực thi", "Kiểm tra file có thể đọc", "Kiểm tra file có thể ghi",
				"In đường dẫn", "In tên file/folder", "Kiểm tra file là thư mục hoặc tập tin", "In ra cây thư mục",
				"In ra các file ẩn trong thư mục" };

		int length = messages.length;

		System.out.println("------MENU------");
		for (int i = 0; i < length; ++i) {
			System.out.println(i + 1 + ". " + messages[i]);
		}
		System.out.println("0. Thoát chương trình");
		System.out.print("Chọn (0-" + length + "): ");
	}

	public static void main(String[] args) {
		int choice;
		do {

			displayEnterPathFile();
			if (manager.exists())
				break;
			ConsoleColor.message("Bạn vừa nhập đường dẫn không hợp lệ. Yêu cầu nhập lại.", "error");

		} while (true);

		do {

			displayMenu();
			try {
				choice = sc.nextInt();
				sc.nextLine(); // Clear key Enter

				switch (choice) {
				case 0:
					ConsoleColor.message("Đã thoát chương trình thành công", "success");
					return;

				case 1:
					manager.canExecute();
					break;

				case 2:
					manager.canRead();
					break;

				case 3:
					manager.canWrite();
					break;

				case 4:
					manager.getAbsolutePath();
					break;

				case 5:
					manager.getName();
					break;

				case 6:
					manager.isDirectoryOrFile();
					break;

				case 7:
					manager.displayTreeFolder(false);
					break;

				case 8:
					manager.displayTreeFolder(true);
					break;

				}

				System.out.print("Nhấn Enter để tiếp tục: ");
				sc.nextLine();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (true);

	}
}
