package graphics;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {
    
    private JRadioButton rectangleTool;
    private JRadioButton ovalTool;
    private JRadioButton polygonTool;
    private JRadioButton lineTool;

    public ToolBar(){
        ButtonGroup buttonGroup = new ButtonGroup();

        this.rectangleTool = new JRadioButton("rectangle");
        this.add(this.rectangleTool);
        buttonGroup.add(this.rectangleTool);

        this.ovalTool = new JRadioButton("oval");
        this.add(this.ovalTool);
        buttonGroup.add(this.ovalTool);

        this.polygonTool = new JRadioButton("polygon");
        this.add(this.polygonTool);
        buttonGroup.add(this.polygonTool);

        this.lineTool = new JRadioButton("line");
        this.add(this.lineTool);
        buttonGroup.add(this.lineTool);

    }

}
