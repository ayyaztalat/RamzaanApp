package com.tecjaunt.ramzanapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.tecjaunt.ramzanapp.Adapter.AllahNamesAdapter;
import com.tecjaunt.ramzanapp.Adapter.DuaAdapter;
import com.tecjaunt.ramzanapp.R;

public class DuaLayout extends AppCompatActivity {

    private String[] duas_arabic={"1 والكَسَلِ والبُخْـلِوالجُـبْ للّهُـمَّ إِنِّي أَعْوذُ بِكَ مِنَ الهَـمِّ وَ الْحُـزْنِ، والعًجْـز وضَلْـعِ الـدَّيْنِ وغَلَبَـةِ الرِّجال","2 رَبَّنَا آتِنَا فِيالدُّنْيَا حَسَنَةً وَفِي الْآخِرَةِ حَسَنَةً وَقِنَا عَذَابَ النَّارِ",
            "4 اللّهُـمَّ إِنِّـي أسْـأَلُـكَ العَـفْوَوَالعـافِـيةَ في الدُّنْـيا وَالآخِـرَة اللّهُـمَّ إِنِّـي أسْـأَلُـكَالعَـفْوَ وَالعـافِـيةَ في ديني وَدُنْـيايَ وَأهْـلي وَمالـي ، اللّهُـمَّاسْتُـرْ عـوْراتي وَآمِـنْ رَوْعاتـي ،اللّهُـمَّ احْفَظْـني مِن بَـينِ يَدَيَّوَمِن خَلْفـي وَعَن يَمـيني وَعَن شِمـالي ، وَمِن فَوْقـي ، وَأَعـوذُ بِعَظَمَـتِكَأَن أُغْـتالَ مِن تَحْتـي","3 رَبِّ اجْعَلْنِي مُقِيمَالصَّلَاةِ وَمِن ذُرِّيَّتِي ۚ رَبَّنَا وَتَقَبَّلْ دُعَاءِرَبَّنَا اغْفِرْ لِيوَلِوَالِدَيَّ وَلِلْمُؤْمِنِينَ يَوْمَ يَقُومُ الْحِسَابُ",
    "7 اللّهُـمَّ إِنِّـي أَسْأَلُـكَ الجَـنَّةَ وأََعوذُ بِـكَ مِـنَ الـنّار","6 اللّهُـمَّ أَعِـنِّي عَلـى ذِكْـرِكَ وَشُكْـرِك ، وَحُسْـنِ عِبـادَتِـك","5 اللّهُـمَّ إِنِّـي أَسْأَلُـكَ عِلْمـاً نافِعـاً وَرِزْقـاً طَيِّـباً ،وَعَمَـلاً مُتَقَـبَّلاً"};

    private String[] translatitions={"Allahumma inni ‘audhubika min al-hammi wal huzani,wal ‘ajzi wal kasali, wal bukhli wal jubni, wa dala’ad-dayni wa ghalabatir-rijâl.","Rabbana aatina fid-dunya hassanatau,wa fil akhirati hassanatau, waqina ‘adhab an-nar.",
    "Rabbi j’alnee muqeem as-salati wa mindhuriyyati. Rabbana, wa taqabbal dua’. Rabbanaghfir li wa li walidayya wa lilmu’mineena yawma yaqoom ul-hisab",
    "Allahumma inni as-alukaal-‘afwa wal ‘afiyata fid dunya wal akhira. Allahumma inni as-aluka al ‘afwa walafiyata fee deeni wa dunyaya wa ahlee wa malee. Allahummastur ‘awrati wa aminrow’ati. Allahumma ahfadhnee min bayni yadayya min khalfi wa ‘an yameeni wa ‘anshimali wa min fowqi wa a’oodhu bi ‘adhmatika an aghtaala min tahti.",
    "Allahuma inni as-aluka‘ilman nafi’an wa rizqan tayyiban wa ‘amalan matqaballa.","Allahuma a’inni ‘aladhikrika washukrika wahusni‘ibadatika.","Allahuma inni as-aluka al-jannata wa a’udhubika min an-nar."};


    private String[] meaning={"O Allah, I take refuge in You from anxiety and sorrow, weakness and laziness, miserliness and cowardice, the burden of debts and from being over powered by men","Our Lord, give us in this world [that which is] good and in the Hereafter [that which is] good and protect us from the punishment of the Fire.",
    "My Lord, make me an establisher of prayer, and [many] from my descendants. Our Lord, and accept my supplication. Our Lord, forgive me and my parents and the believers the Day the account is established.",
    "O Allah, I ask You for pardon and well-being in this life and the next. O Allah,I ask You for pardon and well-being in my religious and worldly affairs, and my family and my wealth. O Allah, veil my weaknesses and set at ease my dismay. O Allah, preserve me from the front and from behind and on my right and on my left and from above, and I take refuge with You lest I be swallowed up by the earth",
    "O Allah, I ask You for knowledge which is beneficial and sustenance which is good, and deeds which are acceptable.","O Allah, help me to remember You, to thank You, and to worship You in the best of manners","O Allah, I ask You to grant me Paradise and I take refuge in You from the Fire"};


    DuaAdapter adapter;
    ImageView back_press;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dua_page);

        back_press=findViewById(R.id.back_press);
        ListView allah_name_recycler=findViewById(R.id.ListView);

        adapter=new DuaAdapter(this,duas_arabic,meaning,translatitions);

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
