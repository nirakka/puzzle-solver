package main;

import java.util.Arrays;

public class Puzzle {
	
	// ToDo:問題をオブジェクトとする．
	
	private String s1="SATURN";
	private String s2="URANUS";
	private String s3="PLANETS";
	
	/*
	private String s1="SEND";
	private String s2="MORE";
	private String s3="MONEY";
	*/
	private char [] used=new char [10];
	public Puzzle() {
		clear();
	}
	
	public static void main(String [] args) {
		Puzzle p = new Puzzle();
		p.run();
	}

	/*
	SATURN = 546790
	URANUS = 794075
	PLANETS = 1340865
	*/
	
	// ToDo:x1,x2のループ上限下限をs1,s2から求める
	
	// 新しいアルゴリズムの実装
	public void run() {
		int x1;
		int x2;
		for (x1=540000;x1<550000;x1++) {
			clear();
			if (match(""+x1,s1)==false) {
				continue;
			}
			
			for (x2=790000;x2<800000;x2++) {
				clear();
				match(""+x1,s1);
				if (match(""+x2,s2)==false) {
					continue;
				}
				
				examine(x1,x2); //a 検査, 見つかれば出力
			}
		}
		System.out.println("Done!");
	}
	
	public void clear() {
		for (int i=0;i<used.length;i++) {
			used[i] = ' ';
		}
	}
	
	public void set(int x, String s) {
		match(""+x, s);
	}

	//a テスト用に分離
	public boolean examine(int x1, int x2){
		int x3 = x1 + x2;
		boolean f = match(""+x3, s3);
		if (f) {			
			//aここに来たら解が見つかる
			System.out.println("x1="+x1+",x2="+x2+",x3="+x3 );
		}
		return f;
	}
	
	//a 整数ｘがパターンｓに一致すればtrueを返す．
	//a 例：match("1234","SEND") = true;
	//a 例: match("1111", "SEND") = false;
	public boolean match(String x, String s) {
		boolean f = true;
		for (int i=0;i<s.length();i++) {
			// sのi桁目がxのi桁目と一致するか調べる
			char xi = extc(x,i);
			char si = extc(s,i);
			if (xi < '0' || xi > '9')
				return false;
			if (match2(xi-'0', si)==false) {
				return false;
			}
		}
		return f;
	}
	
	//a 文字siがほかの数字に割り当てられていれば失敗
	private boolean notUsed(char si) {
		for (int i=0;i<used.length;i++) {
			if (used[i] == si) {
				return false;
			}
		}
		return true;
	}
	
	//a整数xiに文字siを割り当てられるかどうか調べる
	//a整数xiがすでに別の文字に割り当てられていれば失敗
	public boolean match2(int xi, char si) {
		if (used[xi]==' ' && notUsed(si)) {
			//a siに数字が割り当てられていない
			//a →割り当てて成功とする
			used[xi]=si;
			return true;
		} else if (used[xi] != si) {
			return false;
		}
		return true;
	}

	//a文字列sの右からi文字目を取り出す(0から数える)
	public char extc(String s, int i) {
		int j = (s.length()-1)-i;
		if (j >= 0 && j < s.length())	
			return s.charAt(j);
		else
			return ' ';
	}
}
