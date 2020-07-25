package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import main.Puzzle;
import test.TestMatch.TestRec;

public class TestExamine {
	class TestRec{
		public int x1;
		public int x2;
		public boolean ans;
	
		public TestRec() {
			this.x1 = 0;
			this.x2 = 0;
			this.ans = false;
		}
		
		public TestRec(int x1, int x2, boolean ans) {
			this.x1 = x1;
			this.x2 = x2;
			this.ans = ans;		
		}
		
		public String toString() {
			return "x1="+x1+" x2="+x2+" ans="+ans;
		}
	}
	
	TestRec[] recs = {
		new TestRec(546790,794075,true),
//		new TestRec(546000,794000,false),
		
	};

	Puzzle p = new Puzzle();

	@Test
	public void testl() {
		for (TestRec r:recs) {	
			testsub(r);			
		}
	}
	
	public void testsub(TestRec r) {
		p.clear();
		p.set(r.x1, "SATURN");
		p.set(r.x2, "URANUS");
		assertTrue(p.examine(r.x1, r.x2)==r.ans);
	}
}
