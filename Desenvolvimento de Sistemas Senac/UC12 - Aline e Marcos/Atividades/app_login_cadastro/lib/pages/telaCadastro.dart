import 'dart:typed_data';

import 'package:app_login_cadastro/controller/alunosController.dart';
import 'package:app_login_cadastro/controller/cadastroController.dart';
import 'package:app_login_cadastro/pages/telaPrincipal.dart';

import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';

class TelaCadastro extends StatefulWidget {
  const TelaCadastro({super.key});

  @override
  State<TelaCadastro> createState() => _TelaCadastro();
}

class _TelaCadastro extends State<TelaCadastro> {
  ControllerCadastro _controller = ControllerCadastro();
  ImagePicker _imagePicker = ImagePicker();
  Uint8List? _imagemBytes;

  void pegarImagemGaleria() async {
    final XFile? imagemTemporaria = await _imagePicker.pickImage(
      source: ImageSource.gallery,
    );

    if (imagemTemporaria != null) {
      final Uint8List bytes = await imagemTemporaria.readAsBytes();

      setState(() {
        _imagemBytes = bytes;
      });
    }
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  void _executarCadastro() {
    setState(() {
      // 1. Chama o Controller para processar os dados
      final retorno = _controller.cadastro(_imagemBytes);

      if (retorno['sucesso'] == true) {
        ControllerAlunos().addAlunos(retorno['aluno']);

        Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => TelaPrincipal()),
        );
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsetsGeometry.all(24),

          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              SizedBox(height: 20),

              Row(
                crossAxisAlignment: CrossAxisAlignment.center,
                mainAxisAlignment: MainAxisAlignment.center,

                children: [
                  Column(
                    children: [
                      Image.asset(
                        'assets/Imagens/Img_Escola_Mundial.png',
                        height: 120,
                      ),

                      SizedBox(height: 5),

                      Text(
                        "Cadastro",
                        style: TextStyle(
                          color: Colors.black,
                          fontSize: 30,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ],
                  ),
                ],
              ),

              SizedBox(height: 5),

              Divider(
                color: Colors.blue,
                thickness: 2, // Espessura da linha
                indent: 0, // Espaçamento no início (esquerda)
                endIndent: 0, // Espaçamento no fim (direita)
              ),

              SizedBox(height: 25),

              // Campo Nome
              TextField(
                controller: _controller.nome,
                decoration: InputDecoration(
                  labelText: "Nome",
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(15.0),
                  ),
                  prefixIcon: Icon(Icons.person),
                  contentPadding: EdgeInsets.all(25),
                ),
              ),

              SizedBox(height: 5),

              Text(
                _controller.mensagemNome,
                style: TextStyle(
                  color: Colors.red,
                  fontSize: 15,

                  fontWeight: FontWeight.normal,
                ),
              ),

              SizedBox(height: 40),

              // Campo Email
              TextField(
                controller: _controller.email,
                decoration: InputDecoration(
                  labelText: "Email",
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(15.0),
                  ),
                  prefixIcon: Icon(Icons.email),
                  contentPadding: EdgeInsets.all(25),
                ),
              ),

              SizedBox(height: 5),

              Text(
                _controller.mensagemEmail,
                style: TextStyle(
                  color: Colors.red,
                  fontSize: 15,
                  fontWeight: FontWeight.normal,
                ),
              ),

              SizedBox(height: 40),

              // Campo Curso
              TextField(
                controller: _controller.curso,
                decoration: InputDecoration(
                  labelText: "Curso",
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(15.0),
                  ),
                  prefixIcon: Icon(Icons.book),
                  contentPadding: EdgeInsets.all(25),
                ),
              ),

              SizedBox(height: 5),

              Text(
                _controller.mensagemCurso,
                style: TextStyle(
                  color: Colors.red,
                  fontSize: 15,
                  fontWeight: FontWeight.normal,
                ),
              ),

              SizedBox(height: 40),

              // Campo Turma
              TextField(
                controller: _controller.turma,
                decoration: InputDecoration(
                  labelText: "Turma",
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(15.0),
                  ),
                  prefixIcon: Icon(Icons.book),
                  contentPadding: EdgeInsets.all(25),
                ),
              ),

              SizedBox(height: 5),

              Text(
                _controller.mensagemTurma,
                style: TextStyle(
                  color: Colors.red,
                  fontSize: 15,
                  fontWeight: FontWeight.normal,
                ),
              ),

              SizedBox(height: 40),

              // Campo Senha
              TextField(
                controller: _controller.senha,
                obscureText: true,
                decoration: InputDecoration(
                  labelText: "Senha",
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(15),
                  ),
                  prefixIcon: Icon(Icons.password),
                  contentPadding: EdgeInsets.all(25),
                  // suffixIcon: Icon(
                  //   _controller._ocutarSenha ? Icons.visibility_off : Icons.visibility,
                  // ),
                ),
              ),

              SizedBox(height: 5),

              Text(
                _controller.mensagemSenha,
                style: TextStyle(
                  color: Colors.red,
                  fontSize: 15,
                  fontWeight: FontWeight.normal,
                ),
              ),

              SizedBox(height: 40),

              // Campo Imagem : FAZER
              Container(
                alignment: Alignment.center,
                width: double.infinity,
                height: 300,
                decoration: BoxDecoration(
                  color: Colors.white60,
                  borderRadius: BorderRadius.circular(20),
                  border: Border.all(color: Colors.blue, width: 2),
                ),
                child: _imagemBytes != null
                    ? ClipRRect(
                        borderRadius: BorderRadiusGeometry.circular(13),
                        child: Image.memory(
                          _imagemBytes!,
                          width: double.infinity,
                          height: double.infinity,
                          fit: BoxFit.cover,
                        ),
                      )
                    : Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          IconButton(
                            onPressed: pegarImagemGaleria,
                            icon: Icon(Icons.add_a_photo_outlined, size: 40),
                          ),
                        ],
                      ),
              ),

              SizedBox(height: 30),

              // Botão Cadastro
              ElevatedButton(
                onPressed: (_executarCadastro),
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.blue.shade500,
                  foregroundColor: Colors.white,
                  shadowColor: Colors.black,
                  padding: const EdgeInsets.all(20),
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadiusGeometry.circular(15),
                  ),
                ),
                child: Text(
                  "Cadastrar",
                  style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                ),
              ),

              SizedBox(height: 30),

              // Botão Voltar
              ElevatedButton(
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => TelaPrincipal()),
                  );
                },
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.indigo,
                  foregroundColor: Colors.white,
                  shadowColor: Colors.black,
                  padding: const EdgeInsets.all(20),
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadiusGeometry.circular(15),
                  ),
                ),
                child: Text(
                  "Voltar",
                  style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                ),
              ),

              SizedBox(height: 35),
            ],
          ),
        ),
      ),
    );
  }
}
