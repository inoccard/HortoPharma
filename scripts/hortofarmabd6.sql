-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 14-Jun-2018 às 03:28
-- Versão do servidor: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hortofarmabd`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `farmaceutico`
--

CREATE TABLE `farmaceutico` (
  `CODFARMACEUTICO` int(11) NOT NULL,
  `LOGIN` varchar(45) DEFAULT NULL,
  `SENHA` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `CARGO` varchar(56) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `farmaceutico`
--

INSERT INTO `farmaceutico` (`CODFARMACEUTICO`, `LOGIN`, `SENHA`, `EMAIL`, `CARGO`) VALUES
(1, 'allan', '123', 'allan@gmail.com', 'Gerente'),
(2, 'Weverton', '234', 'weverton@outlook.com', 'Atendente'),
(3, 'inocencio', '123', 'ino@gmail.com', 'gerente 2'),
(4, 'inoccard', '1234', 'inoccard@gmail.com', 'Gerente Associado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `farmacia`
--

CREATE TABLE `farmacia` (
  `CODFARMACIA` int(11) NOT NULL,
  `NOME` varchar(50) DEFAULT NULL,
  `ENRERECO` varchar(50) DEFAULT NULL,
  `CNPJ` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `problemas_saude`
--

CREATE TABLE `problemas_saude` (
  `CODPROBS` int(11) NOT NULL,
  `NOME_PROBS` varchar(55) DEFAULT NULL,
  `CLIENTE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbcliente`
--

CREATE TABLE `tbcliente` (
  `CODCLIENTE` int(11) NOT NULL,
  `NOME` varchar(450) DEFAULT NULL,
  `CPF` varchar(14) NOT NULL,
  `SEXO` varchar(20) DEFAULT NULL,
  `ENDERECO` varchar(60) DEFAULT NULL,
  `DATANASCIMENTO` date DEFAULT '0000-00-00',
  `CELULAR` varchar(11) DEFAULT NULL,
  `EMAIL` varchar(55) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbcliente`
--

INSERT INTO `tbcliente` (`CODCLIENTE`, `NOME`, `CPF`, `SEXO`, `ENDERECO`, `DATANASCIMENTO`, `CELULAR`, `EMAIL`) VALUES
(11, 'Inocencio Cardoso', '121.111.111-44', NULL, NULL, '2018-05-31', NULL, NULL),
(12, 'MAtheus Correia', '122.333.433-33', NULL, NULL, '2018-05-31', NULL, NULL),
(13, 'Hallan Dias da Silva', '123.148.748-12', NULL, NULL, '2018-06-07', NULL, NULL),
(14, 'Weverton Santos', '324.344.444-53', NULL, NULL, '2018-06-07', NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbcompra`
--

CREATE TABLE `tbcompra` (
  `CODCOMPRAS` int(11) NOT NULL,
  `CODIGOFORNECEDOR` int(11) NOT NULL,
  `DATACOMPRAS` date DEFAULT NULL,
  `VALORTOTAL` decimal(10,2) NOT NULL,
  `SITUACAO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbcompra`
--

INSERT INTO `tbcompra` (`CODCOMPRAS`, `CODIGOFORNECEDOR`, `DATACOMPRAS`, `VALORTOTAL`, `SITUACAO`) VALUES
(1, 10, '2018-06-10', '121.42', 2),
(2, 8, '2018-06-10', '154.92', 2),
(3, 10, '2018-06-10', '43.96', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbdoencas`
--

CREATE TABLE `tbdoencas` (
  `CODDOENCAS` int(11) NOT NULL,
  `NOME` varchar(56) DEFAULT 'NULL',
  `CODIGOCLIENTE` int(11) NOT NULL,
  `DESCONTO` decimal(10,2) DEFAULT '0.00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbdoencas`
--

INSERT INTO `tbdoencas` (`CODDOENCAS`, `NOME`, `CODIGOCLIENTE`, `DESCONTO`) VALUES
(1, 'ALERGIA', 12, '0.00'),
(2, 'CRONICA', 11, '0.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbfornecedor`
--

CREATE TABLE `tbfornecedor` (
  `CODFORNECEDOR` int(11) NOT NULL,
  `NOME` varchar(100) NOT NULL,
  `CNPJ` varchar(18) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbfornecedor`
--

INSERT INTO `tbfornecedor` (`CODFORNECEDOR`, `NOME`, `CNPJ`) VALUES
(8, 'Unasp-ec', '12.222.222/2242-23'),
(9, 'unasp-sp', '22.222.211/1222-22'),
(10, 'unicamp', '12.234.359/3480-30');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbitemcompra`
--

CREATE TABLE `tbitemcompra` (
  `CODIGO` int(11) NOT NULL,
  `CODIGOPRODUTO` int(11) NOT NULL,
  `CODIGOCOMPRA` int(11) NOT NULL,
  `QUANTIDADE` int(11) NOT NULL,
  `VALORUNITARIO` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbitemcompra`
--

INSERT INTO `tbitemcompra` (`CODIGO`, `CODIGOPRODUTO`, `CODIGOCOMPRA`, `QUANTIDADE`, `VALORUNITARIO`) VALUES
(1, 2, 1, 3, '25.82'),
(2, 1, 1, 4, '10.99'),
(3, 2, 2, 6, '25.82'),
(4, 1, 3, 3, '10.99'),
(5, 1, 3, 1, '10.99');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbitemvenda`
--

CREATE TABLE `tbitemvenda` (
  `CODIGO` int(11) NOT NULL,
  `CODIGOPRODUTO` int(11) NOT NULL,
  `CODIGOVENDA` int(11) NOT NULL,
  `QUANTIDADE` int(11) NOT NULL,
  `VALORUNITARIO` decimal(10,2) NOT NULL DEFAULT '0.00',
  `DESCONTO` decimal(10,2) NOT NULL DEFAULT '0.00',
  `PAGAR` decimal(10,2) NOT NULL DEFAULT '0.00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbitemvenda`
--

INSERT INTO `tbitemvenda` (`CODIGO`, `CODIGOPRODUTO`, `CODIGOVENDA`, `QUANTIDADE`, `VALORUNITARIO`, `DESCONTO`, `PAGAR`) VALUES
(1, 2, 1, 2, '30.81', '0.00', '61.62'),
(2, 2, 1, 2, '30.81', '0.00', '61.62'),
(3, 2, 1, 2, '30.81', '0.00', '61.62'),
(4, 2, 2, 1, '30.81', '0.00', '30.81'),
(5, 1, 2, 1, '20.99', '3.15', '17.84'),
(6, 1, 2, 1, '20.99', '3.15', '17.84'),
(7, 1, 2, 2, '20.99', '6.30', '35.68'),
(8, 2, 3, 1, '30.81', '0.00', '30.81'),
(9, 1, 3, 1, '20.99', '18.89', '-16.79');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbproduto`
--

CREATE TABLE `tbproduto` (
  `CODPRODUTO` int(11) NOT NULL,
  `NOME` varchar(450) DEFAULT NULL,
  `PRECOCOMPRA` decimal(10,2) DEFAULT NULL,
  `PRECOVENDA` decimal(10,2) DEFAULT NULL,
  `QTDESTOQUE` int(11) DEFAULT NULL,
  `CLASSE` int(3) DEFAULT '0',
  `DESCONTO` decimal(10,2) DEFAULT '0.00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbproduto`
--

INSERT INTO `tbproduto` (`CODPRODUTO`, `NOME`, `PRECOCOMPRA`, `PRECOVENDA`, `QTDESTOQUE`, `CLASSE`, `DESCONTO`) VALUES
(1, 'xarope', '10.99', '20.99', 5, 1, '5.45'),
(2, 'Metamizol', '25.82', '30.81', 4, 2, '0.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbvenda`
--

CREATE TABLE `tbvenda` (
  `CODVENDAS` int(11) NOT NULL,
  `CODIGOCLIENTE` int(11) NOT NULL,
  `DATAVENDA` date NOT NULL,
  `VALORTOTAL` decimal(10,2) NOT NULL,
  `SITUACAO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbvenda`
--

INSERT INTO `tbvenda` (`CODVENDAS`, `CODIGOCLIENTE`, `DATAVENDA`, `VALORTOTAL`, `SITUACAO`) VALUES
(1, 11, '2018-06-10', '158.92', 2),
(2, 12, '2018-06-10', '102.17', 1),
(3, 14, '2018-06-10', '14.02', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `farmaceutico`
--
ALTER TABLE `farmaceutico`
  ADD PRIMARY KEY (`CODFARMACEUTICO`),
  ADD UNIQUE KEY `CODFARMACEUTICO_UNIQUE` (`CODFARMACEUTICO`),
  ADD UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`),
  ADD UNIQUE KEY `LOGIN_UNIQUE` (`LOGIN`);

--
-- Indexes for table `farmacia`
--
ALTER TABLE `farmacia`
  ADD PRIMARY KEY (`CODFARMACIA`),
  ADD UNIQUE KEY `CODFARMACIA_UNIQUE` (`CODFARMACIA`),
  ADD UNIQUE KEY `CNPJ_UNIQUE` (`CNPJ`);

--
-- Indexes for table `problemas_saude`
--
ALTER TABLE `problemas_saude`
  ADD PRIMARY KEY (`CODPROBS`),
  ADD KEY `CODCLIENTE` (`CLIENTE`);

--
-- Indexes for table `tbcliente`
--
ALTER TABLE `tbcliente`
  ADD PRIMARY KEY (`CODCLIENTE`),
  ADD UNIQUE KEY `CODCLIENTE_UNIQUE` (`CODCLIENTE`);

--
-- Indexes for table `tbcompra`
--
ALTER TABLE `tbcompra`
  ADD PRIMARY KEY (`CODCOMPRAS`),
  ADD KEY `DATACOMPRAS` (`DATACOMPRAS`);

--
-- Indexes for table `tbdoencas`
--
ALTER TABLE `tbdoencas`
  ADD PRIMARY KEY (`CODDOENCAS`),
  ADD KEY `fk_cliente_idx` (`CODIGOCLIENTE`);

--
-- Indexes for table `tbfornecedor`
--
ALTER TABLE `tbfornecedor`
  ADD PRIMARY KEY (`CODFORNECEDOR`);

--
-- Indexes for table `tbitemcompra`
--
ALTER TABLE `tbitemcompra`
  ADD PRIMARY KEY (`CODIGO`),
  ADD KEY `FK_CodigoCompra_idx2` (`CODIGOPRODUTO`),
  ADD KEY `FK_CodigoProduto_idx2` (`CODIGOCOMPRA`);

--
-- Indexes for table `tbitemvenda`
--
ALTER TABLE `tbitemvenda`
  ADD PRIMARY KEY (`CODIGO`),
  ADD KEY `FK_CodigoVenda_idx` (`CODIGOVENDA`),
  ADD KEY `FK_CodigoProduto_idx` (`CODIGOPRODUTO`);

--
-- Indexes for table `tbproduto`
--
ALTER TABLE `tbproduto`
  ADD PRIMARY KEY (`CODPRODUTO`);

--
-- Indexes for table `tbvenda`
--
ALTER TABLE `tbvenda`
  ADD PRIMARY KEY (`CODVENDAS`),
  ADD KEY `FK_CodigoCliente_idx` (`CODIGOCLIENTE`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `farmaceutico`
--
ALTER TABLE `farmaceutico`
  MODIFY `CODFARMACEUTICO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `farmacia`
--
ALTER TABLE `farmacia`
  MODIFY `CODFARMACIA` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `problemas_saude`
--
ALTER TABLE `problemas_saude`
  MODIFY `CODPROBS` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbcliente`
--
ALTER TABLE `tbcliente`
  MODIFY `CODCLIENTE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `tbcompra`
--
ALTER TABLE `tbcompra`
  MODIFY `CODCOMPRAS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbdoencas`
--
ALTER TABLE `tbdoencas`
  MODIFY `CODDOENCAS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbfornecedor`
--
ALTER TABLE `tbfornecedor`
  MODIFY `CODFORNECEDOR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tbitemcompra`
--
ALTER TABLE `tbitemcompra`
  MODIFY `CODIGO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbitemvenda`
--
ALTER TABLE `tbitemvenda`
  MODIFY `CODIGO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tbproduto`
--
ALTER TABLE `tbproduto`
  MODIFY `CODPRODUTO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbvenda`
--
ALTER TABLE `tbvenda`
  MODIFY `CODVENDAS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `problemas_saude`
--
ALTER TABLE `problemas_saude`
  ADD CONSTRAINT `CODCLIENTE` FOREIGN KEY (`CLIENTE`) REFERENCES `tbcliente` (`CODCLIENTE`);

--
-- Limitadores para a tabela `tbdoencas`
--
ALTER TABLE `tbdoencas`
  ADD CONSTRAINT `fk_cliente` FOREIGN KEY (`CODIGOCLIENTE`) REFERENCES `tbcliente` (`CODCLIENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `tbitemcompra`
--
ALTER TABLE `tbitemcompra`
  ADD CONSTRAINT `FK_CodigoCompra2` FOREIGN KEY (`CODIGOCOMPRA`) REFERENCES `tbcompra` (`CODCOMPRAS`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_CodigoMedicamento2` FOREIGN KEY (`CODIGOPRODUTO`) REFERENCES `tbproduto` (`CODPRODUTO`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `tbitemvenda`
--
ALTER TABLE `tbitemvenda`
  ADD CONSTRAINT `FK_CodigoProduto` FOREIGN KEY (`CODIGOPRODUTO`) REFERENCES `tbproduto` (`CODPRODUTO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_CodigoVenda` FOREIGN KEY (`CODIGOVENDA`) REFERENCES `tbvenda` (`CODVENDAS`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `tbvenda`
--
ALTER TABLE `tbvenda`
  ADD CONSTRAINT `FK_CodigoCliente` FOREIGN KEY (`CODIGOCLIENTE`) REFERENCES `tbcliente` (`CODCLIENTE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
