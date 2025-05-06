import java.io.File;

public class FileInfoManager {
	private FileInfo file;
	private String pathFile;

	public FileInfoManager(String pathFile) {
		this.file = new FileInfo(pathFile);
		this.pathFile = pathFile;
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

	public void handleClearFiles(File[] childFolder) {
		for (File child : childFolder) {
			if (child.isFile())
				child.delete();
			else {
				handleClearFiles(child.listFiles());
				child.delete();
			}
		}
	}

	public void clearFiles() {
		if (!this.file.isDirectory()) {
			ConsoleColor.message("Đây không phải là thư mục nên không có các tệp tin con phía trong.", "error");
			return;
		}
		handleClearFiles(this.file.listFiles());
		this.file.delete();
		ConsoleColor.message("Đã xóa hết tất cả các tệp tin", "success");

	}

	public boolean exists() {
		return this.file.exists();
	}

	public void renameTo(String nameFile) {
		String pathParent = this.file.getParent();
		if (this.file.isDirectory()) {
			pathParent = this.file.getAbsolutePath();
		}
		pathParent += "\\";
		String newPath = pathParent + nameFile;
		if (this.file.renameTo(new File(newPath))) {
			ConsoleColor.message("Đã đổi tên thành công", "success");
			this.file = new FileInfo(newPath);
			return;
		}
		ConsoleColor.message("Đã xảy ra lỗi trong quá trình đổi tên", "error");
	}

	public void handleMove(File fileOld, File fileNew) {
		if (fileOld.isFile()) {
			String pathOk = fileNew.getAbsoluteFile() + "\\" + fileOld.getName();
			if (fileOld.renameTo(new File(pathOk))) {
				ConsoleColor.message("Đã di chuyển thành công file " + fileOld.getAbsolutePath(), "success");
			} else {
				ConsoleColor.message("Đã xảy ra lỗi khi di chuyển file " + fileOld.getAbsolutePath() + " sang: " + pathOk, "error");
			}
		} else {
			File[] childFolder = fileOld.listFiles();
			File fileNew2;
			for (File child : childFolder) {
				if (child.isDirectory()) {
					fileNew2 = new File(fileNew.getAbsoluteFile() + "\\" + child.getName());
					if (!fileNew2.exists()) {
						fileNew2.mkdir();
					}
				} else {
					fileNew2 = fileNew;
				}
				handleMove(child, fileNew2);
				child.delete();
			}
		}
	}

	public void move(String pathNew) {
		File fileNew = new File(pathNew);
		if (fileNew.isFile() || !fileNew.exists()) {
			ConsoleColor.message("Đường dẫn mới bắt buộc phải là thư mục và phải tồn tại trước.", "error");
			return;
		}
		handleMove(new File(this.pathFile), new File(pathNew));
	}

}