package jp.ac.meijou.android.s241205043;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import jp.ac.meijou.android.s241205043.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //ここから
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //ここまで
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.text.setText(R.string.text);

        binding.button.setOnClickListener((view -> {
            var word = binding.editTextText.getText().toString();
            var memo = binding.editTextText2.getText().toString();
            binding.text.setText(word);
            binding.textView.setText(memo);
        }));

        binding.editTextText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence,int i, int i1, int i2){
                //テキストが更新される直前に呼ばれる
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2){
                //文字を1つ入力されたときに呼ばれる
            }

            @Override
            public void afterTextChanged(Editable editable){
                //テキストが更新された後に呼ばれる
                binding.text.setText(editable.toString());  //editableに変更後の文字が渡される
            }
        });
    }
}