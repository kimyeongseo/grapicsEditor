package graphics.global;

import graphics.shapes.TLine;
import graphics.shapes.TOval;
import graphics.shapes.TPolygon;
import graphics.shapes.TRectangle;
import graphics.shapes.TShape;

public class Constants { 
	
	public enum ETools{
		eRectangle(new TRectangle()),
		eOval(new TOval()),
		ePolygon(new TPolygon()),
		eLine(new TLine());
		
		private TShape tool;
		private ETools(TShape tool) {
			this.tool = tool;
		}
		
		public TShape newShape() {
			return this.tool.clone();
		}

	}
}
