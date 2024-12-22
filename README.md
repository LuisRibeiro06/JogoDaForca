O Jogo da Forca é um clássico jogo de palavras implementado em Java, onde o jogador deve adivinhar uma palavra secreta com base em tentativas de letras individuais. Este projeto foi desenvolvido como um exercício prático para explorar conceitos fundamentais da linguagem Java, como manipulação de strings, arrays, entrada e saída de dados, bem como boas práticas de programação.

Descrição do Jogo
No Jogo da Forca:

O jogador recebe uma palavra secreta aleatória selecionada de um ficheiro externo de palavras.
As letras da palavra são inicialmente ocultadas, sendo representadas por traços (_).
A cada ronda, o jogador pode inserir uma letra:
Se a letra estiver presente na palavra secreta, ela é revelada em todas as posições correspondentes.
Se a letra não estiver presente, o jogador perde uma tentativa.
O jogo continua até que o jogador:
Acerte a palavra completa, ou
Esgote todas as tentativas disponíveis.
Mensagens informativas são exibidas ao longo do jogo para mostrar o progresso, as tentativas restantes e o estado atual da palavra.

Funcionalidades Principais
Leitura de Palavras de um Ficheiro Externo:

As palavras são carregadas de um ficheiro de texto, permitindo maior flexibilidade para adicionar ou modificar o conjunto de palavras disponíveis.
Seleção Aleatória da Palavra:

Cada partida apresenta uma palavra diferente, garantindo variabilidade no jogo.
Validação de Entradas:

Apenas letras são aceites como entrada, e o programa não faz distinção entre maiúsculas e minúsculas.
Feedback ao Jogador:

Exibe mensagens claras e detalhadas sobre o progresso, como letras corretas, letras incorretas e o estado atual da palavra.
Mensagens de Vitória ou Derrota:

Informa o jogador sobre o resultado final e revela a palavra secreta em caso de derrota.
Como Jogar
Certifique-se de que o ficheiro palavras.txt, contendo as palavras do jogo, está no local correto.
Execute o programa.
Insira o seu nome para personalizar a experiência.
Tente adivinhar a palavra inserindo letras, uma de cada vez.
Continue a jogar até acertar a palavra ou esgotar as suas tentativas.
Requisitos
Java JDK 8 ou superior.
Ficheiro palavras.txt contendo uma lista de palavras, uma por linha.
