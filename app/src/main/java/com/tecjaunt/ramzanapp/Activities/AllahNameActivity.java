package com.tecjaunt.ramzanapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.tecjaunt.ramzanapp.AdManger;
import com.tecjaunt.ramzanapp.Adapter.AllahNamesAdapter;
import com.tecjaunt.ramzanapp.R;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class AllahNameActivity extends AppCompatActivity {

    private   int imagesSmall[] = {R.drawable.thumba0,R.drawable.thumba1, R.drawable.thumba2, R.drawable.thumba3, R.drawable.thumba4, R.drawable.thumba5, R.drawable.thumba6, R.drawable.thumba7, R.drawable.thumba8, R.drawable.thumba9, R.drawable.thumba10, R.drawable.thumba11, R.drawable.thumba12, R.drawable.thumba13, R.drawable.thumba14, R.drawable.thumba15, R.drawable.thumba16, R.drawable.thumba17, R.drawable.thumba18, R.drawable.thumba19, R.drawable.thumba20, R.drawable.thumba21, R.drawable.thumba22, R.drawable.thumba23, R.drawable.thumba24, R.drawable.thumba25, R.drawable.thumba26, R.drawable.thumba27, R.drawable.thumba28, R.drawable.thumba29, R.drawable.thumba30, R.drawable.thumba31, R.drawable.thumba32, R.drawable.thumba33, R.drawable.thumba34, R.drawable.thumba35, R.drawable.thumba36, R.drawable.thumba37, R.drawable.thumba38, R.drawable.thumba39, R.drawable.thumba40, R.drawable.thumba41, R.drawable.thumba42, R.drawable.thumba43, R.drawable.thumba44, R.drawable.thumba45, R.drawable.thumba46, R.drawable.thumba47, R.drawable.thumba48, R.drawable.thumba49, R.drawable.thumba50, R.drawable.thumba51, R.drawable.thumba52, R.drawable.thumba53, R.drawable.thumba54, R.drawable.thumba55, R.drawable.thumba56, R.drawable.thumba57, R.drawable.thumba58, R.drawable.thumba59, R.drawable.thumba60, R.drawable.thumba61, R.drawable.thumba62, R.drawable.thumba63, R.drawable.thumba64, R.drawable.thumba65, R.drawable.thumba66, R.drawable.thumba67, R.drawable.thumba68, R.drawable.thumba69, R.drawable.thumba70, R.drawable.thumba71, R.drawable.thumba72, R.drawable.thumba73, R.drawable.thumba74, R.drawable.thumba75, R.drawable.thumba76, R.drawable.thumba77, R.drawable.thumba78, R.drawable.thumba79, R.drawable.thumba80, R.drawable.thumba81, R.drawable.thumba82, R.drawable.thumba83, R.drawable.thumba84, R.drawable.thumba85, R.drawable.thumba86, R.drawable.thumba87, R.drawable.thumba88, R.drawable.thumba89, R.drawable.thumba90, R.drawable.thumba91, R.drawable.thumba92, R.drawable.thumba93, R.drawable.thumba94, R.drawable.thumba95, R.drawable.thumba96, R.drawable.thumba97, R.drawable.thumba98, R.drawable.thumba99};

    private   String names[] = {"Allah","Ar-Rahman", "Ar-Raheem", "Al-Malik", "Al-Quddus", "As-Salam", "Al-Mu min", "Al-Muhaymin", "Al-Aziz", "Al-Jabbar", "Al-Mutakabbir", "Al-Khaaliq", "Al-Baari", "Al-Musawwir", "Al-Ghaffar", "Al-Qahhaar", "Al-Wahhaab", "Ar-Razzaaq", "Al-Fattaah", "Al- Alim", "Al-Qaabid", "Al-Basit", "Al-Khaafid",
            "Ar-Raafi", "Al-Mu izz", "Al-Muzil", "As-Sami", "Al-Basir", "Al-Hakam", "Al-Adl", "Al-Latif", "Al-Khabir", "Al-Halim", "Al- Azim", "Al-Ghafur", "Ash-Shakur", "Al- Ali", "Al-Kabir", "Al-Hafiz", "Al-Muqit", "Al-Hasib", "Al-Jalil", "Al-Karim", "Ar-Raqib", "Al-Mujib",
            "Al-Wasi", "Al-Hakim", "Al-Wadud", "Al-Majeed", "Al-Baa ith", "Ash-Shahid", "Al-Haqq", "Al-Wakil", "Al-Qawiyy", "Al-Matin", "Al-Wali", "Al-Hamid", "Al-Muhsi", "Al-Mubdi", "Al-Mu id", "Al-Muhyi", "Al-Mumit", "Al-Hayy", "Al-Qayyum", "Al-Waajid", "Al-Maajid", "Al-Waahid",
            "Al-Ahad", "As-Samad", "Al-Qadir", "Al-Muqtadir", "Al-Muqaddim", "Al-Mu akhkhir", "Al-Awwal", "Al-Akhir", "Az-Zahir", "Al-Batin", "Al-Wali", "Al-Muta ali", "Al-Barr", "At-Tawwaab", "Al-Muntaqim", "Al-Afuww", "Ar-Ra uf", "Malik al-Mulk", "Dhu al Jalal wa al Ikram", "Al-Muqsit", "Al-Jami", "Al-Ghani",
            "Al-Mughni", "Al-Mani", "Ad-Darr", "An-Nafi", "An-Nur", "Al-Hadi", "Al-Badi", "Al-Baaqi", "Al-Waarith", "Ar-Rashid", "As-Sabur"};

    private   String meaning[] = {"GOD (ALLAH)","The Beneficent", "The Merciful", "The Eternal Lord", "The Most Sacred", "The Embodiment of Peace", "The Infuser of Faith",
            "The Preserver of Safety", "The Mighty One", "The Omnipotent One", "The Dominant One", "The Creator", "The Evolver",
            "The Flawless Shaper", "The Great Forgiver", "The All-Prevailing One", "The Supreme Bestower", "The Total Provider", "The Supreme Solver",
            "The All-Knowing One", "The Restricting One", "The Extender", "The Reducer", "The Elevating One", "The Honourer-Bestower",
            "The Abaser", "The All-Hearer", "The All-Seeing", "The Impartial Judge", "The Embodiment of Justice", "The Knower of Subtleties",
            "The All-Aware One", "The Clement One", "The Magnificent One", "The Great Forgiver", "The Acknowledging One", "The Sublime One",
            "The Great One", "The Guarding One", "The Sustaining One", "The Reckoning One", "The Majestic One", "The Bountiful One",
            "The Watchful One", "The Responding One", "The All-Pervading One", "The Wise One", "The Loving One", "The Glorious One",
            "The Infuser of New Life", "The All Observing Witness", "The Embodiment of Truth", "The Universal Trustee", "The Strong One", "The Firm One",
            "The Protecting Associate", "The Sole-Laudable One", "The All-Enumerating One", "The Originator", "The Restorer", "The Maintainer of life",
            "The Inflictor of Death", "The Eternally Living One", "The Self-Subsisting One", "The Pointing One", "The All-Noble One", "The Only One",
            "The Sole One", "The Supreme Provider", "The Omnipotent One", "The All Authoritative One", "The Expediting One", "The Procrastinator",
            "The Very First", "The Infinite Last One", "The Perceptible", "The Imperceptible", "The Holder of Supreme Authority", "The Extremely Exalted One",
            "The Fountain-Head of Truth", "The Ever-Acceptor of Repentance", "The Retaliator", "The Supreme Pardoner", "The Benign One", "The Eternal Possessor of Sovereignty",
            "The Possessor of Majesty and Honour", "The Just One", "The Assembler of Scattered Creations", "The Self-Sufficient One", "The Bestower of Sufficiency",
            "The Preventer", "The Distressor", "The Bestower of Benefits", "The Prime Light", "The Provider of Guidance", "The Unique One",
            "The Ever Surviving One", "The Eternal Inheritor", "The Guide to Path of Rectitude", "The Extensively Enduring One"};


    ListView allah_name_recycler;
    LinearLayoutManager manager;
    ImageView back_press;
    AllahNamesAdapter adapter;
    ArrayList<Integer> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allah_names_layout);
        RelativeLayout adLayout=findViewById(R.id.adLayout);
        AdManger.init(this);
        AdManger.loadBannerAds(adLayout,this);
        back_press=findViewById(R.id.back_press);
        try {
            // for assets folder add empty string

            // for assets/subFolderInAssets add only subfolder name
            Field[] fields=R.raw.class.getDeclaredFields();
            for (int count=0;count<fields.length;count++){
                arrayList.add(fields[count].getInt(fields[count]));
            }

            // if(filelistInSubfolder == null) ............

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        allah_name_recycler=findViewById(R.id.ListView);

        adapter=new AllahNamesAdapter(this,imagesSmall,meaning,names,arrayList);

        allah_name_recycler.setAdapter(adapter);


        onclicks();

    }

    private void onclicks() {
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
