import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StudentManager manager = new StudentManager();
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n----- MENU -----");
			System.out.println("1. Thêm sinh viên");
			System.out.println("2. Sửa sinh viên");
			System.out.println("3. Xóa sinh viên");
			System.out.println("4. Hiển thị danh sách");
			System.out.println("5. Hiển thị sinh viên điểm cao nhất");
			System.out.println("6. Lưu sinh viên xuống tệp");
			System.out.println("7. Lấy dữ liệu sinh viên từ tệp lên");
			System.out.println("0. Thoát");
			System.out.print("Chọn: ");
			choice = sc.nextInt();
			sc.nextLine(); // Xóa dấu enter

			switch (choice) {
			case 1:
				manager.addStudent();
				break;
			case 2:
				manager.updateStudent();
				break;
			case 3:
				manager.deleteStudent();
				break;
			case 4:
				manager.displayStudents();
				break;
			case 5:
				manager.displayStudentExcellent();
				break;
			case 6:
				manager.writeDataInFile();
				break;
			case 7:
				manager.readDataFromFile();
				break;
			case 0:
				System.out.println("Đã thoát chương trình.");
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ!");
			}
		} while (choice != 0);
	}
}
