package graphics.shapes;

import java.awt.Rectangle;

public class TSelect extends TShape{

	public TSelect() {
		this.shape = new Rectangle.Double();
	}
	
	@Override
	public void setOrigin(int x, int y) {
	}

	@Override
	public void resize(int x, int y) {
	}

	@Override
	public TShape clone() {
		return new TSelect();
	}
}
