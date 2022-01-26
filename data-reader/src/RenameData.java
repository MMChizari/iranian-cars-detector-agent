import java.io.File;
import java.io.IOException;

public class RenameData {
	public static void main(String[] args) throws IOException {
		File folder = new File("images/dena2-webp-all - Copy");
		File[] files = folder.listFiles();
		for (File file : files) {
			String name = file.getName();
			file.renameTo(new File("images/dena2-jpg/" + name.substring(0, name.length() - 4) + "jpg"));
		}
	}
}
