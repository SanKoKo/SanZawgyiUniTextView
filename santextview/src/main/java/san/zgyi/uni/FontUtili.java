package san.zgyi.uni;

import android.content.Context;
import android.graphics.Typeface;

public class FontUtili {
	
protected static int defaultFont;
	public static Typeface font(Context context,int mstyle)
	{
		Typeface mfont = null;
		
		switch (mstyle) {
		case 1:
			mfont = Typeface.createFromAsset(context.getAssets(), "zg.TTF");
			break;
		case 2:
			mfont = Typeface.createFromAsset(context.getAssets(), "mm3.ttf");
			break;
		case 3:
			mfont = Typeface.createFromAsset(context.getAssets(), "san.ttf");
			break;
		}
		
		
		return mfont;
	}
}
