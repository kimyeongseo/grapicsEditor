package graphics.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import graphics.frames.DrawingPanel;
import graphics.global.Constants.EEditMenus;

public class EditMenu extends JMenu {

    private DrawingPanel drawingPanel;

    public EditMenu(String title) {
		super(title);

		ActionHandler actionHandler = new ActionHandler();

		for (EEditMenus eMenu : EEditMenus.values()) {
			JMenuItem menuItem = new JMenuItem(eMenu.getLabel());
			menuItem.addActionListener(actionHandler);
			this.add(menuItem);
			
			 menuItem.setActionCommand(eMenu.toString());
	         menuItem.addActionListener(actionHandler);
		}
	}

	public void initialize(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {	
		}
	}    
}
