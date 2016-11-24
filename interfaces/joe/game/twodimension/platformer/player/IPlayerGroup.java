package joe.game.twodimension.platformer.player;

import java.util.Collection;

import joe.classes.identifier.IMappable;
import joe.game.base.statistics.IStatistics;

public interface IPlayerGroup extends IStatistics, IMappable {
	IPlayerManager getPlayer(String playerID);
	Collection<IPlayerManager> getPlayers();
	Collection<IPlayerManager> getPlayers(String... playerIDs);
	Collection<IPlayerManager> getPlayers(IPlayerManager... playerIDs);
	Collection<IPlayerManager> getPlayers(Collection<Object> playerIDs);
	
	boolean addPlayers(IMappable callingObject, IPlayerManager... players);
	boolean addPlayers(IMappable callingObject, Collection<IPlayerManager> players);
	
	Collection<IPlayerManager> removePlayers(IMappable callingObject, String... playerIDs);
	Collection<IPlayerManager> removePlayers(IMappable callingObject, IPlayerManager... players);
	Collection<IPlayerManager> removePlayers(IMappable callingObject, Collection<Object> playerIDs);
}
