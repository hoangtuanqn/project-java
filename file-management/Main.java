import java.util.*;

public class Main {
	private static final Scanner sc = new Scanner(System.in);
	private static FileInfoManager manager;

	private static void promptForFilePath() {
		System.out.print("Vui lòng nhập đường dẫn của file: ");
		String pathFile = sc.nextLine();
		manager = new FileInfoManager(pathFile);
	}

	private static boolean confirmDangerousAction() {
		Menu.displayMenuWarning();
		int choice = sc.nextInt();
		sc.nextLine();
		return choice == 1;
	}

	public static void main(String[] args) {
		while (true) {
			promptForFilePath();
			if (manager.exists())
				break;
			ConsoleColor.message("Đường dẫn không hợp lệ. Vui lòng nhập lại.", "error");
		}

		while (true) {
			Menu.displayMenu();
			try {
				int choice = sc.nextInt();
				sc.nextLine(); // clear Enter

				switch (choice) {

				case 0 -> ConsoleColor.message("Đã thoát chương trình thành công", "success");
				case 1 -> manager.canExecute();
				case 2 -> manager.canRead();
				case 3 -> manager.canWrite();
				case 4 -> manager.getAbsolutePath();
				case 5 -> manager.getName();
				case 6 -> manager.isDirectoryOrFile();
				case 7 -> manager.displayTreeFolder(false);
				case 8 -> manager.displayTreeFolder(true);
				case 9 -> {
					if (confirmDangerousAction()) {
						System.out.print("Nhập tên mới của tệp tin / thư mục: ");
						String newName = sc.nextLine();
						manager.renameTo(newName);
					}
				}
				case 10 -> {
					if (confirmDangerousAction()) {
						System.out.print("Nhập đường dẫn mới: ");
						String newPath = sc.nextLine();
						manager.move(newPath);
					}
				}
				case 11 -> {
					if (confirmDangerousAction()) {
						manager.clearFiles();
					}
				}

				default -> ConsoleColor.message("Lựa chọn không hợp lệ.", "error");

				}

				System.out.print("Nhấn Enter để tiếp tục: ");
				sc.nextLine();
			} catch (Exception e) {
				ConsoleColor.message("Đã xảy ra lỗi: " + e.getMessage(), "error");
				sc.nextLine(); // tránh loop vô tận
			}
		}
	}
}
