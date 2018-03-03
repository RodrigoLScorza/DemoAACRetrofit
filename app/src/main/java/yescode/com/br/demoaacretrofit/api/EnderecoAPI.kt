package yescode.com.br.demoaacretrofit.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import yescode.com.br.demoaacretrofit.entities.Endereco

/**
 * Created by Rodrigo on 03/03/2018.
 */
interface EnderecoAPI{

    @GET("ws/{cep}/json")
    fun pesquisar(@Path("cep")cep:String): Call<Endereco>

}