package no07.no0797;


import org.junit.Test;

public class Test0797 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		
		int[][] graph = new int[][] {{1,2}, {3}, {3}, {}};
		
		so.allPathsSourceTarget(graph);
	}
}
