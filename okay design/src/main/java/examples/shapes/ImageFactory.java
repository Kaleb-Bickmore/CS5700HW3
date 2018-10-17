package examples.shapes;

import java.util.HashMap;


public class ImageFactory {
    private static final HashMap<String, EmbeddedImage> imageByFileLoc = new HashMap<String, EmbeddedImage>();
    public EmbeddedImage getImage(Point center,double size,String imageLocation ) throws ShapeException {
        EmbeddedImage myImage = imageByFileLoc.get(imageLocation);

        if (myImage == null) {
            IntrinsicEmbedded intrinsicImage = new IntrinsicEmbedded(imageLocation);
            myImage = new AllStateEmbedded(intrinsicImage, center, size);
            imageByFileLoc.put(imageLocation, intrinsicImage);

        }
        return myImage;
    }
}
