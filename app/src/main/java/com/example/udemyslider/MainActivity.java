package com.example.udemyslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView cityName;
    private TabLayout tabLayout;
    private ViewPager citiesViewPager;
    private RadioGroup rgCities;

    private ArrayList<City> cities;
    private ViewPagerAdapter adapter;
    private City selectedCity ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        cities = new ArrayList<>();
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        initializeCities();

        citiesViewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(citiesViewPager);

        selectedCity = getCityByName("London");

        ArrayList<imagefragments> fragments = new ArrayList<>();


        for(int i =0 ; i <selectedCity.getImageUrls().size(); i++)
        {
            imagefragments imf = new imagefragments();
            Bundle bundle = new Bundle();
            bundle.putString("imageUrl" , selectedCity.getImageUrls().get(i));
            imf.setArguments(bundle);
            fragments.add(imf);
        }
        adapter.setFragments(fragments);
        cityName.setText(selectedCity.getName());

        rgCities.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                cityChanged(checkedId);
            }
        });
    }

    private void cityChanged(int rbId){
        switch  (rbId){
            case R.id.rbLondon:
                selectedCity = getCityByName("London");
                break;
            case R.id.rbNewYork:
                selectedCity = getCityByName("New York");
                break;
            case R.id.rbTokyo:
                selectedCity = getCityByName("Tokyo");
                break;
            case R.id.rbIndia:
                selectedCity = getCityByName("India");
                break;
            default:
                break;
        }
        
        if(null != selectedCity){
            cityName.setText(selectedCity.getName());

            ArrayList<imagefragments> fragments = new ArrayList<>();

            
            for(int i =0 ; i <selectedCity.getImageUrls().size(); i++)
            {
                imagefragments imf = new imagefragments();
                Bundle bundle = new Bundle();
                bundle.putString("imageUrl" , selectedCity.getImageUrls().get(i));
                imf.setArguments(bundle);
                fragments.add(imf);
            }
            adapter.setFragments(fragments);
        }
    }
    
    private City getCityByName (String name){
        for(City city:cities)
            if(city.getName().equals(name)){
                return city;
            }
        return null;
    }
    

    private void initViews(){
        cityName = (TextView)findViewById(R.id.txtCityName);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        citiesViewPager = (ViewPager)findViewById(R.id.citiesViewPager);
        rgCities = (RadioGroup)findViewById(R.id.rgCities);
    }

    private void initializeCities() {
        City london = new City();
        london.setName("London");
        ArrayList<String> londonImageUrls = new ArrayList<>();

        londonImageUrls.add("https://image.shutterstock.com/image-photo/aerial-panoramic-cityscape-view-london-260nw-551334580.jpg");
        londonImageUrls.add("https://image.shutterstock.com/image-photo/aerial-panoramic-cityscape-view-london-260nw-551334580.jpg");
        londonImageUrls.add("https://image.shutterstock.com/image-photo/panorama-tower-bridge-sunset-london-260nw-750033364.jpg");
        londonImageUrls.add("https://image.shutterstock.com/image-photo/aerial-panoramic-cityscape-view-london-260nw-551334580.jpg");


        london.setImageUrls(londonImageUrls);

        cities.add(london);

        City tokyo = new City();
        tokyo.setName("Tokyo");
        ArrayList<String> tokyoImageUrls = new ArrayList<>();

        tokyoImageUrls.add("https://images.unsplash.com/photo-1540959733332-eab4deabeeaf?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        tokyoImageUrls.add("https://i0.wp.com/www.director.co.uk/wp-content/uploads/Tokyo-city-landscape.jpg?fit=1000%2C500&ssl=1");
        tokyoImageUrls.add("https://images.unsplash.com/photo-1540959733332-eab4deabeeaf?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        tokyoImageUrls.add("https://i0.wp.com/www.director.co.uk/wp-content/uploads/Tokyo-city-landscape.jpg?fit=1000%2C500&ssl=1");


        tokyo.setImageUrls(tokyoImageUrls);

        cities.add(tokyo);

        City newYork = new City();
      newYork.setName("New York");
        ArrayList<String> newYorkImageUrls = new ArrayList<>();

        newYorkImageUrls.add("https://media.gettyimages.com/photos/aerial-view-of-lower-manhattan-new-york-picture-id946087016?s=612x612");
        newYorkImageUrls.add("https://media.gettyimages.com/photos/aerial-view-of-lower-manhattan-new-york-picture-id946087016?s=612x612");
        newYorkImageUrls.add("https://media.gettyimages.com/photos/aerial-view-of-lower-manhattan-new-york-picture-id946087016?s=612x612");
        newYorkImageUrls.add("https://media.gettyimages.com/photos/aerial-view-of-lower-manhattan-new-york-picture-id946087016?s=612x612");

        newYork.setImageUrls(newYorkImageUrls);

        cities.add(newYork);

        City india = new City();
        india.setName("India");
        ArrayList<String> indiaImageUrls = new ArrayList<>();

        indiaImageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQwQfImGsZNK0Jui4-eR5H77oYCmUjHcYFdc7mq342exC7qBC0e");
        indiaImageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSRlpH82u_P5E10fxxEnmtGtsyt5rgUhawZ15MGVi1GSTM4QHAL");
        indiaImageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQwQfImGsZNK0Jui4-eR5H77oYCmUjHcYFdc7mq342exC7qBC0e");
        indiaImageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSRlpH82u_P5E10fxxEnmtGtsyt5rgUhawZ15MGVi1GSTM4QHAL");


        india.setImageUrls(indiaImageUrls);

        cities.add(india);
    }
}
