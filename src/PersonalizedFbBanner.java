import java.awt.Color;
import java.util.Random;

/* CS 125 - Intro to Computer Science
 * File Name: PeronalizedFbBanner.java
 * Java Programming
 * Lab 4 - Due X/XX/XXXX
 * Instructor: Dr. Dan Grissom
 * 
 * Name 1: FirstName1 LastName1
 * Name 2: FirstName2 LastName2
 * Description: This file contains the source code for the Lab 4 class PeronalizedFbBanner,
 * which is the main class containing your facebook banner code that you create.
 */
public class PersonalizedFbBanner extends FbBanner implements RandomDrawMethods {

    Random rand = new Random();

    @Override

    public void DrawRandomFilledOval() {
        g2d.setColor(bannerColors[rand.nextInt(bannerColors.length)]);
        g2d.fillOval(rand.nextInt(getWidth()), rand.nextInt(getHeight()), rand.nextInt(100), rand.nextInt(100));
    }

    @Override
    public void DrawRandomFilledRectangle() {
        g2d.setColor(bannerColors[rand.nextInt(bannerColors.length)]);
        g2d.fillRect(rand.nextInt(getWidth()), rand.nextInt(getHeight()), rand.nextInt(100), rand.nextInt(100));
    }

    @Override
    public void DrawTextAtRandomLocation(String txt) {

        g2d.setColor(Color.BLACK);
        rotateDrawingAngle(rand.nextInt(40) - 20);
        g2d.drawString(txt, rand.nextInt(getWidth()), rand.nextInt(getHeight()));
        setRotationAngleToDefault();
    }

    //Creates a random pattern of squares where no two touching squares are the same color
    @Override
    public void DrawCustomizedDecoration() {
        final Color[] rubiksColors = {Color.RED, Color.ORANGE, Color.BLUE, Color.GREEN, Color.WHITE, Color.YELLOW};
        final int SIZE = 20;

        //Make a grid that will correlate to a number of SIZE*SIZE colored boxes on our banner
        //The +1 ensures that any small portion of a box will also be included
        int[][] colorArray = new int[(getHeight() / SIZE) + 1][(getWidth() / SIZE) + 1];

        //Populate the array with "colors" 0-5
        int colorBehind, colorAbove, newColor = -1;
        
        for (int r = 0; r < colorArray.length; r++) {
            for (int c = 0; c < colorArray[r].length; c++) {

                //If this is the first row, don't compare to the color above
                if (r == 0) {
                    colorAbove = -1;
                } else {
                    colorAbove = colorArray[r - 1][c];
                }

                //If this is the first column, don't compare to the color behind
                if (c == 0) {
                    colorBehind = -1;
                } else {
                    colorBehind = colorArray[r][c - 1];
                }

                //While newColor is the same as the color above or behind, make a new color
                do {
                    newColor = rand.nextInt(rubiksColors.length);

                } while (newColor == colorBehind || newColor == colorAbove);

                //Fill in this cell with the new color
                colorArray[r][c] = newColor;
            }
        }

        //Translate colorArray into real colors
        int xPos, yPos = 0;
        for (int[] r : colorArray) {
            //Start at 0 each new row
            xPos = 0;
            for (int c : r) {
                g2d.setColor(rubiksColors[c]);
                g2d.fillRect(xPos, yPos, SIZE, SIZE);
                xPos += SIZE;
            }
            yPos += SIZE;
        }
        //End method
    }

}
