import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static FileInfoManager manager;

	public static void displayEnterPathFile() {
		System.out.print("Vui lòng nhập đường dẫn của file: ");
		String pathFile = sc.nextLine();
		manager = new FileInfoManager(pathFile);
	}

	public static void main(String[] args) {
		int choice, c;
		do {

			displayEnterPathFile();
			if (manager.exists())
				break;
			ConsoleColor.message("Bạn vừa nhập đường dẫn không hợp lệ. Yêu cầu nhập lại.", "error");

		} while (true);

		do {

			Menu.displayMenu();
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

				case 9:
					Menu.displayMenuWarning();
					c = sc.nextInt();
					sc.nextLine();
					if (c != 1) {
						break;
					}
					System.out.print("Vui lòng nhập tên mới của tệp tin / thư mục: ");
					String PathNew = sc.nextLine();
					manager.renameTo(PathNew);
					break;

				case 10:
					Menu.displayMenuWarning();
					c = sc.nextInt();
					sc.nextLine();
					if (c != 1) {
						break;
					}
					System.out.print("Vui lòng nhập đường dẫn mới: ");
					PathNew = sc.nextLine();
					manager.move(PathNew);
					break;
				case 11:
					Menu.displayMenuWarning();
					c = sc.nextInt();
					sc.nextLine();
					if (c != 1) {
						break;
					}
					manager.clearFiles();
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
