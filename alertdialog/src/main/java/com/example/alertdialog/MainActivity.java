package com.example.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    final String[] star = new String[]{"美女教师", "性感少妇", "可爱萝莉", "可爱御姐", "清纯妹子", "性感白领", "兔儿女仆"};
    AlertDialog.Builder dialog;
    int picWhich;
    boolean[] chk = new boolean[]{false, false, false, false, false, false, false};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //提示对话框
    public void button(View view) {
        dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("温馨提示");
        dialog.setIcon(R.drawable.calendar3);
        dialog.setMessage("确定要关闭本应用程序吗？");
        //确定的点击事件,匿名内部类
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        //取消的点击事件,匿名内部类
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        dialog.show();
    }

    //提示对话框2
    public void button0(View view) {
        dialog = new AlertDialog.Builder(this).setTitle("温馨提示")
                .setIcon(R.drawable.weibo).setMessage("确定要关闭本应用程序吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        dialog.show();
    }

    //单选对话框
    public void button1(View view) {
        dialog = new AlertDialog.Builder(MainActivity.this).setTitle("选择角色").setIcon(R.drawable.taobao).setSingleChoiceItems(
                star, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        picWhich = i;
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "你选定角色是："
                        + star[picWhich], Toast.LENGTH_LONG).show();
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }

    //多选对话框
    public void button2(View view) {
        dialog = new AlertDialog.Builder(this).setTitle("请选择职业").setMultiChoiceItems(star, chk, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                chk[i] = b;
            }
        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = " ";
                for (i = 0; i < chk.length; i++) {
                    if (chk[i])
                        str += star[i] + "";
                    Toast.makeText(MainActivity.this, "你选择的妹子有：" + str, Toast.LENGTH_SHORT).show();
                }
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }

    //列表对话框
    public void button3(View view) {
        dialog = new AlertDialog.Builder(this).setTitle("请选择职业").setIcon(R.drawable.mi)
                .setItems(star, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        picWhich = i;
                        Toast.makeText(MainActivity.this, "你选定角色是："
                                + star[picWhich], Toast.LENGTH_LONG).show();
                    }
                });
        dialog.show();
    }

}