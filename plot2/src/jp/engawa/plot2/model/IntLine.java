package jp.engawa.plot2.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IntLine extends AbstractLine {
	protected DecimalFormat deci = new DecimalFormat("#,##0");
	
	protected String key;
	protected String label;
	protected String unit;
	protected List<Integer> data = new ArrayList<Integer>();
	
	public IntLine(String key) {
		this.key = key;
	}
	
	public IntLine sample() {
		Random r = new Random();
		int max = (int)Math.pow(10d,r.nextInt(5)+1);
		for(int ii=0;ii<10;ii++) {
			int num = r.nextInt(max);
			this.data.add(num);
		}
		return this;
	}
	
	@Override
	public double getMax() {
		if(data == null || data.size() == 0) {
			return 0d;
		}
		int ret = Integer.MIN_VALUE;
		for(int num:data) {
			if(num > ret) {
				ret = num;
			}
		}
		if(ret == Integer.MIN_VALUE) {
			ret = 0;
		}
		return ret;
	}
	
	@Override
	public int size() {
		return this.data.size();
	}
	
	@Override
	public String label(double value) {
		DecimalFormat deci = new DecimalFormat("#,##0");
		return deci.format(value);
	}
}
