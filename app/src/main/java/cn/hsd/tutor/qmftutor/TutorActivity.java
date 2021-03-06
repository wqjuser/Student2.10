package cn.hsd.tutor.qmftutor;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import cn.hsd.sett.TusetActivity;
import cn.hsd.student.R;
import cn.hsd.student.activity.gxq_class.gxqStatic;
import cn.hsd.tutor.Stu_log.VistlogActivity;
import cn.hsd.tutor.cxsxzj.CksxzjActivity;
import cn.hsd.tutor.gxq_teacher.Apply_gxqshow_Activity;
import cn.hsd.tutor.gxq_teacher.gxq_teacher_Activity;

public class TutorActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView tv1;
    private ImageView iv1;
    private Button bt1;

    private final int OPEN_RESULT = 1;
    private final int PICK_RESULT = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutor_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView=navigationView.getHeaderView(0);
        tv1=(TextView)headerView.findViewById(R.id.hq_info_tu);
        tv1.setText(gxqStatic.info);
        iv1 = (ImageView) headerView.findViewById(R.id.tu_iv);
    }

    public void camera(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(TutorActivity.this);
        builder.setTitle("选择拍照方式");
        builder.setPositiveButton("本地图片", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_RESULT);

            }
        });
        builder.setNegativeButton("相机拍照", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(
                        android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, OPEN_RESULT);
            }
        });
        builder.show();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tutor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.refer_sign) {
            Intent intent = new Intent(TutorActivity.this,gxq_teacher_Activity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.refer_log) {
            Intent intent2 = new Intent(TutorActivity.this, VistlogActivity.class);
            startActivity(intent2);

        } else if (id == R.id.assign_goodb) {
            Intent intent3=new Intent();
            intent3.setClass(this,Tutor_Good_student.class);
            startActivity(intent3);
        } else if (id == R.id.assess_grade) {
            Intent intent4=new Intent();
            intent4.setClass(this,tutor_mete_grade.class);
            startActivity(intent4);

        } else if (id == R.id.tutor_leaveword) {
            Intent intent5=new Intent();
            intent5.setClass(this,tutor_LeaveWord.class);
            startActivity(intent5);

        } else if (id == R.id.assess_leave) {
            Intent intent6 = new Intent(TutorActivity.this, Apply_gxqshow_Activity.class);
            startActivity(intent6);

        }else if (id == R.id.refer_summary) {
            Intent intent7 = new Intent(TutorActivity.this, CksxzjActivity.class);
            startActivity(intent7);

        } else if (id == R.id.tu_setting) {
            Intent intent7 = new Intent(TutorActivity.this, TusetActivity.class);
            startActivity(intent7);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
