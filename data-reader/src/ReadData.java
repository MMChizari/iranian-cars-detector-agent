import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadData {

	public static void main(String[] args) throws IOException {
		String searchFileName = "search-dena2 [22-01-26 14-50-47].txt";
		File inputFile = new File("search files/" + searchFileName);
		Scanner scanner = new Scanner(inputFile);
		ArrayList<String> result = new ArrayList<>();
		int counter = 0;

		String pattern = "https:\\/\\/s1.*[.]webp";
		Pattern compiler = Pattern.compile(pattern);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			Matcher matcher = compiler.matcher(line);
			if (matcher.find()) {
				String imageURL = matcher.group();
				if (!result.contains(imageURL)) {
					counter++;
					result.add(imageURL);
				}
			}
		}

		String resultFileName = "result-dena2.txt";
		File outputFile = new File("result files/" + resultFileName);
		Formatter formatter = new Formatter(outputFile);
		formatter.format("numbers: " + counter + "\n");
		for (String s : result) {
			formatter.format(s + "\n");
		}
		formatter.flush();
	}
}
