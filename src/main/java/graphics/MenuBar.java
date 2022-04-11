package graphics;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar{
    
    private JMenu fileMenu;
    private JMenu editMenu;

    public MenuBar(){
        this.fileMenu = new JMenu("file");
        this.add(this.fileMenu);

        this.editMenu = new JMenu("edit");
        this.add(this.editMenu);
    }
}
