
public class ConsoleColor {
	protected final static String RED = "\u001B[31m";
	protected final static String GREEN = "\u001B[32m";
	protected final static String RESET = "\u001B[0m";

	public static void message(String message, String status) {
		if (status.compareTo("success") == 0) {
			System.out.println(GREEN + message + RESET);
		} else {
			System.out.println(RED + message + RESET);
		}
	}
}
