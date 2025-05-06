public class ConsoleColor {
	public static final String RESET = "\u001B[0m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String CYAN = "\u001B[36m";

	public static void println(String message, String color) {
		String colorCode = getColorCode(color);
		System.out.println(colorCode + message + RESET);
	}

	public static void message(String message, String type) {
		switch (type.toLowerCase()) {
		case "success" -> println(message, "green");
		case "error" -> println(message, "red");
		case "warning" -> println(message, "yellow");
		case "info" -> println(message, "cyan");
		default -> println(message, "reset");
		}
	}

	private static String getColorCode(String colorName) {
		return switch (colorName.toLowerCase()) {
		case "red" -> RED;
		case "green" -> GREEN;
		case "yellow" -> YELLOW;
		case "cyan" -> CYAN;
		default -> RESET;
		};
	}
}
