# AWS Educate | UFMG 

Esse repositório será o resultado de uma iniciativa de difusão de conhecimento na UFMG para alunos de quaisquer cursos que tenham interesse em aprender mais sobre _Cloud Computing_ e, principalmente AWS.

A ídeia é fomentar o uso de tecnologias mais recentes pelos alunos e professores, no intuíto de diminuir a dificuldade inicial de aprendizado de algumas ferramentas para desenvolvimento de ideias dos membros da UFMG e outras instituíções de ensino.

## Apresentações
Todas as apresentações podem ser nos links abaixo:
* [Programa AWS Educate](https://bit.ly/awseducate-ffr)
* [AWS Introdução](https://bit.ly/slide-aws-intro)

## [Link AWS Educate](https://bit.ly/aws-edu-ffr)

## Videos
* [AWS Introcução](https://bit.ly/ffr-aws-intro)
* [AWS Camadas]()

## Comandos Utilizados
Os comandos utilizados para as instalações de java e node em instancias Amazon Linux:
```bash
#!/bin/bash
yum update -y
amazon-linux-extras install java-openjdk11 -y
```

```bash
#!/bin/bash
yum update -y
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.34.0/install.sh | bash
. ~/.nvm/nvm.sh
. home/ec2-user/.nvm/nvm.sh
nvm install 12.18.2
node -e "console.log('Running Node.js ' + process.version)"
```

## Comandos de conexão remota

Para se conectar em instancias da AWS é importante lembrar de realizar o download da chave privada.
Após o download:
```bash
chmod 400 <chave priada>.pem
```
Conexão e transferência de arquivos
```bash
# Tunelamento de portas
ssh -i <chave priada>.pem -L <port1-host>:<ip 1>:<port1-rem> -A <user>@<ip|dns maquina remota>

# Tunelamento de cópia
ssh -i <chave priada>.pem -L <port1-host>:<ip 1>:22 -A <user>@<ip|dns maquina remota>
scp -P <port1-host> -r /pasta/origem/ <user>@127.0.0.1:/pasta/destino/
```

## Referências
* [NAT Instances](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_NAT_Instance.html)
* [VPC Scencario](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Scenario2.html)
* [Aplicação](https://www.devdiaries.net)
* [React](https://create-react-app.dev/)
* [Spring](https://start.spring.io/)
* [PostegreSQL](https://www.postgresql.org/)
