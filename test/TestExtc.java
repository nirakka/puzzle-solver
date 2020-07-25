package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Puzzle;
import test.TestExt.TestRec;

public class TestExtc {
	class TestRec{
		public String pat;
		public int [] pos;
		public char [] ans;
		
		public TestRec() {
			this.pat = "";
			this.pos = new int [1];
			this.ans = new char [1];
		}
		
		public TestRec(String pat, int [] pos, char [] ans) {
			this.pat = pat;
			this.pos = pos;
			this.ans = ans;
		}
		
		public String toString() {
			return "(pat="+pat+" pos="+a2s(pos)+" ans="+a2s(ans)+")";
		}
		
		//a 配列の内容を一度に表示する 
		private String a2s(int [] a) {
			String str = "[";
			for (int i=0;i<a.length;i++) {
				str = str + " " + a[i];
			}
			str = str + "]";
			return str;
		}
	
		//a 配列の内容を一度に表示する(引数の型が異なる)
		private String a2s(char [] a) {
			String str = "[";
			for (int i=0;i<a.length;i++) {
				str = str + " " + a[i];
			}
			str = str + "]";
			return str;
		}
	}

	Puzzle p = new Puzzle();
	private TestRec [] recs = {
		new TestRec("SEND", new int [] {0,1,2,3,4}, new char [] {'D', 'N', 'E', 'S', ' '}),
		new TestRec("DDDD", new int [] {0,1,2,3,4}, new char [] {'D', 'D', 'D', 'D', ' '}),
		new TestRec("DDDS", new int [] {0,1,2,3,4}, new char [] {'S', 'D', 'D', 'D', ' '}),
		new TestRec("DDSS", new int [] {0,1,2,3,4}, new char [] {'S', 'S', 'D', 'D', ' '}),
		new TestRec("DSSS", new int [] {0,1,2,3,4}, new char [] {'S', 'S', 'S', 'D', ' '}),
	};
	
	@Test
	public void testl() {
		for (TestRec r:recs) {	
			System.out.println("r="+r);
			testsub(r);			
		}
	}
	
	public void testsub(TestRec r) {
		for(int i=0;i<r.ans.length;i++) {
			assertTrue(p.extc(r.pat, r.pos[i])==r.ans[i]);
		}
	}
	
}
