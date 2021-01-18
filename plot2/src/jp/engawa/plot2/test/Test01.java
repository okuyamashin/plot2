package jp.engawa.plot2.test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jp.engawa.plot2.model.Figure;
import jp.engawa.plot2.model.IntLine;
import jp.engawa.plot2.svg.SvgBuilder;

public class Test01 {
	public static void main(String[] args) throws Exception {
		List<Integer> arr0 = new ArrayList<Integer>();
		Random r = new Random();
		for(int ii=0;ii<100;ii++) {
			int num = r.nextInt(10000);
			arr0.add(num);
		}
		
		Figure f = new Figure();
		IntLine line0 = new IntLine("sales").sample();
		f.add(line0);
		
		SvgBuilder builder = new SvgBuilder(f);
		
		FileOutputStream out = new FileOutputStream("/tmp/test01.svg");
		builder.build(out);
		out.flush();
		out.close();
		System.out.println("--");
	}
}
