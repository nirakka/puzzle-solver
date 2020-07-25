package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import main.Puzzle;

public class TestMatch {
	class TestRec{
		public String num;
		public String pat;
		public boolean ans;
		
		public TestRec() {
			this.num = "";
			this.pat = "";
			this.ans = false;
		}
		
		public TestRec(String num, String pat, boolean ans) {
			this.num = num;
			this.pat = pat;
			this.ans = ans;
		}
	}
	
	Puzzle p = new Puzzle();

	private TestRec [] recs = {
			new TestRec("546790","SATURN", true),
			new TestRec("794075","URANUS", true),
			new TestRec("546789","SATURN", true),
			
	};
	
	private String a2s(char [] a) {
		String str = "[";
		for (int i=0;i<a.length;i++) {
			str = str + i + ":" + a[i] + " ";
		}
		str = str + "]";
		return str;
	}
	
	@Test
	public void testl() {
		for (TestRec r:recs) {	
			System.out.println("r="+r);
			testsub(r);
			
		}
	}
	
	public void testsub(TestRec r) {
		assertTrue(p.match(r.num, r.pat)==r.ans);
		//System.out.println("used="+a2s(p.stack.getUsed()));
		p.clear();
	}
}
