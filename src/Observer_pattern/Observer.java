package Observer_pattern;

import java.util.List;

public interface Observer {
	/**
	 * Notifie les observateurs des changements effectues
	 * @param stContent		Contenu de la pile avec les changements
	 */
	public void update(List<Integer> stContent);
}
