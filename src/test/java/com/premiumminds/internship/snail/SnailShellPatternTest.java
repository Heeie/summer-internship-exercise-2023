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
  };

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    
    int[][] matrix = new int[][] {{ 1, 2, 3 },
                                      { 4, 5, 6 },
                                      { 7, 8, 9 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 6, 9, 8, 7, 4, 5 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTest1Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { {} };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {};
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTest2Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2 }, { 3, 4 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 4, 3 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTest4Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = new int[][] {{ 1, 2, 3 , 4},
                                  { 5, 6, 7, 8 },
                                  {9, 10, 11, 12 },
                                  { 13, 14, 15, 16}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10};
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTest7Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1 , 2 , 3 , 4 , 5 , 6 , 7 }, 
                       { 24, 25, 26, 27, 28, 29, 8 }, 
                       { 23, 40, 41, 42, 43, 30, 9 }, 
                       { 22, 39, 48, 49, 44, 31, 10 }, 
                       { 21, 38, 47, 46, 45, 32, 11 }, 
                       { 20, 37, 36, 35, 34, 33, 12 }, 
                       { 19, 18, 17, 16, 15, 14, 13 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = new int[49];
    for (int i = 0; i<49; i++) {expected[i]=i+1;}
    assertArrayEquals(result, expected);
}
}
