package san.zgyi.uni;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//This library is developed by U San Ko Ko.
//Please Credit me.
//ph: 09250052301
//San Software Development Training

public class SanZtoU {
 Activity ac;
 private int syth =0;
	public SanZtoU(Activity ac) {
	super();
	this.ac = ac;
}

	public void showFontChooser(Class clazz)
	{
		if(clazz==null) {
			ac.getApplicationContext().startActivity(new Intent(ac.getApplicationContext(), MessageView.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
		} else {
			ac.getApplicationContext().startActivity(new Intent(ac.getApplicationContext(), clazz).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
		}
	}
	
	public void autoTextFace(String data, View view){
		
		if(view instanceof TextView)
		{
			showTextofTextView(data,(TextView)view);
		} else if(view instanceof Button)
		{
			showTextofTextView(data,(Button)view);
		} 
	}
	
	public void autoTextFaceToNavigationView(Menu menu){
		getShareSYTH();
		
		for(int i=0;i<menu.size();i++)
        {
            MenuItem menuItem = menu.getItem(i);
            SubMenu subMenu = menuItem.getSubMenu();
            if(subMenu!=null && subMenu.size()>0)
            {
                for(int ii=0; ii<subMenu.size();ii++)
                {
                    MenuItem subMenuItem = subMenu.getItem(ii);
                    applyFontToMenuItem(subMenuItem);
                }
            }
            applyFontToMenuItem(menuItem);
        }
	}
	
	private void applyFontToMenuItem(MenuItem subMenuItem) {
		// TODO Auto-generated method stub
		String s = subMenuItem.getTitle().toString();
		
		
		switch (syth) {
		case 1:
			if(FontUtili.defaultFont==2)
			{
				
				s = (String) ZawGyiToUni(s, false);
				setStringTypeFace(s,FontUtili.font(ac, 1), subMenuItem);
			} else {
				setStringTypeFace(s,FontUtili.font(ac, 1), subMenuItem);
			}
			break;
			
		case 2:
			if(FontUtili.defaultFont==1)
			{
				
				s =(String) ZawGyiToUni(s, true);
				setStringTypeFace(s,FontUtili.font(ac, 2), subMenuItem);
			} else {
				
				setStringTypeFace(s,FontUtili.font(ac, 2), subMenuItem);
			}
			break;

		case 3:
			if(FontUtili.defaultFont ==1)
			{
				s = (String) XtremeZawGyi(s, true);
				
			} else {
				s = (String) XtremeUni(s, true);
			}
			setStringTypeFace(s, FontUtili.font(ac,3), subMenuItem);
			break;
			
		
		}
	}

	private void setStringTypeFace(String s, Typeface font,MenuItem menuItem) {
		// TODO Auto-generated method stub
		SpannableString mNewTitle = new SpannableString(s);
        mNewTitle.setSpan(new CustomTypefaceSpan("", font), 0, mNewTitle.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        menuItem.setTitle(mNewTitle);
	}

	private void showTextofTextView(String data, TextView textView) {

		getShareSYTH();
		
		switch (syth) {
		case 1:
			if(FontUtili.defaultFont==2)
			{
				
				textView.setText(ZawGyiToUni(data, false));
				
				textView.setTypeface(FontUtili.font(ac,1));
			} else {
				textView.setText(data);
				textView.setTypeface(FontUtili.font(ac,1));
			}
			break;
			
		case 2:
			if(FontUtili.defaultFont==1)
			{
				
				textView.setText(ZawGyiToUni(data, true));
				
				textView.setTypeface(FontUtili.font(ac,2));
			} else {
				
				textView.setText(data);
				textView.setTypeface(FontUtili.font(ac,2));
			}
			break;

		case 3:
			if(FontUtili.defaultFont ==1)
			{
				textView.setText(XtremeZawGyi(data, true));
			} else {
				textView.setText(XtremeUni(data, true));
			}
			
			textView.setTypeface(FontUtili.font(ac,3));
			break;
			
		
		}
	}

	private void getShareSYTH() {
		@SuppressWarnings("static-access")
		SharedPreferences share = ac.getSharedPreferences("SanFontStyleLib",ac.MODE_PRIVATE);
		
		if(share.contains("sfont"))
		{
			syth = share.getInt("sfont", 1);
		} else {
			showFontChooser(null);
		}
		
	}

	public CharSequence ZawGyiToUni(String myString1, Boolean unicode) {
		// TODO Auto-generated method stub
		 String uni = "["
	                + " {\"from\": \"(\u103D|\u1087)\",\"to\":\"\u103E\"},"
	                + " {\"from\": \"\u103C\",\"to\":\"\u103D\"},"
	                + " {\"from\": \"(\u103B|\u107E|\u107F|\u1080|\u1081|\u1082|\u1083|\u1084)\",\"to\":\"\u103C\"},"
	                + " {\"from\": \"(\u103A|\u107D)\",\"to\":\"\u103B\"},"
	                + " {\"from\": \"\u1039\",\"to\":\"\u103A\"},"
	                + " {\"from\": \"\u106A\",\"to\":\"\u1009\"},"
	                + " {\"from\": \"\u106B\",\"to\":\"\u100A\"},"
	                + " {\"from\": \"\u106C\",\"to\":\"\u1039\u100B\"},"
	                + " {\"from\": \"\u106D\",\"to\":\"\u1039\u100C\"},"
	                + " {\"from\": \"\u106E\",\"to\":\"\u100D\u1039\u100D\"},"
	                + " {\"from\": \"\u106F\",\"to\":\"\u100D\u1039\u100E\"},"
	                + " {\"from\": \"\u1070\",\"to\":\"\u1039\u100F\"},"
	                + " {\"from\": \"(\u1071|\u1072)\",\"to\":\"\u1039\u1010\"},"
	                + " {\"from\": \"\u1060\",\"to\":\"\u1039\u1000\"},"
	                + " {\"from\": \"\u1061\",\"to\":\"\u1039\u1001\"},"
	                + " {\"from\": \"\u1062\",\"to\":\"\u1039\u1002\"},"
	                + " {\"from\": \"\u1063\",\"to\":\"\u1039\u1003\"},"
	                + " {\"from\": \"\u1065\",\"to\":\"\u1039\u1005\"},"
	                + " {\"from\": \"\u1068\",\"to\":\"\u1039\u1007\"},"
	                + " {\"from\": \"\u1069\",\"to\":\"\u1039\u1008\"},"
	                + " {\"from\": \"/(\u1073|\u1074)/g\",\"to\":\"\u1039\u1011\"},"
	                + " {\"from\": \"\u1075\",\"to\":\"\u1039\u1012\"},"
	                + " {\"from\": \"\u1076\",\"to\":\"\u1039\u1013\"},"
	                + " {\"from\": \"\u1077\",\"to\":\"\u1039\u1014\"},"
	                + " {\"from\": \"\u1078\",\"to\":\"\u1039\u1015\"},"
	                + " {\"from\": \"\u1079\",\"to\":\"\u1039\u1016\"},"
	                + " {\"from\": \"\u107A\",\"to\":\"\u1039\u1017\"},"
	                + " {\"from\": \"\u107C\",\"to\":\"\u1039\u1019\"},"
	                + " {\"from\": \"\u1085\",\"to\":\"\u1039\u101C\"},"
	                + " {\"from\": \"\u1033\",\"to\":\"\u102F\"},"
	                + " {\"from\": \"\u1034\",\"to\":\"\u1030\"},"
	                + " {\"from\": \"\u103F\",\"to\":\"\u1030\"},"
	                + " {\"from\": \"\u1086\",\"to\":\"\u103F\"},"
	                + " {\"from\": \"\u1088\",\"to\":\"\u103E\u102F\"},"
	                + " {\"from\": \"\u1089\",\"to\":\"\u103E\u1030\"},"
	                + " {\"from\": \"\u108A\",\"to\":\"\u103D\u103E\"},"
	                + " {\"from\": \"([\u1000-\u1021])\u1064\",\"to\":\"\u1004\u103A\u1039$1\"},"
	                + " {\"from\": \"([\u1000-\u1021])\u108B\",\"to\":\"\u1004\u103A\u1039$1\u102D\"},"
	                + " {\"from\": \"([\u1000-\u1021])\u108C\",\"to\":\"\u1004\u103A\u1039$1\u102E\"},"
	                + " {\"from\": \"([\u1000-\u1021])\u108D\",\"to\":\"\u1004\u103A\u1039$1\u1036\"},"
	                + " {\"from\": \"\u108E\",\"to\":\"\u102D\u1036\"},"
	                + " {\"from\": \"\u108F\",\"to\":\"\u1014\"},"
	                + " {\"from\": \"\u1090\",\"to\":\"\u101B\"},"
	                + " {\"from\": \"\u1091\",\"to\":\"\u100F\u1039\u1091\"},"
	                + " {\"from\": \"\u1019\u102C(\u107B|\u1093)\",\"to\":\"\u1019\u1039\u1018\u102C\"},"
	                + " {\"from\": \"(\u107B|\u1093)\",\"to\":\"\u103A\u1018\"},"
	                + " {\"from\": \"(\u1094|\u1095)\",\"to\":\"\u1037\"},"
	                + " {\"from\": \"\u1096\",\"to\":\"\u1039\u1010\u103D\"},"
	                + " {\"from\": \"\u1097\",\"to\":\"\u100B\u1039\u100B\"},"
	                + " {\"from\": \"\u103C([\u1000-\u1021])([\u1000-\u1021])?\",\"to\":\"$1\u103C$2\"},"
	                + " {\"from\": \"([\u1000-\u1021])\u103C\u103A\",\"to\":\"\u103C$1\u103A\"},"
	                + " {\"from\": \"\u1031([\u1000-\u1021])(\u103E)?(\u103B)?\",\"to\":\"$1$2$3\u1031\"},"
	                + " {\"from\": \"([\u1000-\u1021])\u1031(\u103B|\u103C|\u103D)\",\"to\":\"$1$2\u1031\"},"
	                + " {\"from\": \"\u1032\u103D\",\"to\":\"\u103D\u1032\"},"
	                + " {\"from\": \"\u103D\u103B\",\"to\":\"\u103B\u103D\"},"
	                + " {\"from\": \"\u103A\u1037\",\"to\":\"\u1037\u103A\"},"
	                + " {\"from\": \"\u102F(\u102D|\u102E|\u1036|\u1037)\u102F\",\"to\":\"\u102F$1\"},"
	                + " {\"from\": \"\u102F\u102F\",\"to\":\"\u102F\"},"
	                + " {\"from\": \"(\u102F|\u1030)(\u102D|\u102E)\",\"to\":\"$2$1\"},"
	                + " {\"from\": \"(\u103E)(\u103B|\u1037)\",\"to\":\"$2$1\"},"
	                + " {\"from\": \"\u1025(\u103A|\u102C)\",\"to\":\"\u1009$1\"},"
	                + " {\"from\": \"\u1025\u102E\",\"to\":\"\u1026\"},"
	                + " {\"from\": \"\u1005\u103B\",\"to\":\"\u1008\"},"
	                + " {\"from\": \"\u1036(\u102F|\u1030)\",\"to\":\"$1\u1036\"},"
	                + " {\"from\": \"\u1031\u1037\u103E\",\"to\":\"\u103E\u1031\u1037\"},"
	                + " {\"from\": \"\u1031\u103E\u102C\",\"to\":\"\u103E\u1031\u102C\"},"
	                + " {\"from\": \"\u105A\",\"to\":\"\u102B\u103A\"},"
	                + " {\"from\": \"\u1031\u103B\u103E\",\"to\":\"\u103B\u103E\u1031\"},"
	                + " {\"from\": \"(\u102D|\u102E)(\u103D|\u103E)\",\"to\":\"$2$1\"},"
	                + " {\"from\": \"\u102C\u1039([\u1000-\u1021])\",\"to\":\"\u1039$1\u102C\"},"
	                + " {\"from\": \"\u103C\u1004\u103A\u1039([\u1000-\u1021])\",\"to\":\"\u1004\u103A\u1039$1\u103C\"},"
	                + " {\"from\": \"\u1039\u103C\u103A\u1039([\u1000-\u1021])\",\"to\":\"\u103A\u1039$1\u103C\"},"
	                + " {\"from\": \"\u103C\u1039([\u1000-\u1021])\",\"to\":\"\u1039$1\u103C\"},"
	                + " {\"from\": \"\u1036\u1039([\u1000-\u1021])\",\"to\":\"\u1039$1\u1036\"},"
	                + " {\"from\": \"\u1092\",\"to\":\"\u100B\u1039\u100C\"},"
	                + " {\"from\": \"\u104E\",\"to\":\"\u104E\u1004\u103A\u1038\"},"
	                + " {\"from\": \"\u1040(\u102B|\u102C|\u1036)\",\"to\":\"\u101D$1\"},"
	                + " {\"from\": \"\u1025\u1039\",\"to\":\"\u1009\u1039\"}" + "]";
		 
		 String zawgyi = "[ { \"from\": \"င်္\", \"to\": \"ၤ\" }, { \"from\": \"္တွ\", \"to\": \"႖\" }, { \"from\": \"န(?=[ူွှု္])\", \"to\": \"ႏ\" }, { \"from\": \"ါ်\", \"to\": \"ၚ\" }, { \"from\": \"ဋ္ဌ\", \"to\": \"႒\" }, { \"from\": \"ိံ\", \"to\": \"ႎ\" }, { \"from\": \"၎င်း\", \"to\": \"၎\" }, { \"from\": \"[ဥဉ](?=[္ုူ])\", \"to\": \"ၪ\" }, { \"from\": \"[ဥဉ](?=[်])\", \"to\": \"ဥ\" }, { \"from\": \"ည(?=[္ုူွ])\", \"to\": \"ၫ\" }, { \"from\": \"(္[က-အ])ု\", \"to\": \"$1ဳ\" }, { \"from\": \"(္[က-အ])ူ\", \"to\": \"$1ဴ\" }, { \"from\": \"္က\", \"to\": \"ၠ\" }, { \"from\": \"္ခ\", \"to\": \"ၡ\" }, { \"from\": \"္ဂ\", \"to\": \"ၢ\" }, { \"from\": \"္ဃ\", \"to\": \"ၣ\" }, { \"from\": \"္စ\", \"to\": \"ၥ\" }, { \"from\": \"္ဆ\", \"to\": \"ၦ\" }, { \"from\": \"္ဇ\", \"to\": \"ၨ\" }, { \"from\": \"္ဈ\", \"to\": \"ၩ\" }, { \"from\": \"ည(?=[္ုူ])\", \"to\": \"ၫ\" }, { \"from\": \"္ဋ\", \"to\": \"ၬ\" }, { \"from\": \"္ဌ\", \"to\": \"ၭ\" }, { \"from\": \"ဍ္ဍ\", \"to\": \"ၮ\" }, { \"from\": \"ဎ္ဍ\", \"to\": \"ၯ\" }, { \"from\": \"္ဏ\", \"to\": \"ၰ\" }, { \"from\": \"္တ\", \"to\": \"ၱ\" }, { \"from\": \"္ထ\", \"to\": \"ၳ\" }, { \"from\": \"္ဒ\", \"to\": \"ၵ\" }, { \"from\": \"္ဓ\", \"to\": \"ၶ\" }, { \"from\": \"္ဓ\", \"to\": \"ၶ\" }, { \"from\": \"္န\", \"to\": \"ၷ\" }, { \"from\": \"္ပ\", \"to\": \"ၸ\" }, { \"from\": \"္ဖ\", \"to\": \"ၹ\" }, { \"from\": \"္ဗ\", \"to\": \"ၺ\" }, { \"from\": \"္ဘ\", \"to\": \"ၻ\" }, { \"from\": \"္မ\", \"to\": \"ၼ\" }, { \"from\": \"္လ\", \"to\": \"ႅ\" }, { \"from\": \"ဿ\", \"to\": \"ႆ\" }, { \"from\": \"(ြ)ှ\", \"to\": \"$1ႇ\" }, { \"from\": \"ွှ\", \"to\": \"ႊ\" }, { \"from\": \"(ၤ)([ေ]?)([ြ]?)([က-အ])ိ\", \"to\": \"$2$3$4ႋ\" }, { \"from\": \"(ၤ)([ေ]?)([ြ]?)([က-အ])ီ\", \"to\": \"$2$3$4ႌ\" }, { \"from\": \"(ၤ)([ေ]?)([ြ]?)([က-အ])ံ\", \"to\": \"$2$3$4ႍ\" }, { \"from\": \"(ၤ)([ေ]?)([ြ]?)([က-အ])\", \"to\": \"$2$3$4$1\" }, { \"from\": \"ရ(?=[ုူွႊ])\", \"to\": \"႐\" }, { \"from\": \"ဏ္ဍ\", \"to\": \"႑\" }, { \"from\": \"ဋ္ဋ\", \"to\": \"႗\" }, { \"from\": \"([က-အႏဩ႐])([ၠ-ၩၬၭၰ-ၼႅႊ])?([ျ-ှ]*)?ေ\", \"to\": \"ေ$1$2$3\" }, { \"from\": \"([က-အဩ])([ၠ-ၩၬၭၰ-ၼႅ])?(ြ)\", \"to\": \"$3$1$2\" }, { \"from\": \"်\", \"to\": \"္\" }, { \"from\": \"ျ\", \"to\": \"်\" }, { \"from\": \"ြ\", \"to\": \"ျ\" }, { \"from\": \"ွ\", \"to\": \"ြ\" }, { \"from\": \"ှ\", \"to\": \"ွ\" }, { \"from\": \"ွု\", \"to\": \"ႈ\" }, { \"from\": \"([ုူနရြႊွႈ])([ဲံ]{0,1})့\", \"to\": \"$1$2႕\" }, { \"from\": \"ု႕\", \"to\": \"ု႔\" }, { \"from\": \"([နရ])([ဲံိီႋႌႍႎ])့\", \"to\": \"$1$2႕\" }, { \"from\": \"႕္\", \"to\": \"႔္\" }, { \"from\": \"([်ျ])([က-အ])([ံိီႋႌႍႎ]?)ု\", \"to\": \"$1$2$3ဳ\" }, { \"from\": \"([်ျ])([က-အ])([ံိီႋႌႍႎ]?)ူ\", \"to\": \"$1$2$3ဴ\" }, { \"from\": \"်ု\", \"to\": \"်ဳ\" }, { \"from\": \"်([ံိီႋႌႍႎ])ု\", \"to\": \"်$1ဳ\" }, { \"from\": \"([်ျ])([က-အ])ူ\", \"to\": \"$1$2ဴ\" }, { \"from\": \"်ူ\", \"to\": \"်ဴ\" }, { \"from\": \"်([ံိီႋႌႍႎ])ူ\", \"to\": \"်$1ဴ\" }, { \"from\": \"ွူ\", \"to\": \"ႉ\" }, { \"from\": \"ျ([ကဃဆဏတထဘယလယသဟ])\", \"to\": \"ၾ$1\" }, { \"from\": \"ၾ([ကဃဆဏတထဘယလယသဟ])([ြႊ])([ဲံိီႋႌႍႎ])\", \"to\": \"ႄ$1$2$3\" }, { \"from\": \"ၾ([ကဃဆဏတထဘယလယသဟ])([ြႊ])\", \"to\": \"ႂ$1$2\" }, { \"from\": \"ၾ([ကဃဆဏတထဘယလယသဟ])([ဳဴ]?)([ဲံိီႋႌႍႎ])\", \"to\": \"ႀ$1$2$3\" }, { \"from\": \"ျ([က-အ])([ြႊ])([ဲံိီႋႌႍႎ])\", \"to\": \"ႃ$1$2$3\" }, { \"from\": \"ျ([က-အ])([ြႊ])\", \"to\": \"ႁ$1$2\" }, { \"from\": \"ျ([က-အ])([ဳဴ]?)([ဲံိီႋႌႍႎ])\", \"to\": \"ၿ$1$2$3\" }, { \"from\": \"်ွ\", \"to\": \"ွ်\" }, { \"from\": \"်([ြႊ])\", \"to\": \"$1ၽ\" }, { \"from\": \"([ဳဴ])႔\", \"to\": \"$1႕\" }, {  \"from\": \"ႏၱ\",  \"to\" : \"ႏၲ\" }, {  \"from\": \"([က-အ])([ၻၦ])ာ\",  \"to\": \"$1ာ$2\" }, {  \"from\": \"ာ([ၻၦ])့\",  \"to\": \"ာ$1႔\" }]";
		 
		 if(unicode==true) {
		return replacewithUni(uni, myString1);
		 } else {
			 return replacewithZawgyi(zawgyi, myString1);
		 }
	}
	
	public CharSequence XtremeZawGyi(String myString1,Boolean Zawgyi) {
        // TODO Auto-generated method stub
		
        String uni = "["
                +	" {\"from\": \"	\u1000	\",\"to\":\"	\u1E00\"},"
                +	" {\"from\": \"	\u1001	\",\"to\":\"	\u1E01	\"},"
                +	" {\"from\": \"	\u1002	\",\"to\":\"	\u1E02	\"},"
                +	" {\"from\": \"	\u1003	\",\"to\":\"	\u1E03	\"},"
                +	" {\"from\": \"	\u1004	\",\"to\":\"	\u1E04	\"},"
                +	" {\"from\": \"	\u1005	\",\"to\":\"	\u1E05	\"},"
                +	" {\"from\": \"	\u1006	\",\"to\":\"	\u1E06	\"},"
                +	" {\"from\": \"	\u1007	\",\"to\":\"	\u1E07	\"},"
                +	" {\"from\": \"	\u1008	\",\"to\":\"	\u1E08	\"},"
                +	" {\"from\": \"	\u1009	\",\"to\":\"	\u1E09	\"},"
                +	" {\"from\": \"	\u100A	\",\"to\":\"	\u1E0A	\"},"
                +	" {\"from\": \"	\u100B	\",\"to\":\"	\u1E0B	\"},"
                +	" {\"from\": \"	\u100C	\",\"to\":\"	\u1E0C	\"},"
                +	" {\"from\": \"	\u100D	\",\"to\":\"	\u1E0D	\"},"
                +	" {\"from\": \"	\u100E	\",\"to\":\"	\u1E0E	\"},"
                +	" {\"from\": \"	\u100F	\",\"to\":\"	\u1E0F	\"},"
                +	" {\"from\": \"	\u1010	\",\"to\":\"	\u1E10	\"},"
                +	" {\"from\": \"	\u1011	\",\"to\":\"	\u1E11	\"},"
                +	" {\"from\": \"	\u1012	\",\"to\":\"	\u1E12	\"},"
                +	" {\"from\": \"	\u1013	\",\"to\":\"	\u1E13	\"},"
                +	" {\"from\": \"	\u1014	\",\"to\":\"	\u1E14	\"},"
                +	" {\"from\": \"	\u1015	\",\"to\":\"	\u1E15	\"},"
                +	" {\"from\": \"	\u1016	\",\"to\":\"	\u1E16	\"},"
                +	" {\"from\": \"	\u1017	\",\"to\":\"	\u1E17	\"},"
                +	" {\"from\": \"	\u1018	\",\"to\":\"	\u1E18	\"},"
                +	" {\"from\": \"	\u1019	\",\"to\":\"	\u1E19	\"},"
                +	" {\"from\": \"	\u101A	\",\"to\":\"	\u1E1A	\"},"
                +	" {\"from\": \"	\u101B	\",\"to\":\"	\u1E1B	\"},"
                +	" {\"from\": \"	\u101C	\",\"to\":\"	\u1E1C	\"},"
                +	" {\"from\": \"	\u101D	\",\"to\":\"	\u1E1D	\"},"
                +	" {\"from\": \"	\u101E	\",\"to\":\"	\u1E1E	\"},"
                +	" {\"from\": \"	\u101F	\",\"to\":\"	\u1E1F	\"},"
                +	" {\"from\": \"	\u1020	\",\"to\":\"	\u1E20	\"},"
                +	" {\"from\": \"	\u1021	\",\"to\":\"	\u1E21	\"},"
                +	" {\"from\": \"	\u1023	\",\"to\":\"	\u1E22	\"},"
                +	" {\"from\": \"	\u1024	\",\"to\":\"	\u1E23	\"},"
                +	" {\"from\": \"	\u1025	\",\"to\":\"	\u1E24	\"},"
                +	" {\"from\": \"	\u1026	\",\"to\":\"	\u1E25	\"},"
                +	" {\"from\": \"	\u1027	\",\"to\":\"	\u1E26	\"},"
                +	" {\"from\": \"	\u1029	\",\"to\":\"	\u1E27	\"},"
                +	" {\"from\": \"	\u102A	\",\"to\":\"	\u1E28	\"},"
                +	" {\"from\": \"	\u102B	\",\"to\":\"	\u1E29	\"},"
                +	" {\"from\": \"	\u102C	\",\"to\":\"	\u1E2A	\"},"
                +	" {\"from\": \"	\u102D	\",\"to\":\"	\u1E2B	\"},"
                +	" {\"from\": \"	\u102E	\",\"to\":\"	\u1E2C	\"},"
                +	" {\"from\": \"	\u102F	\",\"to\":\"	\u1E2D	\"},"
                +	" {\"from\": \"	\u1030	\",\"to\":\"	\u1E2E	\"},"
                +	" {\"from\": \"	\u1031	\",\"to\":\"	\u1E2F	\"},"
                +	" {\"from\": \"	\u1032	\",\"to\":\"	\u1E30	\"},"
                +	" {\"from\": \"	\u1033	\",\"to\":\"	\u1E31	\"},"
                +	" {\"from\": \"	\u1034	\",\"to\":\"	\u1E32	\"},"
                +	" {\"from\": \"	\u1036	\",\"to\":\"	\u1E33	\"},"
                +	" {\"from\": \"	\u1037	\",\"to\":\"	\u1E34	\"},"
                +	" {\"from\": \"	\u1038	\",\"to\":\"	\u1E35	\"},"
                +	" {\"from\": \"	\u1039	\",\"to\":\"	\u1E36	\"},"
                +	" {\"from\": \"	\u103A	\",\"to\":\"	\u1E37	\"},"
                +	" {\"from\": \"	\u103B	\",\"to\":\"	\u1E38	\"},"
                +	" {\"from\": \"	\u103C	\",\"to\":\"	\u1E39	\"},"
                +	" {\"from\": \"	\u103D	\",\"to\":\"	\u1E3A	\"},"
                +	" {\"from\": \"	\u1040	\",\"to\":\"	\u1E3B	\"},"
                +	" {\"from\": \"	\u1041	\",\"to\":\"	\u1E3C	\"},"
                +	" {\"from\": \"	\u1042	\",\"to\":\"	\u1E3D	\"},"
                +	" {\"from\": \"	\u1043	\",\"to\":\"	\u1E3E	\"},"
                +	" {\"from\": \"	\u1044	\",\"to\":\"	\u1E3F	\"},"
                +	" {\"from\": \"	\u1045	\",\"to\":\"	\u1E40	\"},"
                +	" {\"from\": \"	\u1046	\",\"to\":\"	\u1E41	\"},"
                +	" {\"from\": \"	\u1047	\",\"to\":\"	\u1E42	\"},"
                +	" {\"from\": \"	\u1048	\",\"to\":\"	\u1E43	\"},"
                +	" {\"from\": \"	\u1049	\",\"to\":\"	\u1E44	\"},"
                +	" {\"from\": \"	\u104A	\",\"to\":\"	\u1E45	\"},"
                +	" {\"from\": \"	\u104B	\",\"to\":\"	\u1E46	\"},"
                +	" {\"from\": \"	\u104C	\",\"to\":\"	\u1E47	\"},"
                +	" {\"from\": \"	\u104D	\",\"to\":\"	\u1E48	\"},"
                +	" {\"from\": \"	\u104E	\",\"to\":\"	\u1E49	\"},"
                +	" {\"from\": \"	\u104F	\",\"to\":\"	\u1E4A	\"},"
                +	" {\"from\": \"	\u105A	\",\"to\":\"	\u1E4B	\"},"
                +	" {\"from\": \"	\u1060	\",\"to\":\"	\u1E4C	\"},"
                +	" {\"from\": \"	\u1061	\",\"to\":\"	\u1E4D	\"},"
                +	" {\"from\": \"	\u1062	\",\"to\":\"	\u1E4E	\"},"
                +	" {\"from\": \"	\u1063	\",\"to\":\"	\u1E4F	\"},"
                +	" {\"from\": \"	\u1064	\",\"to\":\"	\u1E50	\"},"
                +	" {\"from\": \"	\u1065	\",\"to\":\"	\u1E51	\"},"
                +	" {\"from\": \"	\u1066	\",\"to\":\"	\u1E52	\"},"
                +	" {\"from\": \"	\u1067	\",\"to\":\"	\u1E53	\"},"
                +	" {\"from\": \"	\u1068	\",\"to\":\"	\u1E54	\"},"
                +	" {\"from\": \"	\u1069	\",\"to\":\"	\u1E55	\"},"
                +	" {\"from\": \"	\u106A	\",\"to\":\"	\u1E56	\"},"
                +	" {\"from\": \"	\u106B	\",\"to\":\"	\u1E57	\"},"
                +	" {\"from\": \"	\u106C	\",\"to\":\"	\u1E58	\"},"
                +	" {\"from\": \"	\u106D	\",\"to\":\"	\u1E59	\"},"
                +	" {\"from\": \"	\u106E	\",\"to\":\"	\u1E5A	\"},"
                +	" {\"from\": \"	\u106F	\",\"to\":\"	\u1E5B	\"},"
                +	" {\"from\": \"	\u1070	\",\"to\":\"	\u1E5C	\"},"
                +	" {\"from\": \"	\u1071	\",\"to\":\"	\u1E5D	\"},"
                +	" {\"from\": \"	\u1072	\",\"to\":\"	\u1E5E	\"},"
                +	" {\"from\": \"	\u1073	\",\"to\":\"	\u1E5F	\"},"
                +	" {\"from\": \"	\u1074	\",\"to\":\"	\u1E60	\"},"
                +	" {\"from\": \"	\u1075	\",\"to\":\"	\u1E61	\"},"
                +	" {\"from\": \"	\u1076	\",\"to\":\"	\u1E62	\"},"
                +	" {\"from\": \"	\u1077	\",\"to\":\"	\u1E63	\"},"
                +	" {\"from\": \"	\u1078	\",\"to\":\"	\u1E64	\"},"
                +	" {\"from\": \"	\u1079	\",\"to\":\"	\u1E65	\"},"
                +	" {\"from\": \"	\u107A	\",\"to\":\"	\u1E66	\"},"
                +	" {\"from\": \"	\u107B	\",\"to\":\"	\u1E67	\"},"
                +	" {\"from\": \"	\u107C	\",\"to\":\"	\u1E68	\"},"
                +	" {\"from\": \"	\u107D	\",\"to\":\"	\u1E69	\"},"
                +	" {\"from\": \"	\u107E	\",\"to\":\"	\u1E6A	\"},"
                +	" {\"from\": \"	\u107F	\",\"to\":\"	\u1E6B	\"},"
                +	" {\"from\": \"	\u1080	\",\"to\":\"	\u1E6C	\"},"
                +	" {\"from\": \"	\u1081	\",\"to\":\"	\u1E6D	\"},"
                +	" {\"from\": \"	\u1082	\",\"to\":\"	\u1E6E	\"},"
                +	" {\"from\": \"	\u1083	\",\"to\":\"	\u1E6F	\"},"
                +	" {\"from\": \"	\u1084	\",\"to\":\"	\u1E70	\"},"
                +	" {\"from\": \"	\u1085	\",\"to\":\"	\u1E71	\"},"
                +	" {\"from\": \"	\u1086	\",\"to\":\"	\u1E72	\"},"
                +	" {\"from\": \"	\u1087	\",\"to\":\"	\u1E73	\"},"
                +	" {\"from\": \"	\u1088	\",\"to\":\"	\u1E74	\"},"
                +	" {\"from\": \"	\u1089	\",\"to\":\"	\u1E75	\"},"
                +	" {\"from\": \"	\u108A	\",\"to\":\"	\u1E76	\"},"
                +	" {\"from\": \"	\u108B	\",\"to\":\"	\u1E77	\"},"
                +	" {\"from\": \"	\u108C	\",\"to\":\"	\u1E78	\"},"
                +	" {\"from\": \"	\u108D	\",\"to\":\"	\u1E79	\"},"
                +	" {\"from\": \"	\u108E	\",\"to\":\"	\u1E7A	\"},"
                +	" {\"from\": \"	\u108F	\",\"to\":\"	\u1E7B	\"},"
                +	" {\"from\": \"	\u1090	\",\"to\":\"	\u1E7C	\"},"
                +	" {\"from\": \"	\u1091	\",\"to\":\"	\u1E7D	\"},"
                +	" {\"from\": \"	\u1092	\",\"to\":\"	\u1E7E	\"},"
                +	" {\"from\": \"	\u1094	\",\"to\":\"	\u1E7F	\"},"
                +	" {\"from\": \"	\u1095	\",\"to\":\"	\u1E80	\"},"
                +	" {\"from\": \"	\u1096	\",\"to\":\"	\u1E81	\"},"
                +	" {\"from\": \"	\u1097	\",\"to\":\"	\u1E82	\"}" + "]";
        if(!Zawgyi)
        {
        	String temp = (String) ZawGyiToUni(myString1, false);
        	return replacewithSan(uni, temp);
        }
        else {
        return replacewithSan(uni, myString1);
        }
    }

	public CharSequence XtremeUni(String myString1, Boolean Uni) {
        // TODO Auto-generated method stub
		
        String uni = "["
        		+	   " {\"from\": \"	\u1000		\",\"to\":\"	\u1EF5			\"},"
        		+	   " {\"from\": \"	\u1001		\",\"to\":\"	\u1EF6			\"},"
        		+	   " {\"from\": \"	\u1002		\",\"to\":\"	\u1EF7			\"},"
        		+	   " {\"from\": \"	\u1003		\",\"to\":\"	\u1EF8			\"},"
        		+	   " {\"from\": \"	\u1004		\",\"to\":\"	\u1EF9			\"},"
        		+	   " {\"from\": \"	\u1005		\",\"to\":\"	\u1F00			\"},"
        		+	   " {\"from\": \"	\u1006		\",\"to\":\"	\u1F01			\"},"
        		+	   " {\"from\": \"	\u1007		\",\"to\":\"	\u1F02			\"},"
        		+	   " {\"from\": \"	\u1008		\",\"to\":\"	\u1F03			\"},"
        		+	   " {\"from\": \"	\u1009		\",\"to\":\"	\u1F04			\"},"
        		+	   " {\"from\": \"	\u100A		\",\"to\":\"	\u1F05			\"},"
        		+	   " {\"from\": \"	\u100B		\",\"to\":\"	\u1F06			\"},"
        		+	   " {\"from\": \"	\u100C		\",\"to\":\"	\u1F07			\"},"
        		+	   " {\"from\": \"	\u100D		\",\"to\":\"	\u1F08			\"},"
        		+	   " {\"from\": \"	\u100E		\",\"to\":\"	\u1F09			\"},"
        		+	   " {\"from\": \"	\u100F		\",\"to\":\"	\u1F0A			\"},"
        		+	   " {\"from\": \"	\u1010		\",\"to\":\"	\u1F0B			\"},"
        		+	   " {\"from\": \"	\u1011		\",\"to\":\"	\u1F0C			\"},"
        		+	   " {\"from\": \"	\u1012		\",\"to\":\"	\u1F0D			\"},"
        		+	   " {\"from\": \"	\u1013		\",\"to\":\"	\u1F0E			\"},"
        		+	   " {\"from\": \"	\u1014		\",\"to\":\"	\u1F0F			\"},"
        		+	   " {\"from\": \"	\u1015		\",\"to\":\"	\u1F10			\"},"
        		+	   " {\"from\": \"	\u1016		\",\"to\":\"	\u1F11			\"},"
        		+	   " {\"from\": \"	\u1017		\",\"to\":\"	\u1F12			\"},"
        		+	   " {\"from\": \"	\u1018		\",\"to\":\"	\u1F13			\"},"
        		+	   " {\"from\": \"	\u1019		\",\"to\":\"	\u1F14			\"},"
        		+	   " {\"from\": \"	\u101A		\",\"to\":\"	\u1F15			\"},"
        		+	   " {\"from\": \"	\u101B		\",\"to\":\"	\u1F18			\"},"
        		+	   " {\"from\": \"	\u101C		\",\"to\":\"	\u1F19			\"},"
        		+	   " {\"from\": \"	\u101D		\",\"to\":\"	\u1F1A			\"},"
        		+	   " {\"from\": \"	\u101E		\",\"to\":\"	\u1F1B			\"},"
        		+	   " {\"from\": \"	\u101F		\",\"to\":\"	\u1F1C			\"},"
        		+	   " {\"from\": \"	\u1020		\",\"to\":\"	\u1F1D			\"},"
        		+	   " {\"from\": \"	\u1021		\",\"to\":\"	\u1F20			\"},"
        		+	   " {\"from\": \"	\u1023		\",\"to\":\"	\u1F21			\"},"
        		+	   " {\"from\": \"	\u1024		\",\"to\":\"	\u1F22			\"},"
        		+	   " {\"from\": \"	\u1025		\",\"to\":\"	\u1F23			\"},"
        		+	   " {\"from\": \"	\u1026		\",\"to\":\"	\u1F24			\"},"
        		+	   " {\"from\": \"	\u1027		\",\"to\":\"	\u1F25			\"},"
        		+	   " {\"from\": \"	\u1029		\",\"to\":\"	\u1F26			\"},"
        		+	   " {\"from\": \"	\u102A		\",\"to\":\"	\u1F27			\"},"
        		+	   " {\"from\": \"	\u102B		\",\"to\":\"	\u1EC0			\"},"
        		+	   " {\"from\": \"	\u102C		\",\"to\":\"	\u1EC1			\"},"
        		+	   " {\"from\": \"	\u102D		\",\"to\":\"	\u1EC2			\"},"
        		+	   " {\"from\": \"	\u102E		\",\"to\":\"	\u1EC3			\"},"
        		+	   " {\"from\": \"	\u102F		\",\"to\":\"	\u1EC4			\"},"
        		+	   " {\"from\": \"	\u1030		\",\"to\":\"	\u1EC5			\"},"
        		+	   " {\"from\": \"	\u1031		\",\"to\":\"	\u1EC6			\"},"
        		+	   " {\"from\": \"	\u1032		\",\"to\":\"	\u1EC7			\"},"
        		+	   " {\"from\": \"	\u1033		\",\"to\":\"	\u1EE5			\"},"
        		+	   " {\"from\": \"	\u1034		\",\"to\":\"	\u1EE6			\"},"
        		+	   " {\"from\": \"	\u1036		\",\"to\":\"	\u1EC8			\"},"
        		+	   " {\"from\": \"	\u1037		\",\"to\":\"	\u1EC9			\"},"
        		+	   " {\"from\": \"	\u1038		\",\"to\":\"	\u1ECA			\"},"
        		+	   " {\"from\": \"	\u1039		\",\"to\":\"	\u1ECB			\"},"
        		+	   " {\"from\": \"	\u103A		\",\"to\":\"	\u1ECC			\"},"
        		+	   " {\"from\": \"	(\u103B|\u103C)		\",\"to\":\"	\u1ED8			\"},"
        		+	   " {\"from\": \"	\u103B		\",\"to\":\"	\u1ED0			\"},"
        		+	   " {\"from\": \"	\u103C		\",\"to\":\"	\u1ECD			\"},"
        		+	   " {\"from\": \"	\u103D		\",\"to\":\"	\u1ECE			\"},"
        		+	   " {\"from\": \"	\u1040		\",\"to\":\"	\u1F29			\"},"
        		+	   " {\"from\": \"	\u1041		\",\"to\":\"	\u1F2A			\"},"
        		+	   " {\"from\": \"	\u1042		\",\"to\":\"	\u1F2B			\"},"
        		+	   " {\"from\": \"	\u1043		\",\"to\":\"	\u1F2C			\"},"
        		+	   " {\"from\": \"	\u1044		\",\"to\":\"	\u1F2D			\"},"
        		+	   " {\"from\": \"	\u1045		\",\"to\":\"	\u1F2E			\"},"
        		+	   " {\"from\": \"	\u1046		\",\"to\":\"	\u1F2F			\"},"
        		+	   " {\"from\": \"	\u1047		\",\"to\":\"	\u1F30			\"},"
        		+	   " {\"from\": \"	\u1048		\",\"to\":\"	\u1F31			\"},"
        		+	   " {\"from\": \"	\u1049		\",\"to\":\"	\u1F32			\"},"
        		+	   " {\"from\": \"	\u104A		\",\"to\":\"	\u1F33			\"},"
        		+	   " {\"from\": \"	\u104B		\",\"to\":\"	\u1F34			\"},"
        		+	   " {\"from\": \"	\u104C		\",\"to\":\"	\u1F35			\"},"
        		+	   " {\"from\": \"	\u104D		\",\"to\":\"	\u1F36			\"},"
        		+	   " {\"from\": \"	\u104E		\",\"to\":\"	(\u1F37|\u1EF9|\u1ECB)	\"},"
        		+	   " {\"from\": \"	\u104F		\",\"to\":\"	\u1F38			\"},"
        		+	   " {\"from\": \"	\u105A		\",\"to\":\"	\u1ECF			\"},"
        		+	   " {\"from\": \"	\u1060		\",\"to\":\"	\u1EA0			\"},"
        		+	   " {\"from\": \"	\u1061		\",\"to\":\"	\u1EA1			\"},"
        		+	   " {\"from\": \"	\u1062		\",\"to\":\"	\u1EA2			\"},"
        		+	   " {\"from\": \"	\u1063		\",\"to\":\"	\u1EA3			\"},"
        		+	   " {\"from\": \"	\u1064		\",\"to\":\"	\u1EDC			\"},"
        		+	   " {\"from\": \"	\u1065		\",\"to\":\"	\u1EA5			\"},"
        		+	   " {\"from\": \"	\u1066		\",\"to\":\"	\u1EA6			\"},"
        		+	   " {\"from\": \"	\u1067		\",\"to\":\"	\u1EA6			\"},"
        		+	   " {\"from\": \"	\u1068		\",\"to\":\"	\u1EA7			\"},"
        		+	   " {\"from\": \"	\u1069		\",\"to\":\"	\u1EA8			\"},"
        		+	   " {\"from\": \"	\u106A		\",\"to\":\"	\u1EE9			\"},"
        		+	   " {\"from\": \"	\u106B		\",\"to\":\"	\u1EE7			\"},"
        		+	   " {\"from\": \"	\u106C		\",\"to\":\"	\u1EAB			\"},"
        		+	   " {\"from\": \"	\u106D		\",\"to\":\"	\u1EAC			\"},"
        		+	   " {\"from\": \"	\u106E		\",\"to\":\"	\u1EF1			\"},"
        		+	   " {\"from\": \"	\u106F		\",\"to\":\"	\u1EEC			\"},"
        		+	   " {\"from\": \"	\u1070		\",\"to\":\"	\u1EAF			\"},"
        		+	   " {\"from\": \"	\u1071		\",\"to\":\"	\u1EB0			\"},"
        		+	   " {\"from\": \"	\u1072		\",\"to\":\"	\u1EB0			\"},"
        		+	   " {\"from\": \"	\u1073		\",\"to\":\"	\u1EB1			\"},"
        		+	   " {\"from\": \"	\u1074		\",\"to\":\"	\u1EB1			\"},"
        		+	   " {\"from\": \"	\u1075		\",\"to\":\"	\u1EB2			\"},"
        		+	   " {\"from\": \"	\u1076		\",\"to\":\"	\u1EB3			\"},"
        		+	   " {\"from\": \"	\u1077		\",\"to\":\"	\u1EB4			\"},"
        		+	   " {\"from\": \"	\u1078		\",\"to\":\"	\u1EB5			\"},"
        		+	   " {\"from\": \"	\u1079		\",\"to\":\"	\u1EB6			\"},"
        		+	   " {\"from\": \"	\u107A		\",\"to\":\"	\u1EB7			\"},"
        		+	   " {\"from\": \"	\u107B		\",\"to\":\"	\u1EB8			\"},"
        		+	   " {\"from\": \"	\u107C		\",\"to\":\"	\u1EB9			\"},"
        		+	   " {\"from\": \"	(\u107D|\u103C)\",\"to\":\"	\u1ED7			\"},"
        		+	   " {\"from\": \"	(\u107D|\u108A)\",\"to\":\"	\u1EDB			\"},"
        		+	   " {\"from\": \"	(\u103D|\u107D)\",\"to\":\"	\u1EDA			\"},"
        		+	   " {\"from\": \"	(\u107E|\u103C)		\",\"to\":\"	\u1ED9			\"},"
        		+	   " {\"from\": \"	\u107E		\",\"to\":\"	\u1ED1			\"},"
        		+	   " {\"from\": \"	\u107F		\",\"to\":\"	\u1ED2			\"},"
        		+	   " {\"from\": \"	\u1080		\",\"to\":\"	\u1ED3			\"},"
        		+	   " {\"from\": \"	\u1081		\",\"to\":\"	\u1ED4			\"},"
        		+	   " {\"from\": \"	\u1082		\",\"to\":\"	\u1ED5			\"},"
        		+	   " {\"from\": \"	(\u1083|\u103C)\",\"to\":\"	\u1ED8			\"},"
        		+	   " {\"from\": \"	(\u1083|\u108A)\",\"to\":\"	\u1EDC			\"},"
        		+	   " {\"from\": \"	(\u1084|\u103C)\",\"to\":\"	\u1ED9			\"},"
        		+	   " {\"from\": \"(\u1084|\u108A)	\",\"to\":\"	\u1EDD			\"},"
        		+	   " {\"from\": \"	\u1085		\",\"to\":\"	\u1EBC			\"},"
        		+	   " {\"from\": \"	\u1086		\",\"to\":\"	\u1F28			\"},"
        		+	   " {\"from\": \"	\u1087		\",\"to\":\"	\u1EE3			\"},"
        		+	   " {\"from\": \"	\u1088		\",\"to\":\"	\u1EE4			\"},"
        		+	   " {\"from\": \"	\u1089		\",\"to\":\"	(\u1ECE|\u1EE6)		\"},"
        		+	   " {\"from\": \"	\u108A		\",\"to\":\"	\u1ED6			\"},"
        		+	   " {\"from\": \"	\u108B		\",\"to\":\"	\u1EDF			\"},"
        		+	   " {\"from\": \"	\u108C		\",\"to\":\"	\u1EE0			\"},"
        		+	   " {\"from\": \"	\u108D		\",\"to\":\"	\u1EE1			\"},"
        		+	   " {\"from\": \"	\u108E		\",\"to\":\"	\u1EE2			\"},"
        		+	   " {\"from\": \"	\u108F		\",\"to\":\"	\u1EEA			\"},"
        		+	   " {\"from\": \"	\u1090		\",\"to\":\"	\u1EEB			\"},"
        		+	   " {\"from\": \"	\u1091		\",\"to\":\"	\u1EEE			\"},"
        		+	   " {\"from\": \"	\u1092		\",\"to\":\"	\u1EED			\"},"
        		+	   " {\"from\": \"	\u1094		\",\"to\":\"	\u1EF3			\"},"
        		+	   " {\"from\": \"	\u1095		\",\"to\":\"	\u1EF4			\"},"
        		+	   " {\"from\": \"	\u1097		\",\"to\":\"	\u1EF0			\"},"
+ "]";
        if(Uni) {
    		String temp = (String) ZawGyiToUni(myString1, false);
    		return replacewithXUi(uni, temp);
    		} else {
        return replacewithXUi(uni, myString1);
    		}
    }
	
	

    private CharSequence replacewithXUi(String Xuni, String myUi) {
		// TODO Auto-generated method stub
    	try {
            JSONArray rule_array = new JSONArray(Xuni);
            int max_loop = rule_array.length();
            myUi = myUi.replace("null", "\uFFFF\uFFFF");
            for (int i = 0; i < max_loop; i++) {
                JSONObject obj = rule_array.getJSONObject(i);
                String from = obj.getString("from");
                String to = obj.getString("to");
                myUi = myUi.replaceAll(from, to);
                myUi = myUi.replace("null", "");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    	myUi = myUi.replace("\uFFFF\uFFFF", "null");
        
        return myUi;
		
	}



	private CharSequence replacewithSan(String uni1, String myString2) {
        // TODO Auto-generated method stub
        try {
            JSONArray rule_array = new JSONArray(uni1);
            int max_loop = rule_array.length();
            myString2 = myString2.replace("null", "\uFFFF\uFFFF");
            for (int i = 0; i < max_loop; i++) {
                JSONObject obj = rule_array.getJSONObject(i);
                String from = obj.getString("from");
                String to = obj.getString("to");
                myString2 = myString2.replaceAll(from, to);
                myString2 = myString2.replace("null", "");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        myString2 = myString2.replace("\uFFFF\uFFFF", "null");
        return myString2;
    }
	
	
	
	private CharSequence replacewithZawgyi(String zawgyi, String myString1) {
		// TODO Auto-generated method stub
		try {
            JSONArray rule_array = new JSONArray(zawgyi);
            int max_loop = rule_array.length();
            
            myString1 = myString1.replace("null", "\uFFFF\uFFFF");
            for (int i = 0; i < max_loop; i++) {
                JSONObject obj = rule_array.getJSONObject(i);
                String from = obj.getString("from");
                String to = obj.getString("to");
                myString1 = myString1.replaceAll(from, to);
                myString1 = myString1.replace("null", "");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
		myString1 = myString1.replace("\uFFFF\uFFFF", "null");
        return myString1;
    
	}

	private CharSequence replacewithUni(String uni1, String myString2) {
		// TODO Auto-generated method stub
		try {
            JSONArray rule_array = new JSONArray(uni1);
            int max_loop = rule_array.length();

            myString2 = myString2.replace("null", "\uFFFF\uFFFF");
            for (int i = 0; i < max_loop; i++) {
                JSONObject obj = rule_array.getJSONObject(i);
                String from = obj.getString("from");
                String to = obj.getString("to");
                myString2 = myString2.replaceAll(from, to);
                myString2 = myString2.replace("null", "");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
		myString2 = myString2.replace("\uFFFF\uFFFF", "null");
        return myString2;
    }
	
	public void ForceToZawGyi(String Fontname,Boolean FromUni) {

        ViewGroup root = (ViewGroup)ac.getWindow().getDecorView().getRootView();
        overridezawgyi(ac.getApplicationContext(),root,Fontname,FromUni);
	}
	
	public void XtremlyForceToZawgyi(Boolean Zawgyi) {

        ViewGroup root = (ViewGroup)ac.getWindow().getDecorView().getRootView();
        overridezawgyiToSan(ac.getApplicationContext(),root,"san.ttf",Zawgyi);
	}
	
	public void XtremlyForceToUni(Boolean Uni) {

        ViewGroup root = (ViewGroup)ac.getWindow().getDecorView().getRootView();
        overridezawgyiToSanUNI(ac.getApplicationContext(),root,"san.ttf",Uni);
	}
	
	private void overridezawgyiToSanUNI(final Context con2, final View root,String fontname,Boolean Uni) {
		// TODO Auto-generated method stub
		  try {
	            if (root instanceof ViewGroup) {
	                ViewGroup vg = (ViewGroup) root;
	                for (int i = 0; i < vg.getChildCount(); i++) {
	                    View child = vg.getChildAt(i);
	                    overridezawgyiToSanUNI(con2, child,fontname,Uni);
	                }
	            } else if (root instanceof TextView) {
	                ((TextView) root).setTypeface(Typeface.createFromAsset(con2.getAssets(), fontname));
	                	 ((TextView) root).setText(XtremeUni(((TextView)root).getText().toString(), Uni));
	                
	            }
	            else if (root instanceof Button) {
	                ((Button) root).setTypeface(Typeface.createFromAsset(con2.getAssets(), fontname));
	                	 ((Button) root).setText(XtremeUni(((Button)root).getText().toString(), Uni));
	                
	            }  else if (root instanceof EditText) {
	                ((EditText) root).setTypeface(Typeface.createFromAsset(con2.getAssets(), fontname));
	                	 ((EditText) root).setText(XtremeUni(((EditText)root).getText().toString(), Uni));
	                	 ((EditText) root).setHint(XtremeUni(((EditText)root).getHint().toString(), Uni));
	                	 
	                	            }
	        } catch (Exception e) {
	        }
	}
	
	private void overridezawgyiToSan(final Context con2, final View root,String fontname,Boolean Zawgyi) {
		// TODO Auto-generated method stub
		  try {
	            if (root instanceof ViewGroup) {
	                ViewGroup vg = (ViewGroup) root;
	                for (int i = 0; i < vg.getChildCount(); i++) {
	                    View child = vg.getChildAt(i);
	                    overridezawgyiToSan(con2, child,fontname,Zawgyi);
	                }
	            } else if (root instanceof TextView) {
	                ((TextView) root).setTypeface(Typeface.createFromAsset(con2.getAssets(), fontname));
	                	 ((TextView) root).setText(XtremeZawGyi(((TextView)root).getText().toString(), Zawgyi));
	                
	            }
	            else if (root instanceof Button) {
	                ((Button) root).setTypeface(Typeface.createFromAsset(con2.getAssets(), fontname));
	                	 ((Button) root).setText(XtremeZawGyi(((Button)root).getText().toString(), Zawgyi));
	                
	            }  else if (root instanceof EditText) {
	                ((EditText) root).setTypeface(Typeface.createFromAsset(con2.getAssets(), fontname));
	                	 ((EditText) root).setText(XtremeZawGyi(((EditText)root).getText().toString(), Zawgyi));
	                	 ((EditText) root).setHint(XtremeZawGyi(((EditText)root).getHint().toString(), Zawgyi));
	                	 
	                	            }
	        } catch (Exception e) {
	        }
	}



	public void ForceToUni(String Fontname,Boolean FromZawgyi) {
		 ViewGroup root = (ViewGroup)ac.getWindow().getDecorView().getRootView();
	        overridezawgyi(ac.getApplicationContext(),root,Fontname,FromZawgyi);
	}
	private void overridezawgyi(final Context context, final View v,String Fontname, Boolean fromUni) {
        try {
            if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    overridezawgyi(context, child,Fontname, fromUni);
                }
            } else if (v instanceof TextView) {
                ((TextView) v).setTypeface(Typeface.createFromAsset(context.getAssets(), Fontname));
                if(fromUni==true)
                {
                	 ((TextView) v).setText(ZawGyiToUni(((TextView)v).getText().toString(), false));
                } else {
                	 ((TextView) v).setText(ZawGyiToUni(((TextView)v).getText().toString(), true));
                }
            }
            else if (v instanceof Button) {
                ((Button) v).setTypeface(Typeface.createFromAsset(context.getAssets(), Fontname));
                if(fromUni==true)
                {
                	 ((Button) v).setText(ZawGyiToUni(((Button)v).getText().toString(), false));
                } else {
                	 ((Button) v).setText(ZawGyiToUni(((Button)v).getText().toString(), true));
                }
            }  else if (v instanceof EditText) {
                ((EditText) v).setTypeface(Typeface.createFromAsset(context.getAssets(), Fontname));
                if(fromUni==true)
                {
                	 ((EditText) v).setText(ZawGyiToUni(((EditText)v).getText().toString(), false));
                	 ((EditText) v).setHint(ZawGyiToUni(((EditText)v).getHint().toString(), false));
                	 
                } else {
               	 ((EditText) v).setText(ZawGyiToUni(((EditText)v).getText().toString(), true));
            	 ((EditText) v).setHint(ZawGyiToUni(((EditText)v).getHint().toString(), true));
                }
            }
        } catch (Exception e) {
        }
    }



}
