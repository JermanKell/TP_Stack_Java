package Stack;

import java.util.ArrayList;
import java.util.List;

import Observer_pattern.*;
import View.View;

public class Stack implements Subject{
	
	private List<Integer> stackCont;
	private List<View> lView;
	
	public Stack() {
		stackCont = new ArrayList<Integer>();
		lView = new ArrayList<View>();
	}
	
	@Override
	public void Attach(Observer obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Detach(Observer obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Notify() {
		// TODO Auto-generated method stub
		
	}
	
}
