package bitmapTransformer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Path;

public class Bitmap {

    public String inputPath;
    public String outputPath;
    public String transformOperation;
    public BufferedImage workingImage;

    public Bitmap(String inputPath, String outputPath, String transformOperation){
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.transformOperation = transformOperation;
    }

    public void readFile(){
        File file = new File(this.inputPath);
        System.out.println(file.toString());
        try {
            BufferedImage image = ImageIO.read(file);

            System.out.println(image.toString());

            int height = image.getHeight();

            System.out.println("the height is: " + height);

            this.workingImage = image;

        } catch (IOException exception) {
            System.out.println(exception);
        }

    }

    public void verticalFlip(){
        int imgHeight = this.workingImage.getHeight();
        int imgWidth = this.workingImage.getWidth();

        for (int x = 0; x < imgWidth; x++) {
            for (int y = 0; y < imgHeight / 2; y++) {
                int temp = this.workingImage.getRGB(x, y);
                this.workingImage.setRGB(x, y, this.workingImage.getRGB(x, this.workingImage.getHeight()-y-1));
                this.workingImage.setRGB(x, this.workingImage.getHeight()-y-1, temp);
                ;
            }
        }
    }

    public void horizontalFlip(){
        int imgHeight = this.workingImage.getHeight();
        int imgWidth = this.workingImage.getWidth();

        for (int y = 0; y < imgHeight; y++) {
            for (int x = 0; x < imgWidth / 2; x++) {
                int temp = this.workingImage.getRGB(x, y);
                this.workingImage.setRGB(x, y, this.workingImage.getRGB(this.workingImage.getWidth()-x-1, y));
                this.workingImage.setRGB(this.workingImage.getWidth()-x-1,y, temp);

            }
        }
    }

    public void savefile(){

        try {
            ImageIO.write(this.workingImage, "bmp", new File(this.outputPath));
        } catch(IOException exception) {
            System.out.println(exception);
        }

    }
}
