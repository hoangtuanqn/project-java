import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeOperation {
	protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	public static String getTime() {
		return LocalDateTime.now().format(formatter);
	};
}
