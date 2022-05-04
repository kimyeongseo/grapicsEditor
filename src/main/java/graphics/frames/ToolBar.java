package graphics.frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import graphics.global.Constants.ETools;

public class ToolBar extends JToolBar {
	private static final long serialVersionUID = 1L;

	DrawingPanel drawingPanel;

	public ToolBar() {
		this.setBackground(Color.PINK);

		ButtonGroup buttonGroup = new ButtonGroup();
		ActionHandler actionHandler = new ActionHandler();

		// shape tool
		for (ETools eTool : ETools.values()) {
			ImageIcon toolIcon = new ImageIcon(eTool.getIcon());
			JRadioButton toolButton = new JRadioButton(toolIcon);
			toolButton.setSelectedIcon(new ImageIcon(eTool.getSelectedIcon()));
			toolButton.setToolTipText(eTool.getToolTip());

			toolButton.setActionCommand(eTool.name());
			toolButton.addActionListener(actionHandler);

			this.add(toolButton);
			buttonGroup.add(toolButton);
		}

		// thickness tool
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 20, 1);
		slider.setPaintLabels(true); // 간격 보여주기
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(9);
		slider.setMinorTickSpacing(5);
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider js = (JSlider) e.getSource();
				drawingPanel.thick = js.getValue();
			}
		});
		this.add(slider);
	}

	public void associate(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
		JRadioButton defaultButton = (JRadioButton) this.getComponent(ETools.eRectangle.ordinal());
		defaultButton.doClick();
	}

	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			drawingPanel.setSelectedTool(ETools.valueOf(event.getActionCommand()));
		}
	}
}
