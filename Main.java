import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;


public class Main {

    public static final double[][] BLUR = {
            {1.0 / 9, 1.0 / 9, 1.0 / 9},
            {1.0 / 9, 1.0 / 9, 1.0 / 9},
            {1.0 / 9, 1.0 / 9, 1.0 / 9}};
    public static final double[][] GAUSS_BLUR = {
            {.0625, .125, .0625},
            {.125, .25, .125},
            {.0625, .125, .0625}};
    public static final double[][] SHARPEN = {
            {0, -1, 0},
            {-1, 5, -1},
            {0, -1, 0}};
    public static final double[][] EMBOSS = {
            {-2, -1, 0},
            {-1, 1, 1},
            {0, 1, 2}};
    public static final double[][] EDGE_DETECT = {
            {-1.0, -1.0, -1.0},
            {-1.0, 8.0, -1.0},
            {-1.0, -1.0, -1.0}
    };
    public static final double[][] EDGE_DETECT_2 = {
            {0, -1, 0},
            {-1, 4, -1},
            {0, -1, 0}};
    public static final double[][] TEST = {
            {5, 0, 5},
            {0, 7, 0},
            {5, 0, 5}};
    public static BufferedImage image;
    public static int width, height;

    public static void main(String[] args) {
        //read the file
        Color[][] imageArray = getColors("quiz-penguin.png");
        //manipulate the image
        imageArray = convolve(EMBOSS, imageArray);
        //write the image to output file
        toFile(imageArray, "output1.png");


    }


    private static void toFile(Color[][] colors, String fileName) {
        for (int i = 0; i < width; i++) {
            //![](mango.png)
            for (int j = 0; j < height; j++) {
                image.setRGB(i, j, colors[i][j].getRGB());
            }
        }
        try {
            File outputFile = new File(fileName);
            ImageIO.write(image, "png", outputFile);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    private static Color[][] getColors(String filename) {
        try {
            File inputFile = new File(filename);
            image = ImageIO.read(inputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        Color[][] output = null;
        if (image != null) {
            width = image.getWidth();
            height = image.getHeight();
            output = new Color[width][height];

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    output[i][j] = new Color(image.getRGB(i, j));
                }
            }
        }
        return output;
    }

    private static Color[][] toGreyscale(Color[][] input) {
        Color[][] output = new Color[input.length][input[0].length];
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                output[i][j] = toGrey(input[i][j], 0);

            }
        }
        return output;
    }

    private static Color[][] blackAndWhite(Color[][] input) {
        Color[][] output = new Color[input.length][input[0].length];
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                output[i][j] = toBW(input[i][j], 100);

            }
        }
        return output;
    }


    private static Color toGrey(Color color, int type) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        if (type == 0) {

            int grey = (r + g + b) / 3;
            return new Color(grey, grey, grey);
        }
        if (type == 1) {
            int grey = (int) (Math.sqrt(r * r + g * g + b * b));
            grey = Math.min(grey, 255);
            grey = Math.max(grey, 0);
            return new Color(grey, grey, grey);
        } else {
            double Rs = r / 255.0 <= 0.03928 ? r / (255.0 * 12) : Math.pow((r + 0.055) / 1.055, 2.4);
            double Gs = g / 255.0 <= 0.03928 ? g / (255.0 * 12) : Math.pow((g + 0.055) / 1.055, 2.4);
            double Bs = b / 255.0 <= 0.03928 ? b / (255.0 * 12) : Math.pow((b + 0.055) / 1.055, 2.4);
            double lum = 0.2126 * Rs + 0.7152 * Gs + 0.0722 * Bs;
            int grey = (int) (256 * lum);
            grey = Math.min(grey, 255);
            grey = Math.max(grey, 0);
            return new Color(grey, grey, grey);
        }
    }

    private static Color toBW(Color color, int threshold) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        double len = Math.sqrt(r * r + g * g + b * b);
        return len < threshold ? Color.BLACK : Color.WHITE;
    }

    public static Color[][] convolve(double[][] kernel, Color[][] image) {
        Color[][] output = new Color[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (i == 0 || j == 0 || i == image.length - 1 || j == image[0].length - 1) {
                    output[i][j] = image[i][j];
                } else {
                    double tempSumRed = 0;
                    double tempSumGreen = 0;
                    double tempSumBlue = 0;
                    for (int k = 0; k < 3; k++) {
                        for (int m = 0; m < 3; m++) {
                            tempSumRed += image[i - 1 + k][j - 1 + m].getRed() * kernel[k][m];
                            tempSumGreen += image[i - 1 + k][j - 1 + m].getGreen() * kernel[k][m];
                            tempSumBlue += image[i - 1 + k][j - 1 + m].getBlue() * kernel[k][m];
                        }
                    }
                    int r = getBoundedValue(Math.abs((int) tempSumRed), 0, 255);
                    int g = getBoundedValue(Math.abs((int) tempSumGreen), 0, 255);
                    int b = getBoundedValue(Math.abs((int) tempSumBlue), 0, 255);
                    output[i][j] = new Color(r, g, b);
                }
            }
        }
        return output;
    }

    private static int getBoundedValue(int input, int lowerBound, int upperBound) {
        return Math.max(lowerBound, Math.min(input, upperBound));
    }
}