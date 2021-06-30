package pl.edu.agh.mwo.scratchbook;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {

	private List<Memento> mementoList = new ArrayList<Memento>();
	private Editor editor;
	
	
	public void setText(String text) {
		this.editor.setText(text);
	}

	public void add(Memento memento) {
		mementoList.add(memento);
	}

	public Memento get(int number) {
		return mementoList.get(number);
	}
	
	public List<Memento> getMementoList(){
        return this.mementoList;
    }

}
