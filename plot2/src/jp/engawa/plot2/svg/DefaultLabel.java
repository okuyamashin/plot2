package jp.engawa.plot2.svg;

import java.io.IOException;
import java.io.PrintWriter;

import jp.engawa.plot2.model.ILine;

public class DefaultLabel implements IXLabel {

	@Override
	public void draw(SvgBuilder builder,PrintWriter out,ILine line) throws IOException {
		int size = line.size();
		if(size <= 0) {
			return;
		}
		
		double dsize = size;
		double delta = 1d / dsize;
		double delta2 = delta / 2d;
		
		for(int ii=0;ii<size;ii++) {
			double di = ii;
			String label = line.xlabel(ii);
			int x = builder.x(delta * di + delta2);
			int y0 = builder.y(0);
			int y1 = builder.y(0) + builder.label_index_len;

			SvgBuilder.line(out,x,y0,x,y1,"#888888");
			
			String style = "stroke:#888888; text-anchor:middle; font-size:8px;";
			SvgBuilder.text(out,x ,y1 + 10,label,style);
		}		
	}

}
