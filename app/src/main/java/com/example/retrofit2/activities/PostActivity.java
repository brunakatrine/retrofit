
package com.example.retrofit2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import com.example.retrofit2.R;
import com.example.retrofit2.bootstrap.APIClient;
import com.example.retrofit2.model.Post;
import com.example.retrofit2.resource.PostResource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostActivity extends AppCompatActivity {

    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
    }

    /**
     * Método de exemplo para listar os dados de um serviço na internet
     * Utilizando o retrofit
     */
    public void listarPosts(View view){

        //Passo 6 - Criar função para trabalhar com o retrofit
        Retrofit retrofit = APIClient.getClient();

        //Passo 7
        //Fazer a IoC e injeção de dependência da interface (contrato) PostResource
        PostResource postResource = retrofit.create(PostResource.class);

        //Passo 8 - Fazer o método/operação preterido.
        Call<List<Post>> lista = postResource.get();

        //Passo 9 - Utilizar a estrutura de dados FILA (FIFO) para trabalhar com chamadas
        // assincronas.

        lista.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                //O método onResponse retorna os dados do recurso(resource) consumido.
                List<Post> posts = response.body();

                //laço de repetição padrão
                for(int i=0;i<posts.size();i++){
                    Log.i("post",String.format("%d %s",i,posts.get(i).toString()));
                }

//                posts.stream().forEach(p->{
//                    Log.i("post",String.format("%s",p.toString()));
//                });


            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                //Método responsáve para tratar erro
                Toast.makeText(getApplicationContext(),
                        "Ocorreu um erro no serviço.",
                        Toast.LENGTH_LONG).show();
            }
        });


    }
}