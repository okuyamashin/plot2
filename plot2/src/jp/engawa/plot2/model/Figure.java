package jp.engawa.plot2.model;

import java.util.ArrayList;
import java.util.List;

public class Figure implements IConst {
	protected XAxis xaxis = new XAxis();
	
	protected YAxis yaxis0 = new YAxis();
	protected YAxis yaxis1 = null;
	
	protected List<ILine> lines = new ArrayList<ILine>();
	
	protected int size = 0;
	protected double max = 0d;
	
	protected Scale scale = new Scale();
	
	public boolean isHas_yaxis1() {
		if(this.yaxis1 == null) {
			return false;
		}
		return true;
	}
	
	public Figure addYAxis1() {
		if(this.yaxis1 != null) return this;
		
		this.yaxis1 = new YAxis();
		return this;
	}

	public Figure add(ILine line) throws PlotException {
		if(this.lines.size() > 0) {
			int size = line.size();
			if(size != this.size) {
				throw new PlotException("Lines must be same size.");
			}
			double max = line.getMax();
			if(max > this.max) {
				this.max = max;
				this.scale.build(line);
			}
		} else {
			this.size = line.size();
			this.max = line.getMax();
			this.scale.build(line);
		}
		
		this.lines.add(line);
		
		return this;
	}

	public ILine getLine() {
		if(this.scale == null) return null;
		return this.scale.getLine();
	}
	
	public Scale getScale() {
		return scale;
	}

	public void setScale(Scale scale) {
		this.scale = scale;
	}
}
