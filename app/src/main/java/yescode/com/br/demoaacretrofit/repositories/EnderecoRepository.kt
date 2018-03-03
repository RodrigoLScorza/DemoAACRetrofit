package yescode.com.br.demoaacretrofit.repositories

import android.arch.lifecycle.LiveData
import yescode.com.br.demoaacretrofit.entities.EnderecoResponse

/**
 * Created by Rodrigo on 03/03/2018.
 */
interface EnderecoRepository{

    //live data funciona como um observador
    fun buscarEndereco(cep:String): LiveData<EnderecoResponse>
}