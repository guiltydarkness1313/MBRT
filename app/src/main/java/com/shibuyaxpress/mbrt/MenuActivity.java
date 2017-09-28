package com.shibuyaxpress.mbrt;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        TextView user=navigationView.getHeaderView(0).findViewById(R.id.txt_name);
        TextView username=navigationView.getHeaderView(0).findViewById(R.id.txt_username);
        CircleImageView imagen=navigationView.getHeaderView(0).findViewById(R.id.profile_image);
        user.setText(User.getInstance().getName());
        username.setText(User.getInstance().getUsername());
        Glide.with(getApplicationContext()).load(User.getInstance().getImgprofile()).into(imagen);
        navigationView.setNavigationItemSelectedListener(this);

        addMenuIteminNavMenuDrawer();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        /*if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //agregar menus dinamicamente
    private void addMenuIteminNavMenuDrawer(){
        NavigationView nav=(NavigationView)findViewById(R.id.nav_view);
        Menu menu=nav.getMenu();
        Menu submenu1;
            switch (User.getInstance().getRole()){
                case "cliente":
                    submenu1=menu.addSubMenu("Opciones Cliente");
                    submenu1.add("Registrar Ticket Nuevo");
                    submenu1.add("Consultar estado de sus tickets");
                    break;
                case "supervisor":
                    submenu1=menu.addSubMenu("Opciones Supervisor");
                    submenu1.add("Registrar Ticket Nuevo");
                    submenu1.add("Consultar estado de sus tickets");
                    submenu1.add("Reporte de tickets");
                    break;
                case "tecnico":
                    submenu1=menu.addSubMenu("Opciones Técnico");
                    submenu1.add("Consultar tickets asignados");
                    submenu1.add("Atender tickets asignados");
                    break;
            }
        Menu submenu=menu.addSubMenu("Opciones");

        submenu.add(0,0,0,"Perfil").setShortcut('3','c');
        submenu.add(0,1,0,"Configuración").setShortcut('3','c');
        submenu.add(0,1,0,"Cerrar Sesión").setShortcut('3','c');

        nav.invalidate();
    }
}
