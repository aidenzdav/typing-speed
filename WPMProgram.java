package wpm;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class WPMProgram {

	static String[] words = { "realize", "selection", "the", "hello", "microphone", "elephant", "biscuit", "hammer",
			"went", "cap", "bullet", "look", "mold", "pleasant", "a", "blank", "blank", "head", "translate", "bread",
			"sweep", "watch", "scream", "shy", "bolt", "cellar", "fantasy", "friend", "television", "account", "welcome"};

	public static String getWordAtPosition(String data, String delimiter, int position) {
		int i = 0;
		String[] parts = data.split(delimiter);
		for (String s : parts) {
			i++;
			if (i == position) {
				return s;
			}
		}

		return "";
	}

	double compareStr(String inputStr, String userStr) {
		int charsTypedCorrect = 0;
		//int numberOfCharsNotTyped = 0;
		for (int i = 0; i < userStr.length(); i++) {
			if (userStr.charAt(i) == inputStr.charAt(i)) {
				charsTypedCorrect++;
			}
		}

		double perc = inputStr.length() / charsTypedCorrect * 100;

		return perc;
	}

	public static void main(String[] args) throws InterruptedException {

		System.out.println("3");
		TimeUnit.SECONDS.sleep(1);

		System.out.println("2");
		TimeUnit.SECONDS.sleep(1);

		System.out.println("1");
		TimeUnit.SECONDS.sleep(1);

		Random rand = new Random();
		for (int i = 0; i < 15; i++) {
			System.out.print(words[rand.nextInt(31)] + " ");
		}
		System.out.println();

		double start = LocalTime.now().toNanoOfDay();

		Scanner scan = new Scanner(System.in);
		String typedWords = scan.nextLine();

		double end = LocalTime.now().toNanoOfDay();
		double elapsedTime = end - start;
		double seconds = elapsedTime / 1000000000.0;
		int numChars = typedWords.length();

		int wpm = (int) ((((double) numChars / 5) / seconds) * 60);

		System.out.println("Your wpm is " + wpm + "!");

		scan.close();

	}

}
