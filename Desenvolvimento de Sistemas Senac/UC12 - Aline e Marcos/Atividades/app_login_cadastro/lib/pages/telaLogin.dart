import 'package:app_login_cadastro/controller/loginController.dart';
import 'package:app_login_cadastro/pages/telaPrincipal.dart';
import 'package:flutter/material.dart';

class TelaLogin extends StatefulWidget {
  const TelaLogin({super.key});

  @override
  State<TelaLogin> createState() => _TelaLogin();
}

class _TelaLogin extends State<TelaLogin> {
  ControllerLogin _controller = ControllerLogin();

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  void _executarLogin() {
    setState(() {
      // 1. Chama o Controller para processar os dados
      String retorno = _controller.logar();

      if (retorno == 'Sucesso'){
        Navigator.push(
          context, 
          MaterialPageRoute(
            builder: (context) => TelaPrincipal()
          )
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

                      SizedBox(height: 130),

                      Text(
                        "Login",
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
                  contentPadding: EdgeInsets.all(25)
                ),
              ),
             
              SizedBox(height: 5),

              Text(
                _controller.mensagemEmail,
                style: TextStyle(
                  color: Colors.red,
                  fontSize: 15,
                  fontWeight: FontWeight.normal
                ),
              ),

              SizedBox(height: 20),

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
                  fontWeight: FontWeight.normal
                ),
              ),

              SizedBox(height: 35),

              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Text(
                    "Esqueci minha senha",
                    style: TextStyle(
                      color: Colors.blue,
                      fontSize: 20,
                      decoration: TextDecoration.underline
                    ),
                  ),
                ]
              ),

              SizedBox(height: 200),

              // Botão Login
              ElevatedButton(
                onPressed: (_executarLogin),
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
                  "Logar", 
                  style: TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold
                    ),
                  ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
