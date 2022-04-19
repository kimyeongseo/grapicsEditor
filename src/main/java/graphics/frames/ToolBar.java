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
	 
	 DrawingPanel drawingPanel = new DrawingPanel();
	
	public ToolBar(){
		this.setBackground(Color.PINK);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		ActionHandler actionHandler = new ActionHandler();
			
		for(ETools eTool: ETools.values()) {
			ImageIcon toolIcon = new ImageIcon(eTool.getIcon());
			JRadioButton toolButton = new JRadioButton(toolIcon);
			toolButton.setSelectedIcon(new ImageIcon(eTool.getSelectedIcon()));
			toolButton.setToolTipText(eTool.getToolTip());
			
			
			toolButton.setActionCommand(eTool.name());
			toolButton.addActionListener(actionHandler);
			
			this.add(toolButton);
			buttonGroup.add(toolButton);
		}	 
	}


	public void assosiate(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
		JRadioButton defaultButton = (JRadioButton) this.getComponent(ETools.eRectangle.ordinal()); 
		defaultButton.doClick();
	}
	
	private class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			drawingPanel.setSelectedTool(ETools.valueOf(event.getActionCommand()));
		}	
	}
}
