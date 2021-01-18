package jp.engawa.plot2.svg;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import jp.engawa.plot2.model.Figure;
import jp.engawa.plot2.model.ILine;
import jp.engawa.plot2.model.Scale;
import jp.engawa.plot2.model.ScaleLabel;

public class SvgBuilder {
	protected Figure figure;
	
	protected int width = 640;
	protected int height = 480;
	
	protected int left_margin = 100;
	protected int top_margin = 100;
	protected int bottom_margin = 100;
	protected int right_margin = 100;
	
	public SvgBuilder(Figure figure) {
		this.figure = figure;
	}
	
	public SvgBuilder build(OutputStream out) throws IOException {
		
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(out,"utf-8"));
		
		writer.write("<?xml version=\"1.0\"?>");
		writer.println("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">");
		writer.print("<svg xmlns=\"http://www.w3.org/2000/svg\" ");
		writer.print("width=\"");
		writer.print(this.width);
		writer.print("\" ");
		writer.print("height=\"");
		writer.print(this.height);
		writer.print("\" ");
		writer.println(" >");
		
		frame(writer);
		
		drawLeftScale(writer);
		
		writer.println("</svg>");
		writer.flush();
		
		return this;
	}
	
	protected void frame(PrintWriter out) throws IOException {
		int x = 0;
		int y = 0;
		int width = this.width;
		int height = this.height;
		
		String color = "#888888";
		
		rect(out,x,y,width,height,color);
		
		line(out,x(0),y(0),x(1),y(0),color);
		line(out,x(0),y(0),x(0),y(1),color);
	}
	
	protected void drawLeftScale(PrintWriter out) throws IOException {
		ILine line = this.figure.getLine();
		if(line == null) return;
		Scale scale = this.figure.getScale();
		if(scale == null) return;
		
		for(ScaleLabel s:scale.getLabels()) {
			//
		}
	}
	
	protected int x(double num) {
		double n = num;
		if(num <= 0d) {
			n = 0d;
		}
		if(num >= 1d) {
			n = 1d;
		}
		double width = this.width - (this.left_margin + this.right_margin);
		double pos = n * width;
		
		int ret = ((int)pos) + this.left_margin;
		
		return ret;
	}
	
	protected int y(double num) {
		double n = (1d - num);
		if(num <= 0d) {
			n = 1d;
		}
		if(num >= 1d) {
			n = 0d;
		}
		double height = this.height - (this.top_margin + this.bottom_margin);
		double pos = n * height;
		
		int ret = ((int)pos) + this.top_margin;
		
		return ret;
	}
	
	protected void line(PrintWriter out,int x0,int y0,int x1, int y1, String color) {
		String style = "stroke: " + color + ";";
		out.print("<line ");
		out.print(" x1=\"");
		out.print(x0);
		out.print("\" ");
		out.print(" y1=\"");
		out.print(y0);
		out.print("\" ");
		out.print(" x2=\"");
		out.print(x1);
		out.print("\" ");
		out.print(" y2=\"");
		out.print(y1);
		out.print("\" ");
		out.print(" style=\"");
		out.print(style);
		out.print("\" ");
		out.println(" />");
	}
	
	protected void rect(PrintWriter out,int x,int y,int width,int height,String color) {
		String style = "fill:none; stroke: " + color + ";";
		
		out.print("<rect ");
		out.print(" x=\"");
		out.print(x);
		out.print("\" ");
		out.print(" y=\"");
		out.print(y);
		out.print("\" ");
		out.print(" width=\"");
		out.print(width);
		out.print("\" ");
		out.print(" height=\"");
		out.print(height);
		out.print("\" ");
		out.print(" style=\"");
		out.print(style);
		out.print("\" ");
		out.println(" />");
		
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
