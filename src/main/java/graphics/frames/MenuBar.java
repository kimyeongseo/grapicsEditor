package graphics.frames;

import javax.swing.JMenuBar;

import graphics.menus.EditMenu;
import graphics.menus.FileMenu;

public class MenuBar extends JMenuBar{
    
    private FileMenu fileMenu;
    private EditMenu editMenu;

    private DrawingPanel drawingPanel;

    public MenuBar(){
        this.fileMenu = new FileMenu("file");
        this.add(this.fileMenu);

        this.editMenu = new EditMenu("edit");
        this.add(this.editMenu);
    }

    public void associate(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
        this.fileMenu.associate(this.drawingPanel);
    }
}
