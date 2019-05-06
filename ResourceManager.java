import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class ResourceManager
{
    public static BufferedImage getImage(String i){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("graphics/"+i));
        } catch (IOException e) {}
        return image;
    }
}
