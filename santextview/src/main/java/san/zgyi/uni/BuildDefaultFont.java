package san.zgyi.uni;


public class BuildDefaultFont {

	
	public static void setProjectDefaultFont(DefaultFont defaultFont) {
		
		switch(defaultFont)
		{
		case ZAWGYI:
			FontUtili.defaultFont = 1;
			break;
			
		case UNICODE:
			FontUtili.defaultFont = 2;
			break;
		default:
			break;
		}
	}
}
