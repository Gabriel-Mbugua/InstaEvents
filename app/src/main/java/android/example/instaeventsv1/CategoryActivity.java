package android.example.instaeventsv1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    List<CategoryModel> mCategoryModel1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        mCategoryModel1 = new ArrayList<>();
        mCategoryModel1.add(new CategoryModel("Technology","Description of event",R.drawable.smart_tv));
        mCategoryModel1.add(new CategoryModel("Social","Description of event",R.drawable.network));
        mCategoryModel1.add(new CategoryModel("Learning","Description of event",R.drawable.brainicon));
        mCategoryModel1.add(new CategoryModel("Family","Description of event",R.drawable.family));
        mCategoryModel1.add(new CategoryModel("Fitness","Description of event",R.drawable.fitness));

        mCategoryModel1.add(new CategoryModel("Technology","Description of event",R.drawable.smart_tv));
        mCategoryModel1.add(new CategoryModel("Social","Description of event",R.drawable.network));
        mCategoryModel1.add(new CategoryModel("Learning","Description of event",R.drawable.brainicon));
        mCategoryModel1.add(new CategoryModel("Family","Description of event",R.drawable.family));
        mCategoryModel1.add(new CategoryModel("Fitness","Description of event",R.drawable.fitness));

        RecyclerView categoryRecycler = (RecyclerView) findViewById(R.id.recyclerView_category);
        CategoryAdapter myAdapter = new CategoryAdapter(this, mCategoryModel1);
        categoryRecycler.setLayoutManager(new GridLayoutManager(this,3));
        categoryRecycler.setAdapter(myAdapter);
    }
}
