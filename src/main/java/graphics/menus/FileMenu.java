package graphics.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import graphics.frames.DrawingPanel;
import graphics.global.Constants.EFileMenus;
public class FileMenu extends JMenu{

    private DrawingPanel drawingPanel;
			
	public FileMenu(String title) {
		super(title);
				
		ActionHandler actionHandler = new ActionHandler();
		
		for(EFileMenus eMenu: EFileMenus.values()) {
			JMenuItem menuItem = new JMenuItem(eMenu.getLable());
			menuItem.setActionCommand(eMenu.name());
			menuItem.addActionListener(actionHandler);
			this.add(menuItem);
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
