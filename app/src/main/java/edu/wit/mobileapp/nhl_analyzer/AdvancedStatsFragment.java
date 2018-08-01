package edu.wit.mobileapp.nhl_analyzer;

import android.app.Fragment;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import edu.wit.mobileapp.nhl_analyzer.Player;
import edu.wit.mobileapp.nhl_analyzer.R;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AdvancedStatsFragment extends Fragment
{
    private ArrayList<Player> playerlist;

    public AdvancedStatsFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.advanced_stats_fragment, container, false);

        playerlist = new ArrayList<>();
        initplayers(rootView);

        return rootView;
    }

    private void initplayers(final View rootView) {
        //with help from http://androidbash.com/connecting-android-app-to-a-database-using-php-and-mysql/
        AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            String siteurl = "https://pure-badlands-77403.herokuapp.com/phpcodetry2.php";

            @Override
            protected Void doInBackground(Void... voids) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(siteurl).build();
                try {
                    Response response = client.newCall(request).execute();
                    JSONArray array = new JSONArray((response.body().string()));
                    int i = 0;
                    while (i < array.length()) {
                        JSONObject object = array.getJSONObject(i);
                        Player newplayer = new Player(object.getInt("idplayers"), object.getString("name"), object.getInt("age"), object.getString("team"), object.getString("pos"), object.getInt("gp"), object.getInt("CF"),
                                object.getInt("CA"), object.getDouble("CFpercent"), object.getDouble("CFpercentRel"), object.getInt("FF"), object.getInt("FA"), object.getDouble("FFpercent"), object.getDouble("FFpercentRel"),
                                object.getDouble("oiSHpercent"), object.getDouble("oiSVpercent"), object.getDouble("PDO"), object.getDouble("oZSpercent"), object.getDouble("dZSpercent"), object.getString("TOI60"), object.getString("TOIEV"), object.getInt("TK"),
                                object.getInt("GV"), object.getDouble("Eplusminus"), object.getInt("Satt"), object.getDouble("Thrupercent"));
                        playerlist.add(newplayer);
                        i++;

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                //code here can be used to notify the app that everything's been loaded, if needed
                int SizeTest = playerlist.size();
                String SizeTestString = Integer.toString(SizeTest);
                Log.v("MyApp", SizeTestString);
                init(rootView);
            }
        };
        asyncTask.execute();
    }

    public void init(View rootView) {
        TableLayout stk = (TableLayout) rootView.findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(getContext());
        TextView tv0 = new TextView(getContext());
        tv0.setText("ID ");
        tv0.setTextColor(Color.BLUE);
        tv0.setTextSize(20);
        tbrow0.addView(tv0);

        TextView tv1 = new TextView(getContext());
        tv1.setText("Player ");
        tv1.setTextColor(Color.BLUE);
        tv1.setTextSize(20);
        tbrow0.addView(tv1);

        TextView tv2 = new TextView(getContext());
        tv2.setText("Age ");
        tv2.setTextColor(Color.BLUE);
        tv2.setTextSize(20);
        tbrow0.addView(tv2);

        TextView tv3 = new TextView(getContext());
        tv3.setText("Team ");
        tv3.setTextColor(Color.BLUE);
        tv3.setTextSize(20);
        tbrow0.addView(tv3);

        TextView tv4 = new TextView(getContext());
        tv4.setText("Pos ");
        tv4.setTextColor(Color.BLUE);
        tv4.setTextSize(20);
        tbrow0.addView(tv4);

        TextView tv5 = new TextView(getContext());
        tv5.setText("GP ");
        tv5.setTextColor(Color.BLUE);
        tv5.setTextSize(20);
        tbrow0.addView(tv5);

        TextView tv6 = new TextView(getContext());
        tv6.setText("CF ");
        tv6.setTextColor(Color.BLUE);
        tv6.setTextSize(20);
        tbrow0.addView(tv6);

        TextView tv7 = new TextView(getContext());
        tv7.setText("CA ");
        tv7.setTextColor(Color.BLUE);
        tv7.setTextSize(20);
        tbrow0.addView(tv7);

        TextView tv8 = new TextView(getContext());
        tv8.setText("CF% ");
        tv8.setTextColor(Color.BLUE);
        tv8.setTextSize(20);
        tbrow0.addView(tv8);

        TextView tv9 = new TextView(getContext());
        tv9.setText("CF% rel ");
        tv9.setTextColor(Color.BLUE);
        tv9.setTextSize(20);
        tbrow0.addView(tv9);

        TextView tv10 = new TextView(getContext());
        tv10.setText("FF ");
        tv10.setTextColor(Color.BLUE);
        tv10.setTextSize(20);
        tbrow0.addView(tv10);

        TextView tv11 = new TextView(getContext());
        tv11.setText("FA ");
        tv11.setTextColor(Color.BLUE);
        tv11.setTextSize(20);
        tbrow0.addView(tv11);

        TextView tv12 = new TextView(getContext());
        tv12.setText("FF% ");
        tv12.setTextColor(Color.BLUE);
        tv12.setTextSize(20);
        tbrow0.addView(tv12);

        TextView tv13 = new TextView(getContext());
        tv13.setText("FF% rel ");
        tv13.setTextColor(Color.BLUE);
        tv13.setTextSize(20);
        tbrow0.addView(tv13);

        TextView tv14 = new TextView(getContext());
        tv14.setText("oiSH% ");
        tv14.setTextColor(Color.BLUE);
        tv14.setTextSize(20);
        tbrow0.addView(tv14);

        TextView tv15 = new TextView(getContext());
        tv15.setText("oiSV% ");
        tv15.setTextColor(Color.BLUE);
        tv15.setTextSize(20);
        tbrow0.addView(tv15);

        TextView tv16 = new TextView(getContext());
        tv16.setText("PDO ");
        tv16.setTextColor(Color.BLUE);
        tv16.setTextSize(20);
        tbrow0.addView(tv16);

        TextView tv17 = new TextView(getContext());
        tv17.setText("oZS% ");
        tv17.setTextColor(Color.BLUE);
        tv17.setTextSize(20);
        tbrow0.addView(tv17);

        TextView tv18 = new TextView(getContext());
        tv18.setText("dZS% ");
        tv18.setTextColor(Color.BLUE);
        tv18.setTextSize(20);
        tbrow0.addView(tv18);

        TextView tv19 = new TextView(getContext());
        tv19.setText("TOI/60 ");
        tv19.setTextColor(Color.BLUE);
        tv19.setTextSize(20);
        tbrow0.addView(tv19);

        TextView tv20 = new TextView(getContext());
        tv20.setText("TOI(EV) ");
        tv20.setTextColor(Color.BLUE);
        tv20.setTextSize(20);
        tbrow0.addView(tv20);

        TextView tv21 = new TextView(getContext());
        tv21.setText("TK ");
        tv21.setTextColor(Color.BLUE);
        tv21.setTextSize(20);
        tbrow0.addView(tv21);

        TextView tv22 = new TextView(getContext());
        tv22.setText("GV ");
        tv22.setTextColor(Color.BLUE);
        tv22.setTextSize(20);
        tbrow0.addView(tv22);

        TextView tv23 = new TextView(getContext());
        tv23.setText("E+/- ");
        tv23.setTextColor(Color.BLUE);
        tv23.setTextSize(20);
        tbrow0.addView(tv23);

        TextView tv24 = new TextView(getContext());
        tv24.setText("Satt. ");
        tv24.setTextColor(Color.BLUE);
        tv24.setTextSize(20);
        tbrow0.addView(tv24);

        TextView tv25 = new TextView(getContext());
        tv25.setText("Thru% ");
        tv25.setTextColor(Color.BLUE);
        tv25.setTextSize(20);
        tbrow0.addView(tv25);
        //Add row
        stk.addView(tbrow0,0);


        for (int i=0;i < playerlist.size();i++) {
            //Makes row
            TableRow tbrow = new TableRow(getContext());

            TextView t1v = new TextView(getContext());
            int ID = playerlist.get(i).id;
            String IDString = Integer.toString(ID);
            t1v.setText(IDString + " | ");
            tbrow.addView(t1v);

            TextView t2v = new TextView(getContext());
            String Name = playerlist.get(i).playername;
            t2v.setText(Name);
            tbrow.addView(t2v);

            TextView t3v = new TextView(getContext());
            int Age = playerlist.get(i).age;
            String AgeString = Integer.toString(Age);
            t3v.setText(AgeString + " | ");
            tbrow.addView(t3v);

            TextView t4v = new TextView(getContext());
            String Team = playerlist.get(i).team;
            t4v.setText(Team);
            tbrow.addView(t4v);

            TextView t5v = new TextView(getContext());
            String Pos = playerlist.get(i).pos;
            t5v.setText(Pos);
            tbrow.addView(t5v);

            TextView t6v = new TextView(getContext());
            int GP = playerlist.get(i).gp;
            String GPString = Integer.toString(GP);
            t6v.setText(GPString);
            tbrow.addView(t6v);

            TextView t7v = new TextView(getContext());
            int CF = playerlist.get(i).CF;
            String CFString = Integer.toString(CF);
            t7v.setText(CFString + " | ");
            tbrow.addView(t7v);

            TextView t8v = new TextView(getContext());
            int CA = playerlist.get(i).CA;
            String CAString = Integer.toString(CA);
            t8v.setText(CAString + " | ");
            tbrow.addView(t8v);

            TextView t9v = new TextView(getContext());
            double CFPer = playerlist.get(i).CFpercent;
            String CFPerString = Double.toString(CFPer);
            t9v.setText(CFPerString + " | ");
            tbrow.addView(t9v);

            TextView t10v = new TextView(getContext());
            double CFPerRel = playerlist.get(i).CFpercentRel;
            String CFPerRelString = Double.toString(CFPerRel);
            t10v.setText(CFPerRelString);
            tbrow.addView(t10v);

            TextView t11v = new TextView(getContext());
            int FF = playerlist.get(i).FF;
            String FFString = Integer.toString(FF);
            t11v.setText(FFString + " | ");
            tbrow.addView(t11v);

            TextView t12v = new TextView(getContext());
            int FA = playerlist.get(i).FA;
            String FAString = Integer.toString(FA);
            t12v.setText(FAString + " | ");
            tbrow.addView(t12v);

            TextView t13v = new TextView(getContext());
            double FFPer = playerlist.get(i).FFpercent;
            String FFPerString = Double.toString(FFPer);
            t13v.setText(FFPerString + " | ");
            tbrow.addView(t13v);

            TextView t14v = new TextView(getContext());
            double FFPerRel = playerlist.get(i).FFpercentRel;
            String FFPerRelString = Double.toString(FFPerRel);
            t14v.setText(FFPerRelString);
            tbrow.addView(t14v);

            TextView t15v = new TextView(getContext());
            double ioSHPer = playerlist.get(i).oiSHpercent;
            String ioSHPerString = Double.toString(ioSHPer);
            t15v.setText(ioSHPerString);
            tbrow.addView(t15v);

            TextView t16v = new TextView(getContext());
            double ioSVPer = playerlist.get(i).oiSVpercent;
            String ioSVPerString = Double.toString(ioSVPer);
            t16v.setText(ioSVPerString);
            tbrow.addView(t16v);

            TextView t17v = new TextView(getContext());
            double PDO = playerlist.get(i).PDO;
            String PDOString = Double.toString(PDO);
            t17v.setText(PDOString);
            tbrow.addView(t17v);

            TextView t18v = new TextView(getContext());
            double oZSPer = playerlist.get(i).oZSpercent;
            String ozSPerString = Double.toString(oZSPer);
            t18v.setText(ozSPerString);
            tbrow.addView(t18v);

            TextView t19v = new TextView(getContext());
            double dZSPer = playerlist.get(i).dZSpercent;
            String dzSPerString = Double.toString(dZSPer);
            t19v.setText(dzSPerString);
            tbrow.addView(t19v);

            TextView t20v = new TextView(getContext());
            String TOI60 = playerlist.get(i).TOI60;
            t20v.setText(TOI60);
            tbrow.addView(t20v);

            TextView t21v = new TextView(getContext());
            String TOIEV = playerlist.get(i).TOIEV;
            t21v.setText(TOIEV);
            tbrow.addView(t21v);

            TextView t22v = new TextView(getContext());
            int TK = playerlist.get(i).TK;
            String TKString = Integer.toString(TK);
            t22v.setText(TKString);
            tbrow.addView(t22v);

            TextView t23v = new TextView(getContext());
            int GV = playerlist.get(i).GV;
            String GVString = Integer.toString(GV);
            t23v.setText(GVString);
            tbrow.addView(t23v);

            TextView t24v = new TextView(getContext());
            double EPlusMin = playerlist.get(i).Eplusminus;
            String EPlusMinString = Double.toString(EPlusMin);
            t24v.setText(EPlusMinString);
            tbrow.addView(t24v);

            TextView t25v = new TextView(getContext());
            int Satt = playerlist.get(i).Satt;
            String SattString = Integer.toString(Satt);
            t25v.setText(SattString);
            tbrow.addView(t25v);

            TextView t26v = new TextView(getContext());
            double ThruPer = playerlist.get(i).thrupercent;
            String ThruPerString = Double.toString(ThruPer);
            t26v.setText(ThruPerString);
            tbrow.addView(t26v);

            //Prints out everything
            stk.addView(tbrow);
        }



    }


}