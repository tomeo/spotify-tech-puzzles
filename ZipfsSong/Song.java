public class Song {
	private String name;
	private Integer pos;
	private Long quality;

	public Song (Long times, String name, Integer pos) {
		this.name = name;
		this.pos = pos;
		this.quality = times*pos;
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
