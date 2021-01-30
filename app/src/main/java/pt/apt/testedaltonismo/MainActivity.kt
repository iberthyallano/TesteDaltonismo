package pt.apt.testedaltonismo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil.*
import pt.apt.testedaltonismo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        binding = setContentView(this, R.layout.activity_main);

        binding.teste01Button.setOnClickListener {
            val intent = Intent(this, TesteActivity::class.java);
            intent.putExtra("image", 1);
            startActivityForResult(intent, 1);
        }

        binding.teste02Button.setOnClickListener {
            val intent = Intent(this, TesteActivity::class.java);
            intent.putExtra("image", 2);
            startActivityForResult(intent, 2);
        }

        binding.teste03Button.setOnClickListener {
            val intent = Intent(this, TesteActivity::class.java);
            intent.putExtra("image", 3);
            startActivityForResult(intent, 3);
        }

        binding.verificaButton.setOnClickListener {
            if (binding.resposta01TextView.text == "Resposta_1" || binding.resposta02TextView.text == "Resposta_2" || binding.resposta03TextView.text == "Resposta_3") {
                Toast.makeText(this, "Realize todos os testes!", Toast.LENGTH_LONG ).show()
            } else {
                if (binding.resposta01TextView.text == "29" && binding.resposta02TextView.text == "74" && binding.resposta03TextView.text == "8") {
                    binding.resultadoTextView.text = "Visao normal";
                } else {
                    binding.resultadoTextView.text = "Daltonico";
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                1 -> {
                    binding.resposta01TextView.text = data?.getStringExtra("RESPOSTA").toString();
                }
                2 -> {
                    binding.resposta02TextView.text = data?.getStringExtra("RESPOSTA").toString();
                }
                3 -> {
                    binding.resposta03TextView.text = data?.getStringExtra("RESPOSTA").toString();
                }
            }
        }
    }

}

