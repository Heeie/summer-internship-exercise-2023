package com.premiumminds.internship.snail;

import java.util.concurrent.Future;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] matrix) {
    ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<int[]> task = new Callable<int[]>(){
            int[] resultado = new int[matrix.length * matrix.length];
            public int[] call() throws Exception {
        
                int count = 0;
        
                int[][] vazio = new int[][] {{}};
                
                
                //Verifica se a matriz é vazia
                if(vazio == matrix){
                    
                    return resultado;
                    
                } 
                
                //Verifica se a matriz tem apenas um elemnento
                else if(matrix[0].length == 1){
                    resultado[0] = matrix[0][0];
                    
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

                        // Percorrendo o limite superior da matriz
                        for (int i = limiteEsquerdo; i <= limiteDireito; i++) {
                            resultado[count] = matrix[limiteSuperior][i];
                            count++;
                        }
                        limiteSuperior++;

                        // Percorrendo o limite direito da matriz
                        for (int i = limiteSuperior; i <= limiteInferior; i++) {
                            resultado[count] = matrix[i][limiteDireito];
                            count++;
                            
                        }
                        limiteDireito--;

                        // Percorrendo o limite inferior da matriz (em sentido reverso)
                        if (limiteSuperior <= limiteInferior) {
                            for (int i = limiteDireito; i >= limiteEsquerdo; i--) {
                                resultado[count] = matrix[limiteInferior][i];
                                count++;
                                
                            }
                            limiteInferior--;
                        }

                        // Percorrendo o limite esquerdo da matriz (em sentido reverso)
                        if (limiteEsquerdo <= limiteDireito) {
                            for (int i = limiteInferior; i >= limiteSuperior; i--) {
                                resultado[count] = matrix[i][limiteEsquerdo];
                                count++;
                                
                            }
                            limiteEsquerdo++;
                        }
                        }
                       
                };
                
                return resultado;
              
        };
        };

        Future<int[]> resultado = executor.submit(task);
        executor.shutdown();
        return resultado;
  };
}
