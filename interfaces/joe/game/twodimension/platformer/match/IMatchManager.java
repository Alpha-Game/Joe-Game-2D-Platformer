package joe.game.twodimension.platformer.match;

import java.util.Collection;

import joe.game.base.IMappableContainer;
import joe.game.base.effect.IHasEffectableStates;
import joe.game.base.settings.IHasSettings;
import joe.game.base.statistics.IHasStatistics;
import joe.game.manager.IManager;
import joe.game.twodimension.platformer.layer.ILayerManager;
import joe.game.twodimension.platformer.player.IPlayerGroup;
import joe.game.twodimension.platformer.player.IPlayerManager;

public interface IMatchManager extends IMappableContainer, IHasStatistics, IHasEffectableStates, IHasSettings, IManager {
	IPlayerManager getPlayer(Object playerID);
	Collection<IPlayerManager> getPlayers();
	Collection<IPlayerManager> getPlayers(Object... playerIDs);
	Collection<IPlayerManager> getPlayers(Collection<Object> playerIDs);
	
	IPlayerGroup getPlayerGroup(Object playerGroupID);
	Collection<IPlayerGroup> getPlayerGroups();
	Collection<IPlayerGroup> getPlayerGroups(Object... playerGroupIDs);
	Collection<IPlayerGroup> getPlayerGroups(Collection<Object> playerGroupIDs);
	
	ILayerManager getLayer(Object layerID);
	Collection<ILayerManager> getLayers();
	Collection<ILayerManager> getLayers(Object... layerIDs);
	Collection<ILayerManager> getLayers(Collection<Object> layerIDs);
	
	ILayerManager getActiveLayer(Object layerID);
	Collection<ILayerManager> getActiveLayers();
	Collection<ILayerManager> getActiveLayers(Object... layerIDs);
	Collection<ILayerManager> getActiveLayers(Collection<Object> layerIDs);
	
	void setLayerActive(double priority, ILayerManager layer);
	void setLayerInactive(ILayerManager layer);
}
