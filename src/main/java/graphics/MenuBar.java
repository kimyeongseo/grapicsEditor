package graphics;

import javax.swing.JMenuBar;

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
