package graphics.global;

import graphics.shapes.TLine;
import graphics.shapes.TOval;
import graphics.shapes.TPolygon;
import graphics.shapes.TRectangle;
import graphics.shapes.TShape;

public class Constants { 
	private static String IconAddress(String iconName) {
		return "Icon/" + iconName + ".png";
	}

	public enum ETools {
		// eSelect(IconAddress("select"), IconAddress("clicked_select"), "그려진 도형을 선택하여 이동시킵니다.",new TSelect()),
		eRectangle(IconAddress("rectangle"), IconAddress("clicked_rectangle"), "네모를 그립니다.", new TRectangle()),
		eOval(IconAddress("oval"), IconAddress("clicked_oval"), "원을 그립니다.", new TOval()),
		eLine(IconAddress("line"), IconAddress("clicked_line"), "선을 그립니다.", new TLine()),
		ePolygon(IconAddress("polygon"), IconAddress("clicked_polygon"), "다각형을 그립니다.", new TPolygon());
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
		
		private String lable;

		private EFileMenus(String lable) {
			this.lable = lable;
		}

		public String getLable() {
			return this.lable;
		}
	}

	public enum EEditMenus {
		eUnDo("undo"), eReDo("redo"), eCut("cut"), eCopy("copy"), ePaste("paste"), eDelete("delete"),
		eSelectAll("selectAll"), eGroup("group"), eUnGroup("unGroup");

		private String lable;

		private EEditMenus(String lable) {
			this.lable = lable;
		}

		public String getLable() {
			return this.lable;
		}
	}
}
