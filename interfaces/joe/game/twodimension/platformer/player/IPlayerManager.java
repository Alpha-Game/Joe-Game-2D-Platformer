package joe.game.twodimension.platformer.player;

import java.util.Collection;

import joe.classes.identifier.IMappable;
import joe.game.base.action.IActionableObject;
import joe.game.base.effect.IEffectableStates;
import joe.game.base.effect.IKillableObject;
import joe.game.base.settings.ISettings;
import joe.game.base.statistics.IStatistics;
import joe.game.twodimension.platformer.layer.ILayerObject;
import joe.game.twodimension.platformer.physics.IMoveableObject;

public interface IPlayerManager extends IActionableObject, IMoveableObject, IEffectableStates, IKillableObject, ISpawnableObject, IStatistics, ISettings, ILayerObject {
	IPlayerGroup getPlayerGroup(String playerGroupID);
	Collection<IPlayerGroup> getPlayerGroups();
	Collection<IPlayerGroup> getPlayerGroups(String... playerGroupIDs);
	Collection<IPlayerGroup> getPlayerGroups(IPlayerGroup... playerGroupIDs);
	Collection<IPlayerGroup> getPlayerGroups(Collection<Object> playerGroupIDs);
	
	boolean addPlayerGroups(IMappable callingObject, IPlayerGroup... playerGroups);
	boolean addPlayerGroups(IMappable callingObject, Collection<IPlayerGroup> playerGroups);
	
	Collection<IPlayerGroup> removePlayerGroups(IMappable callingObject, String... playerGroupIDs);
	Collection<IPlayerGroup> removePlayerGroups(IMappable callingObject, IPlayerGroup... playerGroups);
	Collection<IPlayerGroup> removePlayerGroups(IMappable callingObject, Collection<Object> playerGroupIDs);
}
