package pt.apt.testedaltonismo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil.*
import pt.apt.testedaltonismo.databinding.ActivityTesteBinding


class TesteActivity : AppCompatActivity() {

    lateinit var binding: ActivityTesteBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        binding = setContentView(this, R.layout.activity_teste);

        var param = intent.extras?.getInt("image");

        binding.apply {
            when (param) {
                1 -> {
                    testeImageView.setImageResource(R.drawable.teste01);
                }
                2 -> {
                    testeImageView.setImageResource(R.drawable.teste02);
                }
                3 -> {
                    testeImageView.setImageResource(R.drawable.teste03);
                }
            }
        }

        binding.confirmarButton.setOnClickListener {
            var intent = Intent();
            var resposta = binding.entradaEditTextNumber.text.toString();
            if(resposta != ""){
                intent.putExtra("RESPOSTA", resposta);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }else{
                Toast.makeText(this, "Coloque uma resposta ou cancele o teste.", Toast.LENGTH_LONG ).show()
            }


        }


        binding.cacelarButton.setOnClickListener {
            val intent = Intent();
            intent.putExtra("VOLTAR", "Cancelado");
            setResult(Activity.RESULT_CANCELED, intent);
            finish();
        }
    }
}