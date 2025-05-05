import java.io.File;

public class FileInfo {
	private File file;

	public FileInfo(String pathFile) {
		this.file = new File(pathFile);
	}

	public boolean exists() {
		return this.file.exists();
	}

	public boolean canExecute() {
		return this.file.canExecute();
	}

	public boolean canRead() {
		return this.file.canRead();
	}

	public boolean canWrite() {
		return this.file.canWrite();
	}

	public String getAbsolutePath() {
		return this.file.getAbsolutePath();
	}

	public String getName() {
		return this.file.getName();
	}

	public boolean isDirectory() {
		return this.file.isDirectory();
	}

	public boolean isFile() {
		return this.file.isFile();
	}

	public File[] listFiles() {
		return this.file.listFiles();
	}

	public boolean delete() {
		return this.file.delete();
	}

	public boolean renameTo(File desc) {
		return this.file.renameTo(desc);
	}

	public String getParent() {
		return this.file.getParent();
	}

	public void displayFileHidden() {

	}
}
