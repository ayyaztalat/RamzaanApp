package com.tecjaunt.ramzanapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.tecjaunt.ramzanapp.AdManger;
import com.tecjaunt.ramzanapp.Adapter.DuaAdapter;
import com.tecjaunt.ramzanapp.R;

public class DuaLayout extends AppCompatActivity {

    private String[] dua_title={"Greeting another Muslim ","When someone conveys salam to you on another's behalf","Before a meal ","After having a meal ","Dua for ZamZam (Holy Water)","Before wudhu (ablution)","After Wudhu ","When entering the mosque","After sneezing ","Reply to someone who sneezes ","When a Non-Muslim sneezes ","When someone is critically ill ","When visiting the sick "
            ,"Dua taught to a new muslim ","When entering the toilet ","When leaving the toilet, recite","Reaching the top of an incline ","Repentance dua ","Upon awakening ","When undertaking a journey ","Istikhara for marriage ","Dua-e-Qunoot (read in Witr) "};

    private String[] duas_arabic={"اَلسَّلاَ مُ عَلَيْكُمْ وَرَحْمَةُ اللهِ وَبَرَكَا تُهُ","وعليكم السلام","بِسْمِ اللَّهِ وَعَلَى بَرَكَةِ اللَّهِ","اَلْحَمْدُ لِلّٰہِ الَّذِیْ اَطْعَمَنَا وَسَقَانَاوَجَعَلَنَامُسْلِمِیْنَ ۔","اللَّهُمَّ إِنِّي أَسْأَلُكَ عِلْمَاً نَافِعَاًً وَرِزْقَاً وَاسِعَاًَ وَشِفَاءً مِنْ كُلِّ دَاءٍ","اَللّٰھُمَّ اغْفِرْلِیْ ذَنْبِی وَوَسِّعْ لِیْ فِیْ دَارِیْ وَبَارِکْ لِیْ فِیْ رِزْقِیْ ۔","اَشْھَدُاَنْ لَّا اِلٰہَ اِلَّا اللّٰہُ وَحْدَہ لَاشَرِیْکَ لَہ وَاَشْھَدُ اَ نَّ مُحَمَّدًا عَبْدُہ وَرَسُوْلُہ اَللّٰہُمَّ اجْعَلْنِیْ مِنَ التَّوَّابِیْنَ وَاجْعَلْنِیْ مِنَ الْمُتَطَھِّرِیْنَ۔","اَللّٰہُمَّ افْتَحْ لِیْ اَبْوَابَ رَحْمَتِکَ۔"
            ,"الْحَمْدُ لِلَّهِ","يَرْحَمُكَ اللَّهُ","يَهْدِيكُمُ اللهُ ويُصْلِحُ بَالَكُمْ","أَذْهِبِ البَاسَ رَبَّ النَّاسِ، اشْفِ وَأَنْتَ الشَّافِي، لاَ شِفَاءَ إِلَّا شِفَاؤُكَ، شِفَاءً لاَ يُغَادِرُ سَقَمًا" ,"لَابَأْسَ طُہُوْر اِنْ شَآ ئَ اللّٰہ۔","اللَّهُمَ اسْتُر عَيْبَ مٌعَلِمي عَنِّي، ولا تُذْهِبْ بَرَكَةَ عِلْمِهِ مِنِّي","اَللّٰہُمَّ اِنِّیْ اَعُوْذُبِکَ مِنَ الْخُبُثِ وَالْخَبَآئِثِ۔","اَلْحَمْدُ لِلّٰہِ الَّذِیْ اَذْھَبَ عَنِّی الْاَذٰی وَعَافَانِیْْ ۔","اضغط على الصورة لرؤيتها بالحجم الطبيعي","أَسْتَغْفِرُ اللهَ الَّذِي لاَ إِلَهَ إلاَّ هُوَ الحَيُّ القَيّوُمُ وأَتُوبُ إِلَيهِ"
            ,"الحَمْدُ لِلهِ الَّذِي أَحْيَانَا بَعْدَ مَا أَمَاتَنَا وَإِلَيْهِ النُّشُورُ","سُبْحَانَ الَّذِي سَخَّرَ لَنَا هَذَا، وَمَا كُنَّا لَهُ مُقْرِنِينَ، وَإِنَّا إِلَى رَبِّنَا لَمُنْقَلِبُون"
            ,"اللَّهُمَّ إِنِّي أَسْتَخِيرُكَ بِعِلْمِكَ وَأَسْتَقْدِرُكَ بِقُدْرَتِكَ وَأَسْأَلُكَ مِنْ فَضْلِكَ الْعَظِيمِ فَإِنَّكَ تَقْدِرُ وَلَا أَقْدِرُ وَتَعْلَمُ وَلَا أَعْلَمُ وَأَنْتَ عَلَّامُ الْغُيُوبِ اللَّهُمَّ إِنْ كُنْتَ تَعْلَمُ أَنَّ هَذَا الْأَمْرَ خَيْرٌ لِي فِي دِينِي وَمَعَاشِي وَعَاقِبَةِ أَمْرِي فَاقْدُرْهُ لِي وَيَسِّرْهُ لِي ثُمَّ بَارِكْ لِي فِيهِ وَإِنْ كُنْتَ تَعْلَمُ أَنَّ هَذَا الْأَمْرَ شَرٌّ فِي دِينِي وَمَعَاشِي وَعَاقِبَةِ أَمْرِي فَاصْرِفْهُ عَنِّي وَاصْرِفْنِي عَنْهُ وَاقْدُرْ لِيَ الْخَيْرَ حَيْثُ كَانَ ثُمَّ ارْضِنِي بِهِ"
            ,"اَللَّهُمَّ إنا نَسْتَعِينُكَ وَنَسْتَغْفِرُكَ وَنُؤْمِنُ بِكَ وَنَتَوَكَّلُ عَلَيْكَ وَنُثْنِئْ عَلَيْكَ الخَيْرَ وَنَشْكُرُكَ وَلَا نَكْفُرُكَ وَنَخْلَعُ وَنَتْرُكُ مَنْ ئَّفْجُرُكَ اَللَّهُمَّ إِيَّاكَ نَعْبُدُ وَلَكَ نُصَلِّئ وَنَسْجُدُ وَإِلَيْكَ نَسْعأئ وَنَحْفِدُ وَنَرْجُو رَحْمَتَكَ وَنَخْشآئ عَذَابَكَ إِنَّ عَذَابَكَ بِالكُفَّارِ مُلْحَق"};


    private String[] translatitions={"As salamu alaykum wa Rahmatullahi wa Barakatuh","Alayka wa alay-his salaamu wa Rahmatullahi wa Barakatuh. ","Bismillahi wa 'ala baraka-tillah. ","Alham do lillah hilla-thee At Amana wa saquana waja 'alana minal Muslimeen. ","Allah humma Innee As alooka 'ilman naa fee-ow wa Rizq-ow waa See-ow wa Shee-faa amm min Kooll-lee daa-een. ","Allahumma-gh fir-lee dhan-bee wawass si'lee fi dari wa bariklee fi rizq. "
    ,"Allahummaj 'al-ni minat-tow-wa beena waj-alni minal muta-tah-hireen. ","A'uthu bil-Lahil 'atheemi wa biwajhi-hil kareemi wasultaani-hil qadeemi minash-shaytaanir rajeem.","Alhamdulillah! (right graphic) / Alhamdu lillahi 'ala kull-lee ha-leen (left graphic).","Yar Hamoo kall Lah.","Yahdee Kumullahu wa Yaslih Ba Lakoom. ","Allah-humma ah-yini ma kaanatil hayaatu khairall-lee wa tawaff-fani i-dha kaanatil wa faato khai-rall-lee. "
            ,"La ba'sa tahoorun inshaa-Allah. La ba'sa tahoorun inshaa-Allah. ","Allahummagh fir-lee warr hamnee wah-dini warr zuq-ni. ","Allahumma in-nee a'oothu bika minal khubu-thee wal khabaa ith. ","Ghuf-raa naka. ","Allahumma lakash-sharafu 'ala kull-lee shara-few walakal hamdu 'ala kull-li haalin.","Allahumma In-nee a-toobu ilayka minha la ar-ji-u ilayhaa abada. ",
    "Alhamdulillah-hillathee ah-yana ba'da ma ama tana wa ilayhi nushoor. ","Subhanalla-thee sakh-khara-lana haatha wa-ma kun-na lahoo muqrineena wa inna ila Rabbina la-mun-qali-boon. ","No transliterations for Istikhara","No transliterations for Dua Qanoot"};

    private String[] meaning={"May the peace of Allah descend upon you and His Mercy and Blessings. ","Upon you and upon him be the peace of Allah, His mercy and blessings. ","With Allah's name and uon the blessings granted by Allah (do we eat). ","All praise is due to Allah who gave us food and drink and who made us Muslims. "," O Allah, I ask You to grant me beneficial knowledge, abundant sustenance and cure from all diseases. ","O Allah Forgive my sins, make my home accommodating and grant me abundance in my livelihood."," I testify that there is no deity except Allah; He is One and has no partner.  And I testify that Muhammad (Sallallahu alayhi wasallam) is His servant and apostle."
    ,"I seek protection from Allah, The Sublime, and I seek the protection of His Merciful Self and of His Eternal Kingdom against the accursed devil.","Thanks and all praise be to Allah (or) Thanks and all praise be to Allah under all conditions.","May Allah have mercy on you. ","May Allah give you guidance and make your children pious. ","O Allah, keep me alive so long as it is in my best interest and give me death when it is in my best interest. ","No need to worry.  It (this sickness) is a means of cleansing from sins.  No need to worry. It (this sickness) is a means of cleansing from sins. "
            ,"O Allah, forgive me, have mercy on me, guide me aright and grant me sustenance. ","(In the name of Allah). O Allah, I take refuge with you from all evil and evil-doers.","I ask You (Allah) for forgiveness.","O Allah, all sublimity is for You at every incline and all praise is for You at all times under all conditions. ","O Allah, I repent before You for all my sins and I promise never to return to the same (again). ","Many thanks to Allah who gave us life after having given us death and (our) final return (on the Day of Qiyaamah (Judgement)) is to Him. ","Glory be to Him (Allah) who has brought this (vehicle) under our control though we were unable to control it.  Sure, we are to return to our Lord. "
    ," O Allah, You have power and I have none.  You know all and I know not.  You are The Knower of all that is hidden.  If, in Your knowledge (mention name of person here) be good for me in my faith and in my temporal and religious life, then ordain her (or him) for me.  And if anyone other than her (or him) be good for me in my faith and religious life, then ordain her (or him) for me. ","O Allah! We beg help from You alone; ask forgiveness from You alone, and turn towards You and praise You for all the good things and are grateful to You and are not ungrateful to You and we part and break off with all those who are disobedient to you. O Allah! You alone do we worship and pray exclusively to You and bow before You alone and we hasten eagerly towards You and we fear Your severe punishment and hope for Your Mercy as your severe punishment is surely to be meted out to the unbelievers. "};

    DuaAdapter adapter;
    ImageView back_press;
//    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dua_page);

        RelativeLayout adLayout=findViewById(R.id.adLayout);
//        AdManger.init(this);
        AdManger.loadBannerAds(adLayout,this);



        // Instantiate an AdView object.
        // NOTE: The placement ID from the Facebook Monetization Manager identifies your App.
        // To get test ads, add IMG_16_9_APP_INSTALL# to your placement id. Remove this when your app is ready to serve real ads.

        back_press=findViewById(R.id.back_press);
        ListView allah_name_recycler=findViewById(R.id.ListView);

        adapter=new DuaAdapter(this,dua_title,duas_arabic,meaning,translatitions);

        allah_name_recycler.setAdapter(adapter);

        clicks();

    }

    private void clicks() {
        back_press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }



}
