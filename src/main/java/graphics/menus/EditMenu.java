package graphics.menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class EditMenu extends JMenu {

    private JMenuItem undoItem;
    private JMenuItem redoItem;
    private JMenuItem cutItem;
    private JMenuItem copyItem;
    private JMenuItem pasteItem;
    private JMenuItem groupItem;
    private JMenuItem unGroupItem;

    public EditMenu(String title){
        super(title);

        this.undoItem = new JMenuItem("Undo");
        this.add(this.undoItem);
        this.redoItem = new JMenuItem("Redo");
        this.add(this.redoItem);
        this.cutItem = new JMenuItem("Cut");
        this.add(this.cutItem);
        this.copyItem = new JMenuItem("Copy");
        this.add(this.copyItem);
        this.pasteItem = new JMenuItem("Paste");
        this.add(this.pasteItem);
        this.groupItem = new JMenuItem("Group");
        this.add(this.groupItem);
        this.unGroupItem = new JMenuItem("UnGroup");
        this.add(this.unGroupItem);
    }
    
}
