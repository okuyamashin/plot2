package jp.engawa.plot2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Scale {
	public static void main(String[] args) throws Exception {
		IntLine line = new IntLine("sales");
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
		scale.build(line);
		
		/*
		for(int ii=0;ii<size;ii++) {
			int data = line.data.get(ii);
			System.out.println(data);
		}
		*/
	}
	
	protected double max = 0d;
	protected double min = 0d;
	
	protected List<ScaleLabel> labels = new ArrayList<ScaleLabel>();
	protected ILine line;
	
	public void build(ILine line) {
		this.labels = new ArrayList<ScaleLabel>();
		double max = line.getMax();
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
			ScaleLabel label = new ScaleLabel(ii, line);
			this.labels.add(label);
		}
		this.max = top_label;
		this.line = line;
	}
	public String label(double value) {
		return line.label(value);
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
	public List<ScaleLabel> getLabels() {
		return labels;
	}
	public void setLabels(List<ScaleLabel> labels) {
		this.labels = labels;
	}
	public ILine getLine() {
		return line;
	}
	public void setLine(ILine line) {
		this.line = line;
	}
}
