
public class Student {
	protected String fullName, classRoom;
	protected double averageScore;

	public Student(String fullName, String classRoom, double averageScore) {
		this.fullName = fullName;
		this.classRoom = classRoom;
		this.averageScore = averageScore;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	@Override
	public String toString() {
		return "Student [fullName=" + fullName + ", classRoom=" + classRoom + ", averageScore=" + averageScore + "]";
	}

}
