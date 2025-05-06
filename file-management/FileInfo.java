import java.io.File;

public class FileInfo {
	private final File file;

	public FileInfo(String path) {
		this.file = new File(path);
	}

	public boolean exists() {
		return file.exists();
	}

	public boolean canRead() {
		return file.canRead();
	}

	public boolean canWrite() {
		return file.canWrite();
	}

	public boolean canExecute() {
		return file.canExecute();
	}

	public boolean isFile() {
		return file.isFile();
	}

	public boolean isDirectory() {
		return file.isDirectory();
	}

	public String getAbsolutePath() {
		return file.getAbsolutePath();
	}

	public String getName() {
		return file.getName();
	}

	public String getParent() {
		return file.getParent();
	}

	public File[] listFiles() {
		return file.listFiles();
	}

	public boolean renameTo(File dest) {
		return file.renameTo(dest);
	}

	public boolean delete() {
		return file.delete();
	}

	public File getFile() {
		return this.file;
	}
}
