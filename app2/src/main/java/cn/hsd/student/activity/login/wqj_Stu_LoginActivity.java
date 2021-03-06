package cn.hsd.student.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import cn.hsd.student.R;
import cn.hsd.student.activity.logcat.StudentActivity;
import cn.hsd.student.activity.wqj_service.UserServices;

public class wqj_Stu_LoginActivity extends AppCompatActivity {
    private Button wqj_stu_bt;
    private TextView tv1;
    private TextView tv2;
    private TextView Stuinfo;
    private RadioButton rb_ture;
    private RadioButton rb_false;
    private RadioGroup rg;
    //SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_stu__login);
        tv1 = (TextView) findViewById(R.id.username_edit);
        tv2 = (TextView) findViewById(R.id.password_edit);
        Stuinfo = (TextView) findViewById(R.id.Stuinfo);
        //sp = this.getSharedPreferences("ifFirst", 0);
        wqj_stu_bt = (Button) findViewById(R.id.wqj_stu_log_button);
        rb_false = (RadioButton) findViewById(R.id.re_false);
        rg = (RadioGroup) findViewById(R.id.rg1);
        rb_ture = (RadioButton) findViewById(R.id.rb_true);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rb_ture.getId()) {
//                    Toast.makeText(wqj_Stu_LoginActivity.this,"true",Toast.LENGTH_LONG).show();
                    Intent intent1= new Intent(wqj_Stu_LoginActivity.this,InfoActivity.class);
                    startActivity(intent1);

                }
                else{
//                    Toast.makeText(wqj_Stu_LoginActivity.this,"false",Toast.LENGTH_LONG).show();
                    wqj_stu_bt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (tv1.length() == 0 && tv2.length() == 0) {
                                Toast.makeText(wqj_Stu_LoginActivity.this, "学号或密码不能为空", Toast.LENGTH_LONG).show();

                            } else if (tv1.length() < 10) {
                                Toast.makeText(wqj_Stu_LoginActivity.this, "学号错误或者格式不正确", Toast.LENGTH_LONG).show();
                            } else if (tv2.length() < 6) {
                                Toast.makeText(wqj_Stu_LoginActivity.this, "密码错误", Toast.LENGTH_LONG).show();

                            } else {

                                final Handler handler = new Handler() {
                                    @Override
                                    public void handleMessage(Message msg) {
                                        super.handleMessage(msg);
                                        if (msg.what == 0) {
                                            Toast.makeText(wqj_Stu_LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(wqj_Stu_LoginActivity.this, StudentActivity.class);
                                            startActivity(intent);
//                            String name=tv1.getText().toString();
//                            Stuinfo.setText(name);

                                        } else {
                                            Toast.makeText(wqj_Stu_LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                };
                                new Thread() {
                                    Message msg = new Message();

                                    @Override
                                    public void run() {
                                        String name = tv1.getText().toString();
                                        String pass = tv2.getText().toString();
                                        boolean result = UserServices.check(name, pass);
                                        if (result != true) {
                                            msg.what = 1;//false

                                        } else {
                                            msg.what = 0;//true

                                        }
                                        handler.sendMessage(msg);
                                    }
                                }.start();
                            }
                        }
                    });

                }
            }
        });
/*        wqj_stu_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv1.length() == 0 && tv2.length() == 0) {
                    Toast.makeText(wqj_Stu_LoginActivity.this, "学号或密码不能为空", Toast.LENGTH_LONG).show();

                } else if (tv1.length() < 10) {
                    Toast.makeText(wqj_Stu_LoginActivity.this, "学号错误或者格式不正确", Toast.LENGTH_LONG).show();
                } else if (tv2.length() < 6) {
                    Toast.makeText(wqj_Stu_LoginActivity.this, "密码错误", Toast.LENGTH_LONG).show();

                } else {

                    final Handler handler = new Handler() {
                        @Override
                        public void handleMessage(Message msg) {
                            super.handleMessage(msg);
                            if (msg.what == 0) {
                                Toast.makeText(wqj_Stu_LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(wqj_Stu_LoginActivity.this, StudentActivity.class);
                                startActivity(intent);
//                            String name=tv1.getText().toString();
//                            Stuinfo.setText(name);

                            } else {
                                Toast.makeText(wqj_Stu_LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                            }
                        }
                    };
                    new Thread() {
                        Message msg = new Message();

                        @Override
                        public void run() {
                            String name = tv1.getText().toString();
                            String pass = tv2.getText().toString();
                            boolean result = UserServices.check(name, pass);
                            if (result != true) {
                                msg.what = 1;//false

                            } else {
                                msg.what = 0;//true

                            }
                            handler.sendMessage(msg);
                        }
                    }.start();
                }
            }
        });*/

    }

}

   /* public class StuBtuOnClickListener implements View.OnClickListener{
        public void onClick(View v){
            *//*if(tv2.length()==0||tv1.length()==0){
                Toast.makeText(wqj_Stu_LoginActivity.this,"学号或密码不能为空",Toast.LENGTH_LONG).show();
            }
            else if(tv1.length()<10){
                Toast.makeText(wqj_Stu_LoginActivity.this,"学号格式错误或者长度不够",Toast.LENGTH_LONG).show();
            }
            else if(tv2.length()<6){
                Toast.makeText(wqj_Stu_LoginActivity.this,"密码错误",Toast.LENGTH_LONG).show();
            }
            else{
                String name=tv1.getText().toString();
                String pass=tv2.getText().toString();
                boolean result= UserServices.check(name,pass);
                if(result)
                {
                    Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(getApplicationContext(),"登录失败",Toast.LENGTH_LONG).show();
                }
            }*//*
            final Handler handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    if (msg.what == 0) {
                        Toast.makeText(wqj_Stu_LoginActivity.this, "success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(wqj_Stu_LoginActivity.this, "fail", Toast.LENGTH_SHORT).show();
                    }
                }
            };
            new Thread() {
                Message msg = new Message();

                @Override
                public void run() {
                    String name = tv1.getText().toString();
                    String pass = tv2.getText().toString();

                    boolean result = UserServices.check(name, pass);
                    if (result != true) {
                        msg.what = 1;//false
                    } else {
                        msg.what = 0;//true
                    }
                    handler.sendMessage(msg);
                }
            }.start();
        }
    });*/





