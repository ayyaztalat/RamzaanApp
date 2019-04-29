package com.tecjaunt.ramzanapp.Activities;

import android.content.res.AssetManager;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.tecjaunt.ramzanapp.Adapter.MuhammadNamesAdapter;
import com.tecjaunt.ramzanapp.R;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MuhammadActivity extends AppCompatActivity {

    private   int imagesSmall[] = {R.drawable.g_m_01, R.drawable.g_m_02, R.drawable.g_m_03, R.drawable.g_m_04, R.drawable.g_m_05, R.drawable.g_m_06, R.drawable.g_m_07, R.drawable.g_m_08, R.drawable.g_m_09,R.drawable.g_m_10, R.drawable.g_m_11, R.drawable.g_m_12, R.drawable.g_m_13, R.drawable.g_m_14, R.drawable.g_m_15, R.drawable.g_m_16, R.drawable.g_m_17, R.drawable.g_m_18, R.drawable.g_m_19, R.drawable.g_m_20, R.drawable.g_m_21, R.drawable.g_m_22, R.drawable.g_m_23, R.drawable.g_m_24, R.drawable.g_m_25, R.drawable.g_m_26, R.drawable.g_m_27, R.drawable.g_m_28, R.drawable.g_m_29, R.drawable.g_m_30, R.drawable.g_m_31, R.drawable.g_m_32, R.drawable.g_m_33, R.drawable.g_m_34, R.drawable.g_m_35, R.drawable.g_m_36, R.drawable.g_m_37, R.drawable.g_m_38, R.drawable.g_m_39, R.drawable.g_m_40, R.drawable.g_m_41, R.drawable.g_m_42, R.drawable.g_m_43, R.drawable.g_m_44, R.drawable.g_m_45, R.drawable.g_m_46, R.drawable.g_m_47, R.drawable.g_m_48, R.drawable.g_m_49, R.drawable.g_m_50, R.drawable.g_m_51, R.drawable.g_m_52, R.drawable.g_m_53, R.drawable.g_m_54, R.drawable.g_m_55, R.drawable.g_m_56, R.drawable.g_m_57, R.drawable.g_m_58, R.drawable.g_m_59, R.drawable.g_m_60, R.drawable.g_m_61, R.drawable.g_m_62, R.drawable.g_m_63, R.drawable.g_m_64, R.drawable.g_m_65, R.drawable.g_m_66, R.drawable.g_m_67, R.drawable.g_m_68, R.drawable.g_m_69, R.drawable.g_m_70, R.drawable.g_m_71, R.drawable.g_m_72, R.drawable.g_m_73, R.drawable.g_m_74, R.drawable.g_m_75, R.drawable.g_m_76, R.drawable.g_m_77, R.drawable.g_m_78, R.drawable.g_m_79, R.drawable.g_m_80, R.drawable.g_m_81, R.drawable.g_m_82, R.drawable.g_m_83, R.drawable.g_m_84, R.drawable.g_m_85, R.drawable.g_m_86, R.drawable.g_m_87, R.drawable.g_m_88, R.drawable.g_m_89, R.drawable.g_m_90, R.drawable.g_m_91, R.drawable.g_m_92, R.drawable.g_m_93, R.drawable.g_m_94, R.drawable.g_m_95, R.drawable.g_m_96, R.drawable.g_m_97, R.drawable.g_m_98, R.drawable.g_m_99};


    private   String names[] = {"Aadil", "Aalim", "Abdullah", "Abu al Qaasim", "Abu at Tahir", "Abu at Tayyib", "Abu Ibrahim", "Afoow", "Aheed", "Ahmad", "Ajeer", "Alam ul Eeman", "Alam ul Yaqeen", "Alamul Hudaa", "Aleem", "Ameen", "An Najm-us-Saqib", "Aqib", "Arabi", "Awwal", "Ayn ul Ghurr", "Ayn un Naeem",
            "Aziz", "Baaligh", "Bar", "Basheer", "Bayan", "Burhan", "Bushraa", "Daa", "Daleel ul Khyayraat", "Faateh", "Faazil", "Faseehul Lisaan", "Fatah", "Ghani", "Gharib", "Ghaus", "Ghays", "Ghiyaas", "Haad", "Habeebullah", "Habieb", "Hafeey",
            "Al-Hafiz", "Hakeem", "Hamid", "Hamied", "Haq", "Harees-un-Alaikum", "Hashim", "Hashir", "Hashmi", "Hidayatullah", "Hijazi", "Hizbullah", "Hudaa", "Hujjat", "Ikleel", "Imam", "Imamul Muttaqeen", "Izzul Arab", "Jaami", "Jabbar", "Jawwad", "Kaaf",
            "Kaamil", "Kaashiful Kurab", "Kafeel", "Kaleemullah", "Kareem", "Khaleel ur Rahman", "Khalil", "Khatamul anbiya", "Khatamur Rusul", "Khateebul Umam", "Khatieb", "Khatim", "Maah", "Madani", "Madoow", "Mahd", "Mahdee", "Mahdiy", "Mahmood", "Makeen", "Makeen", "Makhsoos bil Izz",
            "Makhsoos bil Majd", "Makhsoos bil Sharaf", "Maloom", "Mamoon", "Mansoor", "Maraj", "Mashhood", "Mashkoor", "Mateen", "Mawsool", "Miftaah"};

    private   String meaning[] = {"The Justice", "The Scholar", "Slave of Allah", "The father of Qasim.", "The father of Tahir.", "The father of Tayyib.",
            "The father of Ibrahim.", "Forgiver.", "He who takes to one side.", "Much praised", "He who is rewarded.", "The banner of faith.",
            "Banner of guidance.", "The Knowledgeable", "The Honest One", "Shining star.", "The Latest", "The Arabi",

            "The First", "The chief of the chosen one.", "The spring of blessing.", "The Honoured One", "He who attains the elevated station.", "Pious",
            "The Messenger of Good News", "Obvious words", "The Evidence", "Giver of good tidings.", "The Invitor", "To guide to virtue.",

            "The Victor", "Virtuous.", "The eloquent of speech.", "The Successor, The Opener", "The Rich", "The Poor",
            "Succour, listener to complaints.", "Shower of mercy.", "Full of succour.", "The Leader", "Beloved of Allah.", "The Beloved",
            "Very merciful.", "The Guardian", "The Wise", "The Praiser", "The Thankful", "The True, The Truth",

            "The Covetous for the Believers", "The Destroyer, The Crusher of Evil", "The Awakener, The Gatherer", "The Hashmi", "Gift of Allah.", "The Hijazi",
            "Army of Allah.", "Guide.", "The Right Argument", "Chief (of Prophets)", "The Guide", "Leader of the pious.",

            "The honour of Arabs.", "Perfect.", "Dominant.", "The Generous", "Sufficient, enough.", "Perfect.",
            "He who solves difficulties.", "Surety.", "Who converses with Allah.", "The Noble", "The freind of Compassionate.", "The True Friend",

            "Seal of the Prophets.", "Seal of Messengers.", "Sermoniser for the people.", "The Sermoniser", "The Finalizer", "The obliterator of Infidelity",
            "The Resident of Madina", "Who is called.", "The Guided One", "Who is guided.", "He Who is Well Guided", "The Commendable",

            "Who is given Rank", "Who is given rank.", "Chosen to be honoured.", "Chosen to be on the right path.", "Picked up as a noble.",
            "Known.", "Secure.", "Who is helped", "The Place of Ascent, The Above", "He who is witnessed.", "The Thankful",
            "The Strong", "Having link with Allah.", "Key to the secrets.", "Key to the secrets."};


    ListView muhammad_names_recycler;
    LinearLayoutManager manager;
    MuhammadNamesAdapter adapter;
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    AssetManager assetManager;
    ImageView back_press;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muhammad_layout);
        back_press=findViewById(R.id.back_press);

        try {
            // for assets folder add empty string

            // for assets/subFolderInAssets add only subfolder name
            Field[] fields=R.raw.class.getDeclaredFields();
            for (int count=100;count<fields.length;count++){
                arrayList.add(fields[count].getInt(fields[count]));
            }

            // if(filelistInSubfolder == null) ............

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        muhammad_names_recycler=findViewById(R.id.ListView_muhammad);

        adapter=new MuhammadNamesAdapter(this,imagesSmall,meaning,names,arrayList);

        muhammad_names_recycler.setAdapter(adapter);

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
