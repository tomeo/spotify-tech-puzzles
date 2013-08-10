import java.util.ArrayList;

public class VoteBooth extends ArrayList<VoteGroup> {
	private int max;

	public VoteBooth() {
		this.max = 1;	
	}

	public void add(Vote vote) {
		for(VoteGroup group : this) {
			group.tryAdd(vote);
			if(group.size() > this.max) this.max = group.size();
		}
		super.add(new VoteGroup(vote));
	}

	public int getMax() {
		return this.max;
	}
}
