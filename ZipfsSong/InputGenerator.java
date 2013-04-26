import java.util.Random;
import java.lang.StringBuilder;

public class InputGenerator {
	public static String randomString() {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: InputGenerator <n> <m> > outfile");
			System.exit(0);
		}

		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);

		System.out.println(n + " " + m);

		Random r = new Random();
		long maxHits = 1000000000000L;
		for (int i = 0; i < n; i++) {
			System.out.println((long)(r.nextDouble()*maxHits) + " " + randomString());
		}

	}
}