package graphics.frames;

import javax.swing.JMenuBar;

import graphics.menus.EditMenu;
import graphics.menus.FileMenu;

public class MenuBar extends JMenuBar{
    
    private FileMenu fileMenu;
    private EditMenu editMenu;

    public MenuBar(){
        this.fileMenu = new FileMenu("file");
        this.add(this.fileMenu);

        this.editMenu = new EditMenu("edit");
        this.add(this.editMenu);
    }
}