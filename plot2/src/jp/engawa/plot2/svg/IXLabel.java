package jp.engawa.plot2.svg;

import java.io.IOException;
import java.io.PrintWriter;

import jp.engawa.plot2.model.ILine;

public interface IXLabel {
	public void draw(SvgBuilder builder,PrintWriter out,ILine line) throws IOException;
}
