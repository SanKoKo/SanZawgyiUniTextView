package san.znu.textView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SanZawgyiTextView extends android.support.v7.widget.AppCompatTextView {


    public SanZawgyiTextView (Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "san.ttf");
        setTypeface(typeface);
    }

    public SanZawgyiTextView (Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SanZawgyiTextView (Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        text = XtremeZawGyi(text.toString());
        super.setText(text, type);
    }


    public CharSequence XtremeZawGyi(String myString1) {

        String uni = "["
                + " {\"from\": \"	\u1000	\",\"to\":\"	\u1E00\"},"
                + " {\"from\": \"	\u1001	\",\"to\":\"	\u1E01	\"},"
                + " {\"from\": \"	\u1002	\",\"to\":\"	\u1E02	\"},"
                + " {\"from\": \"	\u1003	\",\"to\":\"	\u1E03	\"},"
                + " {\"from\": \"	\u1004	\",\"to\":\"	\u1E04	\"},"
                + " {\"from\": \"	\u1005	\",\"to\":\"	\u1E05	\"},"
                + " {\"from\": \"	\u1006	\",\"to\":\"	\u1E06	\"},"
                + " {\"from\": \"	\u1007	\",\"to\":\"	\u1E07	\"},"
                + " {\"from\": \"	\u1008	\",\"to\":\"	\u1E08	\"},"
                + " {\"from\": \"	\u1009	\",\"to\":\"	\u1E09	\"},"
                + " {\"from\": \"	\u100A	\",\"to\":\"	\u1E0A	\"},"
                + " {\"from\": \"	\u100B	\",\"to\":\"	\u1E0B	\"},"
                + " {\"from\": \"	\u100C	\",\"to\":\"	\u1E0C	\"},"
                + " {\"from\": \"	\u100D	\",\"to\":\"	\u1E0D	\"},"
                + " {\"from\": \"	\u100E	\",\"to\":\"	\u1E0E	\"},"
                + " {\"from\": \"	\u100F	\",\"to\":\"	\u1E0F	\"},"
                + " {\"from\": \"	\u1010	\",\"to\":\"	\u1E10	\"},"
                + " {\"from\": \"	\u1011	\",\"to\":\"	\u1E11	\"},"
                + " {\"from\": \"	\u1012	\",\"to\":\"	\u1E12	\"},"
                + " {\"from\": \"	\u1013	\",\"to\":\"	\u1E13	\"},"
                + " {\"from\": \"	\u1014	\",\"to\":\"	\u1E14	\"},"
                + " {\"from\": \"	\u1015	\",\"to\":\"	\u1E15	\"},"
                + " {\"from\": \"	\u1016	\",\"to\":\"	\u1E16	\"},"
                + " {\"from\": \"	\u1017	\",\"to\":\"	\u1E17	\"},"
                + " {\"from\": \"	\u1018	\",\"to\":\"	\u1E18	\"},"
                + " {\"from\": \"	\u1019	\",\"to\":\"	\u1E19	\"},"
                + " {\"from\": \"	\u101A	\",\"to\":\"	\u1E1A	\"},"
                + " {\"from\": \"	\u101B	\",\"to\":\"	\u1E1B	\"},"
                + " {\"from\": \"	\u101C	\",\"to\":\"	\u1E1C	\"},"
                + " {\"from\": \"	\u101D	\",\"to\":\"	\u1E1D	\"},"
                + " {\"from\": \"	\u101E	\",\"to\":\"	\u1E1E	\"},"
                + " {\"from\": \"	\u101F	\",\"to\":\"	\u1E1F	\"},"
                + " {\"from\": \"	\u1020	\",\"to\":\"	\u1E20	\"},"
                + " {\"from\": \"	\u1021	\",\"to\":\"	\u1E21	\"},"
                + " {\"from\": \"	\u1023	\",\"to\":\"	\u1E22	\"},"
                + " {\"from\": \"	\u1024	\",\"to\":\"	\u1E23	\"},"
                + " {\"from\": \"	\u1025	\",\"to\":\"	\u1E24	\"},"
                + " {\"from\": \"	\u1026	\",\"to\":\"	\u1E25	\"},"
                + " {\"from\": \"	\u1027	\",\"to\":\"	\u1E26	\"},"
                + " {\"from\": \"	\u1029	\",\"to\":\"	\u1E27	\"},"
                + " {\"from\": \"	\u102A	\",\"to\":\"	\u1E28	\"},"
                + " {\"from\": \"	\u102B	\",\"to\":\"	\u1E29	\"},"
                + " {\"from\": \"	\u102C	\",\"to\":\"	\u1E2A	\"},"
                + " {\"from\": \"	\u102D	\",\"to\":\"	\u1E2B	\"},"
                + " {\"from\": \"	\u102E	\",\"to\":\"	\u1E2C	\"},"
                + " {\"from\": \"	\u102F	\",\"to\":\"	\u1E2D	\"},"
                + " {\"from\": \"	\u1030	\",\"to\":\"	\u1E2E	\"},"
                + " {\"from\": \"	\u1031	\",\"to\":\"	\u1E2F	\"},"
                + " {\"from\": \"	\u1032	\",\"to\":\"	\u1E30	\"},"
                + " {\"from\": \"	\u1033	\",\"to\":\"	\u1E31	\"},"
                + " {\"from\": \"	\u1034	\",\"to\":\"	\u1E32	\"},"
                + " {\"from\": \"	\u1036	\",\"to\":\"	\u1E33	\"},"
                + " {\"from\": \"	\u1037	\",\"to\":\"	\u1E34	\"},"
                + " {\"from\": \"	\u1038	\",\"to\":\"	\u1E35	\"},"
                + " {\"from\": \"	\u1039	\",\"to\":\"	\u1E36	\"},"
                + " {\"from\": \"	\u103A	\",\"to\":\"	\u1E37	\"},"
                + " {\"from\": \"	\u103B	\",\"to\":\"	\u1E38	\"},"
                + " {\"from\": \"	\u103C	\",\"to\":\"	\u1E39	\"},"
                + " {\"from\": \"	\u103D	\",\"to\":\"	\u1E3A	\"},"
                + " {\"from\": \"	\u1040	\",\"to\":\"	\u1E3B	\"},"
                + " {\"from\": \"	\u1041	\",\"to\":\"	\u1E3C	\"},"
                + " {\"from\": \"	\u1042	\",\"to\":\"	\u1E3D	\"},"
                + " {\"from\": \"	\u1043	\",\"to\":\"	\u1E3E	\"},"
                + " {\"from\": \"	\u1044	\",\"to\":\"	\u1E3F	\"},"
                + " {\"from\": \"	\u1045	\",\"to\":\"	\u1E40	\"},"
                + " {\"from\": \"	\u1046	\",\"to\":\"	\u1E41	\"},"
                + " {\"from\": \"	\u1047	\",\"to\":\"	\u1E42	\"},"
                + " {\"from\": \"	\u1048	\",\"to\":\"	\u1E43	\"},"
                + " {\"from\": \"	\u1049	\",\"to\":\"	\u1E44	\"},"
                + " {\"from\": \"	\u104A	\",\"to\":\"	\u1E45	\"},"
                + " {\"from\": \"	\u104B	\",\"to\":\"	\u1E46	\"},"
                + " {\"from\": \"	\u104C	\",\"to\":\"	\u1E47	\"},"
                + " {\"from\": \"	\u104D	\",\"to\":\"	\u1E48	\"},"
                + " {\"from\": \"	\u104E	\",\"to\":\"	\u1E49	\"},"
                + " {\"from\": \"	\u104F	\",\"to\":\"	\u1E4A	\"},"
                + " {\"from\": \"	\u105A	\",\"to\":\"	\u1E4B	\"},"
                + " {\"from\": \"	\u1060	\",\"to\":\"	\u1E4C	\"},"
                + " {\"from\": \"	\u1061	\",\"to\":\"	\u1E4D	\"},"
                + " {\"from\": \"	\u1062	\",\"to\":\"	\u1E4E	\"},"
                + " {\"from\": \"	\u1063	\",\"to\":\"	\u1E4F	\"},"
                + " {\"from\": \"	\u1064	\",\"to\":\"	\u1E50	\"},"
                + " {\"from\": \"	\u1065	\",\"to\":\"	\u1E51	\"},"
                + " {\"from\": \"	\u1066	\",\"to\":\"	\u1E52	\"},"
                + " {\"from\": \"	\u1067	\",\"to\":\"	\u1E53	\"},"
                + " {\"from\": \"	\u1068	\",\"to\":\"	\u1E54	\"},"
                + " {\"from\": \"	\u1069	\",\"to\":\"	\u1E55	\"},"
                + " {\"from\": \"	\u106A	\",\"to\":\"	\u1E56	\"},"
                + " {\"from\": \"	\u106B	\",\"to\":\"	\u1E57	\"},"
                + " {\"from\": \"	\u106C	\",\"to\":\"	\u1E58	\"},"
                + " {\"from\": \"	\u106D	\",\"to\":\"	\u1E59	\"},"
                + " {\"from\": \"	\u106E	\",\"to\":\"	\u1E5A	\"},"
                + " {\"from\": \"	\u106F	\",\"to\":\"	\u1E5B	\"},"
                + " {\"from\": \"	\u1070	\",\"to\":\"	\u1E5C	\"},"
                + " {\"from\": \"	\u1071	\",\"to\":\"	\u1E5D	\"},"
                + " {\"from\": \"	\u1072	\",\"to\":\"	\u1E5E	\"},"
                + " {\"from\": \"	\u1073	\",\"to\":\"	\u1E5F	\"},"
                + " {\"from\": \"	\u1074	\",\"to\":\"	\u1E60	\"},"
                + " {\"from\": \"	\u1075	\",\"to\":\"	\u1E61	\"},"
                + " {\"from\": \"	\u1076	\",\"to\":\"	\u1E62	\"},"
                + " {\"from\": \"	\u1077	\",\"to\":\"	\u1E63	\"},"
                + " {\"from\": \"	\u1078	\",\"to\":\"	\u1E64	\"},"
                + " {\"from\": \"	\u1079	\",\"to\":\"	\u1E65	\"},"
                + " {\"from\": \"	\u107A	\",\"to\":\"	\u1E66	\"},"
                + " {\"from\": \"	\u107B	\",\"to\":\"	\u1E67	\"},"
                + " {\"from\": \"	\u107C	\",\"to\":\"	\u1E68	\"},"
                + " {\"from\": \"	\u107D	\",\"to\":\"	\u1E69	\"},"
                + " {\"from\": \"	\u107E	\",\"to\":\"	\u1E6A	\"},"
                + " {\"from\": \"	\u107F	\",\"to\":\"	\u1E6B	\"},"
                + " {\"from\": \"	\u1080	\",\"to\":\"	\u1E6C	\"},"
                + " {\"from\": \"	\u1081	\",\"to\":\"	\u1E6D	\"},"
                + " {\"from\": \"	\u1082	\",\"to\":\"	\u1E6E	\"},"
                + " {\"from\": \"	\u1083	\",\"to\":\"	\u1E6F	\"},"
                + " {\"from\": \"	\u1084	\",\"to\":\"	\u1E70	\"},"
                + " {\"from\": \"	\u1085	\",\"to\":\"	\u1E71	\"},"
                + " {\"from\": \"	\u1086	\",\"to\":\"	\u1E72	\"},"
                + " {\"from\": \"	\u1087	\",\"to\":\"	\u1E73	\"},"
                + " {\"from\": \"	\u1088	\",\"to\":\"	\u1E74	\"},"
                + " {\"from\": \"	\u1089	\",\"to\":\"	\u1E75	\"},"
                + " {\"from\": \"	\u108A	\",\"to\":\"	\u1E76	\"},"
                + " {\"from\": \"	\u108B	\",\"to\":\"	\u1E77	\"},"
                + " {\"from\": \"	\u108C	\",\"to\":\"	\u1E78	\"},"
                + " {\"from\": \"	\u108D	\",\"to\":\"	\u1E79	\"},"
                + " {\"from\": \"	\u108E	\",\"to\":\"	\u1E7A	\"},"
                + " {\"from\": \"	\u108F	\",\"to\":\"	\u1E7B	\"},"
                + " {\"from\": \"	\u1090	\",\"to\":\"	\u1E7C	\"},"
                + " {\"from\": \"	\u1091	\",\"to\":\"	\u1E7D	\"},"
                + " {\"from\": \"	\u1092	\",\"to\":\"	\u1E7E	\"},"
                + " {\"from\": \"	\u1094	\",\"to\":\"	\u1E7F	\"},"
                + " {\"from\": \"	\u1095	\",\"to\":\"	\u1E80	\"},"
                + " {\"from\": \"	\u1096	\",\"to\":\"	\u1E81	\"},"
                + " {\"from\": \"	\u1097	\",\"to\":\"	\u1E82	\"}" + "]";
        return replacewithSan(uni, myString1);
    }

    private CharSequence replacewithSan(String uni1, String myString2) {
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
}
