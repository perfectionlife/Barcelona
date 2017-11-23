package comanddrey_1.twitter.newb2;

        import android.annotation.SuppressLint;
        import android.content.Intent;
        import android.support.annotation.NonNull;
        import android.support.design.internal.BottomNavigationItemView;
        import android.support.design.internal.BottomNavigationMenuView;
        import android.support.design.widget.BottomNavigationView;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentTransaction;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.MenuItem;
        import android.support.v7.widget.Toolbar;
        import android.view.View;

        import java.lang.reflect.Field;

        import comanddrey_1.twitter.newb2.fragment.FiveFragment;
        import comanddrey_1.twitter.newb2.fragment.FourFragment;
        import comanddrey_1.twitter.newb2.fragment.OneFragment;
        import comanddrey_1.twitter.newb2.fragment.ThreeFragment;
        import comanddrey_1.twitter.newb2.fragment.TwoFragment;

public class MainActivity extends AppCompatActivity {

    private OneFragment oneFragment = new OneFragment();
    private TwoFragment twoFragment = new TwoFragment();
    private ThreeFragment threeFragment = new ThreeFragment();
    private FourFragment fourFragment = new FourFragment();
    private FiveFragment fiveFragment = new FiveFragment();
    private FragmentManager manager;
    private FragmentTransaction transaction;

    private BottomNavigationView bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();
        fourFragment = new FourFragment();
        fiveFragment = new FiveFragment();


        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.container, threeFragment, threeFragment.TAG);
        transaction.commit();

        bottomNavigation = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigation.setSelectedItemId(R.id.button_menu_3);
        bottomNavigation.setOnNavigationItemSelectedListener(getBottomNavigationListener());
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


    }

    public void onClick(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }


    public static class BottomNavigationViewHelper {
        @SuppressLint("RestrictedApi")
        public static void disableShiftMode(BottomNavigationView view) {
            BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
            try {
                Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
                shiftingMode.setAccessible(true);
                shiftingMode.setBoolean(menuView, false);
                shiftingMode.setAccessible(false);
                for (int i = 0; i < menuView.getChildCount(); i++) {
                    BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                    //noinspection RestrictedApi
                    item.setShiftingMode(false);
                    // set once again checked value, so view will be updated
                    //noinspection RestrictedApi
                    item.setChecked(item.getItemData().isChecked());
                }
            } catch (NoSuchFieldException e) {
                Log.e("BNVHelper", "Unable to get shift mode field", e);
            } catch (IllegalAccessException e) {
                Log.e("BNVHelper", "Unable to change value of shift mode", e);
            }
        }
    }


    @NonNull
    private BottomNavigationView.OnNavigationItemSelectedListener getBottomNavigationListener() {
        return new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.button_menu_1:
                        transaction = manager.beginTransaction();
                        if (manager.findFragmentByTag(OneFragment.TAG) == null) {
                            transaction.add(R.id.container, oneFragment, OneFragment.TAG);
                            if (manager.findFragmentByTag(TwoFragment.TAG ) != null
                                    || manager.findFragmentByTag(ThreeFragment.TAG ) != null
                                    || manager.findFragmentByTag(FourFragment.TAG ) != null
                                    || manager.findFragmentByTag(FiveFragment.TAG ) != null)
                                transaction.replace(R.id.container, oneFragment, oneFragment.TAG);
                        } else transaction.replace(R.id.container, oneFragment, oneFragment.TAG);
                        transaction.commit();
                        break;

                    case R.id.button_menu_2:
                        transaction = manager.beginTransaction();
                        if (manager.findFragmentByTag(TwoFragment.TAG) == null) {
                            transaction.add(R.id.container, twoFragment, TwoFragment.TAG);
                            if (manager.findFragmentByTag(OneFragment.TAG ) != null
                                    || manager.findFragmentByTag(ThreeFragment.TAG ) != null
                                    || manager.findFragmentByTag(FourFragment.TAG ) != null
                                    || manager.findFragmentByTag(FiveFragment.TAG ) != null)
                                transaction.replace(R.id.container, twoFragment, twoFragment.TAG);
                        } else transaction.replace(R.id.container, twoFragment, twoFragment.TAG);
                        transaction.commit();
                        break;

                    case R.id.button_menu_3:
                        transaction = manager.beginTransaction();
                        if (manager.findFragmentByTag(ThreeFragment.TAG) == null) {
                            transaction.add(R.id.container, threeFragment, ThreeFragment.TAG);
                            if (manager.findFragmentByTag(OneFragment.TAG ) != null
                                    || manager.findFragmentByTag(TwoFragment.TAG ) != null
                                    || manager.findFragmentByTag(FourFragment.TAG ) != null
                                    || manager.findFragmentByTag(FiveFragment.TAG ) != null)
                                transaction.replace(R.id.container, threeFragment, threeFragment.TAG);
                        } else transaction.replace(R.id.container, threeFragment, threeFragment.TAG);
                        transaction.commit();
                        break;

                    case R.id.button_menu_4:
                        transaction = manager.beginTransaction();
                        if (manager.findFragmentByTag(FourFragment.TAG) == null) {
                            transaction.add(R.id.container, fourFragment, FourFragment.TAG);
                            if (manager.findFragmentByTag(OneFragment.TAG ) != null
                                    || manager.findFragmentByTag(TwoFragment.TAG ) != null
                                    || manager.findFragmentByTag(ThreeFragment.TAG ) != null
                                    || manager.findFragmentByTag(FiveFragment.TAG ) != null)
                                transaction.replace(R.id.container, fourFragment, fourFragment.TAG);
                        } else transaction.replace(R.id.container, fourFragment, fourFragment.TAG);
                        transaction.commit();
                        break;

                    case R.id.button_menu_5:
                        transaction = manager.beginTransaction();
                        if (manager.findFragmentByTag(FiveFragment.TAG) == null) {
                            transaction.add(R.id.container, fiveFragment, FiveFragment.TAG);
                            if (manager.findFragmentByTag(OneFragment.TAG ) != null
                                    || manager.findFragmentByTag(TwoFragment.TAG ) != null
                                    || manager.findFragmentByTag(ThreeFragment.TAG ) != null
                                    || manager.findFragmentByTag(FourFragment.TAG ) != null)
                                transaction.replace(R.id.container, fiveFragment, fiveFragment.TAG);
                        } else transaction.replace(R.id.container, fiveFragment, fiveFragment.TAG);
                        transaction.commit();
                        break;

                }
                return true;
            }
        };
    }
}

