package yescode.com.br.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import yescode.com.br.demoaacretrofit.R

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        btBusca.setOnClickListener {
            mainViewModel.pesquisarEndereco(edtCep.text.toString())
        }

        mainViewModel.apiResponse.observe(this, Observer { apiResponse ->
            if (apiResponse?.erro == null) {
                Log.i("TAG", "SUCESSO")

                val endereco = apiResponse?.endereco

                tvEndereco.text = "Rua/AV: ${endereco?.logradouro} \n Bairro: ${endereco?.bairro}"


            } else {
                Log.i("TAG", "ERRO")

            }
        })
    }
}
