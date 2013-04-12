import java.util.Scanner;
import java.util.Arrays;

public class ZipfsSong {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] ai = sc.nextLine().split(" ");
		int n = Integer.parseInt(ai[0]);
		int m = Integer.parseInt(ai[1]);

		Song[] songs = new Song[n];
		int pos = 1;
		String[] si;
		while (sc.hasNextLine()) {
			si = sc.nextLine().split(" ");
			songs[pos-1] = new Song(Long.parseLong(si[0]), si[1], pos);
			pos++;
		}

		Arrays.sort(songs, new SongComparator());
		for (int i = 0; i < m; i++) {
			System.out.println(songs[i]);
		}
	}
}
