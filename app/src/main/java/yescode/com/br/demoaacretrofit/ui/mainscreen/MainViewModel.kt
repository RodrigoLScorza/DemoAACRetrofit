package yescode.com.br.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import yescode.com.br.demoaacretrofit.entities.EnderecoResponse
import yescode.com.br.demoaacretrofit.repositories.EnderecoRepository
import yescode.com.br.demoaacretrofit.repositories.EnderecoRepositoryImpl

/**
 * Created by Rodrigo on 03/03/2018.
 */

// se nao precisa de contexto ViewModel se precisar utilizar AndroidViewModel
class MainViewModel : ViewModel() {

    private val enderecoRepository: EnderecoRepository
    private val mApiResponse: MediatorLiveData<EnderecoResponse> = MediatorLiveData()

    val apiResponse: LiveData<EnderecoResponse>
        get() = mApiResponse

    init {
        enderecoRepository = EnderecoRepositoryImpl()
    }

    fun pesquisarEndereco(cep: String): LiveData<EnderecoResponse> {
        mApiResponse.addSource(enderecoRepository.buscarEndereco(cep)) { apiResponse ->
            mApiResponse.value = apiResponse
        }
        return mApiResponse
    }

}