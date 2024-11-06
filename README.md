# Conversor de Moedas

## Descrição do Projeto

O **Conversor de Moedas** é um programa desenvolvido em Java que utiliza a API Exchange Rate para fornecer conversões atualizadas entre diferentes moedas. Este projeto foi criado para facilitar a conversão de valores entre moedas de maneira rápida e precisa, usando dados de taxas de câmbio em tempo real. O programa oferece um menu interativo no console, onde o usuário pode selecionar uma das conversões pré-definidas ou escolher suas próprias moedas de origem e destino.

Este conversor é ideal para desenvolvedores que desejam aprender a integrar APIs em Java, além de ser uma ferramenta útil para quem precisa de conversões de moedas no dia a dia.

## Funcionalidades

- **Conversão de Moedas em Tempo Real**: Utiliza a API Exchange Rate para obter taxas de câmbio atualizadas.
- **Menu Interativo**: Apresenta um menu simples para que o usuário selecione facilmente a conversão desejada.
- **Opções de Conversão Pré-Definidas**: Oferece opções para converter entre moedas populares, incluindo:
  - Dólar (USD) para Peso Argentino (ARS) e vice-versa.
  - Dólar (USD) para Real Brasileiro (BRL) e vice-versa.
  - Dólar (USD) para Peso Colombiano (COP) e vice-versa.
- **Escolha Personalizada de Moedas**: Permite ao usuário especificar as moedas de origem e destino, digitando seus códigos de moeda, por exemplo, "USD" para Dólar dos EUA, "EUR" para Euro.
- **Tratamento de Erros**: Verifica e informa caso a API retorne um erro, se o código de moeda for inválido ou se houver problemas na conexão com a API.
- **Opção de Sair**: O usuário pode sair do programa a qualquer momento selecionando a opção de saída.

## Como os Usuários Podem Utilizá-lo

### Pré-requisitos

1. **Java Development Kit (JDK)**: Certifique-se de ter o JDK 11 ou superior instalado.
2. **Conexão com a Internet**: O programa requer uma conexão com a internet para acessar a API de taxas de câmbio.
3. **Chave da API Exchange Rate (opcional)**: Dependendo das políticas de uso da API, você pode precisar de uma chave de API para realizar as requisições.

### Passo a Passo para Utilização

1. **Clone o Repositório**:
   git clone https://github.com/Lumabarbosa/conversor-de-moedas.git
   cd conversor-de-moedas

2. **Compile o Código Java**:
   javac src/*.java -d out

3. **Execute o Programa**:
   java -cp out principal.ConversorMoedas

4. **Escolha a Conversão Desejada**: Ao iniciar, o programa exibirá um menu com as opções de conversão. Selecione a opção desejada digitando o número correspondente e pressionando 'Enter'.

5. **Digite o Valor a Ser Convertido**: O programa solicitará que você informe o valor que deseja converter. Digite o valor e pressione 'Enter'.

6. **Visualize o Resultado**: O programa exibirá o valor original, o valor convertido com base na taxa de câmbio atual fornecida pela API, bem como a data e a hora que a conversão foi realizada.

### Onde os Usuários Podem Encontrar Ajuda Sobre o Projeto
Se precisar de ajuda para utilizar o Conversor de Moedas ou para solucionar problemas, você pode:

- Verificar o Repositório de Issues: Verifique a aba de Issues no GitHub para ver se o problema já foi relatado e se há uma solução.
- Abrir uma Nova Issue: Caso o problema não esteja documentado, sinta-se à vontade para abrir uma nova issue. Descreva o problema com detalhes para que possamos ajudar.
- Contactar o Autor: Se precisar de ajuda adicional, você pode enviar uma mensagem para o desenvolvedor via GitHub."# conversordemoedasalura" 
