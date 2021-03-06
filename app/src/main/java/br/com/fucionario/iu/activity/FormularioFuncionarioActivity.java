package br.com.fucionario.iu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.fucionario.R;
import br.com.fucionario.dao.FuncionarioDAO;
import br.com.fucionario.model.Funcionario;

public class FormularioFuncionarioActivity extends AppCompatActivity {

    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_funcionario);
        setTitle("Cadastro de Novo Funcionario");
        final FuncionarioDAO dao = new FuncionarioDAO();
        inicializarCampos();
        Button botaoSalvar = findViewById(R.id.activity_formulario_funcionario_botao_salvar);

        botaoSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Funcionario funcionario = criarFuncionario();
                salvarFuncionario(funcionario, dao);
            }
        });

    }

    private void inicializarCampos() {
        campoNome = findViewById(R.id.activity_formulario_funcionario_nome);
        campoTelefone = findViewById(R.id.activity_formulario_funcionario_telefone);
        campoEmail = findViewById(R.id.activity_formulario_funcionario_email);
    }

    private void salvarFuncionario(Funcionario funcionario, FuncionarioDAO dao) {
        dao.salvar(funcionario);
        finish();
    }

    private Funcionario criarFuncionario() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();
        return new Funcionario(nome, telefone, email);
    }
}

