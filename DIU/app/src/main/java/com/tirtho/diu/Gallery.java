package com.tirtho.diu;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.tirtho.diu.gallery.DataAdapter;
import com.tirtho.diu.gallery.ImageUrl;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {
    private ImageView imageView;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        imageView = (ImageView) findViewById(R.id.imageView);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        ArrayList imageUrlList = prepareData();
        DataAdapter dataAdapter = new DataAdapter(getApplicationContext(), imageUrlList);
        recyclerView.setAdapter(dataAdapter);
        
    }

    private ArrayList prepareData() {


        String imageUrls[] = {
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/71295241_3389588087725690_1294299428420583424_n-1.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/71896120_3376655325685633_3931092250729119744_n-868x576.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/73349349_3427550693929429_3697439617440546816_n-960x576.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/73446308_3494596293891535_6326782359412670464_n.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/74488582_3565381956812968_978348341203042304_o-960x576.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/88185948_3904147299603097_3640911925065285632_n-960x576.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/87952335_3878013975549763_6758019654574145536_o-960x576.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/86461793_3833653309985830_1255316071859093504_o-960x576.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/86280816_3837101576307670_1919499027217383424_o.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/83091678_3766458840038611_5936403277116604416_o-960x576.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/82326666_3728128793871616_5097075124545257472_o.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/82326666_3728128793871616_5097075124545257472_o.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/81588544_3701653313185831_8441872341864022016_o.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/81456972_3702321126452383_4667672016642375680_o.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/79528120_3638264419524721_7003367539644301312_o-960x576.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/Transport%20(1).jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/Research-cells.jpg",
                "https://github.com/rktirtho/Dhaka-International-University/blob/master/Gallary/Prof.-Dr.-Hafiz-Md.-Hasan-Babu-is-delivering-presentation-on-Cyber-Security-in-the-Banking-System-of-Bangladesh-960x576.jpg?raw=true",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/Photo.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/Library.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/Labs-Laboratory.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/Labs-Laboratory%20(1).jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/IEB-Workshop-1.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/Clubs.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/Canteen-Common-Room.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/89070792_3136632809702993_4223126838328688640_n-960x576.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/88973741_3910577875626706_3777217917704208384_o-copy.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/slide2.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/six-covocation5.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/second-covocation6.jpg",
                "https://github.com/rktirtho/Dhaka-International-University/blob/master/Gallary/second-covocation.jpg?raw=true",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/convocation-img1.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/b66e8ffc3eca29480a7212332ea82fd1-5d9b2eca5864e.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/Untitled-1-copy.jpg",
                "https://raw.githubusercontent.com/rktirtho/Dhaka-International-University/master/Gallary/Transport.jpg"
        };

        ArrayList imageUrlList = new ArrayList<>();
        for (int i = 0; i < imageUrls.length; i++) {
            ImageUrl imageUrl = new ImageUrl();
            imageUrl.setImageUrl(imageUrls[i]);
            imageUrlList.add(imageUrl);
        }
        Log.d("MainActivity", "List count: " + imageUrlList.size());
        return imageUrlList;
    }
}