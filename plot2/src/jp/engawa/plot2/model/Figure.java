package jp.engawa.plot2.model;

import java.awt.Color;
import java.text.DecimalFormat;

public class Figure implements IConst {
	protected XAxis xaxis = new XAxis();
	
	protected YAxis yaxis0 = new YAxis();
	protected YAxis yaxis1 = null;
	
	public boolean isHas_yaxis1() {
		if(this.yaxis1 == null) {
			return false;
		}
		return true;
	}
	
	public boolean addYAxis1() {
		if(this.yaxis1 != null) return false;
		
		this.yaxis1 = new YAxis();
		return true;
	}
	//f.addLine("LINE0","売上","円",Figure.LINE_TYPE_LINE,Color.BLUE,new DecimalFormat("#,##0"));
	
	public boolean addLine(String key,String title,String unit,int lineSide,int lineType,Color color,DecimalFormat deci) {
		return true;
	}
}
