import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.lang.StringBuilder;

public class ZipfsSong {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = Integer.parseInt(sc.nextLine().split(" ")[1]);

		ZipfList songs = new ZipfList(m);
		int pos = 1;
		while (sc.hasNextLine()) {
			songs.offer(new Song(sc.nextLine().split(" "), pos++));
		}

		Song[] out = new Song[m];
		for (int i = m-1; i >= 0; i--) {
			out[i] = songs.poll();
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			sb.append(out[i] + "\n");
		}
		System.out.println(sb.toString());
	}
}

class Song {
	private String name;
	private Integer pos;
	private Long quality;

	public Song (long times, String name, Integer pos) {
		this.name = name;
		this.pos = pos;
		this.quality = times*pos;
	}

	public Song(String[] values, int pos) {
		this(Long.parseLong(values[0]), values[1], pos);
	}

	public int compareQuality(Song other) {
		return this.quality.compareTo(other.quality);
	}

	public int comparePosition(Song other) {
		return this.pos.compareTo(other.pos);
	}

	public String toString() {
		return this.name;
	}
}

class ZipfList extends PriorityQueue<Song> {
	private int maxSize;

	public ZipfList(int maxSize) {
		super(maxSize, new SongComparator());
		this.maxSize = maxSize;
	}

	public boolean offer(Song song) {
		if (this.size() < maxSize) {
			super.offer(song);
			return true;
		} 
		else if (this.comparator().compare(song, this.peek()) > 0) {
			this.remove();
			super.offer(song);
			return true;
		}
		return false;
	}
}

class SongComparator implements Comparator<Song> {
	public int compare(Song s1, Song s2) {
		int qualComp = s1.compareQuality(s2);
		return (qualComp == 0) ? s2.comparePosition(s1) : qualComp;
	}
}