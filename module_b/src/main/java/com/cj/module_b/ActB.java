package com.cj.module_b;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cj.module_base.bus.ModuleBus;

import java.util.ArrayList;
import java.util.List;

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
                Toast.makeText(ActB.this, "ActB收到消息"+s, Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.toa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Boolean> l = new ArrayList<>();
                l.add(true);
                l.add(false);
                ModuleBus.getInstance().of(Gen$module_b$Interface.class).Gen$testList$Method().post(l);
                ARouter.getInstance().build("/module_a/act/a").navigation();
            }
        });
    }
}
