import java.io.*;
import java.util.Scanner;

public class StudentManager {
	private final int maxStudent = 100;
	private Student[] students = new Student[maxStudent];
	private int count = 0;
	private Scanner sc = new Scanner(System.in);

	public void addStudent() {

		if (count >= maxStudent) {
			ConsoleColor.message("Số lượng sinh viên đã đạt đến giới hạn. Không thể thêm.", "error");
			return;
		}
		System.out.print("Vui lòng nhập Họ và Tên sinh viên: ");
		String fullName = sc.nextLine();

		System.out.print("Vui lòng nhập Lớp sinh viên: ");
		String classRoom = sc.nextLine();

		double averageScore = 0;
		do {
			System.out.print("Vui lòng nhập Điểm trung bình sinh viên: ");
			averageScore = sc.nextDouble();
			if (averageScore < 0 || averageScore > 10) {
				ConsoleColor.message("Điểm không hợp lệ.", "error");
			} else {
				break;
			}
		} while (true);
		sc.nextLine(); // Xóa dấu enter
		students[count++] = new Student(fullName, classRoom, averageScore);

		ConsoleColor.message("Đã thêm sinh viên thành công.", "success");

	}

	private boolean isCheckIndexStudent(int index) {
		if (index - 1 < 0 || index - 1 >= maxStudent) {
//			ConsoleColor.message("Sinh viên không hợp lệ.", "error");
			return false;
		}
		if (index - 1 >= count) {
//			ConsoleColor.message("Sinh viên không tồn tại", "error");
			return false;
		}
		return true;
	}

	public void updateStudent() {
		displayStudents();
		int choice;
		do {
			System.out.println("Yêu cầu chọn thứ tự sinh viên cần sửa");
			System.out.print("Chọn: ");
			choice = sc.nextInt();
			sc.nextLine(); // Xóa dấu enter

			if (!isCheckIndexStudent(choice)) {
				ConsoleColor.message("Sinh viên không hợp lệ. Yêu cầu chọn lại.", "error");
			} else {

				System.out.print("Vui lòng nhập Họ và Tên mới: ");
				String fullName = sc.nextLine();

				System.out.print("Vui lòng nhập Lớp mới: ");
				String classRoom = sc.nextLine();

				double averageScore = 0;
				do {
					System.out.print("Vui lòng nhập Điểm trung bình mới: ");
					averageScore = sc.nextDouble();
					if (averageScore < 0 || averageScore > 10) {
						ConsoleColor.message("Điểm không hợp lệ.", "error");
					} else {
						break;
					}
				} while (true);
				students[choice - 1].setFullName(fullName);
				students[choice - 1].setClassRoom(classRoom);
				students[choice - 1].setAverageScore(averageScore);
				students[choice - 1].setUpdatedAt(TimeOperation.getTime());
				ConsoleColor.message("Đã cập nhật thông tin sinh viên thành công.", "success");
				break;

			}

		} while (true);

	}

	public void displayStudents() {
		if (count == 0) {
			ConsoleColor.message("Hiện tại không có sinh viên nào.", "error");
			return;
		}
		for (int i = 0; i < count; ++i) {
			System.out.println((i + 1) + ". " + students[i].toString());
		}

	}

	public void deleteStudent() {
		displayStudents();
		int choice;
		do {
			System.out.println("Yêu cầu chọn thứ tự sinh viên cần xóa");
			System.out.print("Chọn: ");
			choice = sc.nextInt();

			if (!isCheckIndexStudent(choice)) {
				ConsoleColor.message("Sinh viên không hợp lệ. Yêu cầu chọn lại.", "error");
			} else {
				choice--;
				for (int i = choice; i < count - 1; ++i) {
					students[i] = students[i + 1];
				}
				count--;
				ConsoleColor.message("Đã xóa sinh viên thành công.", "success");
				break;
			}
		} while (true);

	}

	public void displayStudentExcellent() {
		if (count == 0) {
			ConsoleColor.message("Hiện tại không có sinh viên nào.", "error");
			return;
		}
		double maxScore = students[0].getAverageScore();
		int index = 0;
		for (int i = 1; i < count; ++i) {
			if (students[i].getAverageScore() > maxScore) {
				maxScore = students[i].getAverageScore();
				index = i;
			}
		}
		System.out.println("Sinh viên có điểm số cao nhất");
		System.out.println(students[index]);
	}

	public void writeDataInFile() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.dat"))) {

			oos.writeObject(students); // ghi 1 danh sách xuống file
			System.out.println("Đã lưu thành công" + count + " sinh viên xuống file.");

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void readDataFromFile() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.dat"))) {

			Student[] arr = (Student[]) ois.readObject();

			for (int i = 0; i < arr.length && i < maxStudent; i++) {
				if (arr[i] != null) {
					students[i] = arr[i];
					count++;
				} else
					break;
			}

			System.out.println("Đã đọc thành công " + count + " sinh viên từ file.");

		} catch (IOException | ClassNotFoundException e) {

			e.printStackTrace();
		}
	}
}