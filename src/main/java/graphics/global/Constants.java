package graphics.global;

import graphics.shapes.TLine;
import graphics.shapes.TOval;
import graphics.shapes.TPolygon;
import graphics.shapes.TRectangle;
import graphics.shapes.TSelect;
import graphics.shapes.TShape;

public class Constants { 
	private static String IconAddress(String iconName) {
		return "Icon/" + iconName + ".png";
	}

	public enum ETools {
		eRectangle(IconAddress("rectangle"), IconAddress("clicked_rectangle"), "네모를 그립니다.", new TRectangle()),
		eOval(IconAddress("oval"), IconAddress("clicked_oval"), "원을 그립니다.", new TOval()),
		eLine(IconAddress("line"), IconAddress("clicked_line"), "선을 그립니다.", new TLine()),
		ePolygon(IconAddress("polygon"), IconAddress("clicked_polygon"), "다각형을 그립니다.", new TPolygon()),
		eSelect(IconAddress("select"), IconAddress("clicked_select"), "그려진 도형을 선택하여 이동시킵니다.",new TSelect());
//		ePen(IconAddress("pen"), IconAddress("clicked_pen"), new TPen());

		private TShape tool;
		private String selectedIcon, icon, toolTip;

		private ETools(String icon, String selectedIcon, String toolTip, TShape tool) {
			this.icon = icon;
			this.selectedIcon = selectedIcon;
			this.toolTip = toolTip;
			this.tool = tool;
		}

		public String getSelectedIcon() {
			return this.selectedIcon;
		}

		public String getIcon() {
			return this.icon;
		}

		public String getToolTip() {
			return this.toolTip;
		}

		public TShape newShape() {
			return this.tool.clone();
		}

	}

	public enum EFileMenus {
//		eNew("new"), eOpen("open"), eClose("close"), eSave("save"), eSaveAs("save as"), ePrint("print"), eQuit("quit");

		eOpen("open"), eSaveAs("save as");
		
		private String label;

		private EFileMenus(String label) {
			this.label = label;
		}

		public String getLabel() {
			return this.label;
		}
	}

	public enum EEditMenus {
		eUnDo("undo"), eReDo("redo"), eCut("cut"), eCopy("copy"), ePaste("paste"), eDelete("delete"),
		eSelectAll("selectAll"), eGroup("group"), eUnGroup("unGroup");

		private String label;

		private EEditMenus(String label) {
			this.label = label;
		}

		public String getLabel() {
			return this.label;
		}
	}
}
