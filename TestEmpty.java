import java.io.File;
public class TestEmpty {
	public static void main(String[] args) {
		File[] files = new File("c:/Users/cotote/Desktop/Temp").listFiles();
		Empty emptyChecker = new Empty();
		emptyChecker.loopThrough(files);
		emptyChecker.printEmptyFiles();
	}
}