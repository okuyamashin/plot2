package jp.engawa.plot2.model;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class IntLine extends AbstractLine {
	protected DecimalFormat deci = new DecimalFormat("#,##0");
	
	protected String key;
	protected String label;
	protected String unit;
	protected List<Integer> data = new ArrayList<Integer>();
	protected List<String> xlabels = new ArrayList<String>();
	
	public IntLine(String key) {
		this.key = key;
	}
	
	public IntLine sample() {
		Random r = new Random();
		int max = (int)Math.pow(10d,r.nextInt(5)+1);
		int size = r.nextInt(10);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		SimpleDateFormat dformat = new SimpleDateFormat("yyyy/MM/dd");
		
		for(int ii=0;ii<size;ii++) {
			int num = r.nextInt(max);
			this.data.add(num);
			this.xlabels.add(dformat.format(cal.getTime()));
			cal.add(Calendar.DATE, +1);
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
	@Override
	public String xlabel(int index) {
		return this.xlabels.get(index);
	}
}
