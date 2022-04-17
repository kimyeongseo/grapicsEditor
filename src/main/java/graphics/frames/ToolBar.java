package graphics.frames;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graphics.global.Constants.ETools;

public class ToolBar extends JToolBar {
	private static final long serialVersionUID = 1L;

	 private JRadioButton toolButton;
	 private Icon tooIcon;
	 
	 DrawingPanel drawingPanel = new DrawingPanel();
	
	public ToolBar(){
		this.setBackground(Color.PINK);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		ActionHandler actionHandler = new ActionHandler();
			
		for(ETools tool: ETools.values()) {
			this.tooIcon = new ImageIcon("Icon/"+tool.name()+".png");
			this.toolButton = new JRadioButton(this.tooIcon);
			
			String toolName = "" + tool.name();
			this.toolButton.setActionCommand(toolName);
			
			this.add(this.toolButton);
			buttonGroup.add(this.toolButton);
			this.toolButton.addActionListener(actionHandler);
		}
				 
	}


	public void assosiate(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;	
		this.toolButton.doClick();
	}
	
	private class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			drawingPanel.setSelectedTool(ETools.valueOf(event.getActionCommand()));
		}	
	}
}
