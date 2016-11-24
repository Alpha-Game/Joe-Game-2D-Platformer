package joe.game.twodimension.platformer.layer;

import joe.game.twodimension.platformer.match.IMatchObject;

public interface ILayerObject extends IMatchObject {
	void setLayer(ILayerManager layer);
	ILayerManager getLayer();
}
