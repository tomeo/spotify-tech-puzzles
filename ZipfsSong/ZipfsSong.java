import java.util.Scanner;
import java.util.Comparator;
import java.util.TreeSet;

public class ZipfsSong {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = Integer.parseInt(sc.nextLine().split(" ")[1]);

		ZipfList songs = new ZipfList(m);
		int pos = 1;
		while (sc.hasNextLine()) {
			songs.add(new Song(sc.nextLine().split(" "), pos++));
		}

		for (Song song : songs) {
			System.out.println(song);
		}
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

class ZipfList extends TreeSet<Song> {
	private int maxSize;

	public ZipfList(int maxSize) {
		super(new SongComparator());
		this.maxSize = maxSize;
	}

	public boolean add(Song song) {
		if (this.size() < maxSize) {
			super.add(song);
			return true;
		} else if (this.comparator().compare(song, this.last()) < 0) {
			this.pollLast();
			super.add(song);
			return true;
		}
		return false;
	}
}

class SongComparator implements Comparator<Song> {
	public int compare(Song s1, Song s2) {
		int qualComp = s2.compareQuality(s1);
		return (qualComp == 0) ? s1.comparePosition(s2) : qualComp;
	}
}