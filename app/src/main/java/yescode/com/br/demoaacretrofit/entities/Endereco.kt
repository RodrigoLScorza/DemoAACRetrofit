package yescode.com.br.demoaacretrofit.entities

/**
 * Created by Rodrigo on 03/03/2018.
 */

data class Endereco(val cep: String, val logradouro: String, val complemento: String, val bairro: String,
                    val localidade: String, val uf: String, val unidade: String, val ibge: String, val gia: String)