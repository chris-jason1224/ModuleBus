package com.cj.module_b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cj.module_base.bus.ModuleBus;

import gen.com.cj.bus.Gen$module_a$Interface;
import gen.com.cj.bus.Gen$module_b$Interface;

@Route(path = "/module_b/act/b")
public class ActB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_b);
        ModuleBus.getInstance().of(Gen$module_b$Interface.class).Gen$eee$Method().observeSticky(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(ActB.this, s, Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.toa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModuleBus.getInstance().of(Gen$module_a$Interface.class).Gen$event_1$Method().post("moduleB send msg to moduleA");
                ARouter.getInstance().build("/module_a/act/a").navigation();
            }
        });
    }
}
