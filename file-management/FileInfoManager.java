import java.io.File;

public class FileInfoManager {
	FileInfo file;

	public FileInfoManager(String pathFile) {
		this.file = new FileInfo(pathFile);
	}

	public void canExecute() {
		if (this.file.canExecute()) {
			ConsoleColor.message("File này có thể thực thi", "success");
			return;
		}
		ConsoleColor.message("File này không thể thực thi", "error");

	}

	public void canRead() {
		if (this.file.canExecute()) {
			ConsoleColor.message("File này có thể đọc", "success");
			return;
		}
		ConsoleColor.message("File này không thể đọc", "error");
	}

	public void canWrite() {
		if (this.file.canExecute()) {
			ConsoleColor.message("File này có thể ghi", "success");
			return;
		}
		ConsoleColor.message("File này không thể ghi", "error");
	}

	public void getAbsolutePath() {
		System.out.println("Đường dẫn cụ thể là: " + this.file.getAbsolutePath());
	}

	public void getName() {
		System.out.println("Tên file là: " + this.file.getName());
	}

	public void isDirectoryOrFile() {
		String typeFile = "Không thể xác định thư mục hoặc tệp tin";
		if (this.file.isDirectory())
			typeFile = "Thư mục";
		if (this.file.isFile())
			typeFile = "Tập tin";
		System.out.println("Đây là: " + typeFile);
	}

	private void displayFilesInFolder(File[] childFolder, int level, boolean hidden) {
		String space = "";

		for (int i = 0; i < level - 1; ++i) {
			space += "|  ";
		}

		if (level >= 1)
			space += "|__";
		if (level == 0) {
			System.out.print("|__");
		}
		for (File child : childFolder) {
			if (level == 0) {
				System.out.print(space);
			}
			System.out.print(space + child.getName());

			if (child.isDirectory()) {
				System.out.println("/");
				displayFilesInFolder(child.listFiles(), level + 1, hidden);
			} else {
				System.out.println();
			}

		}
	}

	public void displayTreeFolder(boolean hidden) {
		if (!this.file.isDirectory()) {
			ConsoleColor.message("Đây không phải là thư mục nên không có các tệp tin con phía trong.", "error");
			return;
		}
		System.out.println(this.file.getName() + "/");
		displayFilesInFolder(this.file.listFiles(), 1, hidden);
	}

	public void displayFileHidden() {

	}

	public boolean exists() {
		return this.file.exists();
	}
}
