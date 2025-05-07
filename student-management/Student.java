import java.io.Serializable;

public class Student implements Serializable {
	protected String fullName, classRoom;
	protected double averageScore;
	String createdAt, updatedAt;

	public Student(String fullName, String classRoom, double averageScore) {
		this.fullName = fullName;
		this.classRoom = classRoom;
		this.averageScore = averageScore;
		this.createdAt = TimeOperation.getTime();
		this.updatedAt = "";
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
	

	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Student [fullName=" + fullName + ", classRoom=" + classRoom + ", averageScore=" + averageScore
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}


}
