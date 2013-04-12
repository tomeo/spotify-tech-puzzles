import java.util.Comparator;

public class SongComparator implements Comparator<Song> {
	public int compare(Song s1, Song s2) {
		int qualComp = s2.compareQuality(s1);
		return (qualComp == 0) ? s1.comparePosition(s2) : qualComp;
	}
}
