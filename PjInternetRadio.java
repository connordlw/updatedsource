/*==============================================================================

name:       PjInternetRadio.java

purpose:    An Internet Radio using the PumaJ Framework.
            
history:    Sun Nov 27, 2011 08:46:23 (LBM) created.

notes:
                        This program was created by PumaJ
             and is the confidential and proprietary product of PumaJ
        Any unauthorized use, reproduction or transfer is strictly prohibited.

                           COPYRIGHT 2011 BY PumaJ
          (Subject to limited distribution and restricted disclosure only).
                             All rights reserved.

==============================================================================*/
                                       // package ----------------------------//
 
                                       // imports ----------------------------//
import com.giavaneers.gui.elements.embedded.GvIMediaPlayer;
import com.giavaneers.gui.elements.embedded.GvVLCMediaPlayer;
import com.pumaj.PjApplication;
import com.pumaj.PjUtils;

// PjInternetRadio ====================//
public class PjInternetRadio extends PjApplication
{
                                       // class constants --------------------//
protected static final String[] kRELATIVE_IMAGE_PATHS =
{
   "images/Jazz 1.png", "images/Jazz 2.png", "images/Jazz 3.png", "images/Jazz 4.png", "images/Jazz 5.png"
};

protected static final String[] kSOUL_IMAGE_PATHS =
{
   "images/Soul1.png", "images/Soul2.png", "images/Soul3.png", "images/Soul4.png", "images/Soul5.png"
};

protected static final String[] kBLUES_PATHS =
{
   "images/Blues1.png", "images/Blues2.png", "images/Blues3.png", "images/Blues4.png", "images/Blues5.png"
};
                                       // package instance variables ---------//
                                       // (none)                              //
                                       // public instance variables ----------//
                                       // (none)                              //
                                       // protected instance variables -------//
protected GvIMediaPlayer mediaPlayer;  // media player                        //
                                       // private instance variables ---------//
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       PjInternetRadio - default constructor
                                                                              */
                                                                             /**
            Default constructor

@return     An instance of PjInternetRadio if successful.

@history    Sun Nov 27, 2011 08:46:23 (LBM) created.

@notes
                                                                              */
//------------------------------------------------------------------------------
public PjInternetRadio()
{
}
/*------------------------------------------------------------------------------

@name       buildGUI - build the radio gui
                                                                              */
                                                                             /**
            Build the radio graphical user interface.

@return     void

@history    Sun Dec 06, 2015 08:46:23 (LBM) created.

@notes
                                                                              */
//------------------------------------------------------------------------------
protected void buildGUI()
{
   PjInternetRadio myRadio = new PjInternetRadio();
                                       // assign this app properties          //
   setLayout(null);
   setVisible(true);
   setWidth(960);
   setHeight(720);
                                       // add a clickable shape 200x200       //
   MyClickableShape[] zeev = new MyClickableShape[24];
   for (int i = 0; i < zeev.length; i++) {
      zeev[i] = new MyClickableShape();
      zeev[i].setWidth(125);
      zeev[i].setHeight(125);

   if (i == 0) {
      zeev[i].setLocation(50, 100);
   }

   else {
      zeev[i].setLocation(zeev[i-1].getX() + 150, zeev[i-1].getY());
   }

   if (i > 0 && i % 6 == 0) {
      zeev[i].setLocation(50, zeev[i-1].getY() + 150);
   }
                                       // and add it to this app              //
   add(zeev[i]);
   }
   zeev[0].setImagePaths(kRELATIVE_IMAGE_PATHS);
   zeev[1].setImagePaths(kSOUL_IMAGE_PATHS);
   zeev[2].setImagePaths(kBLUES_PATHS);
}
/*------------------------------------------------------------------------------

@name       getMediaPlayer - get media player
                                                                              */
                                                                             /**
            Get media player instance.

@return     media player instance.

@history    Sun Nov 27, 2011 08:46:23 (LBM) created.

@notes
                                                                              */
//------------------------------------------------------------------------------
public GvIMediaPlayer getMediaPlayer()
{
   if (mediaPlayer == null)
   {
      mediaPlayer = new GvVLCMediaPlayer();
   }
   
   return(mediaPlayer);
}
/*------------------------------------------------------------------------------

@name       main - project main routine
                                                                              */
                                                                             /**
            Project main routine

@return     void.

@param      args  command line arguments

@history    Sun Nov 27, 2011 08:46:23 (LBM) created.

@notes
                                                                              */
//------------------------------------------------------------------------------
public static void main(
   String   args[])
{
   try
   {
      System.out.println(
         "Java VM running " + System.getProperty("java.version") 
            + ", " + System.getProperty("os.arch") +  ", " 
            + System.getProperty("sun.arch.data.model") + " bit");
      
      PjInternetRadio myRadio = new PjInternetRadio();
      myRadio.buildGUI();

      String[] mediaPaths =
      {
         "http://198.178.123.5:7386/;stream/1",//Arab Radio Test
         "http://stream1.evasionfm.com/Chante_France",//chante-france
      };

      if (true)
      {
         GvIMediaPlayer player = myRadio.getMediaPlayer();
                                       // start the player                    //
         int pathIdx = Integer.parseInt(args[0]);
         player.setURI(mediaPaths[pathIdx]);
      }

      else
      {
                                       // multiple stations at once           //
         GvIMediaPlayer player1 = new GvVLCMediaPlayer();
         player1.setURI(mediaPaths[0]);

         com.pumaj.PjUtils.sleep(5000);

         GvIMediaPlayer player2 = new GvVLCMediaPlayer();
         player2.setURI(mediaPaths[1]);
      }
   }
   catch(Exception e)
   {
      e.printStackTrace();
   }
}
}//====================================// end PjInternetRadio ----------------//
