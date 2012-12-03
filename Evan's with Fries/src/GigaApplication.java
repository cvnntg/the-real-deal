import javax.swing.SwingUtilities;

import app.MultimediaApp;
import app.MultimediaApplication;


public class GigaApplication extends MultimediaApplication {
	public static void main(String []args) throws Exception
    {
        SwingUtilities.invokeAndWait(
           new GigaApplication(args, 600, 400));

     }




     public GigaApplication(String[] args, int width, int height)
     {
        super(args, new GigaApp(), width, height);
     }


}
