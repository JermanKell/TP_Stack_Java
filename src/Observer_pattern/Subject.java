package Observer_pattern;

public interface Subject{
	/**
	 * Ajoute un observateur à la liste des observateurs
	 * @param observer	Observateur a ajouter a la liste
	 */
	public void Attach(Observer observer);
	
	/**
	 * Retire un observateur de la liste des observateurs
	 * @param observer	Observateur a retirer
	 */
	public void Detach(Observer observer);
	
	/**
	 * Notifie les observateurs d'un changement effectue sur la pile
	 */
	public void Notify();
}
