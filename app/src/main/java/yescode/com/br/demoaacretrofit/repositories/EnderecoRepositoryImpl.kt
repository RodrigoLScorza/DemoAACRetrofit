package yescode.com.br.demoaacretrofit.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import yescode.com.br.demoaacretrofit.api.EnderecoAPI
import yescode.com.br.demoaacretrofit.entities.Endereco
import yescode.com.br.demoaacretrofit.entities.EnderecoResponse

/**
 * Created by Rodrigo on 03/03/2018.
 */
class EnderecoRepositoryImpl : EnderecoRepository {

    private val enderecoAPI: EnderecoAPI

    override fun buscarEndereco(cep: String): LiveData<EnderecoResponse> {

        val liveData = MutableLiveData<EnderecoResponse>()

        enderecoAPI.pesquisar(cep)
                .enqueue(object : Callback<Endereco> {
                    override fun onResponse(call: Call<Endereco>?, response: Response<Endereco>?) {
                        liveData.value = EnderecoResponse(response?.body()!!)
                    }

                    override fun onFailure(call: Call<Endereco>?, t: Throwable?) {
                        liveData.value = EnderecoResponse(t!!)
                    }
                })
        return liveData
    }

    //funciona como um construtor inicia classes e objetos
    init {
        val retrofit = Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create()).
                baseUrl("https://viacep.com.br").
                build()

        enderecoAPI = retrofit.create(EnderecoAPI::class.java)
    }

}