package data.models;

import java.net.URISyntaxException;

import javafx.scene.image.Image;

public class ImageManager {
	
	private static ImageManager instance = null;
	
	private static final String PATH_SPRITESHEET = "/minesweeper_spritesheet.png";
	private static final String PATH_ICON = "/minesweeper_icon.png";
	
	private static final int OFFSET_EMPTYBOX = 0;
	private static final int OFFSET_HIDDENBOX = 1;  
	private static final int OFFSET_NB_ONE = 2;
	private static final int OFFSET_NB_TWO = 3;
	private static final int OFFSET_NB_THREE = 4;
	private static final int OFFSET_NB_FOUR = 5;
	private static final int OFFSET_NB_FIVE = 6;
	private static final int OFFSET_NB_SIX = 7;
	private static final int OFFSET_NB_SEVEN = 8;
	private static final int OFFSET_NB_EIGHT = 9;
	private static final int OFFSET_FLAG = 10;
	private static final int OFFSET_BOMB = 11;
	private static final int SPRITE_WIDTH = 50;
	private static final int SPRITE_HEIGHT = 50;
	
	private Image SPRITESHEET = null;
	private Image ICON = null;
	
	private ImageManager() {
		
		try {
			SPRITESHEET = new Image(getClass().getResource(PATH_SPRITESHEET).toURI().toString());
			ICON = new Image(getClass().getResource(PATH_ICON).toURI().toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public static ImageManager getInstance() {
		if (instance == null) 
				instance = new ImageManager();
		return instance;
	}
	
	public Image getIcon() {
		return ICON;
	}
}
