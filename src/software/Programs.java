package software;
import hardware.*;
public class Programs {

        /* Programas fornecidos pelo professor */
        public Word[] progMinimo = new Word[] {
                // OPCODE R1 R2 P :: VEJA AS COLUNAS VERMELHAS DA TABELA DE DEFINICAO DE
                // OPERACOES
                // :: -1 SIGNIFICA QUE O PARAMETRO NAO EXISTE PARA A OPERACAO DEFINIDA
                new Word(Opcode.LDI, 0, -1, 900),
                new Word(Opcode.STD, 0, -1, 1),
                new Word(Opcode.STD, 0, -1, 2),
                new Word(Opcode.STD, 0, -1, 3),
                new Word(Opcode.STD, 0, -1, 4),
                new Word(Opcode.STD, 0, -1, 5),
                new Word(Opcode.STOP, -1, -1, -1)
        };

        public Word[] fibonacci10 = new Word[] { // mesmo que prog exemplo, so que usa r0 no lugar de r8
                new Word(Opcode.LDD, 1, -1, 0),
                new Word(Opcode.STD, 1, -1, 20), // 20 posicao de memoria onde inicia a serie de fibonacci
                                                         // gerada
                new Word(Opcode.LDI, 2, -1, 1),
                new Word(Opcode.STD, 2, -1, 21),
                new Word(Opcode.LDI, 0, -1, 22),
                new Word(Opcode.LDI, 6, -1, 6),
                new Word(Opcode.LDI, 7, -1, 30),
                new Word(Opcode.LDI, 3, -1, 0),
                new Word(Opcode.ADD, 3, 1, -1),
                new Word(Opcode.LDI, 1, -1, 0),
                new Word(Opcode.ADD, 1, 2, -1),
                new Word(Opcode.ADD, 2, 3, -1),
                new Word(Opcode.STX, 0, 2, -1),
                new Word(Opcode.ADDI, 0, -1, 1),
                new Word(Opcode.SUB, 7, 0, -1),
                new Word(Opcode.JMPIG, 6, 7, -1),
                new Word(Opcode.STOP, -1, -1, -1), // POS 16
                new Word(Opcode.DATA, -1, -1, -1),
                new Word(Opcode.DATA, -1, -1, -1),
                new Word(Opcode.DATA, -1, -1, -1),
                new Word(Opcode.DATA, -1, -1, -1), // POS 20
                new Word(Opcode.DATA, -1, -1, -1),
                new Word(Opcode.DATA, -1, -1, -1),
                new Word(Opcode.DATA, -1, -1, -1),
                new Word(Opcode.DATA, -1, -1, -1),
                new Word(Opcode.DATA, -1, -1, -1),
                new Word(Opcode.DATA, -1, -1, -1),
                new Word(Opcode.DATA, -1, -1, -1),
                new Word(Opcode.DATA, -1, -1, -1),
                new Word(Opcode.DATA, -1, -1, -1) // ate aqui - serie de fibonacci ficara armazenada
        };

        public Word[] fatorial = new Word[] { // este fatorial so aceita valores positivos. nao pode ser zero
                                              // linha coment
                new Word(Opcode.LDI, 0, -1, 6), // 0 r0 é valor a calcular fatorial
                new Word(Opcode.LDI, 1, -1, 1), // 1 r1 é 1 para multiplicar (por r0)
                new Word(Opcode.LDI, 6, -1, 1), // 2 r6 é 1 para ser o decremento
                new Word(Opcode.LDI, 7, -1, 8), // 3 r7 tem posicao de stop do programa = 8
                new Word(Opcode.JMPIE, 7, 0, 0), // 4 se r0=0 pula para r7(=8)
                new Word(Opcode.MULT, 1, 0, -1), // 5 r1 = r1 * r0
                new Word(Opcode.SUB, 0, 6, -1), // 6 decrementa r0 1
                new Word(Opcode.JMP, -1, -1, 4), // 7 vai p posicao 4
                new Word(Opcode.STD, 1, -1, 10), // 8 coloca valor de r1 na posição 10
                new Word(Opcode.STOP, -1, -1, -1), // 9 stop
                new Word(Opcode.DATA, -1, -1, -1)
        }; // 10 ao final o valor do fatorial estará na posição 10 da memória

        /*********** FASE 1 ***********/
        // PA: um programa que le um valor de uma determinada posição (carregada no
        // inicio),
        // se o número for menor que zero coloca -1 no início da posição de memória para
        // saída;
        // se for maior que zero este é o número de valores da sequencia de fibonacci a
        // serem escritos em sequencia a partir de uma posição de memória;
        public Word[] pa = new Word[] {
                new Word(Opcode.LDI, 0, -1, 5), // 0 carrega o valor 5 no registrador 0
                new Word(Opcode.STD, 0, -1, 37), // 1 pega o valor do r0 e coloca na posição 37 da memória
                new Word(Opcode.LDD, 1, -1, 37), // 2 pega o valor da posição 37 da memória e coloca em r1
                new Word(Opcode.SUBI, 1, -1, 1), // 3 subtrai 1 do valor que entrou (no caso 5), por conta do
                                                         // zero: 0-4
                                                         // (5 valores)
                new Word(Opcode.LDI, 2, -1, 28), // 4 registrador que vai controlar o incremento de posição de
                                                          // memória
                new Word(Opcode.LDI, 7, -1, 24), // 5 carrega o valor 23 no registrador 7
                new Word(Opcode.JMPIL, 7, 1, -1), // 6 verifica se o valor no r1 é menor que 0, se sim, pula p/
                                                          // instrução 23, guardada no r7, se não, segue o fluxo
                new Word(Opcode.LDI, 5, -1, 1), // 7 carrega o primeiro valor de Fibonacci (1) no r5
                new Word(Opcode.STX, 2, 5, -1), // 8 pega o valor do r5 e carrega na posição 28 (valor
                                                        // armazenado no
                                                        // r2)
                new Word(Opcode.SUBI, 1, -1, 1), // 9 subtrai 1 dos valores do r1
                new Word(Opcode.LDI, 7, -1, 26), // 10 carrega o valor 26 no registrador 7
                new Word(Opcode.JMPIL, 7, 1, -1), // 11 se o valor do r1 for menor que 0, pula para instrução 26
                new Word(Opcode.ADDI, 2, -1, 1), // 12 soma 1 ao valor que está no r2 (posição de memória)
                new Word(Opcode.LDI, 6, -1, 1), // 13 carrega o segundo valor de Fibonacci (1) no r6
                new Word(Opcode.STX, 2, 6, -1), // 14 carrega o valor de r6 na próxima posição da memória (r2)
                new Word(Opcode.SUBI, 1, -1, 1), // 15 subtrai 1 do r1
                new Word(Opcode.JMPIL, 7, 1, -1), // 16 se r1 menor do que 0, pula para instrução 26
                new Word(Opcode.ADDI, 2, -1, 1), // 17 soma 1 na posição de memória
                new Word(Opcode.ADD, 5, 6, -1), // 18 soma os valores de r5 e r6
                new Word(Opcode.SWAP, 5, 6, -1), // 19 faz um swap dos registradores r5 e r6 para manter a ordem
                                                         // correta
                                                         // para somar
                new Word(Opcode.STX, 2, 6, -1), // 20 carrega o valor de r6 (soma) para memória
                new Word(Opcode.LDI, 4, -1, 15), // 21carrega o valor 15 no registrador 4
                new Word(Opcode.JMPIG, 4, 1, -1), // 22 se o que tem no r1 é maior que 0, volta pra instrução
                                                          // 15, se
                                                          // não, segue
                new Word(Opcode.JMPIE, 7, 1, -1), // 23 se o que tem no r1 for igual a 0, pula pra instrução 26
                new Word(Opcode.LDI, 3, -1, -1), // 24 carrega -1 no r3
                new Word(Opcode.STX, 2, 3, -1), // 25 pega o que tá no r3 (-1) e coloca na posição de memória do
                                                        // r2
                                                        // (28)
                new Word(Opcode.STOP, -1, -1, -1), // 26 para o programa

                new Word(Opcode.DATA, -1, -1, 37), // ...
                new Word(Opcode.DATA, -1, -1, 900), // ...
                new Word(Opcode.DATA, -1, -1, -1), // ...
                new Word(Opcode.DATA, -1, -1, -1), // ...
                new Word(Opcode.DATA, -1, -1, -1), // ...
                new Word(Opcode.DATA, -1, -1, -1), // ...
                new Word(Opcode.DATA, -1, -1, -1) // ...
        };

        // teste PA que le valor menor que 0
        public Word[] testePA = new Word[] {
                new Word(Opcode.LDI, 0, -1, -2), // 0 carrega o valor -2 no registrador 0
                new Word(Opcode.STD, 0, -1, 37), // 1 pega o valor do r0 e coloca na posição 37 da memória
                new Word(Opcode.LDD, 1, -1, 37), // 2 pega o valor da posição 37 da memória e coloca em r1
                new Word(Opcode.SUBI, 1, -1, 1), // 3 subtrai 1 do valor que entrou (no caso 5), por conta do
                                                         // zero: 0-4
                                                         // (5 valores)
                new Word(Opcode.LDI, 2, -1, 28), // 4 registrador que vai controlar o incremento de posição de
                                                          // memória
                new Word(Opcode.LDI, 7, -1, 24), // 5 carrega o valor 23 no registrador 7
                new Word(Opcode.JMPIL, 7, 1, -1), // 6 verifica se o valor no r1 é menor que 0, se sim, pula p/
                                                          // instrução 23, guardada no r7, se não, segue o fluxo
                new Word(Opcode.LDI, 5, -1, 1), // 7 carrega o primeiro valor de Fibonacci (1) no r5
                new Word(Opcode.STX, 2, 5, -1), // 8 pega o valor do r5 e carrega na posição 900 (valor
                                                        // armazenado no
                                                        // r2)
                new Word(Opcode.SUBI, 1, -1, 1), // 9 subtrai 1 dos valores do r1
                new Word(Opcode.LDI, 7, -1, 26), // 10 carrega o valor 26 no registrador 7
                new Word(Opcode.JMPIL, 7, 1, -1), // 11 se o valor do r1 for menor que 0, pula para instrução 26
                new Word(Opcode.ADDI, 2, -1, 1), // 12 soma 1 ao valor que está no r2 (posição de memória)
                new Word(Opcode.LDI, 6, -1, 1), // 13 carrega o segundo valor de Fibonacci (1) no r6
                new Word(Opcode.STX, 2, 6, -1), // 14 carrega o valor de r6 na próxima posição da memória (r2)
                new Word(Opcode.SUBI, 1, -1, 1), // 15 subtrai 1 do r1
                new Word(Opcode.JMPIL, 7, 1, -1), // 16 se r1 menor do que 0, pula para instrução 26
                new Word(Opcode.ADDI, 2, -1, 1), // 17 soma 1 na posição de memória
                new Word(Opcode.ADD, 5, 6, -1), // 18 soma os valores de r5 e r6
                new Word(Opcode.SWAP, 5, 6, -1), // 19 faz um swap dos registradores r5 e r6 para manter a ordem
                                                         // correta
                                                         // para somar
                new Word(Opcode.STX, 2, 6, -1), // 20 carrega o valor de r6 (soma) para memória
                new Word(Opcode.LDI, 4, -1, 15), // 21carrega o valor 15 no registrador 4
                new Word(Opcode.JMPIG, 4, 1, -1), // 22 se o que tem no r1 é maior que 0, volta pra instrução
                                                          // 15, se
                                                          // não, segue
                new Word(Opcode.JMPIE, 7, 1, -1), // 23 se o que tem no r1 for igual a 0, pula pra instrução 26
                new Word(Opcode.LDI, 3, -1, -1), // 24 carrega -1 no r3
                new Word(Opcode.STX, 2, 3, -1), // 25 pega o que tá no r3 (-1) e coloca na posição de memória do
                                                        // r2
                                                        // (900)
                new Word(Opcode.STOP, -1, -1, -1), // 26 para o programa

                new Word(Opcode.DATA, -1, -1, -1), // ...
                new Word(Opcode.DATA, -1, -1, -1), // ...
                new Word(Opcode.DATA, -1, -1, -1), // ...
                new Word(Opcode.DATA, -1, -1, -1), // ...
                new Word(Opcode.DATA, -1, -1, -1), // ...
                new Word(Opcode.DATA, -1, -1, -1), // ...
                new Word(Opcode.DATA, -1, -1, -1) // ...
        };

        // PB: dado um inteiro em alguma posição de memória,
        // se for negativo armazena -1 na saída; se for positivo responde o fatorial do
        // número na saída
        public Word[] pb = new Word[] {
                new Word(Opcode.LDI, 0, -1, 3), // 0 carrega o valor 3 no r0
                new Word(Opcode.STD, 0, -1, 16), // 1 carrega o valor do r0 na posição 36 da memória
                new Word(Opcode.LDD, 1, -1, 16), // 2 pega o valor da posição 36 da memória e coloca em r1 (3)
                new Word(Opcode.LDI, 5, -1, 13), // 3 carrega o valor 12 no r5
                new Word(Opcode.JMPIL, 5, 1, -1), // 4 se o que tem no registrador r1 for menor que 0, pula pra
                                                          // instrução guardada no r5 (12), se não, segue
                new Word(Opcode.LDD, 2, -1, 16), // 5 carrega em r2 o mesmo valor de r1 (3)
                new Word(Opcode.SUBI, 1, -1, 1), // 6 subtrai 1 do valor que tinha em r1
                new Word(Opcode.MULT, 2, 1, -1), // 7 multiplica r1 e r2 e coloca em r2 o valor
                new Word(Opcode.SUBI, 1, -1, 1), // 8 subtrai 1 do r1
                new Word(Opcode.LDI, 6, -1, 7), // 9 carrega o valor 7 (próxima instrução) no r6
                new Word(Opcode.JMPIG, 6, 1, -1), // 10 se for maior que 0 o que tem no r1, volta pra instrução
                                                          // 7 se
                                                          // não, segue o fluxo
                new Word(Opcode.STD, 2, -1, 17), // 11 coloca na posição 35 da memória o resultado do fatorial,
                                                         // que está
                                                         // no r2
                new Word(Opcode.JMP, -1, -1, 15), // 12 pula pro stop
                new Word(Opcode.LDI, 1, -1, -1), // 13 carrega no r1 o valor -1
                new Word(Opcode.STD, 1, -1, 17), // 14 coloca na posição 35 da memória o valor -1
                new Word(Opcode.STOP, -1, -1, -1), // 15 termina a execução
                new Word(Opcode.DATA, -1, -1, -1),
        };

        // teste PB que le valor menor que 0
        public Word[] testePB = new Word[] {
                new Word(Opcode.LDI, 0, -1, -2), // 0 carrega o valor -2 no r0
                new Word(Opcode.STD, 0, -1, 16), // 1 carrega o valor do r0 na posição 36 da memória
                new Word(Opcode.LDD, 1, -1, 16), // 2 pega o valor da posição 36 da memória e coloca em r1 (3)
                new Word(Opcode.LDI, 5, -1, 13), // 3 carrega o valor 12 no r5
                new Word(Opcode.JMPIL, 5, 1, -1), // 4 se o que tem no registrador r1 for menor que 0, pula pra
                                                          // instrução guardada no r5 (12), se não, segue
                new Word(Opcode.LDD, 2, -1, 16), // 5 carrega em r2 o mesmo valor de r1 (3)
                new Word(Opcode.SUBI, 1, -1, 1), // 6 subtrai 1 do valor que tinha em r1
                new Word(Opcode.MULT, 2, 1, -1), // 7 multiplica r1 e r2 e coloca em r2 o valor
                new Word(Opcode.SUBI, 1, -1, 1), // 8 subtrai 1 do r1
                new Word(Opcode.LDI, 6, -1, 7), // 9 carrega o valor 7 (próxima instrução) no r6
                new Word(Opcode.JMPIG, 6, 1, -1), // 10 se for maior que 0 o que tem no r1, volta pra instrução
                                                          // 7 se
                                                          // não, segue o fluxo
                new Word(Opcode.STD, 2, -1, 17), // 11 coloca na posição 35 da memória o resultado do fatorial,
                                                         // que está
                                                         // no r2
                new Word(Opcode.JMP, -1, -1, 15), // 12 pula pro stop
                new Word(Opcode.LDI, 1, -1, -1), // 13 carrega no r1 o valor -1
                new Word(Opcode.STD, 1, -1, 17), // 14 coloca na posição 35 da memória o valor -1
                new Word(Opcode.STOP, -1, -1, -1), // 15 termina a execução
                new Word(Opcode.DATA, -1, -1, -1)
        };

        // PC: para um N definido (10 por exemplo)
        // o programa ordena um vetor de N números em alguma posição de memória;
        // ordena usando bubble sort
        // loop ate que não swap nada
        // passando pelos N valores
        // faz swap de vizinhos se da esquerda maior que da direita
        public Word[] pc = new Word[] {
                new Word(Opcode.LDI, 0, -1, 9), // 0 carrega os 3 valores na memória (9,8,7)
                new Word(Opcode.STD, 0, -1, 700), // 1
                new Word(Opcode.LDI, 0, -1, 8), // 2
                new Word(Opcode.STD, 0, -1, 701), // 3
                new Word(Opcode.LDI, 0, -1, 7), // 4
                new Word(Opcode.STD, 0, -1, 702), // 5
                new Word(Opcode.LDI, 0, -1, 702), // 6

                new Word(Opcode.LDI, 1, -1, 700), // 7
                new Word(Opcode.STD, 1, -1, 50), // 8 salva na memória qual é a primeira posição do array na
                                                         // memória
                new Word(Opcode.LDI, 2, 1, 701), // 9
                new Word(Opcode.LDX, 4, 1, -1), // 10 carrega nos registradores os valores que serão comparados
                new Word(Opcode.LDX, 5, 2, -1), // 11

                new Word(Opcode.SUB, 4, 5, -1), // 12 subtrai os dois primeiros valores (9-8)
                new Word(Opcode.LDI, 6, -1, 25), // 13 armazena para onde terá que ir
                new Word(Opcode.JMPIL, 6, 4, -1), // 14 se o que tem no r4 (1) menor que zero, pula pra próxima
                                                          // instrução
                new Word(Opcode.LDX, 4, 1, -1), // 15 volta o valor de r4
                new Word(Opcode.SWAP, 4, 5, -1), // 16 faz swap entre os registadores (8-9)
                new Word(Opcode.STX, 1, 4, -1), // 17 salva 8 na posição 700
                new Word(Opcode.STX, 2, 5, -1), // 18 salva 9 na posição 701

                new Word(Opcode.STD, 2, -1, 50), // 19 salva na posição 50 da memória qual última posição que
                                                         // testou
                new Word(Opcode.SUB, 2, 0, -1), // 20 verifica se chegou no fim do array
                new Word(Opcode.LDI, 7, -1, 7), // 21 se chegou no fim, pula pra instrução
                new Word(Opcode.JMPIE, 7, 2, -1), // 22 se for igual a zero, chegou ao fim, começa a comparar de
                                                          // novo

                new Word(Opcode.LDD, 2, -1, 50), // 23 volta o valor do r2
                new Word(Opcode.ADDI, 2, -1, 1), // 24 valor anterior
                new Word(Opcode.ADDI, 1, -1, 1), // 25 caminha
                new Word(Opcode.ADDI, 2, -1, 1), // 26 caminha
                new Word(Opcode.LDI, 7, -1, 10), // 27 coloca os valores em r4 e r5

                new Word(Opcode.JMP, -1, -1, 7), // 28
        };

        /*********** FASE 2 ***********/
        public Word[] testeOverflow = new Word[] {
                new Word(Opcode.LDI, 0, -1, 2147483646),
                new Word(Opcode.LDI, 1, -1, 2),
                new Word(Opcode.ADD, 0, 1, 0),
                new Word(Opcode.STOP, -1, -1, -1),
                new Word(Opcode.DATA, -1, -1, -1)
        };

        public Word[] testeEnderecoInvalido = new Word[] {
                new Word(Opcode.LDI, 0, -1, -2), // 0
                new Word(Opcode.STD, 0, -1, 36), // 1
                new Word(Opcode.LDD, 1, -1, 36), // 2
                new Word(Opcode.LDI, 5, -1, 1028), // 3
                new Word(Opcode.JMPIL, 5, 1, -1), // 4
                new Word(Opcode.LDD, 2, -1, 36), // 5
                new Word(Opcode.SUBI, 1, -1, 1), // 6
                new Word(Opcode.MULT, 2, 1, -1), // 7
                new Word(Opcode.SUBI, 1, -1, 1), // 8
                new Word(Opcode.LDI, 6, -1, 7), // 9
                new Word(Opcode.JMPIG, 6, 1, -1), // 10
                new Word(Opcode.STD, 2, -1, 35), // 11
                new Word(Opcode.JMP, -1, -1, 15), // 12
                new Word(Opcode.LDI, 1, -1, -1), // 13
                new Word(Opcode.STD, 1, -1, 35), // 14
                new Word(Opcode.STOP, -1, -1, -1), // 15
                new Word(Opcode.DATA, -1, -1, -1)
        };

        public Word[] testeInstrucaoInvalida = new Word[] {
                new Word(Opcode.LDI, 0, -1, 43), // 0
                new Word(Opcode.LDI, 1, -1, 8), // 1
                new Word(Opcode.ADD, 0, 1, 0), // 2
                new Word(Opcode.JMP, -1, -1, 35), // 3 manda pra uma instrução que não existe
                new Word(Opcode.STOP, -1, -1, -1), // 4
                new Word(Opcode.DATA, -1, -1, -1) // 5
        };

        /*********** FASE 3 ***********/
        public Word[] testaIn = new Word[] {
                new Word(Opcode.LDI, 8, -1, 1), // 0
                new Word(Opcode.LDI, 9, -1, 51), // 1
                new Word(Opcode.TRAP, -1, -1, -1), // 2
                new Word(Opcode.STOP, -1, -1, -1), // 3
                new Word(Opcode.DATA, -1, -1, -1), // 4
        };

        public Word[] testaOut = new Word[] {
                new Word(Opcode.LDI, 1, -1, 23), // 0
                new Word(Opcode.STD, 1, -1, 6), // 1
                new Word(Opcode.LDI, 8, -1, 2), // 2
                new Word(Opcode.LDI, 9, -1, 6), // 3
                new Word(Opcode.TRAP, -1, -1, -1), // 4
                new Word(Opcode.STOP, -1, -1, -1), // 5
                new Word(Opcode.DATA, -1, -1, -1)
        };

        public Word[] paInput = new Word[] {
                new Word(Opcode.LDI, 8, -1, 1), // 0
                new Word(Opcode.LDI, 9, -1, 21), // 1
                new Word(Opcode.TRAP, -1, -1, -1), // 2
                new Word(Opcode.LDD, 0, -1, 21), // 3 carrega o valor 5 no registrador 0
                new Word(Opcode.STD, 0, -1, 17), // 4 pega o valor do r0 e coloca na posição 37 da memória
                new Word(Opcode.LDD, 1, -1, 17), // 5 pega o valor da posição 37 da memória e coloca em r1
                new Word(Opcode.SUBI, 1, -1, 1), // 6 subtrai 1 do valor que entrou (no caso 5), por conta do
                                                         // zero: 0-4
                                                         // (5 valores)
                new Word(Opcode.LDI, 2, -1, 41), // 7 registrador que vai controlar o incremento de posição de
                                                          // memória
                new Word(Opcode.LDI, 7, -1, 27), // 8 carrega o valor 28 no registrador 7
                new Word(Opcode.JMPIL, 7, 1, -1), // 9 verifica se o valor no r1 é menor que 0, se sim, pula p/
                                                          // instrução 25, guardada no r7, se não, segue o fluxo
                new Word(Opcode.LDI, 5, -1, 1), // 10 carrega o primeiro valor de Fibonacci (1) no r5
                new Word(Opcode.STX, 2, 5, -1), // 11pega o valor do r5 e carrega na posição 900 (valor
                                                        // armazenado no
                                                        // r2)
                new Word(Opcode.SUBI, 1, -1, 1), // 12 subtrai 1 dos valores do r1
                new Word(Opcode.LDI, 7, -1, 29), // 13
                new Word(Opcode.JMPIL, 7, 1, -1), // 14 se o valor do r1 for menor que 0, pula para instrução 25
                new Word(Opcode.ADDI, 2, -1, 1), // 15 soma 1 ao valor que está no r2 (posição de memória)
                new Word(Opcode.LDI, 6, -1, 1), // 16 carrega o segundo valor de Fibonacci (1) no r6
                new Word(Opcode.STX, 2, 6, -1), // 17 carrega o valor de r6 na próxima posição da memória (r2)
                new Word(Opcode.SUBI, 1, -1, 1), // 18 subtrai 1 do r1
                new Word(Opcode.JMPIL, 7, 1, -1), // 19 se r1 menor do que 0, pula para instrução 25
                new Word(Opcode.ADDI, 2, -1, 1), // 20 soma 1 na posição de memória
                new Word(Opcode.ADD, 5, 6, -1), // 21 soma os valores de r5 e r6
                new Word(Opcode.SWAP, 5, 6, -1), // 22 faz um swap dos registradores r5 e r6 para manter a ordem
                                                         // correta
                                                         // para somar
                new Word(Opcode.STX, 2, 6, -1), // 23 carrega o valor de r6 (soma) para memória
                new Word(Opcode.LDI, 4, -1, 18), // 24 carrega o valor 14 no registrador 4
                new Word(Opcode.JMPIG, 4, 1, -1), // 25 se o que tem no r1 é maior que 0, volta pra instrução
                                                          // 14, se
                                                          // não, segue
                new Word(Opcode.JMPIL, 7, 1, -1), // 26 se o que tem no r1 for menor que 0, pula pra instrução
                                                          // 26
                new Word(Opcode.LDI, 3, -1, -1), // 27 carrega -1 no r3
                new Word(Opcode.STX, 2, 3, -1), // 28 pega o que tá no r3 (-1) e coloca na posição de memória do
                                                        // r2
                                                        // (900)
                new Word(Opcode.STOP, -1, -1, -1), // 29 para o programa
                new Word(Opcode.DATA, -1, -1, -1), // ...
                new Word(Opcode.DATA, -1, -1, -1), // ...
                new Word(Opcode.DATA, -1, -1, -1), // ...
                new Word(Opcode.DATA, -1, -1, -1), // ...
                new Word(Opcode.DATA, -1, -1, -1), // ...
                new Word(Opcode.DATA, -1, -1, -1), // ...
                new Word(Opcode.DATA, -1, -1, -1) // ...
        };

        public Word[] pbOutput = new Word[] {
                new Word(Opcode.LDI, 0, -1, 3), // 0 carrega o valor 3 no r0
                new Word(Opcode.STD, 0, -1, 26), // 1 carrega o valor do r0 na posição 36 da memória
                new Word(Opcode.LDD, 1, -1, 26), // 2 pega o valor da posição 36 da memória e coloca em r1 (3)
                new Word(Opcode.LDI, 5, -1, 13), // 3 carrega o valor 12 no r5
                new Word(Opcode.JMPIL, 5, 1, -1), // 4 se o que tem no registrador r1 for menor que 0, pula pra
                                                          // instrução guardada no r5 (12), se não, segue
                new Word(Opcode.LDD, 2, -1, 26), // 5 carrega em r2 o mesmo valor de r1 (3)
                new Word(Opcode.SUBI, 1, -1, 1), // 6 subtrai 1 do valor que tinha em r1
                new Word(Opcode.MULT, 2, 1, -1), // 7 multiplica r1 e r2 e coloca em r2 o valor
                new Word(Opcode.SUBI, 1, -1, 1), // 8 subtrai 1 do r1
                new Word(Opcode.LDI, 6, -1, 7), // 9 carrega o valor 7 (próxima instrução) no r6
                new Word(Opcode.JMPIG, 6, 1, -1), // 10 se for maior que 0 o que tem no r1, volta pra instrução
                                                          // 7 se
                                                          // não, segue o fluxo
                new Word(Opcode.STD, 2, -1, 25), // 11 coloca na posição 35 da memória o resultado do fatorial,
                                                         // que está
                                                         // no r2
                new Word(Opcode.JMP, -1, -1, 15), // 12 pula pro stop
                new Word(Opcode.LDI, 1, -1, -1), // 13 carrega no r1 o valor -1
                new Word(Opcode.STD, 1, -1, 25), // 14 coloca na posição 35 da memória o valor -1
                new Word(Opcode.LDI, 8, -1, 2), // 15 coloca 2 em reg 8 para criar um trap de out
                new Word(Opcode.LDI, 9, -1, 25), // 16 coloca 6 no reg 9, ou seja a posição onde será feita a
                                                         // leitura
                new Word(Opcode.TRAP, -1, -1, -1), // 17 faz o output da posição 10
                new Word(Opcode.STOP, -1, -1, -1), // 18 termina a execução
                new Word(Opcode.DATA, -1, -1, -1),
        };
}