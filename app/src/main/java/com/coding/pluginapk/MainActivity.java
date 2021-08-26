package com.coding.pluginapk;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.coding.plugin.PluginManager;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        ((Button) this.findViewById(R.id.btn_load_apk)).setOnClickListener((OnClickListener) (new OnClickListener() {
            @Override
            public final void onClick(View it) {
                try {
                    PluginManager.INSTANCE.loadApk((Context) MainActivity.this, Objects.requireNonNull(AssetUtil.copyAssetToCache(MainActivity.this, "other-debug.apk")), "com.coding.other");
                    Toast.makeText((Context) MainActivity.this, (CharSequence) "load apk success", Toast.LENGTH_LONG).show();
                } catch (Exception var4) {
                    var4.printStackTrace();
                }

            }
        }));
        ((Button) this.findViewById(R.id.btn_to_plugin)).setOnClickListener((OnClickListener) (new OnClickListener() {
            @Override
            public final void onClick(View it) {
                try {
                    MainActivity.this.startApk();
                } catch (Exception var3) {
                    var3.printStackTrace();
                }

            }
        }));
    }

    public final void startApk() {
        PluginManager.INSTANCE.startActivity((Context) this, "com.coding.other.Main1Activity");
    }
}
