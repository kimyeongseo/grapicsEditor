package graphics;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {
    
    private JRadioButton rectangleTool;
    private JRadioButton ovalTool;
    private JRadioButton polygonTool;
    private JRadioButton lineTool;

    private Icon rectangleIcon;
	private Icon ovalIcon;
	private Icon lineIcon;
	private Icon polygonIcon;

    public ToolBar(){
        ButtonGroup buttonGroup = new ButtonGroup();

        this.rectangleIcon = new ImageIcon("Icon/icons8-rectangle-24.png");
		this.rectangleTool = new JRadioButton(rectangleIcon);
		this.add(this.rectangleTool);
		buttonGroup.add(this.rectangleTool);
		
		this.ovalIcon = new ImageIcon("Icon/icons8-oval-24.png");
		this.ovalTool = new JRadioButton(ovalIcon);
		this.add(this.ovalTool);
		buttonGroup.add(this.ovalTool);
		
		this.polygonIcon = new ImageIcon("Icon/icons8-polygon-24.png");
		this.polygonTool = new JRadioButton(polygonIcon);
		this.add(this.polygonTool);	
		buttonGroup.add(this.polygonTool);

        this.lineIcon = new ImageIcon("Icon/icons8-line-24.png");
		this.lineTool = new JRadioButton(lineIcon);
		this.add(this.lineTool);
		buttonGroup.add(this.lineTool);
		
    }

}
