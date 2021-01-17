package jp.engawa.plot2.test;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jp.engawa.plot2.model.Figure;

public class Test01 {
	public static void main(String[] args) throws Exception {
		List<Integer> arr0 = new ArrayList<Integer>();
		Random r = new Random();
		for(int ii=0;ii<100;ii++) {
			int num = r.nextInt(10000);
			arr0.add(num);
		}
		
		Figure f = new Figure();
		f.addLine("LINE0","売上","円",Figure.LEFT,Figure.LINE_TYPE_LINE,Color.BLUE,new DecimalFormat("#,##0"));
	}
}
