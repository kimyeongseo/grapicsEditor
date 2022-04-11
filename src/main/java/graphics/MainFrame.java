package graphics;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
    
    private MenuBar menuBar;
    private ToolBar toolBar;
    private DrawingPanel drawingPanel;

    public MainFrame(){
        this.setTitle("Graphics Editor");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우 닫으면 프로세스 종료 

        this.menuBar = new MenuBar();
        this.setJMenuBar(this.menuBar);

        this.toolBar = new ToolBar();
        this.add(this.toolBar);

        this.drawingPanel = new DrawingPanel();
        this.add(this.drawingPanel);
    }
}
