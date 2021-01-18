package jp.engawa.plot2.model;

public class ScaleLabel {
	protected double value;
	protected String label;
	
	public ScaleLabel(double value,ILine line) {
		this.value = value;
		this.label = line.label(value);
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
