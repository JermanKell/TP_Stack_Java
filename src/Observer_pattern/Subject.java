package Observer_pattern;

public interface Subject{
	public void Attach(Observer observer);
	public void Detach(Observer observer);
	public void Notify();
}
