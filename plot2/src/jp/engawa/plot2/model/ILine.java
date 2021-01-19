package jp.engawa.plot2.model;

public interface ILine {
	public double getMax();
	
	public int size();
	
	public String label(double value);
	
	public String xlabel(int index);
}
