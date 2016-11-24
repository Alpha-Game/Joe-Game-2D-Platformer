package joe.game.twodimension.platformer.layer;

import java.util.Collection;

import joe.game.base.IMappableContainer;
import joe.game.base.effect.IEffectableStates;
import joe.game.base.settings.ISettings;
import joe.game.base.statistics.IStatistics;
import joe.game.twodimension.platformer.match.IMatchObject;
import joe.game.twodimension.platformer.player.IPlayerManager;
import joe.game.twodimension.platformer.tiles.ITileManager;

public interface ILayerManager extends IMappableContainer, IStatistics, IEffectableStates, IMatchObject, ISettings {
	IPlayerManager getPlayer(String playerID);
	Collection<IPlayerManager> getPlayers();
	Collection<IPlayerManager> getPlayers(String... playerIDs);
	Collection<IPlayerManager> getPlayers(Collection<Object> playerIDs);
	
	ITileManager getTile(String tileID);
	Collection<ITileManager> getTiles();
	Collection<ITileManager> getTiles(String... tileIDs);
	Collection<ITileManager> getTiles(Collection<Object> tileIDs);
	
	void setIsActive(boolean isActive);
	boolean isActive();
}
