package graphics.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import graphics.frames.DrawingPanel;
import graphics.global.Constants.EFileMenus;
import graphics.shapes.TShape;
public class FileMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	
	private File file;
	private DrawingPanel drawingPanel = new DrawingPanel();
	
	static final String PATH = "data/";
			
	public FileMenu(String title) {
		super(title);
		
		this.file = null;
				
		ActionHandler actionHandler = new ActionHandler();
		
		for(EFileMenus eMenu: EFileMenus.values()) {
			JMenuItem menuItem = new JMenuItem(eMenu.getLabel());
			menuItem.setActionCommand(eMenu.name());
			menuItem.addActionListener(actionHandler);
			this.add(menuItem);
		}
	}
	
	public void associate(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;				
	}

	
	private void newFile() {
		drawingPanel.newDrawingPanel();
	}
	
	private void open() {
		JFileChooser fileChooser = new JFileChooser(new File(this.PATH));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("[Graphics Editor] save file", "dat");
		fileChooser.setFileFilter(filter);

		int returnValue = fileChooser.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			this.file = fileChooser.getSelectedFile();
			this.load(file);

		} else if (returnValue == JFileChooser.CANCEL_OPTION) {
			System.out.println("open cancel");
		}
	}
	
	private void load(File file) {
		try {
			FileInputStream fis = new FileInputStream(file); 
			BufferedInputStream bis = new BufferedInputStream(fis); 
			ObjectInputStream ois = new ObjectInputStream(bis); 
			
			Object obj = ois.readObject(); 
			drawingPanel.setShapes((Vector<TShape>) obj);
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	private void save() {
		if(this.file == null) {
			this.saveAs();
		}else {
			this.store(this.file);
		}
	}
	
	
	
	private void saveAs() {
		JFileChooser fileChooser = new JFileChooser(new File(this.PATH));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Graphics Editor", "dat");
		fileChooser.setFileFilter(filter);
		int returnValue = fileChooser.showSaveDialog(this.drawingPanel);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			this.file = fileChooser.getSelectedFile();
			this.store(this.file);
		} else if (returnValue == JFileChooser.CANCEL_OPTION) {
			System.out.println("save cancel");
		}
	}
	
	private void store(File file) {
		String extension = ".dat";
		if (file != null) {
			if (file.getName().contains(extension)) {
				try {
					file = new File(this.PATH + file.getName());

					FileOutputStream fos = new FileOutputStream(file);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					ObjectOutputStream oos = new ObjectOutputStream(bos);

					oos.writeObject(drawingPanel.getShapes());
					oos.close();

					this.drawingPanel.setUpdated(false);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					file = new File(this.PATH + file.getName() + extension);

					FileOutputStream fos = new FileOutputStream(file);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					ObjectOutputStream oos = new ObjectOutputStream(bos);

					oos.writeObject(drawingPanel.getShapes());
					oos.close();
					
					this.drawingPanel.setUpdated(false);
				} catch (FileNotFoundException e) {
					e.printStackTrace();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	private void quit() {
		if (this.drawingPanel.getUpdated() == true) {
			int returnValue = JOptionPane.showOptionDialog(null,
					this.file != null
							? String.format("닫기 전에 Graphics Editor [%s] 문서에 대해 변경 내용을 저장하시겠습니까?", file.getName())
							: "닫기 전에 Graphics Editor 새로운 문서를 저장하시겠습니까?",
					"My Grahics Editor", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

			switch (returnValue) {
			case JOptionPane.YES_OPTION:
				save();
			case JOptionPane.NO_OPTION:
				System.exit(0);
			}
		}

		else { // this.drawingPanel.getUpdated() == false
			int returnValue = JOptionPane.showOptionDialog(null, "Graphics Editor를 종료하시겠습니까?", "My Grahics Editor",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

			if (returnValue == JOptionPane.YES_OPTION)
				System.exit(0);
		}
	}
	
	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			switch(EFileMenus.valueOf(event.getActionCommand())) {
			case eNew:
				newFile();
			case eSaveAs:
				saveAs();
				break;
			case eSave:
				save();
				break;
			case eOpen:
				open();
				break;
			case eQuit:
				quit();
			}
		}
	}
}