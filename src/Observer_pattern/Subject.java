package Observer_pattern;

public interface Subject{
	public void Attach(Observer obs);
	public void Detach(Observer obs);
	public void Notify();
}
