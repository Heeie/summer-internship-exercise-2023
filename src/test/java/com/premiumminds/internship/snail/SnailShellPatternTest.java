package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;
import java.util.List;
import java.util.ArrayList;

/**  
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest extends SnailShellPattern{

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public SnailShellPatternTest() {
      int[][] teste0 = new int[][] {{}};
        
      int[][] teste1 = new int[][] { { 1 } };

      int[][] teste2 = new int[][] {{ 1, 2, 3 },
                                    { 4, 5, 6 },
                                    { 7, 8, 9 } };

      int[][] teste3 = new int[][] {{ 1, 2, 3 , 4},
                                    { 5, 6, 7, 8 },
                                    {9, 10, 11, 12 },
                                    { 13, 14, 15, 16}};

      int[][] teste4 = new int[][] { { 1, 2},
                                     { 3 ,4}};

      SnailShellPattern tester = new SnailShellPattern();

      System.out.println(tester.getSnailShell(teste0));
      System.out.println(tester.getSnailShell(teste1));
      System.out.println(tester.getSnailShell(teste2));
      System.out.println(tester.getSnailShell(teste3));
      System.out.println(tester.getSnailShell(teste4));
  };

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(result, expected);
  }
}

class SnailShellPattern{
    /*
     * Recebe uma matriz NxN e ordena os seus 
     * elementos organizados, dos mais exteriores 
     * para os interiores, percorrendo a matriz no sentido horário. 
     * 
     * @param matrix  matriz de números inteiros
     * @return lista com os elementos da matrix ordenados
     * 
     */
    public List<Integer> getSnailShell(int[][] matrix) {
        
        int[][] vazio = new int[][] {{}};
        List<Integer> resultado = new ArrayList<>();
    
        //Verifica se a matriz é vazia
        if(vazio == matrix){
            return resultado;
        } 
        
        //Verifica se a matriz tem apenas um elemnento
        else if(matrix[0].length == 1){
            resultado.add( matrix[0][0]);
            return resultado;
        } 

        //Verifica se a matriz tem mais do que um elemnento
        else if( matrix[0].length > 1){

            int n = matrix.length;
            int limiteSuperior = 0;
            int limiteInferior = n - 1;
            int limiteEsquerdo = 0;
            int limiteDireito = n - 1;

            while (limiteSuperior <= limiteInferior && limiteEsquerdo <= limiteDireito) {

                for (int i = limiteEsquerdo; i <= limiteDireito; i++) {
                    resultado.add(matrix[limiteSuperior][i]);
                }
                limiteSuperior++;

                for (int i = limiteSuperior; i <= limiteInferior; i++) {
                    resultado.add(matrix[i][limiteDireito]);
                }
                limiteDireito--;

                
                if (limiteSuperior <= limiteInferior) {
                    for (int i = limiteDireito; i >= limiteEsquerdo; i--) {
                        resultado.add( matrix[limiteInferior][i]);
                    }
                    limiteInferior--;
                }

                if (limiteEsquerdo <= limiteDireito) {
                    for (int i = limiteInferior; i >= limiteSuperior; i--) {
                        resultado.add(matrix[i][limiteEsquerdo]);
                    }
                    limiteEsquerdo++;
                }
                }
            }
            return resultado;
        }
}
