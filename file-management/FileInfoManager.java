import java.io.File;

public class FileInfoManager {
	private FileInfo fileInfo;

	public FileInfoManager(String path) {
		this.fileInfo = new FileInfo(path);
	}

	public boolean exists() {
		return fileInfo.exists();
	}

	private void showResult(String action, boolean result) {
		if (result) {
			ConsoleColor.message(action + ": THÀNH CÔNG", "success");
		} else {
			ConsoleColor.message(action + ": THẤT BẠI", "error");
		}
	}

	public void canExecute() {
		showResult("Tập tin có thể thực thi", fileInfo.canExecute());
	}

	public void canRead() {
		showResult("Tập tin có thể đọc", fileInfo.canRead());
	}

	public void canWrite() {
		showResult("Tập tin có thể ghi", fileInfo.canWrite());
	}

	public void getAbsolutePath() {
		ConsoleColor.message("Đường dẫn tuyệt đối: " + fileInfo.getAbsolutePath(), "success");
	}

	public void getName() {
		ConsoleColor.message("Tên tập tin: " + fileInfo.getName(), "success");
	}

	public void isDirectoryOrFile() {
		if (fileInfo.isDirectory()) {
			ConsoleColor.message("Đây là thư mục", "success");
		} else if (fileInfo.isFile()) {
			ConsoleColor.message("Đây là tập tin", "success");
		} else {
			ConsoleColor.message("Không xác định được loại đối tượng", "error");
		}
	}

	public void displayTreeFolder(boolean includeFiles) {
		if (!fileInfo.isDirectory()) {
			ConsoleColor.message("Đường dẫn không phải là thư mục", "error");
			return;
		}

		File[] files = fileInfo.listFiles();
		if (files == null || files.length == 0) {
			ConsoleColor.message("Thư mục trống", "warning");
			return;
		}

		displayTreeRecursive(files, 0, includeFiles);
	}

	private void displayTreeRecursive(File[] files, int level, boolean includeFiles) {
		for (File f : files) {
			if (f.isDirectory() || includeFiles) {
				System.out.println("  ".repeat(level) + "|-- " + f.getName());
				if (f.isDirectory()) {
					displayTreeRecursive(f.listFiles(), level + 1, includeFiles);
				}
			}
		}
	}

	public void renameTo(String newName) {
		File newFile = new File(fileInfo.getParent(), newName);
		boolean result = fileInfo.renameTo(newFile);
		showResult("Đổi tên", result);
	}

	public void move(String newPath) {
		File newLocation = new File(newPath, fileInfo.getName());
		boolean result = fileInfo.renameTo(newLocation);
		showResult("Di chuyển", result);
	}

	public void clearFiles() {
		boolean result = deleteRecursive(fileInfo);
		showResult("Xoá", result);
	}

	private boolean deleteRecursive(FileInfo fInfo) {
		if (fInfo.isDirectory()) {
			File[] children = fInfo.listFiles();
			if (children != null) {
				for (File child : children) {
					FileInfo childInfo = new FileInfo(child.getAbsolutePath());
					deleteRecursive(childInfo);
				}
			}
		}
		return fInfo.delete();
	}
}
