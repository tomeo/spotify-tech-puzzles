import java.util.ArrayList;

public class VoteBooth extends ArrayList<VoteGroup> {
	private int max;

	public VoteBooth() {
		this.max = 1;	
	}

	public void add(Vote vote) {
		ArrayList<VoteGroup> tmp = new ArrayList<VoteGroup>();
		for(VoteGroup group : this) {
			if (group.compatible(vote)) {
				VoteGroup newGroup = new VoteGroup(vote, group);
				tmp.add(newGroup);
				if(newGroup.size() > this.max) this.max = newGroup.size();
			}
		}
		super.add(new VoteGroup(vote));
		super.addAll(tmp);
		System.out.println("VG size: " + this.size());
	}

	public int getMax() {
		return this.max;
	}
}
