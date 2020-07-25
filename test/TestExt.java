package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Puzzle;

//ext(1234, 0) = 4;
public class TestExt {
	class TestRec{
		public int num;
		public int [] pos;
		public int [] ans;
		
		public TestRec() {
			this.num = 0;
			this.pos = new int [1];
			this.ans = new int [1];
		}
		
		public TestRec(int num, int [] pos, int [] ans) {
			this.num = num;
			this.pos = pos;
			this.ans = ans;
		}
		
		public String toString() {
			return "(num="+num+" pos="+a2s(pos)+" ans="+a2s(ans)+")";
		}
		
		private String a2s(int [] a) {
			String str = "[";
			for (int i=0;i<a.length;i++) {
				str = str + " " + a[i];
			}
			str = str + "]";
			return str;
		}
		
	}

	Puzzle p = new Puzzle();
	
	//ext(1234, 0) = 4, ext(1234, 1) = 3, ext(1234, 4) = 0を確認する
	//a 同様に1111も確認する
	//a いくつまで確認すればよいか？
	
	private TestRec [] recs = {
			new TestRec(1234, new int [] {0,1,2,3,4}, new int [] {4,3,2,1,0}),
			new TestRec(1111, new int [] {0,1,2,3,4}, new int [] {1,1,1,1,0}),
			new TestRec(1112, new int [] {0,1,2,3,4}, new int [] {2,1,1,1,0}),
			new TestRec(1122, new int [] {0,1,2,3,4}, new int [] {2,2,1,1,0}),
			new TestRec(1222, new int [] {0,1,2,3,4}, new int [] {2,2,2,1,0}),
			
			
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
			//assertTrue(p.ext(r.num, r.pos[i])==r.ans[i]);
		}
	}
}
