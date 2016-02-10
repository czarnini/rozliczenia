package v1;

import java.util.Comparator;

public class IncreasingComparator implements Comparator<Pair> {

	@Override
	public int compare(Pair arg0, Pair arg1) {
		return (arg0.getSecond().compareTo(arg1.getSecond()));
	}

}
