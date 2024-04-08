package com.milton.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {

  List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");
  
  @Test
  void testAsserts() {
    boolean test = todos.contains("AWS");//Result
    boolean test2 = todos.contains("GCP");//Result
    
    assertEquals(true, test);

    assertTrue(test);
    
    assertFalse(test2);
    
    // assertNull,assertNotNull
 
    // AssertionFailedError: array contents differ at index [0], 
    // expected: <1> but was: <2>
    assertArrayEquals(new int[] {1,2}, new int[] {2, 1});
    
    assertEquals(3, todos.size());    
  }

}
