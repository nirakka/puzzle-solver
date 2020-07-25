package main;

import java.util.ArrayList;
import java.util.Arrays;

public class AssignmentStack {
	//a Stackの要素型定義
	class AssignmentElem{
		public char [] used;
		public AssignmentElem() {
			used = new char[10];
			Arrays.fill(used, ' ');
		}
		
		//a 配列の内容を一度に表示[0:S 1:E ... ]
		private String a2s(char [] a) {
			String str = "[";
			for (int i=0;i<a.length;i++) {
				str = str + i + ":" + a[i] + " ";
			}
			str = str + "]";
			return str;
		}
		
		public String toString() {
			return a2s(used);
		}
	}
	
	public ArrayList<AssignmentElem> elems;
	public int index;
	
	public AssignmentStack() {
		index = 0;
		elems = new ArrayList<AssignmentElem>();
		push();//a 初期化の際に1つ要素を作成
	}
	
	//a 要素のコピー（入れ物は変更しない）
	//a elems[dst] = elems[src]と同じ内容
	public void copy(int dst, int src) {
		AssignmentElem dstE = elems.get(dst);
		AssignmentElem srcE = elems.get(src);
		
		for (int i=0;i<dstE.used.length;i++) {
			dstE.used[i] = srcE.used[i];
		}
	}
	
	//a 要素の内容を直前にpushされた要素と同じにする
	public void clear() {
		if (index >= 2) {
			copy(index-1,index-2);
		} else {
			Arrays.fill(elems.get(index-1).used, ' ');
		}
	}
	
	//a 新しい要素を作成し，前の要素の内容をコピーする
	public void push() {
		elems.add(new AssignmentElem());
		index++;
		if (index >=2 ) {
			copy(index-1, index-2);
		}
	}
	
	//a 不要になった要素を取り除く
	public void pop() {
		elems.remove(index-1);
		index--;
	}
	
	//a 最新の要素を参照する
	public char [] getUsed() {
		return elems.get(index-1).used;
	}
	
	//a テストに必要: 文字列sに数値xを割当て、表を更新
	public void set(int x, String s) {
		char [] used = getUsed();
		int len = s.length();
		for (int i=0;i<len;i++) {
			int d = x%10;
			used[d] = s.charAt(len-1-i);
			x /= 10;
		}
	}
}
