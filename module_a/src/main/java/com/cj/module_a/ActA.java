package com.cj.module_a;

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

@Route(path = "/module_a/act/a")
public class ActA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_a);

        ModuleBus.getInstance().of(Gen$module_a$Interface.class).Gen$event_1$Method().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(ActA.this, s, Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.tob).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/module_b/act/b").navigation();
                ModuleBus.getInstance().of(Gen$module_b$Interface.class).Gen$eee$Method().post("moduleA send msg to moduleB");
            }
        });
    }
}
