package jp.engawa.plot2.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class IntLine extends AbstractLine {
	protected DecimalFormat deci = new DecimalFormat("#,##0");
	
	protected String key;
	protected String label;
	protected String unit;
	protected List<Integer> data = new ArrayList<Integer>();
	
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
}
