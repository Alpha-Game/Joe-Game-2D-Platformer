package joe.game.twodimension.platformer.tiles;

public interface IDrawableTileManager extends ITileManager {
	double getTileLayerOrder();
	void setTileDrawableGroup(ITileDrawableGroup group);
	ITileDrawableGroup getTileDrawableGroup();
	boolean isRedrawRequired();
}
