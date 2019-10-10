CREATE DATABASE Hospital;
USE Hospital;

CREATE TABLE medico(
idMedico BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
nome VARCHAR(50) NOT NULL,
idade TINYINT NOT NULL,
especializacao VARCHAR(50) NOT NULL,
cpf VARCHAR(15) NOT NULL UNIQUE,
sexo VARCHAR(9) NOT NULL,
telefone VARCHAR (12),
PRIMARY KEY(idMedico)
);

CREATE TABLE planoDeSaude(
idPlano BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
beneficios TINYINT NOT NULL,
categoria VARCHAR(25) NOT NULL,
dataEmissao VARCHAR(10) NOT NULL,
validade VARCHAR(10) NOT NULL,
empresaPlano VARCHAR(30) NOT NULL,
PRIMARY KEY(idPlano)
);

CREATE TABLE paciente(
idPaciente BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
nome VARCHAR(50) NOT NULL,
idade TINYINT NOT NULL,
tipoSanguineo VARCHAR (3) NOT NULL,
dataNascimento VARCHAR(10) NOT NULL,
estadoCivil VARCHAR (8),
cpf VARCHAR(15) NOT NULL UNIQUE,
sexo VARCHAR(9) NOT NULL,
peso DOUBLE NOT NULL,
renda DOUBLE NOT NULL,
telefoneCasa VARCHAR (12),
telefoneCelular VARCHAR (12),
telefoneFamilia VARCHAR (12),
idPlano BIGINT NULL,
FOREIGN KEY (idPlano) REFERENCES planoDeSaude(idPlano),
PRIMARY KEY(idPaciente)
);

CREATE TABLE endereco(
idEndereco BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
rua VARCHAR(30) NOT NULL,
bairro VARCHAR(20) NOT NULL,
numero SMALLINT NOT NULL,
complemento VARCHAR(15),
cidade VARCHAR(30) NOT NULL,
estado VARCHAR(30) NOT NULL,
pais VARCHAR(30) NOT NULL,
cep VARCHAR(10) NOT NULL,
idPaciente BIGINT NOT NULL,
FOREIGN KEY(idPaciente) REFERENCES paciente(idPaciente),
PRIMARY KEY(idEndereco)
);

CREATE TABLE cirurgia(
idCirurgia BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
tipo VARCHAR(30) NOT NULL,
descricao VARCHAR(100),
dataCirurgia VARCHAR(10) NOT NULL,
hora VARCHAR(5) NOT NULL,
sala TINYINT NOT NULL,
preco DOUBLE NOT NULL,
idPaciente BIGINT NOT NULL,
idMedico BIGINT NOT NULL,
PRIMARY KEY(idCirurgia),
FOREIGN KEY(idPaciente) REFERENCES paciente(idPaciente),
FOREIGN KEY(idMedico) REFERENCES medico(idMedico)
);

CREATE TABLE ferramenta(
idFerramenta BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
nome VARCHAR(30) NOT NULL,
tipoFerramenta VARCHAR(30) NOT NULL,
material VARCHAR(30) NOT NULL,
quantidade TINYINT NOT NULL,
PRIMARY KEY(idFerramenta)
);

CREATE TABLE cirurgiaFerramenta(
idCirurgiaFerramenta BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
idCirurgia BIGINT NOT NULL,
idFerramenta BIGINT NOT NULL,
PRIMARY KEY(idCirurgiaFerramenta),
FOREIGN KEY(idCirurgia) REFERENCES cirurgia(idCirurgia),
FOREIGN KEY(idFerramenta) REFERENCES ferramenta(idFerramenta)
);

CREATE TABLE medicamento(
idMedicamento BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
tipo varchar(30) NOT NULL,
quantidade TINYINT NOT NULL,
horaDeConsumo VARCHAR(5) NOT NULL,
PRIMARY KEY(idMedicamento)
);

CREATE TABLE pacienteMedicamento(
idPacienteMedicamento BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
idPaciente BIGINT NOT NULL,
idMedicamento BIGINT NOT NULL,
PRIMARY KEY(idPacienteMedicamento),
FOREIGN KEY(idPaciente) REFERENCES paciente (idPaciente),
FOREIGN KEY(idMedicamento) REFERENCES medicamento (idMedicamento)
);

CREATE TABLE consulta (
idConsulta BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
descricao VARCHAR(100) NOT NULL,
dataConsulta VARCHAR(10) NOT NULL,
hora VARCHAR(5) NOT NULL,
sala TINYINT NOT NULL,
preco DOUBLE NOT NULL,
idPaciente BIGINT NOT NULL,
idMedico BIGINT NOT NULL,
PRIMARY KEY(idConsulta),
FOREIGN KEY(idPaciente) REFERENCES paciente (idPaciente),
FOREIGN KEY(idMedico) REFERENCES medico (idMedico)
);

CREATE TABLE doacaoSangue (
idDoacao BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
nome VARCHAR(50) NOT NULL,
cpfDoador VARCHAR(15) NOT NULL UNIQUE,
tipoSanguineo VARCHAR(3) NOT NULL,
idDoador BIGINT NULL,
idReceptor BIGINT NULL,
PRIMARY KEY(idDoacao),
FOREIGN KEY(idDoador) REFERENCES paciente(idPaciente),
FOREIGN KEY(idReceptor) REFERENCES paciente(idPaciente)
);

CREATE TABLE usuario (
idUsuario BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
login VARCHAR(20) NOT NULL,
senha VARCHAR(20) NOT NULL UNIQUE,
PRIMARY KEY(idUsuario)
);