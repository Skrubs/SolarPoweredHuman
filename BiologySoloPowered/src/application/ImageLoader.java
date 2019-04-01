package application;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class ImageLoader {
	
	
	private static Image spriteSheet = new Image("textures/spritesheet.png");
	
	public static WritableImage sun1 = new WritableImage(spriteSheet.getPixelReader(),25,45,800,725);
	public static WritableImage sun2 = new WritableImage(spriteSheet.getPixelReader(),800,0,800,725);
	public static WritableImage sun3 = new WritableImage(spriteSheet.getPixelReader(),1600,0,800,725);
	
	public static WritableImage earth1 = new WritableImage(spriteSheet.getPixelReader(),495,745,250,230);
	public static WritableImage earth2 = new WritableImage(spriteSheet.getPixelReader(),755,745,250,230);
	public static WritableImage earth3 = new WritableImage(spriteSheet.getPixelReader(),1000,745,250,230);
	
	public static WritableImage hydrogen = new WritableImage(spriteSheet.getPixelReader(),0,750,110,135);
	
	public static WritableImage helium = new WritableImage(spriteSheet.getPixelReader(),150,750,110,135);
	
	public static WritableImage photon = new WritableImage(spriteSheet.getPixelReader(),275,760,120,135);
	
	public static WritableImage plant = new WritableImage(spriteSheet.getPixelReader(),1322,729,325,380);
	
	public static WritableImage ground = new WritableImage(spriteSheet.getPixelReader(),0,1650,1950,250);
	
	public static WritableImage cloud = new WritableImage(spriteSheet.getPixelReader(),0,1900,865,255);
	
	public static WritableImage rainDrop = new WritableImage(spriteSheet.getPixelReader(),0,2190,100,125);
	
	public static WritableImage smallPuddle = new WritableImage(spriteSheet.getPixelReader(),100,2200,170,125);
	public static WritableImage mediumPuddle = new WritableImage(spriteSheet.getPixelReader(),275,2180,200,239);
	public static WritableImage largePuddle = new WritableImage(spriteSheet.getPixelReader(),550,2140,350,300);

	public static WritableImage face1 = new WritableImage(spriteSheet.getPixelReader(),0,1050,534,525);
	public static WritableImage face2 = new WritableImage(spriteSheet.getPixelReader(),535,1050,534,525);
	
	public static WritableImage co2 = new WritableImage(spriteSheet.getPixelReader(),0,900,250,107);
	public static WritableImage o2 = new WritableImage(spriteSheet.getPixelReader(),1875,850,203,189);
	public static WritableImage plantCell = new WritableImage(spriteSheet.getPixelReader(),1670,1150,411,485);
	public static WritableImage humanCell = new WritableImage(spriteSheet.getPixelReader(),1190,1125,375,500);
	public static WritableImage h20 = new WritableImage(spriteSheet.getPixelReader(),1700,825,112,253);

}
