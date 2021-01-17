package jp.engawa.plot2.model;

import java.util.Random;

public class Scale {
	public static void main(String[] args) throws Exception {
		IntLine line = new IntLine();
		Random r = new Random();
		int rmax = r.nextInt(10000);
		if(rmax < 0) {
			rmax = rmax *  (-1);
		}
		for(int ii=0;ii<5;ii++) {
			int num = r.nextInt(rmax) - (rmax / 2);
			line.data.add(num);
		}		
		
		double max = line.getMax();
		int size = line.size();
		
		Scale scale = new Scale();
		scale.build(max);
		
		/*
		for(int ii=0;ii<size;ii++) {
			int data = line.data.get(ii);
			System.out.println(data);
		}
		*/
	}
	
	protected double max = 0d;
	protected double min = 0d;
	
	public void build(double max) {
		if(max <= 0) {
			return;
		}
		
		double log10 = Math.log10(max);
		int digi = (int)Math.ceil(log10);
		long top = (long)Math.floor(max / Math.pow(10d, (digi-1))) + 1;
		
		long top_label = top * (long)(Math.pow(10d, digi-1));
		long delta = (long)(Math.pow(10d, digi-1));
		if(top <= 2) {
			delta = (long)(Math.pow(10d, digi-2));
		}
		
		for(int ii=0;ii<=top_label;ii+=delta) {
			System.out.println(ii);
		}
		this.max = top_label;
	}
	
	public double pos(double value) {
		if(value <= this.min) {
			return 0d;
		}
		if(value >= this.max) {
			return 1d;
		}
		double sa0 = this.max - this.min;
		if(sa0 <= 0) {
			return 0d;
		}
		double sa1 = value - this.min;
		double rate = sa1 / sa0;
		
		return rate;
	}
}
